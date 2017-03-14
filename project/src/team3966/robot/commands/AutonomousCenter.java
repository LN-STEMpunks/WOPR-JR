/*
 * L&N STEMpunks c 2017
 *
 * WOPR-JR.
 *
 * Full repo: github.com/ln-stempunks/WOPR-JR
 *
 * Full licensing here: programming.lnstempunks.org/licensing
 *
 * GPLv3
 */
package team3966.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team3966.robot.Robot;
import team3966.robot.subsystems.Subsystems;

public class AutonomousCenter extends CommandGroup {

    public AutonomousCenter() {
        Subsystems subsystems = Robot.subsystems;

        addSequential(new TankDriveTimed(.6, .6, 3));
        addSequential(new PutGearOnPeg());

        //addSequential(new SetSolenoids(false, false));
        //addSequential(new TankDriveTimed(-.3, -.3, 1.5));



        
        /* Shooting - it wont work
        
        subsystems.drive.shooter.set(1);
        addSequential(new TankDriveAngle(-135));
        addSequential(new TankDriveDistance(1.005967, 1.005967));
        addSequential(new TankDriveAngle(90));
        addSequential(new TankDriveDistance(0.69215, 0.69215));        
        */

    }
}
