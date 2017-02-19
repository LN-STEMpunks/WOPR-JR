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
        lidar = new Lidar(I2C.Port.kMXP);
        pdp = new PDPManager();

        lidar.start();
    }

    protected void initDefaultCommand() {

    }

}
