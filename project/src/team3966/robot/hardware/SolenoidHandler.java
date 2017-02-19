/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3966.robot.hardware;

import team3966.robot.values.IDs;

import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author Tyler Duckworth
 */
public class SolenoidHandler {

    Solenoid A, B;

    boolean areTogether, isInverted;
    
    boolean def;

    public SolenoidHandler(int _A, int _B, boolean _areTogether, boolean _isInverted) {
        A = new Solenoid(_A);
        B = new Solenoid(_B);
        areTogether = _areTogether;
        isInverted = _isInverted;
        def = !isInverted;
    }

    public SolenoidHandler(int _A, int _B, boolean _areTogether) {
        new SolenoidHandler(_A, _B, _areTogether, false);
    }

    public void enable() {
        A.set(def);
        B.set(def ^ !areTogether);
    }

    public void disable() {
        A.set(!def);
        B.set(!def ^ !areTogether);
    }
}
