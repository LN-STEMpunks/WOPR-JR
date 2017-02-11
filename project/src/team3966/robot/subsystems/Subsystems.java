package team3966.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SPI;

import com.kauailabs.navx.frc.AHRS;

import team3966.robot.hardware.DistanceSensor;
import team3966.robot.hardware.Lidar;
import team3966.robot.hardware.UltrasonicSerial;

import team3966.robot.values.IDs;

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
			SmartDashboard.putNumber("L Encoder", drive.Lenc.getRaw());
			SmartDashboard.putNumber("R Encoder", drive.Renc.getRaw());

			SmartDashboard.putNumber("L Distance", drive.Lenc.getDistance());
			SmartDashboard.putNumber("R Distance", drive.Renc.getDistance());
			
			SmartDashboard.putNumber("L Speed", drive.Lenc.getRate());
			SmartDashboard.putNumber("R Speed", drive.Renc.getRate());
			SmartDashboard.putString("Distance: ", ports.PortReadout());
			SmartDashboard.putNumber("LIDAR Distance: ", lidar.getDistance());
			
			// now in meters
			String disps = "(" + navX.getDisplacementX() + ", " + navX.getDisplacementY() + ", " + navX.getDisplacementZ() + ")";
			SmartDashboard.putString("NavX Displacements: ", disps);
		}
	}
}
