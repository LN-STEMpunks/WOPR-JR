package team3966.robot.commands;

import team3966.robot.Robot;
import team3966.robot.subsystems.Subsystems;
import team3966.robot.hardware.Controller;


public class TankDriveDistance extends BaseCommand {
	
	private Controller cont;
	private Subsystems systems;
	
	private long stime;
	
	private double distance;
	private boolean hasStarted = false;
	
	public TankDriveDistance(double _distance) {
		super(Robot.subsystems.drive);
		systems = Robot.subsystems;
		cont = systems.OI.controller;
		
		distance = _distance;
	}

	protected void execute() { 
		if (!hasStarted) {
			systems.drive.tank_dist(distance, distance);
			hasStarted = true;
		}
	}
	
	protected boolean isFinished() {
		return systems.drive.LPID.onTarget() && systems.drive.RPID.onTarget();
	}
	
	protected void interrupted() {
		systems.drive.stop();
	}
	
	protected void end() {
		systems.drive.stop();
	}

}
