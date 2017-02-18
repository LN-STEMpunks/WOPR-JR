package team3966.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SPI;
import team3966.robot.commands.GearPneumaticsController;

import team3966.robot.hardware.DistanceSensor;
import team3966.robot.hardware.Lidar;
import team3966.robot.hardware.UltrasonicSerial;

import team3966.robot.values.IDs;

public class Subsystems {

	public Drive drive;
	public OI OI;
	public Sensors sensors;

	private boolean isEnabled = false;

	public Subsystems() {
		isEnabled = true;
		drive = new Drive(true);
		OI = new OI();
	
		sensors = new Sensors();
	}

	public void dumpInfo() {
		if (isEnabled) {
			/*
			SmartDashboard.putNumber("Voltage: ", sensors.ultrasonic.getVoltages());
			SmartDashboard.putNumber("Average Voltage: ", sensors.ultrasonic.getAverageVolts());
			SmartDashboard.putNumber("Average Distance: ", sensors.ultrasonic.getDistanceAverage());
			SmartDashboard.putNumber("Distance Sensor (serial)", sensors.ports.getDistance());
			SmartDashboard.putString("Serial Output: ", sensors.ports.PortReadout());
			SmartDashboard.putNumber("Average Volts", sensors.ultrasonic.getAverageVoltage());
			SmartDashboard.putNumber("Volts", sensors.ultrasonic.getVoltage());
			*/
			/*
			SmartDashboard.putNumber("L Encoder", drive.Lenc.getRaw());
			SmartDashboard.putNumber("R Encoder", drive.Renc.getRaw());
			*/
			SmartDashboard.putNumber("L Distance", drive.Lenc.getDistance());
			SmartDashboard.putNumber("R Distance", drive.Renc.getDistance());

			SmartDashboard.putNumber("L Speed", drive.Lenc.getRate());
			SmartDashboard.putNumber("R Speed", drive.Renc.getRate());
			SmartDashboard.putNumber("Distance: ", sensors.ultrasonic.getDistance());
			SmartDashboard.putNumber("Yaw: ", sensors.navX.getYaw());

			SmartDashboard.getBoolean("Left Solenoid Status: ", gpc.LeftStatus());
                        SmartDashboard.getBoolean("Right Solenoid Status: ", gpc.RightStatus());
			// now in meters
			SmartDashboard.putString("NavX Displacements: ", disps);
                        if (gpc.LeftBlacklisted() == true) {
                            SmartDashboard.putBoolean("The Left Solenoid has shorted! Check on it during the end of the match!", true);
                        }
                        if (gpc.RightBlackListed() == true) {
                            SmartDashboard.putBoolean("The Right Solenoid has shorted! Check on it during the end of the match!", true);
                        }
		}
	}
}
