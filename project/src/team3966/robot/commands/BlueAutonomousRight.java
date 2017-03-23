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

public class BlueAutonomousRight extends CommandGroup {

    public BlueAutonomousRight() {
        addSequential(new TankDriveTimed(.42, .42, 2));
        addSequential(new MoveToGearPeg(false));
        addSequential(new PutGearOnPeg());
    }
}
