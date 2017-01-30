/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc3966.robot.values;

/**
 *
 * @author cade
 */
public class PS4Buttons {
    
    public static final int SQUARE = 1;
    public static final int X = 2;
    public static final int CIRCLE = 3;
    public static final int TRIANGLE = 4;
    
    public static final int L1 = 5;
    public static final int R1 = 6;
    
    public static final int L2 = 7;
    public static final int R2 = 8;
    
    public static final int SHARE = 9;
    public static final int OPTIONS = 10;
    
    // L3 and R3 are pressing L and R sticks down
    public static final int L3 = 11;
    public static final int R3 = 12;
    
    public static final int PS = 13;
    public static final int TOUCH_PAD = 14;
    
    /*
    
        These are axes which return a double (not a boolean)
    
    */
    
    //TODO
    public static final int STICK_LEFT_X_AXIS = 0;
    public static final int STICK_LEFT_Y_AXIS = 1;
    
    public static final int STICK_RIGHT_X_AXIS = 2;
    public static final int STICK_RIGHT_Y_AXIS = 5;
    
    public static final int L_TRIGGER_AXIS = 3;
    public static final int R_TRIGGER_AXIS = 4;
    
    // These two are not buttons but POV directions.
    public static final int D_PAD_X_AXIS = -1;
    public static final int D_PAD_Y_AXIS = -1;
}
