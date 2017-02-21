/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3966.robot.commands;

import team3966.robot.hardware.SolenoidHandler;
import team3966.robot.values.IDs;


/**
 *
 * @author Ethan Duckworth
 */
public class AutoGearControl {
    SolenoidHandler gearintake;
    SolenoidHandler geargate;
    public AutoGearControl () {
        gearintake = new SolenoidHandler(IDs.gearIntakeTighten, IDs.gearIntakeLower, false, true);
        geargate = new SolenoidHandler(IDs.gearGateOpen, IDs.gearGateClose, false);
    }
    public void enableIntake () {
        gearintake.enable();
    }
    public void enableGate () {
        geargate.enable();
    }
    public void disableIntake () {
        gearintake.disable();
    }
    public void disableGate () {
        geargate.disable();
    }
    
}