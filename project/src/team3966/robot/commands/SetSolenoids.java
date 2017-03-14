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

public class SetSolenoids extends BaseCommand {
    
    private boolean mouth, gate;
    private long stime;
    
    public SetSolenoids(boolean _mouth, boolean _gate) {
        mouth = _mouth;
        gate = _gate;
    }

    protected void initialize() {
        stime = System.nanoTime();
    }
    
    protected void execute() {
        Robot.subsystems.drive.mouth.set(mouth);
        Robot.subsystems.drive.gate.set(gate);
    }
    protected void end() {
        
        //Robot.subsystems.drive.mouth.set(!mouth);
        //Robot.subsystems.drive.gate.set(!gate);
    }
    
    protected boolean isFinished() {
        //return false;
        return (System.nanoTime() - stime) * 1e-9 > 1;
    }
}
