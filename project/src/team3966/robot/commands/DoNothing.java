package team3966.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import team3966.robot.Robot;
import team3966.robot.hardware.MotorEncoder;
import team3966.robot.subsystems.Subsystems;
import team3966.robot.values.PS4Buttons;
import team3966.robot.hardware.Controller;
import team3966.robot.pidcontrollers.MotorPIDOutput;
import team3966.robot.pidcontrollers.MotorPIDSource;

public class DoNothing extends BaseCommand {

    
    private double time;
    private long stime;
    
    public DoNothing(double _time) {
        time = _time;
    }

    protected void initialize() {
        stime = System.nanoTime();
    }

    protected boolean isFinished() {
       return (System.nanoTime() - stime) * Math.pow(10, -9) > time;
    }
}
