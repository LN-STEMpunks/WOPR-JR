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

import team3966.robot.Robot;
import team3966.robot.subsystems.Subsystems;
import team3966.robot.hardware.Controller;

public class ShootTimed extends BaseCommand {

    private Controller cont;
    private Subsystems systems;

    private double pow, time;

    private long stime;

    public ShootTimed(double _pow, double _time) {
        super(Robot.subsystems.drive);
        systems = Robot.subsystems;
        cont = systems.OI.controller;
        pow = _pow;
        time = _time;
        //systems.drive.turnOffPID();
    }

    protected void initialize() {
        stime = System.nanoTime();
    }

    protected void execute() {
        systems.drive.shooter.set(pow);
        systems.drive.intake.set(.8*pow);
        systems.drive.stir.set(-.75 * pow);
    }

    protected boolean isFinished() {
        return (System.nanoTime() - stime) * Math.pow(10, -9) > time;
    }

    protected void interrupted() {
        end();
    }

    protected void end() {
        systems.drive.shooter.set(0);
        systems.drive.stir.set(0);
        systems.drive.intake.set(0);
    }

}
