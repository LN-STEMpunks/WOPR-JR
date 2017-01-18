package org.usfirst.frc.team3966.robot.subsystems;

//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DriverStation;
import org.usfirst.frc.team3966.robot.hardware.PCM;
import org.usfirst.frc.team3966.robot.hardware.DriveMotor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3966.robot.commands.TankDrive;
import org.usfirst.frc.team3966.robot.values.IDs;
import org.usfirst.frc.team3966.util.Logger;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * Drive subsystem, controls left and right motors.
 *
 * Supplies methods for controlling the drive by various functions. The motors
 * objects should not be directly set from any other place.
 */
public class Drive extends Subsystem {
    
    private Logger drive_log;
    
    public Drive(int _LF, int _LB, int _RB, int _RF) {
        drive_log = new Logger("Drive Subsystem");
        LB = new DriveMotor(_LB);
        LF = new DriveMotor(_LF);
        RB = new DriveMotor(_RB);
        RF = new DriveMotor(_RF);
        robotDrive = new RobotDrive(LF, LB, RF, RB);
    }

    private DriveMotor LB, LF, RB. RF;
    private RobotDrive robotDrive;

    public void initDefaultCommand() {

        setDefaultCommand(new TankDrive());
    }

    public void stop() {
        drive(0, 0);
    }
    
    public void drive(double L_speed, double R_speed) {
        LB.set(L_speed);
        LF.set(L_speed);
        
        RB.set(R_speed);
        RF.set(R_speed);
    }
    

}
