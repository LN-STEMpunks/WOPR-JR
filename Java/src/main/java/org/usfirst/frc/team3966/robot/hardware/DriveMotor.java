package org.usfirst.frc.team3966.robot.hardware;

import edu.wpi.first.wpilibj.VictorSP;
import org.usfirst.frc.team3966.util.Logger;

public class DriveMotor extends VictorSP {

    private Logger motor_logger;

    public DriveMotor(int channel) {
        super(channel);
        motor_logger = new Logger("Motor ID " + channel);
    }
}
