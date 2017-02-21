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
package team3966.robot.hardware;

import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author Tyler Duckworth
 */
public class SolenoidHandler {

    Solenoid A, B;

    boolean areTogether, isInverted;
    
    public boolean def, last;

    public SolenoidHandler(int _A, int _B, boolean _areTogether, boolean _isInverted) {
        A = new Solenoid(_A);
        B = new Solenoid(_B);
        areTogether = _areTogether;
        isInverted = _isInverted;
        def = !isInverted;
        last = false;
        set(!def);
    }

    public SolenoidHandler(int _A, int _B, boolean _areTogether) {
       this(_A, _B, _areTogether, false);
    }
    
    public void toggle() {
        set(!last);
    }
    
    public void set(boolean on) {
        if (on) {
            enable();
        } else {
            disable();
        }
    }

    public void enable() {
        last = true;
        A.set(def);
        B.set(def ^ !areTogether);
    }

    public void disable() {
        last = false;
        A.set(!def);
        B.set(!def ^ !areTogether);
    }
}
