/*
    2017 L&N STEMpunks

    lnstempunks.org

Authors:
    Cade Brown <cade@cade.site>

Website:
    programming.lnstempunks.org (or ln-stempunks.github.io)

 */
package org.usfirst.frc.team3966.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc.team3966.robot.subsystems.Drive;
import org.usfirst.frc.team3966.robot.commands.TankDrive;
import org.usfirst.frc.team3966.robot.commands.MecDrive;
import org.usfirst.frc.team3966.robot.commands.StopDrive;
import org.usfirst.frc.team3966.robot.values.IDs;
import org.usfirst.frc.team3966.robot.hardware.PS4Controller;
import org.usfirst.frc.team3966.util.Logger;

/**
 * Do not rename this file. It is auto generated, and used to run the robot.
 *
 * The class declaration should look like this:
 *
 * public class Robot extends IterativeRobot {
 *
 */
public class Robot extends IterativeRobot {

    public static Logger logger;

    public static Drive drive;
    public static PS4Controller controller;

    Command autonomousCommand;
    Command teleopCommand;

    /**
     *
     * @return
     */
    public String getModuleName() {
        return "WOPR-JR";
    }

    public String getModuleVersion() {
        return "0.0.1-java";
    }

    public void robotInit() {
        logger = new Logger(getModuleName(), getModuleVersion());

        drive = new Drive(IDs.LF_motor, IDs.LB_motor, IDs.RF_motor, IDs.RB_motor);
        controller = new PS4Controller(IDs.controller);

        // instantiate the command used for the autonomous period
        // teleopCommand = new TankDrive();
        teleopCommand = new MecDrive();

        // stay still during autonomous
        autonomousCommand = new StopDrive();
    }

    /*
    
        These functions are called right before autonomous/teleop
    
     */
    public void disabledInit() {

    }

    public void autonomousInit() {
        logger.info("Autonomous mode");
        if (autonomousCommand != null) {
            autonomousCommand.start();
        }
    }

    public void teleopInit() {
        logger.info("Teleop mode");
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }

        if (teleopCommand != null) {
            teleopCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous/teleop
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        drive.stop();
    }

}
