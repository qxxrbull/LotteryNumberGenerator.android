package lottery.random.getmyluckynumbers;

import java.util.Iterator;

import lottery.random.focus.FocusAdjusterIF;
import lottery.random.group.RandomGroup;
import lottery.random.group.set.RandomGroupSet;
import lottery.random.group.set.generator.RandomGroupSetGeneratorIF;
import lottery.random.number.RandomNumber;
import lottery.random.ui.validation.ValidationUserIF;
import lottery.random.ui.validation.ValidatorIF;
import lottery.random.ui.validation.list.ValidatorList;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * GetMyLuckyNumbersClickListener is a listener which handles the click
 * on the get my lucky numbers.  When the button is clicked, it uses
 * the group set generator to generate a set of random groups, where
 * each group is also a list of random numbers.
 * 
 * Version History:
 * 1.0 - first version
 * 1.1 - added validation check
 * 
 * @author Chris Adamson
 * @version 1.1
 */
public class GetMyLuckyNumbersClickListener 
implements OnClickListener, ValidationUserIF {
	
	/**
	 * the text view that displays the groups of numbers. 
	 */
	private final TextView groupDisplayBox;
	
	/**
	 * the generator to get sets of groups from.
	 */
	private final RandomGroupSetGeneratorIF groupSetGenerator;

	/**
	 * for logging purposes. 
	 */
	private final String LOG_TAG =
		GetMyLuckyNumbersClickListener.class.getSimpleName();

	/**
	 * the focus adjuster. 
	 */
	private FocusAdjusterIF focusAdjuster;
	
	/**
	 * the list of validators. 
	 */
	private final ValidatorList validators = new ValidatorList();

	/**
	 * Constructs the listener using the text view to display
	 * the groups in, and the generator to get sets of numbers
	 * from.  It also takes a focus adjuster which allows for focus UI changes.
	 * 
	 * @param pastNumbersBox the display box for the numbers.
	 * @param groupGenerator the group set generator.
	 * @param adjuster the focus adjuster for the other UI elements.
	 * @throws IllegalArgumentException if any argument is null.
	 */
	public GetMyLuckyNumbersClickListener(final TextView pastNumbersBox,
                                          final RandomGroupSetGeneratorIF groupGenerator,
                                          final FocusAdjusterIF adjuster) {
		
    	Log.d(LOG_TAG, "ctor-enter");
		
		// Sanity the arguments.
		if (null == pastNumbersBox) {
			throw new IllegalArgumentException("pastNumbersBox can not be null");
		}
		if (null == groupGenerator) {
			throw new IllegalArgumentException("groupGenerator can not be null");
		}
		if (null == adjuster) {
			throw new IllegalArgumentException("adjuster can not be null");
		}
		
		this.groupDisplayBox =
			pastNumbersBox;
		
		this.groupSetGenerator =
			groupGenerator;
		
		this.focusAdjuster = adjuster;
		
    	Log.d(LOG_TAG, "ctor-exit");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(final View view) {

    	Log.d(LOG_TAG, "onClick-enter");
    	
    	// Remove the focus from the other UI elements.
    	focusAdjuster.clearFocus();
    	
    	Boolean validationSuccess = performValidation();
    	
    	if (validationSuccess.booleanValue() == false) {
    		Log.e(LOG_TAG, "validation failed");
    		return;
    	}
    	
    	final RandomGroupSet set = 
    		groupSetGenerator.generateRandomGroupSet();

    	final Iterator < RandomGroup > itr =
    		set.iterator();

    	int idx = 1;
    	
    	final StringBuilder builder =
    		new StringBuilder();
    	
    	while (itr.hasNext()) {
    		
    		// Set up the first part of the group string.
    		builder.append("Group ").append(idx++).append(":");
    		
    		// Grab the next group from the set.
    		final RandomGroup group = itr.next();
    		
    		// Iterate through the group.
    		final Iterator< RandomNumber > groupItr =
    			group.iterator();
    		
    		// Build up the group of random numbers string.
    		while (groupItr.hasNext()) {
    			builder.append(" ").append(groupItr.next().toString());
    		}
    		
    		builder.append("\n");
    	}
    	
    	Log.v(LOG_TAG, "Number Set: " + builder.toString());
    	
    	groupDisplayBox.setText(builder.toString());
    	
    	Log.d(LOG_TAG, "onClick-exit");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see lottery.random.ui.validation.ValidationUserIF#addValidator(lottery.random.ui.validation.ValidatorIF)
	 * @throws IllegalArgumentException if validator is null.
	 */
	@Override
	public void addValidator(final ValidatorIF validator) {
    	
		Log.d(LOG_TAG, "addValidator-enter");
		
		if (null == validator) {
			throw new IllegalArgumentException("validator can not be null");
		}
		
		validators.add(validator);
		
		Log.d(LOG_TAG, "addValidator-exit");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see lottery.random.ui.validation.ValidationUserIF#removeValidator(lottery.random.ui.validation.ValidatorIF)
	 * @throws IllegalArgumentException if validator is null.
	 */
	@Override
	public void removeValidator(final ValidatorIF validator) {
		
		Log.d(LOG_TAG, "removeValidator-enter");

		if (null == validator) {
			throw new IllegalArgumentException("validator can not be null");
		}
		
		validators.remove(validator);
		
		Log.d(LOG_TAG, "removeValidator-exit");
	}
	
	/**
	 * Performs the validation step, if there is nothing
	 * to validate (i.e. no validators) it returns TRUE
	 * by default.
	 */
	private Boolean performValidation() {

		// Assume success to begin.
		Boolean isValid = Boolean.TRUE;
		
		if (hasValidationToPerform().booleanValue() == true) {
			
			final Iterator< ValidatorIF > itr =
				validators.iterator();
			
			while (itr.hasNext()) {
				
				ValidatorIF validator = itr.next();
		
				// Flag that we failed at least one validation. 
				if (validator.isValid() == Boolean.FALSE) {
					isValid = Boolean.FALSE;
				}
			}
			
		}
		
		// Return whether we succeeded or not.
		return isValid;
	}
	
	/**
	 * Returns a boolean indicating whether or not validation needs
	 * to happen.
	 * 
	 * @return true if there is validation to perform, false otherwise.
	 */
	private Boolean hasValidationToPerform() {
		return validators.size() > 0;
	}
}

