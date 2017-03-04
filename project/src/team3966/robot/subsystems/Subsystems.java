/*
 * L&N STEMpunks c 2017
 *
 * WOPR-JR.
 *
 * Full repo: github.com/ln-stempunks/WOPR-JR
 *
 * Full licensing here: programming.lnstempunks.org/licensing
 *
 * GPLv3
 */
package team3966.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.Arrays;

public class Subsystems {
    
    public NetworkTable infoTable;

    public Drive drive;
    public OI OI;
    public Sensors sensors;

    private boolean isEnabled = false;

    public Subsystems() {
        isEnabled = true;
        drive = new Drive(true);
        OI = new OI();
        
        infoTable = NetworkTable.getTable("info");

        sensors = new Sensors();
    }

    public void dumpInfo() {
        if (isEnabled) {
            SmartDashboard.putNumber("L Distance", drive.Lenc.getDistance());
            SmartDashboard.putNumber("R Distance", drive.Renc.getDistance());

            SmartDashboard.putNumber("L Speed", drive.Lenc.getRate());
            SmartDashboard.putNumber("R Speed", drive.Renc.getRate());
            
            
            SmartDashboard.putNumber("Yaw: ", sensors.navX.getYaw());
            SmartDashboard.putNumber("Lidar Distance (In Inches)", sensors.lidar.getInches());
            SmartDashboard.putNumber("Lidar Distance (In Centimeters)", sensors.lidar.getDistance());
            
            SmartDashboard.putString("PDP Current: ", Arrays.toString(sensors.pdp.channelCurrent()));
            SmartDashboard.getNumber("Current of intake (In Amps):", sensors.pdp.getCurrent(5));
            SmartDashboard.getNumber("Current of agitator (In Amps):", sensors.pdp.getCurrent(6));
            SmartDashboard.getNumber("Current of shooter (In Amps):", sensors.pdp.getCurrent(7));
            SmartDashboard.getNumber("Current of climber (In Amps):", sensors.pdp.getCurrent(4));
            SmartDashboard.getNumber("Current of drive motor #1 (In Amps):", sensors.pdp.getCurrent(0));
            SmartDashboard.getNumber("Current of drive motor #2 (In Amps):", sensors.pdp.getCurrent(1));
            SmartDashboard.getNumber("Current of drive motor #3 (In Amps):", sensors.pdp.getCurrent(2));
            SmartDashboard.getNumber("Current of drive motor #4 (In Amps):", sensors.pdp.getCurrent(3));
            SmartDashboard.putNumber("Battery Voltage", DriverStation.getInstance().getBatteryVoltage());
            SmartDashboard.getNumber("Diffence between the two values", sensors.getLidarDifference());
            SmartDashboard.getNumber("What the value should be: 2.5399986284 or similar.", 0);
            infoTable.putNumber("BatteryVoltage", DriverStation.getInstance().getBatteryVoltage());
        }
    }
}
