/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3966.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Ethan Duckworth
 */
public class AutoGearPeg extends CommandGroup {

    public AutoGearPeg() {
        double vexbot = 2.90322 - 2.284095;
        addSequential(new TankDriveDistance(0.5, 0.5));
        //addSequential(new TankDriveDistance(-vexbot, -vexbot));
        addSequential(new TankDriveAngle(-60));

        addSequential(new AlignToGearPeg());
    }

}
