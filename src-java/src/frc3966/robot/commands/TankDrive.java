package frc3966.robot.commands;

import frc3966.robot.Robot;
import frc3966.robot.hardware.Controller;
import frc3966.robot.subsystems.Subsystems;
import frc3966.robot.values.PS4Buttons;


public class TankDrive extends BaseCommand {
	
	private Controller cont;
	private Subsystems systems;

	public TankDrive() {
		super(Robot.subsystems.drive);
		systems = Robot.subsystems;
		cont = systems.OI.controller;
	}

	protected void execute() {
		//System.out.printf("ERROR: This robot only does mecanum drives\n");
		//systems.drive.tank(cont.getAxis(PS4Buttons.STICK_LEFT_Y_AXIS), cont.getAxis(PS4Buttons.STICK_RIGHT_Y_AXIS));
	}

}
