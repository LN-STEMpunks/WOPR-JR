package team3966.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import team3966.robot.hardware.DistanceSensor;
import team3966.robot.hardware.Lidar;
import team3966.robot.values.IDs;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3966.robot.hardware.UltrasonicSerial;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SPI;

public class Subsystems {

	public Drive drive;
	public OI OI;
	public DistanceSensor ultrasonic;
	public UltrasonicSerial ports;
	public Lidar lidar;
	public AHRS navX;
	
	private boolean isEnabled = false;
	
	public Subsystems() {
		isEnabled = true;
		drive = new Drive(true);
		OI = new OI();
		ultrasonic = new DistanceSensor(IDs.ultrasonic_0);
		ports = new UltrasonicSerial();
		navX = new AHRS(SPI.Port.kMXP);
		lidar = new Lidar(I2C.Port.kOnboard);
		
		lidar.start();
	}
	
	public void dumpInfo () {
		if (isEnabled) {
			SmartDashboard.putNumber("Distance Sensor", ultrasonic.getDistance());
			SmartDashboard.putNumber("Average Volts", ultrasonic.getAverageVoltage());
			SmartDashboard.putNumber("Volts", ultrasonic.getVoltage());
			SmartDashboard.putNumber("L Encoder", drive.L.getRaw());
			SmartDashboard.putNumber("R Encoder", drive.R.getRaw());

			SmartDashboard.putNumber("L Distance", drive.L.getDistance());
			SmartDashboard.putNumber("R Distance", drive.R.getDistance());
			
			SmartDashboard.putNumber("L Speed", drive.L.getRate());
			SmartDashboard.putNumber("R Speed", drive.R.getRate());
			SmartDashboard.putString("Distance: ", ports.PortReadout());
			SmartDashboard.putNumber("LIDAR Distance: ", lidar.getDistance());
			double XDist = navX.getDisplacementX() / 0.0254;
			double YDist = navX.getDisplacementY() / 0.0254;
			double ZDist = navX.getDisplacementZ() / 0.0254;
			String disps = "(" + XDist + ", " + YDist + ", " + ZDist + ")";
			SmartDashboard.putString("NavX Displacements: ", disps);
		}
	}
}
