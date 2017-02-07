package team3966.robot.subsystems;

import team3966.robot.hardware.DriveMotor;
import team3966.robot.values.IDs;
import edu.wpi.first.wpilibj.command.Subsystem;
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
	
	// this is essentially to get encoder values
	private class DrivePID implements PIDSource {
		
		private DriveMotor[] motors;
		private PIDSourceType sourceType;
		
		public DrivePID(DriveMotor a, DriveMotor b) {
			motors = new DriveMotor[2];
			motors[0] = a; motors[1] = b;
		}

		@Override
		public PIDSourceType getPIDSourceType() {
			return sourceType;
		}

		@Override
		public double pidGet() {
			return (motors[0].getSpeed() + motors[1].getSpeed()) / 2.0;
		}

		@Override
		public void setPIDSourceType(PIDSourceType arg0) {
			sourceType = PIDSourceType.kRate;
			
		}
	}
	
	// Essentially forwards output to a number of other PIDOutput objects
	private class PIDOutputArray implements PIDOutput {
		
		private PIDOutput[] outputs;
		
		
		public PIDOutputArray(PIDOutput... _outputs) {
			outputs = _outputs;
		}

		@Override
		public void pidWrite(double speed) {
			for (PIDOutput output : outputs) {
				output.pidWrite(speed);
			}
		}
	}
	
	private boolean usePID;
	private PIDController[] pid_control;

	// Constants for https://en.wikipedia.org/wiki/PID_controller
	public static final double kP = 0.3;
	public static final double kI = 0.0;
	public static final double kD = 0.0;
	
	private DriveMotor L0, L1, R0, R1;
	private RobotDrive robotDrive;
	
	public Drive(boolean _usePID) {
		usePID = _usePID;
		L0 = new DriveMotor(IDs.L0_motor);
		L1 = new DriveMotor(IDs.L1_motor);
		R0 = new DriveMotor(IDs.R0_motor);
		R1 = new DriveMotor(IDs.R1_motor);

		
		//L0.setInverted(true);
		
		robotDrive = new RobotDrive(L0, L1, R0, R1);
		
		if (usePID) {
			pid_control = new PIDController[2];
			DrivePID L_source = new DrivePID(L0, L1);
			DrivePID R_source = new DrivePID(R0, R1);
			PIDOutputArray L_out = new PIDOutputArray(L0, L1);
			PIDOutputArray R_out = new PIDOutputArray(R0, R1);
			
			pid_control[0] = new PIDController(kP, kI, kD, L_source, L_out);
			pid_control[1] = new PIDController(kP, kI, kD, R_source, R_out);
			
			for (PIDController pid_c : pid_control) {
				pid_c.setAbsoluteTolerance(DriveMotor.MAX_TOLERANCE);
				pid_c.setInputRange(-1.0, 1.0);
				pid_c.setOutputRange(-DriveMotor.MAX_SPEED, DriveMotor.MAX_SPEED);
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
	}
	
	// using raw power
	public void tank_power(double L_power, double R_power) {
		robotDrive.tankDrive(L_power, R_power);
	}
	
	// inputs should be between +-DriveMotor.MAX_SPEED
	public void tank_speed(double L_speed, double R_speed) {
		if (!usePID) {
			System.out.printf("ERROR: Trying to use speed when PID is not being used!\n");
			return;
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
