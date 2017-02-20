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
package team3966.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import team3966.robot.hardware.DriveMotor;
import team3966.robot.hardware.MotorEncoder;

import team3966.robot.values.IDs;
import team3966.robot.commands.TankDrive;
import team3966.robot.hardware.SolenoidHandler;

/**
 * Drive subsystem, controls left and right motors.
 *
 * Supplies methods for controlling the drive by various functions. The motors
 * objects should not be directly set from any other place.
 */
public class Drive extends Subsystem {

    public DriveMotor L0, L1, R0, R1;
    
    public DriveMotor stir, intake, climb, shooter;
    
    public SolenoidHandler gate, mouth, gearBox;
    public Compressor comp;

    public MotorEncoder Lenc, Renc;

    //public MotorPIDSource Lsource, Rsource;//, Ssource;
    //public PIDController LPID, RPID;//, SPID;
    public Drive(boolean _usePID) {
        comp = new Compressor(0);
        comp.start();
        
        gate = new SolenoidHandler(IDs.gearGateOpen, IDs.gearGateClose, false, true);
        mouth = new SolenoidHandler(IDs.gearIntakeTighten, IDs.gearIntakeLower, false);
        gearBox = new SolenoidHandler(IDs.gearboxLowGear, IDs.gearboxHighGear, false);
        
        Lenc = new MotorEncoder(IDs.L_encoder_dio);
        Renc = new MotorEncoder(IDs.R_encoder_dio);

        stir = new DriveMotor(IDs.stirMotor);
        stir.setInverted(true);
        climb = new DriveMotor(IDs.climbMotor);
        intake = new DriveMotor(IDs.intakeMotor);
        
        shooter = new DriveMotor(IDs.shooterMotor);
        shooter.setInverted(true);
        
        
        L0 = new DriveMotor(IDs.L0Motor);
        L1 = new DriveMotor(IDs.L1Motor);

        R0 = new DriveMotor(IDs.R0Motor);
        R1 = new DriveMotor(IDs.R1Motor);

        R0.setInverted(true);
        R1.setInverted(true);

    }

    public Drive() {
        this(false);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }

    public void stop() {
        tank_power(0, 0);
    }

    // using raw power
    public void tank_power(double L_power, double R_power) {
        L0.set(L_power);
        L1.set(L_power);

        R0.set(R_power);
        R1.set(R_power);
    }
}
