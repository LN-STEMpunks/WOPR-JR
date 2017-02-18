package team3966.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.logging.Level;
import java.util.logging.Logger;
import team3966.robot.Robot;
import team3966.robot.hardware.MotorEncoder;
import team3966.robot.subsystems.Subsystems;
import team3966.robot.values.PS4Buttons;
import team3966.robot.hardware.Controller;
import team3966.robot.hardware.DriveMotor;
import team3966.robot.pidcontrollers.MotorPIDOutput;
import team3966.robot.pidcontrollers.MotorPIDSource;
import team3966.robot.pidcontrollers.MotorTurnPIDOutput;
import team3966.robot.pidcontrollers.NetworkTablePIDSource;

public class AlignToGearPeg extends BaseCommand {

    private Controller cont;
    private Subsystems systems;

    private PIDController PID;

    private NetworkTablePIDSource source;

    private double[] vals = new double[20];
    private int valsIdx = 0;

    // PID constants
    public static final double kP = 0.003;
    public static final double kI = 0.0;
    public static final double kD = 0.0;

    public static final double CAMERA_WIDTH = 320;
    public static final double MIDDLE_OF_CAMERA = 160;

    public AlignToGearPeg() {
        super(Robot.subsystems.drive);
        systems = Robot.subsystems;
        cont = systems.OI.controller;

        source = new NetworkTablePIDSource("vision/gearpeg", "x");

        MotorTurnPIDOutput out = new MotorTurnPIDOutput(
                new DriveMotor[]{
                    systems.drive.L0, systems.drive.L1
                },
                new DriveMotor[]{
                    systems.drive.R0, systems.drive.R1
                }
        );

        PID = new PIDController(kP, kI, kD, source, out);
        PID.setToleranceBuffer(5);
        
        //PID.setInputRange(-1, NetworkTable.getTable("vision/gearpeg").getNumber("camwidth", 320));
        PID.setInputRange(-1, CAMERA_WIDTH);
        PID.setOutputRange(-.15, .15);

        PID.setAbsoluteTolerance(2);

        //systems.drive.turnOffPID();
    }

    protected void initialize() {
        PID.enable();
        PID.setSetpoint(MIDDLE_OF_CAMERA);
        //double width = (NetworkTable.getTable("vision/gearpeg").getNumber("camwidth", 320));
        //PID.setInputRange(0, width);
        //PID.setSetpoint(width / 2.0);
        PID.setToleranceBuffer(5);
    }

    protected boolean isFinished() {
    	return false;
        //return PID.onTarget();
    }

    // if it has wiggled accross too much.
    // We need this method because of latency, the PID loop doesn't work with NT values :(
    private boolean hasWiggled() {
        int changes = 0;
        for (int i = 1; i < vals.length; ++i) {
            if (Math.signum(vals[i] - PID.getSetpoint()) != Math.signum(vals[i - 1] - PID.getSetpoint())) {
                changes++;
            }
        }
        return changes >= 2;
    }

    protected void execute() {
        vals[valsIdx] = source.lastVal;
        valsIdx = (valsIdx + 1) % 20;
        //PID.setSetpoint();
        /*if (PID.onTarget()) {
            end();
        }*/
    }

    protected void interrupted() {
        end();
    }

    protected void end() {
        PID.disable();
        systems.drive.stop();
    }

}
