package lottery.random.ui.validation.max.impl;

import lottery.random.ui.validation.max.MaxNumberValidatorIF;
import android.util.Log;
import android.widget.EditText;

/**
 * MaxNumberValidator implements {@link MaxNumberValidatorIF} to 
 * provide a validator which checks the maximum number for negative
 * values, non-numbers, and that it's greater then or equal to the maximum
 * number.  
 * 
 * @author Chris Adamson
 * @version 1.0
 * @see MaxNumberValidatorIF
 */
public class MaxNumberValidator 
implements MaxNumberValidatorIF {

	/**
	 * for logging purposes. 
	 */
	private final String LOG_TAG =
		MaxNumberValidator.class.getSimpleName();
	
	/**
	 * the maximum number edit text box. 
	 */
	private EditText maximumBox;
	
	/**
	 * the minumum number edit text box. 
	 */
	private EditText miniumumBox;
	
	/**
	 * Constructs the validator using the minimum,
	 * and maximum number edit text boxes.
	 * 
	 * @param minBox the minumum number edit text box. 
	 * @param maxBox the maximum number box. 
	 * @throws IllegalArgumentException if any argument is null.
	 */
	public MaxNumberValidator(final EditText minBox,
			                  final EditText maxBox) {
		
		Log.d(LOG_TAG, "ctor-enter");
		
		if (null == minBox) {
			throw new IllegalArgumentException("minBox can not be null");
		}
		if (null == maxBox) {
			throw new IllegalArgumentException("maxBox can not be null");
		}
		
		this.miniumumBox =
			minBox;
		
		this.maximumBox = 
			maxBox;
		
		Log.d(LOG_TAG, "ctor-exit");
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see lottery.random.ui.validation.max.MaxNumberValidatorIF#isMaxNumberValid()
	 */
	@Override
	public Boolean isMaxNumberValid() {

		Log.d(LOG_TAG, "isMaxNumberValid-enter");
		
		// Clear any error.
		maximumBox.setError(null);
		
		Integer maxValue =
			Integer.valueOf(0);
		
		final String strValue =
			maximumBox.getText().toString();
		
		try {
			maxValue = Integer.valueOf(strValue);
		
		} catch (final Exception e) {
			
			// Set the error string.
			maximumBox.setError(NOT_AN_NUMBER_ERR_STR);
			
			// Bail, we failed.
			return Boolean.FALSE;
		}
		
		// Check for negativity.
		if (maxValue.intValue() < 0) {
			
			// Set the error string.
			maximumBox.setError(NEGATIVE_ERR_STR);
			
			// Bail, we failed.
			return Boolean.FALSE;
		}

		final String strMinValue =
			miniumumBox.getText().toString();

		Integer minValue =
			Integer.valueOf(0);
		
		try {
			minValue = Integer.valueOf(strMinValue);
		
		} catch (final Exception e) {
			
			// Do nothing, simply bail.
			return Boolean.FALSE;
		}
		
		if (maxValue.intValue() < minValue.intValue()) {
			
			// Set the error string.
			maximumBox.setError(MAX_GREATER_THAN_EQUAL_MIN_ERR_STR);
			
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
		
		return isMaxNumberValid();
	}
}
