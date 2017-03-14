package team3966.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PutGearOnPeg extends CommandGroup {

    public PutGearOnPeg() {
        //addSequential(new TankDriveTimed(.4, .4, .4));
        addSequential(new TankDriveTimed(.3, .3, .6));
        addSequential(new SetSolenoids(false, false));
        addSequential(new DoNothing(.2));
        addSequential(new TankDriveTimed(-.4, -.4, 1.0));

    }
}
