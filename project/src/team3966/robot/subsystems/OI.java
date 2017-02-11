package team3966.robot.subsystems;

import team3966.robot.hardware.Controller;
import edu.wpi.first.wpilibj.command.Subsystem;

import team3966.robot.values.IDs;

/**
 * Drive subsystem, controls left and right motors.
 *
 * Supplies methods for controlling the drive by various functions. The motors
 * objects should not be directly set from any other place.
 */
public class OI extends Subsystem {

	public Controller controller;

	public OI() {
		controller = new Controller(IDs.controller);
	}

	@Override
	protected void initDefaultCommand() {
		// needed method
	}
}
