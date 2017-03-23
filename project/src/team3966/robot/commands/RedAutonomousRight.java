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

public class RedAutonomousRight extends CommandGroup {

    public RedAutonomousRight() {
        addSequential(new TankDriveTimed(.42, .42, 2));
        addSequential(new AlignToGearPeg(false));
        addSequential(new MoveToGearPeg(false));
        addSequential(new PutGearOnPeg());
        addSequential(new TankDriveTimed(-.7, -.7, 2.6));
        addSequential(new ShootTimed(1.0, 10));
    }
}
