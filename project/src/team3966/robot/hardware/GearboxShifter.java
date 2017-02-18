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
 * @author Ethan Duckworth
 */
public class GearboxShifter {
    Solenoid leftmotor = new Solenoid(IDs.gearbox_shifter1);
    Solenoid rightmotot = new Solenoid(IDs.gearbox_shifter2);
    
    
}
