package lottery.random.ui.validation.numberofgroups.impl;

import lottery.random.ui.validation.numberofgroups.NumberOfGroupsValidatorIF;
import android.util.Log;
import android.widget.EditText;

/**
 * NumberOfGroupsValidator is a {@link NumberOfGroupsValidatorIF} that
 * checks the number of groups to make sure it is a valid number,
 * and positive (e.g. >= 0).
 * 
 * @author Chris Adamson
 * @version 1.0
 * @see NumberOfGroupsValidatorIF
 */
public class NumberOfGroupsValidator 
implements NumberOfGroupsValidatorIF {

	/**
	 * for logging purposes. 
	 */
	private final String LOG_TAG =
		NumberOfGroupsValidator.class.getSimpleName();
	
	/**
	 * the edit text box to validate. 
	 */
	private final EditText numberOfGroups;

	/**
	 * Constructs the validator using the edit text box
	 * to validate.
	 * 
	 * @param textBox the edit text to validate.
	 * @throws IllegalArgumentException if textBox is null.
	 */
	public NumberOfGroupsValidator(final EditText textBox) {
		
		Log.d(LOG_TAG, "ctor-enter");
		
		if (null == textBox) {
			throw new IllegalArgumentException("textBox can not be null");
		}
		
		this.numberOfGroups = textBox;
		
		Log.d(LOG_TAG, "ctor-exit");				
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see lottery.random.ui.validation.numberofgroups.NumberOfGroupsValidatorIF#isNumberOfGroupsValid()
	 */
	@Override
	public Boolean isNumberOfGroupsValid() {
		
		Log.d(LOG_TAG, "isNumberOfGroupsValid-enter");
		
		Integer value =
			Integer.valueOf(0);
		
		final String strValue =
			numberOfGroups.getText().toString();
		
		try {
			value = Integer.valueOf(strValue);
			
		} catch (final Exception e) {
			
			// Set the error string.
			numberOfGroups.setError(NOT_AN_NUMBER_ERR_STR);
			
			// Bail, we failed.
			return Boolean.FALSE;
		}
		
		// Check for negativity.
		if (value.intValue() < 0) {
			
			// Set the error string.
			numberOfGroups.setError(NEGATIVE_ERR_STR);
			
			// Bail, we failed.
			return Boolean.FALSE;
		}
		
		// Return success.
		return Boolean.TRUE;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see lottery.random.ui.validation.ValidatorIF#isValid()
	 */
	@Override
	public Boolean isValid() {
		Log.d(LOG_TAG, "isValid-enter");
		
		return isNumberOfGroupsValid();
	}
}
