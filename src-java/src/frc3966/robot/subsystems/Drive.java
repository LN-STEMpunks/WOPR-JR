package frc3966.robot.subsystems;

import frc3966.robot.hardware.DriveMotor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc3966.robot.commands.MecDrive;
import frc3966.robot.values.IDs;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * Drive subsystem, controls left and right motors.
 *
 * Supplies methods for controlling the drive by various functions. The motors
 * objects should not be directly set from any other place.
 */
public class Drive extends Subsystem {

	public Drive() {
		LF = new DriveMotor(IDs.LF_motor);
		LB = new DriveMotor(IDs.LB_motor);
		RF = new DriveMotor(IDs.RF_motor);
		RB = new DriveMotor(IDs.RB_motor);
		LB.setInverted(true);
		LF.setInverted(true);
		robotDrive = new RobotDrive(LF, LB, RF, RB);
	}

	private DriveMotor LB, LF, RB, RF;
	private RobotDrive robotDrive;

	public void initDefaultCommand() {
		setDefaultCommand(new MecDrive());
	}

	public void stop() {
		tank(0, 0);
	}
	
	public void tank(double L_speed, double R_speed) {
		robotDrive.tankDrive(L_speed, R_speed);
	}
	
	public void mecanum_cartesian(double X_speed, double Y_speed, double R_speed) {
		robotDrive.mecanumDrive_Cartesian(X_speed, Y_speed, R_speed, 0);
	}
	public void mecanum_polar(double _speed, double _direction, double R_speed) {
		robotDrive.mecanumDrive_Polar(_speed, _direction, R_speed);
	}

}
