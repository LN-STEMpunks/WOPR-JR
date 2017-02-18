package team3966.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SPI;
import java.util.Arrays;
import team3966.robot.commands.GearPneumaticsController;


import team3966.robot.hardware.DistanceSensor;
import team3966.robot.hardware.Lidar;
import team3966.robot.hardware.PDPManager;
import team3966.robot.hardware.UltrasonicSerial;

import team3966.robot.values.IDs;

public class Subsystems {

	public Drive drive;
	public OI OI;
        public PDPManager pdp;
	public DistanceSensor ultrasonic;
	public UltrasonicSerial ports;
	public Lidar lidar;
	public AHRS navX;
        public GearPneumaticsController gpc;
	
	private boolean isEnabled = false;
	
	public Subsystems() {
		isEnabled = true;
		drive = new Drive(true);
		OI = new OI();
		ultrasonic = new DistanceSensor(IDs.ultrasonic_0);
		ports = new UltrasonicSerial();
		navX = new AHRS(SPI.Port.kMXP);
		lidar = new Lidar(I2C.Port.kMXP);
		gpc = new GearPneumaticsController();
                pdp = new PDPManager();
		lidar.start();
	}
	
	public void dumpInfo () {
		if (isEnabled) {
			SmartDashboard.putNumber("Voltage: ", ultrasonic.getVoltages());
                        SmartDashboard.putNumber("Average Voltage: ", ultrasonic.getAverageVolts());
                        SmartDashboard.putNumber("Average Distance: ", ultrasonic.getDistanceAverage());
			SmartDashboard.putNumber("Distance Sensor (serial)", ports.getDistance());
			SmartDashboard.putString("Serial Output: ", ports.PortReadout());
			SmartDashboard.putNumber("Average Volts", ultrasonic.getAverageVoltage());
			SmartDashboard.putNumber("Volts", ultrasonic.getVoltage());
			SmartDashboard.putNumber("L Encoder", drive.Lenc.getRaw());
			SmartDashboard.putNumber("R Encoder", drive.Renc.getRaw());

			SmartDashboard.putNumber("L Distance", drive.Lenc.getDistance());
			SmartDashboard.putNumber("R Distance", drive.Renc.getDistance());
			
			SmartDashboard.putNumber("L Speed", drive.Lenc.getRate());
			SmartDashboard.putNumber("R Speed", drive.Renc.getRate());
			SmartDashboard.putString("Distance: ", ports.PortReadout());
			SmartDashboard.putNumber("LIDAR Distance: ", lidar.getDistance());
			SmartDashboard.putNumber("Yaw: ", navX.getYaw());
			SmartDashboard.getBoolean("Left Solenoid Status: ", gpc.LeftStatus());
                        SmartDashboard.getBoolean("Right Solenoid Status: ", gpc.RightStatus());
                        SmartDashboard.putString("PDP Voltage (0 to 15): ", Arrays.toString(pdp.channelvoltage()));
			// now in meters
			String disps = "(" + navX.getDisplacementX() + ", " + navX.getDisplacementY() + ", " + navX.getDisplacementZ() + ")";
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
