/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3966.robot.hardware;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tyler Duckworth
 */
public class PDPManager {

    public final String FILE = "/home/lvuser/pdp.log";
    PowerDistributionPanel pdp = new PowerDistributionPanel();
    double max = 0;
    long stime;
    FileWriter towrite;
    boolean isGood = false;

    public PDPManager() {
        stime = System.nanoTime();
    }

    public void startLogging() {
        if (!isGood) {
            try {
                PrintWriter writer;
                writer = new PrintWriter(FILE);
                writer.print("");
                writer.close();
            } catch (FileNotFoundException ex) {
            }
            try {
                towrite = new FileWriter(FILE);
                isGood = true;
            } catch (IOException ex) {
                System.out.printf("ERROR opening filewriter");
                isGood = false;
            }
        }
    }

    public double totalvolts() {
        double inputvolts = pdp.getTotalCurrent();
        return inputvolts;
    }

    public double[] channelVoltage() {
        String csvrow = System.nanoTime() + ",";
        double[] channelvolts = new double[16];
        double sum = 0;
        for (int i = 0; i < 16; i++) {
            double amps = pdp.getCurrent(i);
            channelvolts[i] = amps;
            sum += amps;
            csvrow += amps + ",";
        }
        csvrow += ",";
        if (isGood) {
            try {
                towrite.append(csvrow);
            } catch (IOException ex) {
            }
        }
        max = Math.max(max, sum);
        return channelvolts;
    }

    public double maxVoltage() {
        return max;
    }
}
