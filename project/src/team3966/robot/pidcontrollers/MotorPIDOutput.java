package team3966.robot.pidcontrollers;

import team3966.robot.hardware.DriveMotor;
import edu.wpi.first.wpilibj.PIDOutput;

public class MotorPIDOutput implements PIDOutput {
	
	private DriveMotor[] motors;

	// |scale| < 1, should be
	private double scale = 1.0;
	
	public MotorPIDOutput(DriveMotor... _motors) {
		motors = _motors;
	}

	public void pidWrite(double speed) {
		for (PIDOutput motor : motors) {
			motor.pidWrite(speed * scale);
		}
	}
}