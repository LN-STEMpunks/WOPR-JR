package frc3966.robot.commands;


public class TankDrive extends BaseCommand {

	public TankDrive() {
		//super(Robot.subsystems.drive);
	}

	protected void execute() {
		System.out.printf("ERROR: This robot only does mecanum drives\n");
		//Robot.drive.tank(Robot.controller.getAxis(PS4Buttons.STICK_LEFT_Y_AXIS), Robot.controller.getAxis(PS4Buttons.STICK_RIGHT_Y_AXIS));

	}
	@Override
	protected boolean isFinished() {
		return true;
	}

}
