package org.usfirst.frc.team3966.robot.subsystems;

//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DriverStation;
import org.usfirst.frc.team3966.robot.hardware.DriveMotor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3966.robot.commands.TankDrive;
import org.usfirst.frc.team3966.robot.values.IDs;
import org.usfirst.frc.team3966.util.Logger;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.AnalogInput;

/**
 * Drive subsystem, controls left and right motors.
 *
 * Supplies methods for controlling the drive by various functions. The motors
 * objects should not be directly set from any other place.
 */
public class Drive extends Subsystem {
    
    private Logger drive_log;
    
	public AnalogInput sensor;

    public Drive(int _LF, int _LB, int _RF, int _RB) {
        drive_log = new Logger("Drive Subsystem");
		sensor = new AnalogInput(0);
		sensor.setOversampleBits(4);
		sensor.setAverageBits(2);
		sensor.setGlobalSampleRate(62500);
		
		//sensor.setAutomaticMode(true);
        LF = new DriveMotor(_LF);
        LB = new DriveMotor(_LB);
        RF = new DriveMotor(_RF);
        RB = new DriveMotor(_RB);
        LB.setInverted(true);
        LF.setInverted(true);
        robotDrive = new RobotDrive(LF, LB, RF, RB);
    }

    private DriveMotor LB, LF, RB, RF;
    private RobotDrive robotDrive;

    public void initDefaultCommand() {

        setDefaultCommand(new TankDrive());
    }

    public void stop() {
        robotDrive.tankDrive(0, 0);
    }
    
    public void tank(double L_speed, double R_speed) {
    	robotDrive.tankDrive(L_speed, R_speed);
    }
    
    public void mecanum(double X_speed, double Y_speed, double R_speed) {
    	robotDrive.mecanumDrive_Cartesian(X_speed, Y_speed, R_speed, 0);
    }
    

}
