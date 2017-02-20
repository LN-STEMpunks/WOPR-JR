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
