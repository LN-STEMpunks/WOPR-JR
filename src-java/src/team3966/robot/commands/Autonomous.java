package team3966.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author cade
 */
public class Autonomous extends CommandGroup {
	
	public Autonomous() {
		//addSequential(new TankDriveTimed(2.5, 2.5, 5.0));
		addSequential(new TankDriveDistance(2.0, 2.5));
	}
	
}