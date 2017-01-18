package org.usfirst.frc.team3966.robot.commands;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3966.robot.Robot;
import org.usfirst.frc.team3966.robot.values.PS4Buttons;

/**
 *
 */
public class TankDrive extends BaseCommand {

    public TankDrive() {
        super(Robot.drive);
    }

    protected void execute() {
    	System.out.printf("ERROR: This robot only does mecanum drives\n");
        //Robot.drive.tank(Robot.controller.getAxis(PS4Buttons.STICK_LEFT_Y_AXIS), Robot.controller.getAxis(PS4Buttons.STICK_RIGHT_Y_AXIS));

    }
}
