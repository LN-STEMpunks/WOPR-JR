package frc3966.robot.commands;

import frc3966.robot.Robot;

/**
 * Stops the Drive subsystem by setting all motors to 0.0
 */
public class StopDrive extends BaseCommand {

	public StopDrive() {
		super(Robot.subsystems.drive);
	}

	protected void execute() {
		Robot.subsystems.drive.stop();
	}
	@Override
	protected boolean isFinished() {
		return true;
	}

}
