package lottery.random.changelisteners;

import lottery.random.generation.parameters.ParameterNumbersInAGroup;
import lottery.random.group.generator.RandomGroupGeneratorIF;
import android.util.Log;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

/**
 * NumbersInAGroupFocusChangeListener is an OnFocusChangeListener which
 * updates the group generator with values from the {@link EditText}
 * group count number box whenever focus is lost (when focus is gained by
 * the box, the value is ignored).
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class NumbersInAGroupFocusChangeListener 
implements OnFocusChangeListener {

	/**
	 * for updating the parameter on the generator. 
	 */
	private final RandomGroupGeneratorIF numberGenerator;
	
	/**
	 * for retrieving the updated value of the edit text box. 
	 */
	private final EditText numberBox;
	
	/**
	 * for logging purposes. 
	 */
	private final String LOG_TAG =
		NumbersInAGroupFocusChangeListener.class.getSimpleName();
	
	/**
	 * Constructs the focus change listener using the generator to
	 * update, and the edit text box to retrieve values from.
	 * 
	 * @param generator the generator to update new parameters with.
	 * @param numbersInAGroup the {@link EditText} to retrieve values from.
	 */
	public NumbersInAGroupFocusChangeListener(final RandomGroupGeneratorIF generator,
                                              final EditText numbersInAGroup) {
		
		Log.d(LOG_TAG, "ctor-enter");
		
		// Sanity Check the arguments.
		if (null == generator) {
			throw new IllegalArgumentException("generator can not be null");
		}
		if (null == numbersInAGroup) {
			throw new IllegalArgumentException("numbersInAGroup can not be null");
		}
		
		this.numberGenerator = generator;
		this.numberBox = numbersInAGroup;
		
		Log.d(LOG_TAG, "ctor-exit");
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see android.view.View.OnFocusChangeListener#onFocusChange(android.view.View, boolean)
	 */
	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		
		Log.d(LOG_TAG, "onFocusChange-enter");

		// We only care when the box loses focus.
		if (hasFocus) {
			Log.v(LOG_TAG, "onFocusChange-[numbers in a group box gained focus, exiting]");
			return;
		}
		
		final Integer groupCountValue = 
			Integer.valueOf(numberBox.getText().toString());
		
		final ParameterNumbersInAGroup newGroupCount =
			new ParameterNumbersInAGroup(groupCountValue);
		
		numberGenerator.setCountOfNumbersInAGroup(newGroupCount);
		
		Log.v(LOG_TAG, "onFocusChange-[numbers in a group box new value:=" + groupCountValue + "]");
		
		Log.d(LOG_TAG, "onFocusChange-exit");
	}
}
