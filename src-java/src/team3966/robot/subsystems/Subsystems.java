package team3966.robot.subsystems;

import team3966.robot.hardware.DistanceSensor;
import team3966.robot.values.IDs;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3966.robot.hardware.UltrasonicSerial;
public class Subsystems {

	public Drive drive;
	public OI OI;
	public DistanceSensor ultrasonic;
	public UltrasonicSerial ports;
	
	public Subsystems() {
		drive = new Drive(false);
		OI = new OI();
		ultrasonic = new DistanceSensor(IDs.ultrasonic_0);
		ports = new UltrasonicSerial();
	}
	
	public void dumpInfo () {
		SmartDashboard.putNumber("Distance Sensor", ultrasonic.getDistance());
		SmartDashboard.putNumber("Average Volts", ultrasonic.getAverageVoltage());
		SmartDashboard.putNumber("Volts", ultrasonic.getVoltage());
		SmartDashboard.putNumber("L Encoder", drive.L.getRaw());
		SmartDashboard.putNumber("R Encoder", drive.R.getRaw());
		SmartDashboard.putString("Distance: ", ports.PortReadout());
	}
}
