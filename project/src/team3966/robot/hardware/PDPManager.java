/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3966.robot.hardware;

import edu.wpi.first.wpilibj.PowerDistributionPanel;

/**
 *
 * @author Tyler Duckworth
 */
public class PDPManager {
    PowerDistributionPanel pdp = new PowerDistributionPanel();
    public double totalvolts () {
       double inputvolts = pdp.getTotalCurrent();
       return inputvolts;
    }
    public double[] channelvoltage () {
        double[] channelvolts = new double[16];
        for(int i = 0; i < 16; i++) {
            double amps = pdp.getCurrent(i);
            channelvolts[i] = amps;
        }
        return channelvolts;
    }
}
