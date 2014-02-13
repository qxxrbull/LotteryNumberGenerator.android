package lottery.random.changelisteners;

import lottery.random.generation.parameters.ParameterRepeatNumbersAllowed;
import lottery.random.group.generator.RandomGroupGeneratorIF;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/**
 * RepeatNumbersAllowedCheckedChangeListener is an OnCheckedChangeListener 
 * which updates the group generator with values from the repeat numbers 
 * allowed {@link CheckBox} whenever it is checked.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class RepeatNumbersAllowedCheckedChangeListener 
implements OnCheckedChangeListener {

	/**
	 * for updating the parameter on the generator. 
	 */
	private final RandomGroupGeneratorIF numberGenerator;
	
	/**
	 * for retrieving the updated value of the check box. 
	 */
	private final CheckBox checkBox;
	
	/**
	 * for logging purposes. 
	 */
	private final String LOG_TAG =
		RepeatNumbersAllowedCheckedChangeListener.class.getSimpleName();
	
	/**
	 * Constructs the check box change listener using the generator to
	 * update, and the check box to retrieve a boolean value from.
	 * 
	 * @param generator the generator to update new parameters with.
	 * @param allowedBox the {@link CheckBox} to retrieve a boolean value from.
	 */
	public RepeatNumbersAllowedCheckedChangeListener(final RandomGroupGeneratorIF generator,
                                                     final CheckBox allowedBox) {
		
		Log.d(LOG_TAG, "ctor-enter");
		
		// Sanity Check the arguments.
		if (null == generator) {
			throw new IllegalArgumentException("generator can not be null");
		}
		if (null == allowedBox) {
			throw new IllegalArgumentException("allowedBox can not be null");
		}
		
		this.numberGenerator = generator;
		this.checkBox = allowedBox;
		
		Log.d(LOG_TAG, "ctor-exit");
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see android.widget.CompoundButton.OnCheckedChangeListener#onCheckedChanged(android.widget.CompoundButton, boolean)
	 */
	@Override
	public void onCheckedChanged(final CompoundButton buttonView, 
                                 final boolean isChecked) {
		
		Log.d(LOG_TAG, "onCheckedChanged-enter");

		final Boolean repeatsAllowedValue = 
			Boolean.valueOf(checkBox.isChecked());
		
		final ParameterRepeatNumbersAllowed newAllowedValue =
			new ParameterRepeatNumbersAllowed(repeatsAllowedValue);
		
		numberGenerator.setRepeatNumbersAllowed(newAllowedValue);
		
		Log.v(LOG_TAG, "ParameterRepeatNumbersAllowed-[repeat numbers allowed new value:=" + repeatsAllowedValue + "]");
		
		Log.d(LOG_TAG, "ParameterRepeatNumbersAllowed-exit");
	}
}
