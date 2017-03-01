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

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SPI;

import team3966.robot.values.IDs;
import team3966.robot.hardware.DistanceSensor;
import team3966.robot.hardware.Lidar;
import team3966.robot.hardware.PDPManager;

public class Sensors extends Subsystem {

    public DistanceSensor ultrasonic;
    public Lidar lidar;
    public AHRS navX;
    public PDPManager pdp;

    public Sensors() {
        ultrasonic = new DistanceSensor(IDs.ultrasonic_0);
        navX = new AHRS(SPI.Port.kMXP);
        pdp = new PDPManager();
        lidar = new Lidar();
    }
    public double getLidarDifference () {
        double difference = lidar.getInches() / lidar.getDistance();
        return difference;
    }
    protected void initDefaultCommand() {

    }

}
