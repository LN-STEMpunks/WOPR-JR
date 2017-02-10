/*
 * 2017-01-06
 *   - Created class, migrating from OI.java, with renames
 */
package team3966.robot.values;

/**
 * PINs of controllers, motor controllers, PCMs, etc.
 * @author cade
 */
public class IDs {

	public static final int controller = 0;

	public static final int L0_motor = 0;
	public static final int L1_motor = 3;
	
	public static final int R0_motor = 1;
	public static final int R1_motor = 2;

	// Not sure if we are using 2 or 4 encoders. Make sure to change in Drive.java
	// these are probably DIO pins, in A/B order
	public static final int L_encoder_dio_A = 3;
	public static final int L_encoder_dio_B = 2;
	public static final int R_encoder_dio_A = 1;
	public static final int R_encoder_dio_B = 0;
	
	
	// not sure if we are using this
	public static final int ultrasonic_0 = 0;

}
