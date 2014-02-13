package lottery.random.ui.validation.min.impl;

import lottery.random.ui.validation.min.MinNumberValidatorIF;
import android.util.Log;
import android.widget.EditText;

/**
 * MinNumberValidator implements {@link MinNumberValidatorIF} to 
 * provide a validator which checks the minimum number for negative
 * values, non-numbers, and that it's less then or equal to the maximum
 * number.  
 * 
 * @author Chris Adamson
 * @version 1.0
 * @see MinNumberValidatorIF
 */
public class MinNumberValidator 
implements MinNumberValidatorIF {

	/**
	 * for logging purposes. 
	 */
	private final String LOG_TAG =
		MinNumberValidator.class.getSimpleName();
	
	/**
	 * the maximum number edit text box. 
	 */
	private EditText maximumBox;
	
	/**
	 * the minimum number edit text box. 
	 */
	private EditText miniumumBox;

	/**
	 * Constructs the validator using the minimum,
	 * and maximum number edit text boxes.
	 * 
	 * @param minBox the minimum number edit text box. 
	 * @param maxBox the maximum number box. 
	 * @throws IllegalArgumentException if any argument is null.
	 */
	public MinNumberValidator(final EditText minBox,
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
	 * @see lottery.random.ui.validation.min.MinNumberValidatorIF#isMinNumberValid()
	 */
	@Override
	public Boolean isMinNumberValid() {
		
		Log.d(LOG_TAG, "isMinNumberValid-enter");
		
		// Clear any error.
		miniumumBox.setError(null);
		
		Integer minValue =
			Integer.valueOf(0);
		
		final String strValue =
			miniumumBox.getText().toString();
		
		try {
			minValue = Integer.valueOf(strValue);
		
		} catch (final Exception e) {
			
			// Set the error string.
			miniumumBox.setError(NOT_AN_NUMBER_ERR_STR);
			
			// Bail, we failed.
			return Boolean.FALSE;
		}
		
		// Check for negativity.
		if (minValue.intValue() < 0) {
			
			// Set the error string.
			miniumumBox.setError(NEGATIVE_ERR_STR);
			
			// Bail, we failed.
			return Boolean.FALSE;
		}

		final String strMaxValue =
			maximumBox.getText().toString();

		Integer maxValue =
			Integer.valueOf(0);
		
		try {
			maxValue = Integer.valueOf(strMaxValue);
		
		} catch (final Exception e) {
			
			// Do nothing, simply bail.
			return Boolean.FALSE;
		}
		
		if (minValue.intValue() > maxValue.intValue()) {
			
			// Set the error string.
			miniumumBox.setError(MIN_LESS_THAN_MAX_ERR_STR);
			
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
		
		return isMinNumberValid();
	}
}
