package org.usfirst.frc.team3966.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3966.robot.Robot;

/**
 * Stops the Drive subsystem by setting all motors to 0.0
 */
public class StopDrive extends BaseCommand {

    public StopDrive() {
        super(Robot.drive);
    }

    protected void execute() {
        Robot.drive.stop();
    }
}
