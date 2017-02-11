package team3966.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import team3966.robot.Robot;
import team3966.robot.hardware.MotorEncoder;
import team3966.robot.subsystems.Subsystems;
import team3966.robot.values.PS4Buttons;
import team3966.robot.hardware.Controller;
import team3966.robot.pidcontrollers.MotorPIDOutput;
import team3966.robot.pidcontrollers.MotorPIDSource;


public class TankDriveTimed extends BaseCommand {
	
	private Controller cont;
	private Subsystems systems;
        
        private double lpow, rpow, time;
        
        private long stime;

	public TankDriveTimed(double _lpow, double _rpow, double _time) {
		super(Robot.subsystems.drive);
		systems = Robot.subsystems;
		cont = systems.OI.controller;
                lpow = _lpow;
                rpow = _rpow;
                time = _time;
		//systems.drive.turnOffPID();
	}
        
        protected void initialize() {
            stime = System.nanoTime();
	}

	protected void execute() {
            systems.drive.tank_power(lpow, rpow);
	}
        
        protected boolean isFinished() {
            return (System.nanoTime() - stime) * Math.pow(10, -9) > time;
        }

	protected void interrupted() {
            end();
        }
        
        protected void end() {
            systems.drive.stop();
        }
        
}
