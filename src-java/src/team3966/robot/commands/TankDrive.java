package team3966.robot.commands;

import team3966.robot.Robot;
import team3966.robot.hardware.MotorEncoder;
import team3966.robot.subsystems.Subsystems;
import team3966.robot.values.PS4Buttons;
import team3966.robot.hardware.Controller;


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
		//systems.drive.tank_power(cont.getAxis(PS4Buttons.STICK_LEFT_Y_AXIS), cont.getAxis(PS4Buttons.STICK_RIGHT_Y_AXIS));

		//systems.drive.tank_speed(cont.getAxis(PS4Buttons.STICK_LEFT_Y_AXIS)*MotorEncoder.MAX_SPEED, cont.getAxis(PS4Buttons.STICK_RIGHT_Y_AXIS)*MotorEncoder.MAX_SPEED);
		//systems.drive.tank_speed(1.0, 0);

		systems.drive.tank_speed(cont.getAxis(PS4Buttons.STICK_LEFT_Y_AXIS)*MotorEncoder.MAX_SPEED, cont.getAxis(PS4Buttons.STICK_RIGHT_Y_AXIS)*MotorEncoder.MAX_SPEED);
		//systems.drive.tank_power(0, 0);
	}

}
