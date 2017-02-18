/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3966.robot.commands;

import edu.wpi.first.wpilibj.Solenoid;
/**
 *
 * @author Tyler Duckworth
 */
public class GearPneumaticsController {
    Solenoid leftsolenoid = new Solenoid(0);
    Solenoid rightsolenoid = new Solenoid(1);
    public boolean RightStatus() {
        boolean rightstatus = rightsolenoid.get();
        return rightstatus;
    }
    
    public boolean LeftStatus () {
        boolean leftstatus = leftsolenoid.get();
        return leftstatus;
    }
    
    public boolean LeftBlacklisted () {
        boolean leftblacklisted = leftsolenoid.isBlackListed();
        return leftblacklisted;
    }
    
    public boolean RightBlackListed () {
        boolean rightblacklisted = rightsolenoid.isBlackListed();
        return rightblacklisted;
    }
    public void enable () {
        leftsolenoid.set(true);
        rightsolenoid.set(true);
    }
    public void disable () {
        leftsolenoid.set(false);
        rightsolenoid.set(false);
    }
}
