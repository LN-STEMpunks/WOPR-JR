package team3966.robot.subsystems;


import team3966.robot.hardware.DriveMotor;
import team3966.robot.hardware.MotorEncoder;
import team3966.robot.pidcontrollers.DistancePID;
import team3966.robot.pidcontrollers.PIDOutputArray;
import team3966.robot.pidcontrollers.SpeedPID;
import team3966.robot.values.IDs;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
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
	

	public DriveMotor L0, L1, R0, R1;
	public MotorEncoder L, R;

	public PIDController lPID, rPID;
	public PIDController ldPID, rdPID;
	
	private RobotDrive robotDrive;
	
	public static final double kLP = 0.24;
	public static final double kLI = 0.15;
	public static final double kLD = 0.2;
	public static final double kLF = 0.0;

	public static final double kRP = 0.29;
	public static final double kRI = 0.16;
	public static final double kRD = 0.15;
	public static final double kRF = 0.0;
	
	
	public Drive(boolean _usePID) {
		L = new MotorEncoder(IDs.L_encoder_dio_A, IDs.L_encoder_dio_B);
		R = new MotorEncoder(IDs.R_encoder_dio_A, IDs.R_encoder_dio_B);
		
		L0 = new DriveMotor(IDs.L0_motor);
		L1 = new DriveMotor(IDs.L1_motor);
		R0 = new DriveMotor(IDs.R0_motor);
		R1 = new DriveMotor(IDs.R1_motor);
		
		R.setReverseDirection(true);
		
		lPID = new PIDController(kLP, kLI, kLD, kLF, new SpeedPID(-1.0, L), new PIDOutputArray(1.0, L0, L1));
		rPID = new PIDController(kRP, kRI, kRD, kRF, new SpeedPID(-1.0, R), new PIDOutputArray(-1.0, R0, R1));
		
		ldPID = new PIDController(.25, 0, 0, new DistancePID(1.0, L), new PIDOutputArray(-1.0, L0, L1));
		rdPID = new PIDController(.25, 0, 0, new DistancePID(1.0, R), new PIDOutputArray(1.0, R0, R1));
		
		LiveWindow.addActuator("rdPID", 0, rdPID);

		lPID.setAbsoluteTolerance(MotorEncoder.MAX_TOLERANCE);
		rPID.setAbsoluteTolerance(MotorEncoder.MAX_TOLERANCE);
		
		ldPID.setAbsoluteTolerance(.1);
		rdPID.setAbsoluteTolerance(.1);

		
		lPID.setInputRange(-MotorEncoder.MAX_SPEED, MotorEncoder.MAX_SPEED);
		rPID.setInputRange(-MotorEncoder.MAX_SPEED, MotorEncoder.MAX_SPEED);
		
		ldPID.setInputRange(-100, 100);
		rdPID.setInputRange(-100, 100);

		
		lPID.setOutputRange(-MotorEncoder.MAX_SPEED, MotorEncoder.MAX_SPEED);
		rPID.setOutputRange(-MotorEncoder.MAX_SPEED, MotorEncoder.MAX_SPEED);
		
		ldPID.setOutputRange(-MotorEncoder.MAX_SPEED, MotorEncoder.MAX_SPEED);
		rdPID.setOutputRange(-MotorEncoder.MAX_SPEED, MotorEncoder.MAX_SPEED);

	}
	
	public Drive() {
		this(false);
	}


	public void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
	}
	
	public void turnOffPID() {
		ldPID.disable();
		rdPID.disable();
		lPID.disable();
		rPID.disable();
	}

	public void stop() {
		turnOffPID();
		tank_power(0, 0);
	}
	
	// using raw power
	public void tank_power(double L_power, double R_power) {
		lPID.disable();
		rPID.disable();

		L0.set(L_power);
		L1.set(L_power);
		R0.set(R_power);
		R1.set(R_power);
	}

	public void tank_speed(double L_s, double R_s) {
		ldPID.disable();
		rdPID.disable();
		if (!lPID.isEnabled()) {
  			lPID.enable();
			rPID.enable();
		}

		lPID.setSetpoint(L_s);
		rPID.setSetpoint(R_s);
	}

	public void tank_dist(double L_d, double R_d) {
		lPID.disable();
		rPID.disable();
		if (!ldPID.isEnabled()) {
  			ldPID.enable();
			rdPID.enable();
		}
		ldPID.setSetpoint(L_d + L.getDistance());
		rdPID.setSetpoint(R_d + R.getDistance());
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
