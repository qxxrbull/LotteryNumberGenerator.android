package lottery.random.ui.validation.groupsize;

import lottery.random.ui.validation.ValidatorIF;

/**
 * GroupSizeValidatorIF is a validator class that determines if the
 * group count/size is valid.
 *
 * @author Chris Adamson
 * @version 1.0
 */
public interface GroupSizeValidatorIF 
extends ValidatorIF {

	/**
	 * The error string to use if the group size is less then zero. 
	 */
	public static final String NEGATIVE_ERR_STR = 
		"group size must be >= 0";
	
	/**
	 * The error string to use if the group size is not a number. 
	 */
	public static final String NOT_AN_NUMBER_ERR_STR =
		"group size is not a valid integer";
	
	/**
	 * The error string to use if the total numbers requested can
	 * not be generated.
	 */
	public static final String INVALID_COMBO_STR =
		"group size is invalid with min/max numbers";
	
	/**
	 * The toast text to display.
	 */
	public static final String TOAST_INVALID_COMBO_STR = 
		"If repeats are not allowed, then (maximum_number - minimum_number + 1) must be >= group size";
	
	/**
	 * Determines if the group size (i.e. the count of numbers in
	 * the group) is valid, and returns a corresponding Boolean.
	 * 
	 * @return {@link Boolean#TRUE} if the group size is valid, 
	 * {@link Boolean#FALSE} otherwise.
	 */
	Boolean isGroupSizeValid();		
}
