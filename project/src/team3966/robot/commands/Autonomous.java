package team3966.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author cade
 */
public class Autonomous extends CommandGroup {

    public Autonomous() {
        // optimization is taken care of.
        
            addSequential(new TankDriveAngle(90));
            addSequential(new TankDriveDistance(1, 1));
        //double side = 0.6;

       // addSequential(new DriveSquare(side));
        //addSequential(new DriveCircle(1));
        
        //this.addParallel(this);
    }

}
