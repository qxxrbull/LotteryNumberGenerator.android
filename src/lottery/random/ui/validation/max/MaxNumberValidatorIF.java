package lottery.random.ui.validation.max;

import lottery.random.ui.validation.ValidatorIF;

/**
 * MaxNumberValidatorIF is a validator class that determines if the
 * maximum number is valid.
 *
 * @author Chris Adamson
 * @version 1.0
 */
public interface MaxNumberValidatorIF 
extends ValidatorIF {

	/**
	 * The error string to use if the maximum number is less then zero. 
	 */
	public static final String NEGATIVE_ERR_STR = 
		"minimum number must be >= 0";
	
	/**
	 * The error string to use if the maximum number is not a number. 
	 */
	public static final String NOT_AN_NUMBER_ERR_STR =
		"minimum number is not a valid integer";
	
	/**
	 * The error string to use if the maximum number is < minimum number. 
	 */
	public static final String MAX_GREATER_THAN_EQUAL_MIN_ERR_STR =
		"maximum number must be >= minimum number";
	
	/**
	 * Determines if the maximum number is valid, and returns a 
	 * corresponding Boolean.
	 * 
	 * @return {@link Boolean#TRUE} if the maximum number is valid, 
	 * {@link Boolean#FALSE} otherwise.
	 */
	Boolean isMaxNumberValid();	
}
