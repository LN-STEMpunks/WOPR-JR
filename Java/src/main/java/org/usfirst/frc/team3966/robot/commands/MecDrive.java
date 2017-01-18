package org.usfirst.frc.team3966.robot.commands;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3966.robot.Robot;
import org.usfirst.frc.team3966.robot.values.PS4Buttons;

/**
 *
 */
public class MecDrive extends BaseCommand {

    public TankDrive() {
        super(Robot.drive);
    }

    protected void execute() {
        Robot.drive.drive(Robot.controller.getAxis(PS4Buttons.STICK_LEFT_Y_AXIS), Robot.controller.getAxis(PS4Buttons.STICK_RIGHT_Y_AXIS));

        if (Robot.controller.getButton(PS4Buttons.CIRCLE)) {
            Robot.drive.enablePCM();
        } else if (Robot.controller.getButton(PS4Buttons.X)) {
            Robot.drive.disablePCM();
        }
    }
}
