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

import team3966.robot.Robot;

/**
 * Stops the Drive subsystem by setting all motors to 0.0
 */
public class StopDrive extends BaseCommand {

    public StopDrive() {
        super(Robot.subsystems.drive);
    }

    protected void execute() {
        Robot.subsystems.drive.stop();
    }

    protected boolean isFinished() {
        return true;
    }

}
