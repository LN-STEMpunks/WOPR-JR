package team3966.robot.commands;

import team3966.robot.Robot;
import team3966.robot.hardware.MotorEncoder;
import team3966.robot.subsystems.Subsystems;
import team3966.robot.values.PS4Buttons;
import team3966.robot.hardware.Controller;


public class TankDriveTimed extends BaseCommand {
	
	private Controller cont;
	private Subsystems systems;
	private long stime;
	private double timeOut;
	
	private double Lspeed, Rspeed;

	public TankDriveTimed(double L, double R, double timeInSeconds) {
		super(Robot.subsystems.drive);
		systems = Robot.subsystems;
		cont = systems.OI.controller;
		stime = System.nanoTime();
		timeOut = timeInSeconds;
		
		Lspeed = L;
		Rspeed = R;
	}

	protected void execute() {
		//System.out.printf("ERROR: This robot only does mecanum drives\n");
		//systems.drive.tank_power(cont.getAxis(PS4Buttons.STICK_LEFT_Y_AXIS), cont.getAxis(PS4Buttons.STICK_RIGHT_Y_AXIS));
		systems.drive.tank_speed(Lspeed, Rspeed);
		//systems.drive.tank_speed(1.0, 0);
	}
	
	protected boolean isFinished() {
		return (System.nanoTime() - stime) * Math.pow(10, -9) > timeOut;
	}

}
