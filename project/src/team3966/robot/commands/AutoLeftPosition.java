package team3966.robot.commands;

import team3966.robot.subsystems.Sensors;

import edu.wpi.first.wpilibj.command.CommandGroup;

import java.util.Timer;

/**
 *
 * @author Ethan Duckworth
 */
public class AutoLeftPosition extends CommandGroup {

    public AutoLeftPosition() {/*
        addSequential(new TankDriveDistance(2.928366, 2.928366));
        addSequential(new TankDriveAngle(60));*/
        //addSequential(new AlignToGearPeg());
        addSequential(new MoveToGearPeg());
        //addSequential(new TankDriveDistance(1.935734, 1.935734));
        // Thread.sleep(2000);
        // for deliver
        /*
        addSequential(new DoNothing(2));
        addSequential(new TankDriveDistance(-1.464183, -1.464183));
        addSequential(new TankDriveAngle(30));
        addSequential(new TankDriveDistance(4.4704, 4.4704));
        addSequential(new TankDriveAngle(45));
        //addSequential(align to boiler tape);
        //addSequential(shooter control);
        addSequential(new TankDriveAngle(-135));
        addSequential(new TankDriveDistance(1.583817, 1.583817));
        addSequential(new TankDriveAngle(90));
        addSequential(new TankDriveDistance(1.27, 1.27));
*/
    }
}
