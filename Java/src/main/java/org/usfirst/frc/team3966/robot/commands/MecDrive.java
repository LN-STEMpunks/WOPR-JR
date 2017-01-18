package org.usfirst.frc.team3966.robot.commands;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3966.robot.Robot;
import org.usfirst.frc.team3966.robot.values.EXButtons;

/**
 *
 */
public class MecDrive extends BaseCommand {

    public MecDrive() {
        super(Robot.drive);
    }

    protected void execute() {
    	//note: may need to invert Y
        Robot.drive.mecanum(Robot.controller.getAxis(EXButtons.STICK_X_AXIS), Robot.controller.getAxis(EXButtons.STICK_Y_AXIS), Robot.controller.getAxis(EXButtons.STICK_ROT_AXIS));

    }
}
