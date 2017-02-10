package team3966.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import team3966.robot.Robot;
import team3966.robot.hardware.MotorEncoder;
import team3966.robot.pidcontrollers.DistancePID;
import team3966.robot.pidcontrollers.PIDOutputArray;
import team3966.robot.subsystems.Drive;
import team3966.robot.subsystems.Subsystems;
import team3966.robot.values.PS4Buttons;
import team3966.robot.hardware.Controller;


public class TankDriveDistance extends BaseCommand {
	
	private Subsystems systems;
	
	private PIDController cont;
	
	private double dist, speed;

	public TankDriveDistance(double _dist, double _speed) {
		super(Robot.subsystems.drive);
		systems = Robot.subsystems;
		dist = _dist;
		speed = _speed;
		
		DistancePID dPID = new DistancePID(1.0, systems.drive.L, systems.drive.R);
		
		PIDOutputArray out = new PIDOutputArray((_speed / MotorEncoder.MAX_SPEED), systems.drive.L0, systems.drive.L1, systems.drive.R0, systems.drive.R1);
		
		cont = new PIDController(Drive.kP, Drive.kI, Drive.kD, dPID, out);
		cont.setAbsoluteTolerance(MotorEncoder.MAX_TOLERANCE);
		cont.enable();
		cont.setSetpoint(_dist);
	}

	protected void execute() {
		//System.out.printf("ERROR: This robot only does mecanum drives\n");
		//systems.drive.tank_power(cont.getAxis(PS4Buttons.STICK_LEFT_Y_AXIS), cont.getAxis(PS4Buttons.STICK_RIGHT_Y_AXIS));
		//systems.drive.tank_speed(Lspeed, Rspeed);
		//systems.drive.tank_speed(1.0, 0);
	}
	
	protected boolean isFinished() {
		return cont.onTarget();
	}

}
