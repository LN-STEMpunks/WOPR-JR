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
    private boolean isRestricted = true;
    private boolean enabled = false, inwards = true;

    private boolean psButtonLast = false;

    // PID constants
    public static final double kLP = .18;
    public static final double kLI = 0.0;
    public static final double kLD = 0.0;
    public static final double kLF = 0.0;

    public static final double kRP = .18;
    public static final double kRI = 0.0;
    public static final double kRD = 0.0;
    public static final double kRF = 0.0;

    public TankDrive() {
        super(Robot.subsystems.drive);
        systems = Robot.subsystems;
        cont = systems.OI.controller;

        MotorPIDSource Lsource = new MotorPIDSource(systems.drive.Lenc);
        MotorPIDSource Rsource = new MotorPIDSource(systems.drive.Renc);
        Lsource.useSpeed();
        Rsource.useSpeed();
        Lsource.setScale(-1);
        Rsource.setScale(-1);

        MotorPIDOutput Lout = new MotorPIDOutput(systems.drive.L0, systems.drive.L1);
        MotorPIDOutput Rout = new MotorPIDOutput(systems.drive.R0, systems.drive.R1);

        Lout.setScale(-1);
        Rout.setScale(-1);

        LPID = new PIDController(kLP, kLI, kLD, kLF, Lsource, Lout);
        LPID.setInputRange(-MotorEncoder.MAX_HIGH_SPEED, MotorEncoder.MAX_HIGH_SPEED);
        LPID.setOutputRange(-1, 1);

        RPID = new PIDController(kRP, kRI, kRD, kRF, Rsource, Rout);
        RPID.setInputRange(-MotorEncoder.MAX_HIGH_SPEED, MotorEncoder.MAX_HIGH_SPEED);
        RPID.setOutputRange(-1, 1);

        LPID.setAbsoluteTolerance(MotorEncoder.MAX_TOLERANCE_SPEED);
        RPID.setAbsoluteTolerance(MotorEncoder.MAX_TOLERANCE_SPEED);

    }

    boolean LgearBox = false, lGate = false, lMouth = false;

    protected void initialize() {

        /*LPID.enable();
        RPID.enable();
        LPID.setSetpoint(0.0);
        RPID.setSetpoint(0.0);
        */
    }

    protected void execute() {
        if (cont.getPOV(0) != 0) {
            boolean psButtonCur = (cont.getPOV(0) == 90);

            // Could also be isRestricted = (psButtonCur != psButtonLast) ^ isRestricted
            if (psButtonCur != psButtonLast) {
                isRestricted = !isRestricted;
            }
            psButtonLast = psButtonCur;
        }
        //Only gear and climber
        if (isRestricted) {
            LPID.disable();
            RPID.disable();
            restrictedOperation();
        } else {
            LPID.enable();
            RPID.enable();
            normalOperation();
        }
        SmartDashboard.putBoolean("Restricted", isRestricted);
    }

    void restrictedOperation() {
        double Lpow = -cont.getAxis(PS4Buttons.STICK_LEFT_Y_AXIS);
        double Rpow = -cont.getAxis(PS4Buttons.STICK_RIGHT_Y_AXIS);
        systems.drive.tank_power(Lpow, Rpow);

        systems.drive.stir.set(-.8);

        double low_power = cont.getAxis(PS4Buttons.L_TRIGGER_AXIS) + 1;
        double high_power = cont.getAxis(PS4Buttons.R_TRIGGER_AXIS) + 1;
        if (low_power < .2 || high_power < .2) {
            
            if (low_power > high_power) {
                systems.drive.climb.set(.15 * low_power);
            } else if (high_power > low_power) {
                systems.drive.climb.set(high_power);
            } else {
                systems.drive.climb.set(0);
            }
            systems.drive.climb.set(0); 

        } else {
            systems.drive.shooter.set(high_power);
            systems.drive.climb.set(high_power);
        }
        

        if (cont.getButton(PS4Buttons.R1)) {
            systems.drive.gearBox.enable();
        } else if (cont.getButton(PS4Buttons.L1)) {
            systems.drive.gearBox.disable();
        }

        if (cont.getPOV(0) == 270) {
            enabled = false;
        }
        if (cont.getPOV(0) == 0) {
            enabled = true;
            inwards = false;
        }
        if (cont.getPOV(0) == 180) {
            enabled = true;
            inwards = true;
        }
        if (enabled) {
            double inpow = .75 + .25 * (Math.abs(Lpow) + Math.abs(Rpow)) / 2.0;
            if (inwards) {
                systems.drive.intake.set(inpow);
            } else {
                systems.drive.intake.set(-inpow);
            }
        } else {
            systems.drive.intake.set(0);
        }
        systems.drive.shooter.set(cont.getButton(PS4Buttons.TRIANGLE) ? 1 : 0);
        
        systems.drive.mouth.set(cont.getButton(PS4Buttons.SQUARE));
        systems.drive.gate.set(!cont.getButton(PS4Buttons.X));

    }

    void normalOperation() {
        
        if (true) {
            SmartDashboard.putData("L PID", LPID);
            SmartDashboard.putData("R PID", RPID);
        }
        
        double Lpow = cont.getAxis(PS4Buttons.STICK_LEFT_Y_AXIS);
        double Rpow = cont.getAxis(PS4Buttons.STICK_RIGHT_Y_AXIS);

        if (systems.drive.gearBox.get()) {
            LPID.setSetpoint(-Lpow * MotorEncoder.MAX_HIGH_SPEED);
            RPID.setSetpoint(-Rpow * MotorEncoder.MAX_HIGH_SPEED);
        } else {
            LPID.setSetpoint(-Lpow * MotorEncoder.MAX_LOW_SPEED);
            RPID.setSetpoint(-Rpow * MotorEncoder.MAX_LOW_SPEED);
        }

        double cpower = cont.getAxis(PS4Buttons.L_TRIGGER_AXIS) + 1;

        systems.drive.climb.set(cpower * cpower);
        systems.drive.shooter.set(cont.getAxis(PS4Buttons.R_TRIGGER_AXIS) + 1);
        systems.drive.stir.set(-.5);

        if (cont.getPOV(0) == 270) {
            enabled = false;
        }
        if (cont.getPOV(0) == 0) {
            enabled = true;
            inwards = false;
        }
        if (cont.getPOV(0) == 180) {
            enabled = true;
            inwards = true;
        }
        if (enabled) {
            double inpow = .6 + .4 * (Math.abs(Lpow) + Math.abs(Rpow)) / 2.0;
            if (inwards) {
                systems.drive.intake.set(inpow);
            } else {
                systems.drive.intake.set(-inpow);
            }
        } else {
            systems.drive.intake.set(0);
        }

        if (cont.getButton(PS4Buttons.R1)) {
            systems.drive.gearBox.enable();
        } else if (cont.getButton(PS4Buttons.L1)) {
            systems.drive.gearBox.disable();
        }
        systems.drive.mouth.set(cont.getButton(PS4Buttons.SQUARE));
        systems.drive.gate.set(!cont.getButton(PS4Buttons.X));
    }

    protected void interrupted() {
        end();
    }

    protected void end() {
        systems.drive.stop();
        LPID.disable();
        RPID.disable();
    }
}
