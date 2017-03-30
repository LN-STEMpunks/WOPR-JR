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
import team3966.robot.hardware.DriveMotor;
import team3966.robot.pidcontrollers.MotorTurnPIDOutput;
import team3966.robot.pidcontrollers.NetworkTablePIDSource;

public class AlignToGearPeg extends BaseCommand {

    private Subsystems systems;

    private PIDController PID;

    private NetworkTablePIDSource source;

    private double[] vals = new double[20];
    private boolean turnRight;
    private int valsIdx = 0;

    private long stime;
    
    // PID constants
    public static final double kP = 0.02;
    public static final double kI = 0.0;
    public static final double kD = 0.0;

    public static final double CAMERA_WIDTH = 320;
    public static final double MIDDLE_OF_CAMERA = 180;

    public AlignToGearPeg(boolean _turnRight) {
        super(Robot.subsystems.drive);
        systems = Robot.subsystems;
        turnRight = _turnRight;
        source = new NetworkTablePIDSource("vision/gearpeg", "x", turnRight);

        MotorTurnPIDOutput out = new MotorTurnPIDOutput(
                new DriveMotor[]{
                    systems.drive.L0, systems.drive.L1
                },
                new DriveMotor[]{
                    systems.drive.R0, systems.drive.R1
                }
        );
        out.setScale(-1);

        PID = new PIDController(kP, kI, kD, source, out);
        PID.setToleranceBuffer(5);
        
        PID.setInputRange(-1, CAMERA_WIDTH);
        PID.setOutputRange(-.4, .4);

        PID.setAbsoluteTolerance(10);
    }

    protected void initialize() {
        PID.enable();
        stime = System.nanoTime();
        PID.setSetpoint(MIDDLE_OF_CAMERA);
    }

    protected boolean isFinished() {
    	//return false;
        return PID.onTarget() || (System.nanoTime() - stime) * Math.pow(10, -9) > 2.8;
    }

    protected void execute() {
        PID.setSetpoint(MIDDLE_OF_CAMERA);
        if (PID.onTarget()) {
            end();
        }
    }

    protected void interrupted() {
        end();
    }

    protected void end() {
        PID.disable();
        systems.drive.stop();
    }

}
