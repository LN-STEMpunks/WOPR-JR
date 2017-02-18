/*
	2017 L&N STEMpunks

	lnstempunks.org
	
	Robot code for WOPR-JR, our 2016-2017 season robot.
	
	

Authors:
	Cade Brown <cade@cade.site>
	Tyler Duckworth <>


Website:
	programming.lnstempunks.org (or ln-stempunks.github.io)

License:
	GPLv3, see LICENSE.md for more.
	
	Free as in FREEDOM.

 */
package team3966.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3966.robot.commands.AutonomousLeft;

import team3966.robot.subsystems.Subsystems;

import team3966.robot.commands.DriveCircle;
import team3966.robot.commands.DrivePoints;
import team3966.robot.commands.TankDrive;
import team3966.robot.commands.TankDriveAngle;
import team3966.robot.commands.TankDriveDistance;
import team3966.robot.commands.AutonomousLeft;

/**
 * Our 2017 robot code
 *
 * Once we have a working robot, we will fork this and make a MecanumBot repo
 *
 */
public class Robot extends IterativeRobot {

    public static Subsystems subsystems;
    
    SendableChooser autoChooser;

    Command autonomousCommand;
    Command teleopCommand;

    public void robotInit() {
        subsystems = new Subsystems();

        // teleopCommand = new TankDrive();
        teleopCommand = new TankDrive();
        
        autoChooser = new SendableChooser();
        autoChooser.addObject("Circle (1m)", new DriveCircle(1));
        autoChooser.addObject("Circle (2m)", new DriveCircle(2));
        autoChooser.addObject("Drive forward (1m)", new TankDriveDistance(2, 2));
        autoChooser.addObject("Turn (90 d)", new TankDriveAngle(90));
        autoChooser.addObject("Test Points", new DrivePoints(new double[][] {{0, .35}, {-.7, 0}, {.7, .7}}, false));
        autoChooser.addObject("Left Auto", new AutonomousLeft());
        SmartDashboard.putData("Auto Program", autoChooser);
        
    }

    /*
	
		These functions are called right before autonomous/teleop
	
     */
    public void disabledInit() {

    }

    public void autonomousInit() {
        System.out.printf("Autonomous mode\n");
        autonomousCommand = (Command)autoChooser.getSelected();
        if (autonomousCommand != null) {
            autonomousCommand.start();
        }
    }

    public void teleopInit() {
        System.out.printf("Teleop mode\n");
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }

        if (teleopCommand != null) {
            teleopCommand.start();
        }
    }

    /*
	 
	  This function is called periodically during autonomous/teleop
	 
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        subsystems.dumpInfo();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        subsystems.dumpInfo();
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        subsystems.drive.stop();
        subsystems.dumpInfo();
    }

}
