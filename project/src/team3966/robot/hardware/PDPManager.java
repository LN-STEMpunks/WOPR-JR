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

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Tyler Duckworth
 */
public class PDPManager {

    public final String FILE = "/home/lvuser/pdp.log";
    PowerDistributionPanel pdp = new PowerDistributionPanel();
    double max = 0;
    long stime, ltime;
    FileWriter towrite;
    boolean isGood = false;

    public PDPManager() {
    }

    public void startLogging() {
        if (!isGood) {
            stime = System.nanoTime();
            ltime = stime;

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

    public double[] channelCurrent(){
        String csvrow = ((System.nanoTime()-stime)*Math.pow(10, -9)) + ",";
        double[] channelvolts = new double[16];
        double sum = 0;
        for (int i = 0; i < 16; i++) {
            double amps = pdp.getCurrent(i);
            channelvolts[i] = amps;
            sum += amps;
            csvrow += amps + ",";
        }
        csvrow += ",";
//        if (isGood) {
//            if ((System.nanoTime() - ltime) * Math.pow(10, -9) > .5) {
//                ltime = System.nanoTime();
//                try {
//                    towrite.append(csvrow);
//                } catch (IOException ex) {
//                }
//            }
//
//        }
        max = Math.max(max, sum);
        return channelvolts;
    }

    public double maxVoltage() {
        return max;
    }
}
