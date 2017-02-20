/*
 * IDs.java
 * 
 * Holds info for all DIOs, PWM, etc
 * 
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
    public static final int L0_motor = 2;
    public static final int L1_motor = 3;

    public static final int R0_motor = 0;
    public static final int R1_motor = 1;

    public static final int Climb_motor = 4;
    public static final int Intake_motor = 5;
    public static final int Stir_motor = 6;

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
