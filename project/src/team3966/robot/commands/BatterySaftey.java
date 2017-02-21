/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3966.robot.commands;

import edu.wpi.first.wpilibj.PowerDistributionPanel;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 * @author Ethan Duckworth
 */
public class BatterySaftey {
    PowerDistributionPanel pdp = new PowerDistributionPanel();
    public BatterySaftey () {
        double power = pdp.getTotalPower();
        double current = pdp.getTotalCurrent();
        double energy = pdp.getTotalEnergy();
    }
    public void warning() {
        /*if (current >= warning zone) {
            String warning = "Your battery is in the danger zone! Try to stop now before the robot dies!";
            SmartDashboard.putString("!WARNING!", warning);
        
        }
        */
    }
}
