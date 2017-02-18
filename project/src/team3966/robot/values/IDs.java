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

	public static final int L0_motor = 0;
	public static final int L1_motor = 3;
	
	public static final int R0_motor = 1;
	public static final int R1_motor = 2;
	
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
        public static final int gearbox_shifter1 = 0;
        public static final int gearbox_shifter2 = 1;
        public static final int left_gearcylinder = 2;
        public static final int right_gearcylider = 3;

}
