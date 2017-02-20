package team3966.robot.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Solenoid;

import team3966.robot.pidcontrollers.MotorPIDOutput;
import team3966.robot.pidcontrollers.MotorPIDSource;

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

    public DriveMotor L0, L1, R0, R1, stir, intake, climb;
    
    public CANTalon shooter;
    
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
        //gearBox = new SolenoidHandler(IDs.gearboxHighGear, IDs.gearboxHighGear, false);
        
        
        Lenc = new MotorEncoder(IDs.L_encoder_dio);
        Renc = new MotorEncoder(IDs.R_encoder_dio);

        //Lenc.setReverseDirection(true);
        stir = new DriveMotor(IDs.Stir_motor);
        stir.setInverted(true);
        climb = new DriveMotor(IDs.Climb_motor);
        intake = new DriveMotor(IDs.Intake_motor);
        
        shooter = new CANTalon(2);
        SmartDashboard.putData("SHOOTER", shooter);
        shooter.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        
        shooter.configNominalOutputVoltage(+0.0f, -0.0f);
        shooter.configPeakOutputVoltage(+12.0f, -12.0f);
        
        shooter.setProfile(0);
        shooter.setF(.1097);
        shooter.setD(0);
        shooter.setI(0);
        shooter.setP(0.22);
        
        
        
        L0 = new DriveMotor(IDs.L0_motor);
        L1 = new DriveMotor(IDs.L1_motor);

        R0 = new DriveMotor(IDs.R0_motor);
        R1 = new DriveMotor(IDs.R1_motor);

        R0.setInverted(true);
        R1.setInverted(true);

        //Shooter = new DriveMotor();
        //Lsource = new MotorPIDSource(Lenc);
        //Rsource = new MotorPIDSource(Renc);
        //Lout = new MotorPIDOutput(L0, L1);
        //Rout = new MotorPIDOutput(R0, R1);
        //LPID = new PIDController(kLP, kLI, kLD, kLF, Lsource, Lout);
        //RPID = new PIDController(kRP, kRI, kRD, kRF, Rsource, Rout);
        //RPID.setOutputRange(-.6, .6);
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
