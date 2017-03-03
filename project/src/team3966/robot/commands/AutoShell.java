/* L&N STEMpunks c 2017

WOPR-JR.

Full repo: github.com/ln-stempunks/WOPR-JR

Full licensing here: programming.lnstempunks.org/licensing

GPLv3
*/
package team3966.robot.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;

import team3966.robot.Robot;
import team3966.robot.subsystems.Subsystems;

/**
 *
 * @author Ethan Duckworth
 */


public class AutoShell extends CommandGroup {
    public AutoShell(boolean initalmove, double firstdist, double angle, boolean isAligned, double seconddist, double otherangle, boolean release, double backdist, double angles, double thirddist) {
        Subsystems subsystems = Robot.subsystems;
        
        if(initalmove == true) {
            addSequential(new MoveToGearPeg());
            subsystems.drive.gate.disable();
        }
        
        addSequential(new TankDriveDistance(firstdist, firstdist));
        
        addSequential(new TankDriveAngle(angle));
        
        if(isAligned == true) {
            addSequential(new AlignToGearPeg());
        }
        
        addSequential(new TankDriveDistance(seconddist, seconddist));
        
        addSequential(new TankDriveAngle(otherangle));
        
        if(release == true) {
            subsystems.drive.gate.disable();
        }
        
        addSequential(new TankDriveDistance(backdist, backdist));
        
        addSequential(new TankDriveAngle(angles));
        
        addSequential(new TankDriveDistance(thirddist, thirddist));
    }
}
