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

public class RedAutonomousLeft extends CommandGroup {

    public RedAutonomousLeft() {
        addSequential(new TankDriveTimed(.55, .55, 2.4));
        addSequential(new AlignToGearPeg(true));
        addSequential(new MoveToGearPeg(true));
        addSequential(new PutGearOnPeg());
    }
}
