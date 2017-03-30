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
import team3966.robot.Robot;
import team3966.robot.subsystems.Subsystems;

public class BlueAutonomousCenter extends CommandGroup {

    public BlueAutonomousCenter() {
        addSequential(new MoveToGearPeg(false));
        addSequential(new PutGearOnPeg());

    }
}
