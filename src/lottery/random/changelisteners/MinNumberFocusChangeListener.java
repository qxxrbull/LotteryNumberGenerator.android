package lottery.random.changelisteners;

import lottery.random.generation.parameters.ParameterMinNumber;
import lottery.random.number.generator.RandomNumberGeneratorIF;
import android.util.Log;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

/**
 * MinNumberFocusChangeListener is an OnFocusChangeListener which
 * updates the number generator with values from the {@link EditText}
 * min number box whenever focus is lost (when focus is gained by
 * the box, the value is ignored).
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class MinNumberFocusChangeListener 
implements OnFocusChangeListener {

	/**
	 * for updating the parameter on the generator. 
	 */
	private final RandomNumberGeneratorIF numberGenerator;
	
	/**
	 * for retrieving the updated value of the edit text box. 
	 */
	private final EditText numberBox;
	
	/**
	 * for logging purposes. 
	 */
	private final String LOG_TAG =
		MinNumberFocusChangeListener.class.getSimpleName();

	/**
	 * Constructs the focus change listener using the generator to
	 * update, and the edit text box to retrieve values from.
	 * 
	 * @param generator the generator to update new parameters with.
	 * @param minNumberBox the {@link EditText} to retrieve values from.
	 * @throws IllegalArgumentException if any parameter is null.
	 */
	public MinNumberFocusChangeListener(final RandomNumberGeneratorIF generator,
                                        final EditText minNumberBox) {
		
		Log.d(LOG_TAG, "ctor-enter");
		
		// Sanity Check the arguments.
		if (null == generator) {
			throw new IllegalArgumentException("generator can not be null");
		}
		if (null == minNumberBox) {
			throw new IllegalArgumentException("minNumberBox can not be null");
		}
		
		this.numberGenerator = generator;
		this.numberBox = minNumberBox;
		
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
			Log.v(LOG_TAG, "onFocusChange-[min box gained focus, exiting]");
			return;
		}
		
		final Integer minValue = 
			Integer.valueOf(numberBox.getText().toString());
			
		
		final ParameterMinNumber newMin =
			new ParameterMinNumber(minValue);
		
		numberGenerator.setMinimumNumberParameter(newMin);
		
		Log.v(LOG_TAG, "onFocusChange-[min box new value:=" + minValue + "]");
		
		Log.d(LOG_TAG, "onFocusChange-exit");
	}
}
