package team3966.robot.hardware;

import java.util.TimerTask;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.tables.ITable;

public class Lidar implements PIDSource, LiveWindowSendable {
	private I2C i2c;
	private byte[] distance;
	private java.util.Timer updater;
	private ITable m_table;
	private long updateCount = 0;
	private final int LIDAR_ADDR = 0x62;
	private final int LIDAR_CONFIG_REGISTER = 0x00;
	private final int LIDAR_DISTANCE_REGISTER = 0x16;// 0x8f;

	public Lidar(Port port) {
		distance = new byte[2];
		i2c = new I2C(port, LIDAR_ADDR);

		SmartDashboard.putBoolean("LIDAR I2C address responded", i2c.addressOnly());
		reset();
		configure();

		updater = new java.util.Timer();

	    LiveWindow.addSensor("LIDAR_I2C", port.value, this);
	}

	// @Override
	public PIDSourceType getPIDSourceType() {
		return PIDSourceType.kDisplacement;
	}

	// @Override
	public void setPIDSourceType(PIDSourceType pidSourceType) {

	}

	// Distance in cm
	public int getDistance() {
		return (int) Integer.toUnsignedLong(distance[0] << 8) + Byte.toUnsignedInt(distance[1]);
	}

	public double pidGet() {
		return getDistance();
	}

	// Start 10Hz polling
	public void start() {
		updater.scheduleAtFixedRate(new LIDARUpdater(), 0, 100);
	}

	// Start polling for period in milliseconds
	public void start(int period) {
		updater.scheduleAtFixedRate(new LIDARUpdater(), 0, period);
	}

	public void stop() {
		updater.cancel();
		updater = new java.util.Timer();
	}

	public void configure() {
		i2c.write(0x02, 0x80);
		i2c.write(0x04, 0x08);
		i2c.write(0x1c, 0x00);
	}

	public void reset() {
		i2c.write(0x00, 0x00);
	}

	// Update distance variable
	public void update() {
		i2c.write(LIDAR_CONFIG_REGISTER, 0x04); // Initiate measurement
		Timer.delay(0.05); // Delay for measurement to be taken
		i2c.read(LIDAR_DISTANCE_REGISTER, 2, distance); // Read in measurement
		Timer.delay(0.005); // Delay to prevent over polling
		
		updateCount++;
	}

	// Timer task to keep distance updated
	private class LIDARUpdater extends TimerTask {
		public void run() {
			update();
			while (true) {
				update();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String getSmartDashboardType() {
		return "LIDAR";
	}

	public void initTable(ITable subtable) {
		m_table = subtable;
		updateTable();
	}

	public void updateTable() {
		if (m_table != null) {
			m_table.putNumber("LIDAR updateCount", this.updateCount);
			m_table.putNumber("LIDAR distance", getDistance());
			m_table.putNumber("LIDAR distance[0]", this.distance[0]);
			m_table.putNumber("LIDAR distance[1]", this.distance[1]);
			m_table.putBoolean("LIDAR I2C addressOnly test", i2c.addressOnly());
		}
	}

	public ITable getTable() {
		return m_table;
	}

	public void startLiveWindowMode() {
	}

	public void stopLiveWindowMode() {
	}
}