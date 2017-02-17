package team3966.robot.commands;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.SPI;
/**
 *
 * @author Ethan Duckworth
 */
public class AutoLeftPosition {
    AHRS navX = new AHRS(SPI.Port.kMXP);
    public AutoLeftPosition() {
    }
}
