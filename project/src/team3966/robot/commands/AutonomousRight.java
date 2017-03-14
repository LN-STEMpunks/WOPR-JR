/*
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

public class AutonomousRight extends CommandGroup {

    public AutonomousRight() {
        addSequential(new TankDriveTimed(.42, .42, 1.8));
        addSequential(new TankDriveAngle(-60));
        //addSequential(new TankDriveTimed(.5, .5, 2.0));
        addSequential(new MoveToGearPeg());
        addSequential(new PutGearOnPeg());
        addSequential(new TankDriveTimed(-.42, -.42, 1.2));
        addSequential(new TankDriveAngle(60));
    }
}
