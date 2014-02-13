package lottery.random.ui.validation.min;

import lottery.random.ui.validation.ValidatorIF;

/**
 * MinNumberValidatorIF is a validator class that determines if the
 * minimim number is valid.
 *
 * @author Chris Adamson
 * @version 1.0
 */
public interface MinNumberValidatorIF 
extends ValidatorIF {

	/**
	 * The error string to use if the minimum number is less then zero. 
	 */
	public static final String NEGATIVE_ERR_STR = 
		"minimum number must be >= 0";
	
	/**
	 * The error string to use if the minimum number is not a number. 
	 */
	public static final String NOT_AN_NUMBER_ERR_STR =
		"minimum number is not a valid integer";
	
	/**
	 * The error string to use if the minimum number is > maximum number. 
	 */
	public static final String MIN_LESS_THAN_MAX_ERR_STR =
		"minimum number must be <= maximum number";
	
	/**
	 * Determines if the minimum number is valid, and returns a 
	 * corresponding Boolean.
	 * 
	 * @return {@link Boolean#TRUE} if the minimum number is valid, 
	 * {@link Boolean#FALSE} otherwise.
	 */
	Boolean isMinNumberValid();
}
