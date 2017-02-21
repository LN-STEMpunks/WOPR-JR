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
package team3966.robot.values;

public class IDs {

    /*
	 * 
	 * USB/things not on the robot
	 * 
     */
    public static final int controller = 0;

    /*
	 * 
	 * CANS/PWM
	 * 
     */
    public static final int L0Motor = 2;
    public static final int L1Motor = 3;

    public static final int R0Motor = 0;
    public static final int R1Motor = 1;

    public static final int climbMotor = 4;
    public static final int intakeMotor = 5;
    public static final int stirMotor = 6;

    public static final int shooterMotor = 7;

    /*
	 * 
	 * DIO
	 * 
     */
    // Not sure if we are using 2 or 4 encoders. Make sure to change in Drive.java
    public static final int[] L_encoder_dio = {3, 2};
    public static final int[] R_encoder_dio = {1, 0};

    /*
	 * 
	 * Analog
	 * 
     */
 /*
	 * 
	 * Serial
	 * 
     */
    // not sure if we are using this
    public static final int ultrasonic_0 = 0;

    public static final int gearboxHighGear = 4;
    public static final int gearboxLowGear = 5;

    public static final int gearGateOpen = 0;
    public static final int gearGateClose = 1;

    public static final int gearIntakeLower = 2;
    public static final int gearIntakeTighten = 3;
    public static final int talonCANID = 3;
}
