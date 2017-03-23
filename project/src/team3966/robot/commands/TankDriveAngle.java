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

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3966.robot.Robot;
import team3966.robot.hardware.DriveMotor;
import team3966.robot.hardware.MotorEncoder;
import team3966.robot.subsystems.Subsystems;
import team3966.robot.hardware.Controller;
import team3966.robot.pidcontrollers.MotorPIDOutput;
import team3966.robot.pidcontrollers.MotorPIDSource;
import team3966.robot.pidcontrollers.MotorTurnPIDOutput;
import team3966.robot.pidcontrollers.NavXPIDSource;

public class TankDriveAngle extends BaseCommand {

    private Controller cont;
    private Subsystems systems;

    private PIDController PID;

    // PID constants
    public static final double kP = .03;
    public static final double kI = 0.0;
    public static final double kD = 0.0;

    private double angle;

    private NavXPIDSource source;

    public TankDriveAngle(double _angle) {
        super(Robot.subsystems.drive);
        systems = Robot.subsystems;
        cont = systems.OI.controller;

        angle = _angle;

        source = new NavXPIDSource(systems.sensors.navX);

        MotorTurnPIDOutput out = new MotorTurnPIDOutput(new DriveMotor[]{
            systems.drive.L0, systems.drive.L1
        }, new DriveMotor[]{
            systems.drive.R0, systems.drive.R1
        });

        //out.setScale(-1.0);

        PID = new PIDController(kP, kI, kD, source, out);
        PID.setInputRange(-180, 180);
        PID.setContinuous(true);
        PID.setOutputRange(-1, 1);

        PID.setAbsoluteTolerance(4);
    }

    protected void initialize() {
        //double val = source.pidGet() + (180-angle);
        double val = source.pidGet() + (angle);
        if (val > 180) {
            val = val - 360;
        } else if (val < -180) {
            val = val + 360;
        }
        PID.enable();
        PID.setSetpoint(val);
    }

    protected boolean isFinished() {
        return PID.onTarget();
    }

    protected void execute() {
        SmartDashboard.putData("Angle PID", PID);
        // it has setpoint
    }

    protected void interrupted() {
        end();
    }

    protected void end() {
        PID.disable();
        systems.drive.stop();
    }

}
