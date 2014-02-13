package lottery.random.ui.validation.groupsize.impl;

import lottery.random.ui.validation.groupsize.GroupSizeValidatorIF;
import android.app.Activity;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * GroupSizeValidator is a {@link GroupSizeValidatorIF} which checks
 * the group size validity which includes whether it is a number,
 * if its positive, and if its valid given the minimum, maximum,
 * and whether or not repeats are allowed.
 * 
 * This check is needed especially for the minimum and max, because if
 * it goes unchecked it can cause the application to crash.  For example,
 * if repeats are not allowed, and you want 10 numbers, the min and max
 * must allow for at least 10 numbers.  
 * 
 * An example that would crash the application:
 * - No repeats allowed
 * - min := 0
 * - max := 5
 * - group size := 10
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class GroupSizeValidator 
implements GroupSizeValidatorIF {

	/**
	 * for logging purposes. 
	 */
	private final String LOG_TAG =
		GroupSizeValidator.class.getSimpleName();
	
	/**
	 * check box indicating whether or not 
	 * repeats are allowed. 
	 */
	private final CheckBox repeatsAllowed;
	
	/**
	 * the group size edit text box.
	 */
	private final EditText groupSize;
	
	/**
	 * the maximum number edit text box. 
	 */
	private final EditText maxBox;
	
	/**
	 * the minimum number edit text box. 
	 */
	private final EditText minBox;

	/**
	 * the activity to generate toasts on.
	 */
	private final Activity toastActivity;

	/**
	 * Constructs the validator using the various UI elements
	 * to be validated against each other.
	 * 
	 * @param minimumBox the minimum number edit text box.
	 * @param maximumBox the maximum number edit text box.
	 * @param groupSizeBox the group size edit text box.
	 * @param repeatsAllowedCheckBox repeat numbers are allowed or not.
	 * @param activity the activity to generate Toasts's on.
	 * @throws IllegalArgumentException if any argument is null.
	 */
	public GroupSizeValidator(final EditText minimumBox,
                              final EditText maximumBox,
                              final EditText groupSizeBox,
                              final CheckBox repeatsAllowedCheckBox,
                              final Activity activity) {
		
		Log.d(LOG_TAG, "ctor-enter");
		
		// Sanity check the arguments.
		if (null == minimumBox) {
			throw new IllegalArgumentException("minBox can not be null");
		}
		if (null == maximumBox) {
			throw new IllegalArgumentException("maxBox can not be null");
		}
		if (null == groupSizeBox) {
			throw new IllegalArgumentException("groupSize can not be null");
		}
		if (null == repeatsAllowedCheckBox) {
			throw new IllegalArgumentException("repeatsAllowed can not be null");
		}
		if (null == activity) {
			throw new IllegalArgumentException("activity can not be null");
		}
		
		// Cache references to the passed arguments.
		this.minBox =
			minimumBox;
		
		this.maxBox =
			maximumBox;
		
		this.groupSize =
			groupSizeBox;
		
		this.repeatsAllowed =
			repeatsAllowedCheckBox;
		
		this.toastActivity =
			activity;
		
		Log.d(LOG_TAG, "ctor-exit");		
	}
	/**
	 * {@inheritDoc}
	 * 
	 * @see lottery.random.ui.validation.groupsize.GroupSizeValidatorIF#isGroupSizeValid()
	 */
	@Override
	public Boolean isGroupSizeValid() {
		
		Log.d(LOG_TAG, "isGroupSizeValid-enter");
		
		// Clear any error.
		groupSize.setError(null);
		
		// Grab the repeats allowed value. 
		boolean repAllowed =
			repeatsAllowed.isChecked();
		
		Log.v(LOG_TAG, "[repeatsAllowed := " + repAllowed + "]");
		
		Integer maxValue =
			Integer.valueOf(0);
		
		final String strMaxValue =
			maxBox.getText().toString();
		
		try {
			maxValue = Integer.valueOf(strMaxValue);
			
			Log.v(LOG_TAG, "[maxValue := " + maxValue + "]");
		
		} catch (final Exception e) {
			
			// Do nothing, simply bail.
			return Boolean.FALSE;
		}
		
		Integer minValue =
			Integer.valueOf(0);
		
		final String strMinValue =
			minBox.getText().toString();
		
		try {
			minValue = Integer.valueOf(strMinValue);
		
			Log.v(LOG_TAG, "[minValue := " + minValue + "]");
			
		} catch (final Exception e) {
			
			// Do nothing, simply bail.
			return Boolean.FALSE;
		}
		
		Integer groupSizeValue =
			Integer.valueOf(0);
		
		final String strGroupSizeValue =
			groupSize.getText().toString();
		
		try {
			groupSizeValue = Integer.valueOf(strGroupSizeValue);
		
		} catch (final Exception e) {
			
			// Set the error string.
			groupSize.setError(NOT_AN_NUMBER_ERR_STR);
			
			// Bail, we failed.
			return Boolean.FALSE;
		}
		
		// Check for negativity.
		if (groupSizeValue.intValue() < 0) {
			
			// Set the error string.
			groupSize.setError(NEGATIVE_ERR_STR);
			
			// Bail, we failed.
			return Boolean.FALSE;
		}

		// If repeats are allowed, then we are done because the
		// resulting group set could consist of the same number.
		if (repAllowed) {
			return Boolean.TRUE;
		}
		
		// Calculate the total numbers possible based on
		// the minimum and maximum
		int numberCount =
			maxValue.intValue() - minValue.intValue() + 1;
		
		if (numberCount < groupSizeValue.intValue()) {

			// Display the Toast.
			Toast.makeText(toastActivity, TOAST_INVALID_COMBO_STR, Toast.LENGTH_SHORT);
			
			// Set the error text.
			groupSize.setError(INVALID_COMBO_STR);
			
			// Bail, we failed.
			return Boolean.FALSE;
		}
		
		// Return true, we succeeded.
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
		
		return isGroupSizeValid();
	}
}
