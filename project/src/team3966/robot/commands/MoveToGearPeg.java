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

    private long stime;

    private boolean turnRight;
    // PID constants
    public static final double kP = 0.1;
    public static final double kI = 0.0;
    public static final double kD = 0.0;

    public static final double CAMERA_WIDTH = 320;
    public static final double MIDDLE_OF_CAMERA = 180;

    public MoveToGearPeg(boolean _turnRight) {
        super(Robot.subsystems.drive);
        systems = Robot.subsystems;
        cont = systems.OI.controller;
        turnRight = _turnRight;

        source = new NetworkTablePIDSource("vision/gearpeg", "x", turnRight);

        MotorTurnAndMovePIDOutput out = new MotorTurnAndMovePIDOutput(
                new DriveMotor[]{
                    systems.drive.L0, systems.drive.L1
                },
                new DriveMotor[]{
                    systems.drive.R0, systems.drive.R1
                }, .38, .38
        );
        out.setScale(-1);
        
        PID = new PIDController(kP, kI, kD, source, out);
        PID.setToleranceBuffer(4);
        
        PID.setInputRange(-1, CAMERA_WIDTH);
        PID.setOutputRange(-.1, .1);

        PID.setAbsoluteTolerance(0);

        //systems.drive.turnOffPID();
    }

    protected void initialize() {
        stime = System.nanoTime();
        PID.enable();
        PID.setSetpoint(MIDDLE_OF_CAMERA);
    }

    protected void execute() {
        PID.setSetpoint(MIDDLE_OF_CAMERA);
    }


    protected boolean isFinished() {
        //return false;
        double ld = systems.sensors.lidar.getDistance();
        return (ld <= 30 && ld > 2) || ((System.nanoTime() - stime) * Math.pow(10, -9) > 6) || (systems.sensors.ultrasonic.getDistance() < 0.125);
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
