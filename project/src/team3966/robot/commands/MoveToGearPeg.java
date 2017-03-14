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
import team3966.robot.Robot;
import team3966.robot.subsystems.Subsystems;
import team3966.robot.hardware.Controller;
import team3966.robot.hardware.DriveMotor;
import team3966.robot.pidcontrollers.MotorTurnAndMovePIDOutput;
import team3966.robot.pidcontrollers.NetworkTablePIDSource;

public class MoveToGearPeg extends BaseCommand {

    private Controller cont;
    private Subsystems systems;

    private PIDController PID;

    private NetworkTablePIDSource source;

    private double[] vals = new double[20];
    private int valsIdx = 0;

    // PID constants
    public static final double kP = 0.03;
    public static final double kI = 0.0;
    public static final double kD = 0.0;

    public static final double CAMERA_WIDTH = 320;
    public static final double MIDDLE_OF_CAMERA = 160;

    public MoveToGearPeg() {
        super(Robot.subsystems.drive);
        systems = Robot.subsystems;
        cont = systems.OI.controller;

        source = new NetworkTablePIDSource("vision", "x");

        MotorTurnAndMovePIDOutput out = new MotorTurnAndMovePIDOutput(
                new DriveMotor[]{
                    systems.drive.L0, systems.drive.L1
                },
                new DriveMotor[]{
                    systems.drive.R0, systems.drive.R1
                }, .7, .7
        );
        out.setScale(-1);
        
        PID = new PIDController(kP, kI, kD, source, out);
        PID.setToleranceBuffer(6);
        
        PID.setInputRange(-1, CAMERA_WIDTH);
        PID.setOutputRange(-.3, .3);

        PID.setAbsoluteTolerance(0);

        //systems.drive.turnOffPID();
    }

    protected void initialize() {
        PID.enable();
        PID.setSetpoint(MIDDLE_OF_CAMERA);
    }

    protected void execute() {
        PID.setSetpoint(MIDDLE_OF_CAMERA);
    }


    protected boolean isFinished() {
        //return false;
        double ld = systems.sensors.lidar.getDistance();
        return ld <= 23 && ld > 2;
        //return PID.get() < 0;
    }

    protected void interrupted() {
        end();
    }

    protected void end() {
        PID.disable();
        systems.drive.stop();
    }

}
