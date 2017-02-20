/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3966.robot.hardware;

import com.ctre.CANTalon;
import team3966.robot.values.IDs;

/**
 *
 * @author Tyler Duckworth
 */
public class ShooterControl {
    CANTalon talon = new CANTalon(IDs.talonCANID);
    
    public ShooterControl (boolean isInverted) {
        talon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
        talon.setInverted(isInverted);
        talon.setCurrentLimit(60);
    }
    
    public boolean status() {
        boolean status = talon.isEnabled();
        return status;
    }
    
    public double getAmpage () {
        double ampage = talon.getOutputCurrent();
        return ampage;
    }
    
    public double getVoltage () {
        double voltage = talon.getOutputVoltage();
        return voltage;
    }
    public void enable() {
        talon.set(0.5);
    }
    public void disable() {
        talon.set(0.0);
    }
    
}
