package team3966.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import team3966.robot.Robot;
import team3966.robot.hardware.MotorEncoder;
import team3966.robot.subsystems.Subsystems;
import team3966.robot.hardware.Controller;
import team3966.robot.pidcontrollers.MotorPIDOutput;
import team3966.robot.pidcontrollers.MotorPIDSource;


public class TankDriveDistance extends BaseCommand {
	
	private Controller cont;
	private Subsystems systems;
        
        private PIDController LPID, RPID;
        
        // PID constants
	public static final double kLP = 0.8;
	public static final double kLI = 0.0;
	public static final double kLD = 0.1;
	public static final double kLF = 0.0;

	public static final double kRP = 0.8;
	public static final double kRI = 0.0;
	public static final double kRD = 0.1;
	public static final double kRF = 0.0;
        
        private double distance;
	

	public TankDriveDistance(double _distance) {
		super(Robot.subsystems.drive);
		systems = Robot.subsystems;
		cont = systems.OI.controller;
                
                distance = _distance;

                MotorPIDSource Lsource = new MotorPIDSource(systems.drive.Lenc);
                MotorPIDSource Rsource = new MotorPIDSource(systems.drive.Renc);
                Lsource.useDistance();
                Rsource.useDistance();
                
                Lsource.setScale(-1);
                
                MotorPIDOutput Lout = new MotorPIDOutput(systems.drive.L0, systems.drive.L1);
                MotorPIDOutput Rout = new MotorPIDOutput(systems.drive.R0, systems.drive.R1);
                
                LPID = new PIDController(kLP, kLI, kLD, kLF, Lsource, Lout);
                LPID.setInputRange(-MotorEncoder.MAX_DISTANCE, MotorEncoder.MAX_DISTANCE);
                LPID.setOutputRange(-1, 1);

                RPID = new PIDController(kRP, kRI, kRD, kRF, Rsource, Rout);
                RPID.setInputRange(-MotorEncoder.MAX_DISTANCE, MotorEncoder.MAX_DISTANCE);
                RPID.setOutputRange(-1, 1);
                
                LPID.setAbsoluteTolerance(MotorEncoder.MAX_TOLERANCE_DISTANCE);
                RPID.setAbsoluteTolerance(MotorEncoder.MAX_TOLERANCE_DISTANCE);
	}
        
        protected void initialize() {
            LPID.enable();
            RPID.enable();
            LPID.setSetpoint(systems.drive.Lenc.getDistance()-distance);
            RPID.setSetpoint(systems.drive.Renc.getDistance()-distance);
	}
        
        protected boolean isFinished() {
           return LPID.onTarget() && RPID.onTarget();
        }

	protected void execute() {
            // it has setpoint
	}

	protected void interrupted() {
            end();
        }
        
        protected void end() {
            LPID.disable();
            RPID.disable();
            systems.drive.stop();
        }
        
}
