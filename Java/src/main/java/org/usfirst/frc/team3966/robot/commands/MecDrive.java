package org.usfirst.frc.team3966.robot.commands;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3966.robot.Robot;
import org.usfirst.frc.team3966.robot.values.PS4Buttons;

/**
 * hannah garrett changed something
 *
 */
public class MecDrive extends BaseCommand {

    public MecDrive() {
        super(Robot.drive);
    }

	// averageValue
	// 10000, 160
	// 7550, 92
	// 3900, 50

    protected void execute() {
    	//note: may need to invert Y
		System.out.printf("volts, avgVolts, value, avgValue: %f, %f, %d, %d\n", Robot.drive.sensor.getVoltage(), Robot.drive.sensor.getAverageVoltage(), Robot.drive.sensor.getValue(), Robot.drive.sensor.getAverageValue());
        Robot.drive.mecanum(-Robot.controller.getAxis(PS4Buttons.STICK_LEFT_X_AXIS), -Robot.controller.getAxis(PS4Buttons.STICK_LEFT_Y_AXIS), .5 * Robot.controller.getAxis(PS4Buttons.STICK_RIGHT_X_AXIS));

    }
}
