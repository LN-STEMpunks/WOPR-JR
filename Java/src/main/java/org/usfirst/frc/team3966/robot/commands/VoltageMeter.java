package frc.team3966.toastrhino.commands;

import edu.wpi.first.wpilib.AnalogInput;
import frc.team3966.toastrhino.RobotModule;
/*
Goal: Read the voltage used by the channel to find the distance traveled. 
1 Centimeter = 4.9 MilliVolts (0.0049 Volts)
*/ 
public class VoltageMeter extends RobotModule {
        AnalogInput ai = new AnalogInput(0);

        public void Calclations() {
            double voltage = ai.getVoltage();
            double millivolts = voltage * 1000;
            double centimeters = millivolts / 4.9;
            if (centimeters <= 5) {
                RobotModule.drive.doNothing();
            }
    }
}