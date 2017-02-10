package team3966.robot.subsystems;


import team3966.robot.hardware.DriveMotor;
import team3966.robot.hardware.MotorEncoder;
import team3966.robot.pidcontrollers.PIDOutputArray;
import team3966.robot.pidcontrollers.SpeedPID;
import team3966.robot.values.IDs;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3966.robot.commands.TankDrive;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * Drive subsystem, controls left and right motors.
 *
 * Supplies methods for controlling the drive by various functions. The motors
 * objects should not be directly set from any other place.
 */

public class Drive extends Subsystem {
	
	private boolean usePID;
	private PIDController[] pid_control;

	// Constants for https://en.wikipedia.org/wiki/PID_controller
	public static final double kP = 0.1;
	public static final double kI = 0.0;
	public static final double kD = 0.0;
	
	public DriveMotor L0, L1, R0, R1;
	public MotorEncoder L, R;
	
	private RobotDrive robotDrive;
	
	public Drive(boolean _usePID) {
		usePID = _usePID;
		L = new MotorEncoder(IDs.L_encoder_dio_A, IDs.L_encoder_dio_B);
		R = new MotorEncoder(IDs.R_encoder_dio_A, IDs.R_encoder_dio_B);
		
		L0 = new DriveMotor(IDs.L0_motor);
		L1 = new DriveMotor(IDs.L1_motor);
		R0 = new DriveMotor(IDs.R0_motor);
		R1 = new DriveMotor(IDs.R1_motor);
		
		
		R.setReverseDirection(true);

		
		//L0.setInverted(true);
		
		robotDrive = new RobotDrive(L0, L1, R0, R1);
		
		if (usePID) {
			pid_control = new PIDController[2];
			SpeedPID L_source = new SpeedPID(-1.0, L);
			SpeedPID R_source = new SpeedPID(-1.0, R);
			PIDOutputArray L_out = new PIDOutputArray(1.0, L0, L1);
			PIDOutputArray R_out = new PIDOutputArray(-1.0, R0, R1);
			
			pid_control[0] = new PIDController(kP, kI, kD, L_source, L_out);
			pid_control[1] = new PIDController(kP, kI, kD, R_source, R_out);
			
			for (PIDController pid_c : pid_control) {
				pid_c.setAbsoluteTolerance(MotorEncoder.MAX_TOLERANCE);
				pid_c.setInputRange(-MotorEncoder.MAX_SPEED, MotorEncoder.MAX_SPEED);
				pid_c.setOutputRange(-MotorEncoder.MAX_SPEED, MotorEncoder.MAX_SPEED);
			}
			
		}
	}
	
	public Drive() {
		this(false);
	}


	public void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
	}

	public void stop() {
		tank_power(0, 0);
		for (PIDController pid_c : pid_control) {
			pid_c.disable();
		}
	}
	
	// using raw power
	public void tank_power(double L_power, double R_power) {
		robotDrive.tankDrive(L_power, R_power);
	}
	
	// inputs should be between +-DriveMotor.MAX_SPEED
	public void tank_speed(double L_speed, double R_speed) {

		for (PIDController pid_c : pid_control) {
			pid_c.enable();
		}
		pid_control[0].setSetpoint(L_speed);
		pid_control[1].setSetpoint(R_speed);
	}
	
	/*
	public void mecanum_cartesian(double X_speed, double Y_speed, double R_speed) {
		robotDrive.mecanumDrive_Cartesian(X_speed, Y_speed, R_speed, 0);
	}
	public void mecanum_polar(double _speed, double _direction, double R_speed) {
		robotDrive.mecanumDrive_Polar(_speed, _direction, R_speed);
	}
	 */
}
