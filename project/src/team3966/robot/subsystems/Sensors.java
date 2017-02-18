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

public class Sensors extends Subsystem {

	public DistanceSensor ultrasonic;
	public Lidar lidar;
	public AHRS navX;

	public Sensors() {
		ultrasonic = new DistanceSensor(IDs.ultrasonic_0);
		navX = new AHRS(SPI.Port.kMXP);
		lidar = new Lidar(I2C.Port.kMXP);

		lidar.start();
	}

	protected void initDefaultCommand() {

	}

}
