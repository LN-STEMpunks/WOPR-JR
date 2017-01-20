package org.usfirst.frc.team3966.robot.commands;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3966.robot.Robot;
import org.usfirst.frc.team3966.robot.values.PS4Buttons;

/**
 *
 */
public class MecDrive extends BaseCommand {

    public MecDrive() {
        super(Robot.drive);
    }

    protected void execute() {
    	//note: may need to invert Y
        Robot.drive.mecanum(-Robot.controller.getAxis(PS4Buttons.STICK_LEFT_X_AXIS), -Robot.controller.getAxis(PS4Buttons.STICK_LEFT_Y_AXIS), .5 * Robot.controller.getAxis(PS4Buttons.STICK_RIGHT_X_AXIS));

    }
}
