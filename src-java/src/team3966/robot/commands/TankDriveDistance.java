package team3966.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import team3966.robot.Robot;
import team3966.robot.hardware.MotorEncoder;
import team3966.robot.pidcontrollers.DistancePID;
import team3966.robot.pidcontrollers.PIDOutputArray;
import team3966.robot.subsystems.Subsystems;
import team3966.robot.values.PS4Buttons;
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
		if(!hasStarted) {
			systems.drive.tank_dist(distance, distance);
			hasStarted = true;
		}
		
	}
	
	protected void interrupted() {
		systems.drive.turnOffPID();
	}
	
	protected void end() {
		systems.drive.turnOffPID();
	}

}
