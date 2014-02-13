package lottery.random.changelisteners;

import lottery.random.generation.parameters.ParameterNumberOfGroups;
import lottery.random.group.set.generator.RandomGroupSetGeneratorIF;
import android.util.Log;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

/**
 * GroupCountFocusChangeListener is an OnFocusChangeListener which
 * updates the group generator with values from the {@link EditText}
 * group count box whenever focus is lost (when focus is gained by
 * the box, the value is ignored).
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class GroupCountFocusChangeListener 
implements OnFocusChangeListener {

	/**
	 * for updating the parameter on the generator. 
	 */
	private final RandomGroupSetGeneratorIF groupGenerator;
	
	/**
	 * for retrieving the updated value of the edit text box. 
	 */
	private final EditText numberBox;
	
	/**
	 * for logging purposes. 
	 */
	private final String LOG_TAG =
		GroupCountFocusChangeListener.class.getSimpleName();
	
	/**
	 * Constructs the focus change listener using the generator to
	 * update, and the edit text box to retrieve values from.
	 * 
	 * @param generator the generator to update new parameters with.
	 * @param groupCountBox the {@link EditText} to retrieve values from.
	 */
	public GroupCountFocusChangeListener(final RandomGroupSetGeneratorIF generator,
                                         final EditText groupCountBox) {
		
		Log.d(LOG_TAG, "ctor-enter");
		
		// Sanity Check the arguments.
		if (null == generator) {
			throw new IllegalArgumentException("generator can not be null");
		}
		if (null == groupCountBox) {
			throw new IllegalArgumentException("groupCountBox can not be null");
		}
		
		this.groupGenerator = generator;
		this.numberBox = groupCountBox;
		
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
			Log.v(LOG_TAG, "onFocusChange-[group count box gained focus, exiting]");
			return;
		}
		
		final Integer groupCountValue = 
			Integer.valueOf(numberBox.getText().toString());
		
		final ParameterNumberOfGroups newGroupCount =
			new ParameterNumberOfGroups(groupCountValue);
		
		groupGenerator.setGroupCountParameter(newGroupCount);
		
		Log.v(LOG_TAG, "onFocusChange-[group count new value:=" + groupCountValue + "]");
		
		Log.d(LOG_TAG, "onFocusChange-exit");
	}
}
