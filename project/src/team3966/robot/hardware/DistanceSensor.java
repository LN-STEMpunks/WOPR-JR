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

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CircularBuffer;

public class DistanceSensor extends AnalogInput {

	// millivolts per meter
	private double V_PER_M = 4.88 / 5;
        
        private CircularBuffer cb = new CircularBuffer(10);
	
	public DistanceSensor(int id) {
		super(id);
		setOversampleBits(5);
		setAverageBits(4);
		setGlobalSampleRate(62500);
		//SmartDashboard.putNumber("Distance Sensor", DistanceSensor.getDistance());
	}

	// returns distance in meters
	// Is finicky, try debugging it
	public double getDistance() {
                double met = getAverageVoltage() * V_PER_M;
                cb.pushFront(met);
		return met;
	}
        public double getVoltages() {
                double met = getVoltage();
                cb.pushFront(met);
		return met;
	}
	public double getAverageVolts() {
                double met = getAverageVoltage();
                cb.pushFront(met);
		return met;
	}
        public double getDistanceAverage() {
		getDistance();
                int minidx = 0, maxidx = 0;
                for (int i = 0; i < 10; ++i) {
                    if (cb.get(i) < cb.get(minidx)) {
                        minidx = i;
                    }
                    if (cb.get(i) > cb.get(maxidx)) {
                        maxidx = i;
                    }
                }
                double avg = 0;
                for (int i = 0; i < 10; ++i) {
                    if (i != minidx && i != maxidx) {
                        avg += cb.get(i);
                    }
                }
                avg = avg / 8;
                return avg;
	}
}

