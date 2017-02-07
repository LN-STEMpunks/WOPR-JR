package frc3966.robot.commands;

import frc3966.robot.Robot;
import frc3966.robot.values.PS4Buttons;

/**
 * Drives using Mecanum
 */
public class MecDrive extends BaseCommand {

	public MecDrive() {
		super(Robot.subsystems.drive);
	}


	protected void execute() {
		// print out debug info
		//System.out.printf(
		//		"predicted distance: %3.3f\n", 
		//Robot.subsystems.ultrasonic.getDistance());
		
		
		Robot.subsystems.drive.mecanum_cartesian(
				-Robot.subsystems.OI.controller.getAxis(PS4Buttons.STICK_LEFT_X_AXIS), 
				-Robot.subsystems.OI.controller.getAxis(PS4Buttons.STICK_LEFT_Y_AXIS), 
				Robot.subsystems.OI.controller.getAxis(PS4Buttons.STICK_RIGHT_X_AXIS) * .5);

	}
}
