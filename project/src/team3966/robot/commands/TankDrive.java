package team3966.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import team3966.robot.Robot;
import team3966.robot.hardware.MotorEncoder;
import team3966.robot.subsystems.Subsystems;
import team3966.robot.values.PS4Buttons;
import team3966.robot.hardware.Controller;
import team3966.robot.pidcontrollers.MotorPIDOutput;
import team3966.robot.pidcontrollers.MotorPIDSource;

public class TankDrive extends BaseCommand {

    private Controller cont;
    private Subsystems systems;

    private PIDController LPID, RPID;

    // PID constants
    public static final double kLP = 0.24;
    public static final double kLI = 0.15;
    public static final double kLD = 0.2;
    public static final double kLF = 0.0;

    public static final double kRP = 0.29;
    public static final double kRI = 0.16;
    public static final double kRD = 0.15;
    public static final double kRF = 0.0;

    public TankDrive() {
        super(Robot.subsystems.drive);
        systems = Robot.subsystems;
        cont = systems.OI.controller;

        MotorPIDSource Lsource = new MotorPIDSource(systems.drive.Lenc);
        MotorPIDSource Rsource = new MotorPIDSource(systems.drive.Renc);
        Lsource.useSpeed();
        Rsource.useSpeed();

        MotorPIDOutput Lout = new MotorPIDOutput(systems.drive.L0, systems.drive.L1);
        MotorPIDOutput Rout = new MotorPIDOutput(systems.drive.R0, systems.drive.R1);

        LPID = new PIDController(kLP, kLI, kLD, kLF, Lsource, Lout);
        LPID.setInputRange(-MotorEncoder.MAX_SPEED, MotorEncoder.MAX_SPEED);
        LPID.setOutputRange(-1, 1);

        RPID = new PIDController(kRP, kRI, kRD, kRF, Rsource, Rout);
        RPID.setInputRange(-MotorEncoder.MAX_SPEED, MotorEncoder.MAX_SPEED);
        RPID.setOutputRange(-1, 1);

        LPID.setAbsoluteTolerance(MotorEncoder.MAX_TOLERANCE_SPEED);
        RPID.setAbsoluteTolerance(MotorEncoder.MAX_TOLERANCE_SPEED);
    }

    protected void initialize() {/*
        LPID.enable();
        RPID.enable();
        LPID.setSetpoint(0.0);
        RPID.setSetpoint(0.0);*/
    }

    protected void execute() {
        double Lpow = cont.getAxis(PS4Buttons.STICK_LEFT_Y_AXIS);
        double Rpow = cont.getAxis(PS4Buttons.STICK_RIGHT_Y_AXIS);
        systems.drive.tank_power(Lpow, Rpow);
        systems.drive.climb.set(cont.getAxis(PS4Buttons.R_TRIGGER_AXIS) + 1);
        systems.drive.stir.set(.15);
        systems.drive.intake.set(Math.abs(Lpow + Rpow) / 2.0);
        if (cont.getButton(PS4Buttons.X)) {
            systems.drive.mouth.enable();
        } else if (cont.getButton(PS4Buttons.SQUARE)) {
            systems.drive.mouth.disable();
        }
        /*
        LPID.setSetpoint(MotorEncoder.MAX_SPEED * cont.getAxis(PS4Buttons.STICK_LEFT_Y_AXIS));
        RPID.setSetpoint(MotorEncoder.MAX_SPEED * cont.getAxis(PS4Buttons.STICK_RIGHT_Y_AXIS));
        */
    }

    protected void interrupted() {
        end();
    }

    protected void end() {
        systems.drive.stop();/*
        LPID.disable();
        RPID.disable();*/
    }
}
