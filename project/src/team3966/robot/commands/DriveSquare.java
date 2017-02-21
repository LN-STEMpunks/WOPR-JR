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
package team3966.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author cade
 */
public class DriveSquare extends CommandGroup {

    public DriveSquare(double sideLength) {
        //double side = 0.6;
        final double angle = 90;
        //addSequential(new TankDriveTimed(2.5, 2.5, 5.0));
        //addSequential(new TankDriveTimed(1.5, 4.0));
        //addSequential(new TankDriveDistance(3));
        for (int i = 0; i < 4; ++i) {
            addSequential(new TankDriveDistance(sideLength, sideLength));
            addSequential(new TankDriveAngle(angle));
        }
    }

}
