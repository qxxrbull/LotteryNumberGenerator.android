package lottery.random.focus.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.widget.EditText;
import lottery.random.focus.FocusAdjusterIF;

/**
 * FocusAdjuster simply adjusts the list of {@link EditText} boxes
 * by clearing the focus away from them.
 * 
 * @author Chris Adamson
 * @version 1.0
 * @see FocusAdjusterIF
 */
public class FocusAdjuster 
implements FocusAdjusterIF {

	/**
	 * the list of edit text boxes to clear focus with.
	 */
	private final List< EditText > list =
		new ArrayList < EditText >();
	
	/**
	 * Constructs the focus adjuster using the
	 * list of {@link EditText} boxes.
	 * 
	 * @param textObjs the {@link EditText} variable array.
	 * @throws IllegalArgumentException if textObjs is null.
	 */
	public FocusAdjuster(final EditText... textObjs) {
		
		// Sanity check the text object array.
		if (null == textObjs) {
			throw new IllegalArgumentException("textObjs can not be null");
		}
		
		// Get the number of text objects passed
		final int length = 
			textObjs.length;
		
		for(int idx = 0; idx < length; idx++) {
			list.add(textObjs[idx]);
		}
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see lottery.random.focus.FocusAdjusterIF#clearFocus()
	 */
	@Override
	public void clearFocus() {
		
		// Iterate through the list of boxes.
		final Iterator< EditText > itr =
			list.iterator();
		
		// Loop through simply clearing the focus.
		while (itr.hasNext()) {			
			itr.next().clearFocus();
		}
	}
}

