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
import edu.wpi.first.wpilibj.command.WaitCommand;
import team3966.robot.subsystems.Subsystems;
/**
 *
 * @author Ethan Duckworth
 */
public class AutonomousLeft extends CommandGroup {
    public AutonomousLeft() {
        Subsystems subsystems = new Subsystems();
        WaitCommand wait = new WaitCommand(10);

        addSequential(new TankDriveDistance(2.30516, 2.30516));
        addSequential(new TankDriveAngle(60));
        addSequential(new AlignToGearPeg());
        addSequential(new MoveToGearPeg());
        addSequential(new TankDriveDistance(1.357884, 1.357884));
        subsystems.drive.gate.enable();
        addSequential(new DoNothing(2));
        addSequential(new TankDriveDistance(-0.88633, -0.886333));
        subsystems.drive.gate.disable();
        addSequential(new TankDriveAngle(30));
        addSequential(new TankDriveDistance(3.89255, 3.89255));
        addSequential(new TankDriveAngle(45));
        //addSequential(align to boiler tape);
        //addSequential(subsystems.drive.shooter.set(1));
        addSequential(new TankDriveAngle(-135));
        addSequential(new TankDriveDistance(1.005967, 1.005967));
        addSequential(new TankDriveAngle(90));
        addSequential(new TankDriveDistance(0.69215, 0.69215));
    }
}
