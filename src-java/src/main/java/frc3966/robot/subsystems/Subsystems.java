package frc3966.robot.subsystems;

import frc3966.robot.hardware.DistanceSensor;

public class Subsystems {

	public Drive drive;
	public OI OI;
	public DistanceSensor ultrasonic;
	
	public Subsystems() {
		drive = new Drive();
		OI = new OI();
		ultrasonic = new DistanceSensor();
	}
}
