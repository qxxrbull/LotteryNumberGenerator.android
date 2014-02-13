package lottery.random.ui.validation.numberofgroups;

import lottery.random.ui.validation.ValidatorIF;

/**
 * NumberOfGroupsValidatorIF is a validator class that determines if the
 * number of groups is valid.
 *
 * @author Chris Adamson
 * @version 1.0
 */
public interface NumberOfGroupsValidatorIF 
extends ValidatorIF {

	/**
	 * The error string to use if the number of groups is less then zero. 
	 */
	public static final String NEGATIVE_ERR_STR = 
		"number of groups must be >= 0";
	
	/**
	 * The error string to use if the number of groups is not a number. 
	 */
	public static final String NOT_AN_NUMBER_ERR_STR =
		"number of groups is not a valid integer";
	
	
	/**
	 * Determines if the number of groups  is valid, and returns a 
	 * corresponding Boolean.
	 * 
	 * @return {@link Boolean#TRUE} if the number of groups is valid, 
	 * {@link Boolean#FALSE} otherwise.
	 */
	Boolean isNumberOfGroupsValid();		
}
