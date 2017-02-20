/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
