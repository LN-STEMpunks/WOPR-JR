package team3966.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
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

    // PID constants
    public static final double kLP = 0.24;
    public static final double kLI = 0.15;
    public static final double kLD = 0.2;
    public static final double kLF = 0.0;

    public static final double kRP = 0.29;
    public static final double kRI = 0.16;
    public static final double kRD = 0.15;
    public static final double kRF = 0.0;


    public AlignToGearPeg() {
        super(Robot.subsystems.drive);
        systems = Robot.subsystems;
        cont = systems.OI.controller;


        NetworkTablePIDSource source = new NetworkTablePIDSource("/vision/gearpeg/", "x");

        MotorTurnPIDOutput out = new MotorTurnPIDOutput(
                new DriveMotor[]{
                    systems.drive.L0, systems.drive.L1
                },
                new DriveMotor[]{
                    systems.drive.R0, systems.drive.R1
                }
        );

        PID = new PIDController(kRP, kRI, kRD, kRF, source, out);
        PID.setInputRange(0, NetworkTable.getTable("/vision/gearpeg/").getNumber("camwidth", 320));
        PID.setOutputRange(-1, 1);

        PID.setAbsoluteTolerance(5);

        //systems.drive.turnOffPID();
    }

    protected void initialize() {
        PID.enable();
        double width = (NetworkTable.getTable("/vision/gearpeg/").getNumber("camwidth", 320));
        PID.setInputRange(0, width);
        PID.setSetpoint(width / 2.0);
    }

    protected boolean isFinished() {
        return PID.onTarget();
    }

    protected void execute() {
        double width = (NetworkTable.getTable("/vision/gearpeg/").getNumber("camwidth", 320));
        PID.setInputRange(0, width);
        PID.setSetpoint(width / 2.0);
    }

    protected void interrupted() {
        end();
    }

    protected void end() {
        systems.drive.stop();
        PID.disable();
    }

}
