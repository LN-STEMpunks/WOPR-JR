package team3966.robot.subsystems;


import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SPI;

import team3966.robot.pidcontrollers.MotorPIDOutput;
import team3966.robot.pidcontrollers.MotorPIDSource;

import team3966.robot.hardware.DriveMotor;
import team3966.robot.hardware.MotorEncoder;

import team3966.robot.values.IDs;
import team3966.robot.commands.TankDrive;
import team3966.robot.hardware.DistanceSensor;
import team3966.robot.hardware.Lidar;
import team3966.robot.hardware.UltrasonicSerial;

/**
 * Drive subsystem, controls left and right motors.
 *
 * Supplies methods for controlling the drive by various functions. The motors
 * objects should not be directly set from any other place.
 */

public class Sensors extends Subsystem {

	//public MotorPIDSource Lsource, Rsource;//, Ssource;
	
	//public PIDController LPID, RPID;//, SPID;
	
	public Drive drive;
	public OI OI;
        
	public DistanceSensor ultrasonic;
	public UltrasonicSerial ports;
	public Lidar lidar;
	public AHRS navX;
	

	
	public Sensors () {
		drive = new Drive(true);
		OI = new OI();
		ultrasonic = new DistanceSensor(IDs.ultrasonic_0);
		ports = new UltrasonicSerial();
		navX = new AHRS(SPI.Port.kMXP);
		lidar = new Lidar(I2C.Port.kMXP);
		
		lidar.start();
        }

    @Override
    protected void initDefaultCommand() {
        
    }
		
}
