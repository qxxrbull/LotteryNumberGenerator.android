package lottery.random;

import lottery.random.changelisteners.GroupCountFocusChangeListener;
import lottery.random.changelisteners.MaxNumberFocusChangeListener;
import lottery.random.changelisteners.MinNumberFocusChangeListener;
import lottery.random.changelisteners.NumbersInAGroupFocusChangeListener;
import lottery.random.changelisteners.RepeatNumbersAllowedCheckedChangeListener;
import lottery.random.focus.FocusAdjusterIF;
import lottery.random.focus.impl.FocusAdjuster;
import lottery.random.generation.parameters.ParameterMaxNumber;
import lottery.random.generation.parameters.ParameterMinNumber;
import lottery.random.generation.parameters.ParameterNumberOfGroups;
import lottery.random.generation.parameters.ParameterNumbersInAGroup;
import lottery.random.generation.parameters.ParameterRepeatNumbersAllowed;
import lottery.random.generation.parameters.defaults.DefaultParameterMaxNumber;
import lottery.random.generation.parameters.defaults.DefaultParameterMinNumber;
import lottery.random.generation.parameters.defaults.DefaultParameterNumberOfGroups;
import lottery.random.generation.parameters.defaults.DefaultParameterNumbersInAGroup;
import lottery.random.generation.parameters.defaults.DefaultParameterRepeatNumbersAllowed;
import lottery.random.getmyluckynumbers.GetMyLuckyNumbersClickListener;
import lottery.random.group.generator.RandomGroupGeneratorIF;
import lottery.random.group.generator.impl.RandomGroupGenerator;
import lottery.random.group.set.generator.RandomGroupSetGeneratorIF;
import lottery.random.group.set.generator.impl.RandomGroupSetGenerator;
import lottery.random.number.generator.RandomNumberGeneratorIF;
import lottery.random.number.generator.impl.RandomNumberGenerator;
import lottery.random.ui.validation.groupsize.impl.GroupSizeValidator;
import lottery.random.ui.validation.max.impl.MaxNumberValidator;
import lottery.random.ui.validation.min.impl.MinNumberValidator;
import lottery.random.ui.validation.numberofgroups.impl.NumberOfGroupsValidator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * RandomLotteryActivity is the primary screen (Activity) which
 * the user interacts with.  It displays all of the generator
 * parameters which are changeable, and then allows the user to
 * generate sets of numbers.
 * 
 * Version History:
 * 1.0 - first version
 * 1.1 - added validation code for go button.
 * 
 * @author Chris Adamson
 * @version 1.1
 */
public class RandomLotteryActivity 
extends Activity {
	
	/**
	 * for logging purposes. 
	 */
	private final String LOG_TAG =
		RandomLotteryActivity.class.getSimpleName();
	
	/**
	 * the view that controls the minimum random number.
	 */
	private EditText minBox;
	
	/**
	 * the view that controls the maximum random number.
	 */
	private EditText maxBox;
	
	/**
	 * the view that controls the number of groups to generate.
	 */
	private EditText groupCountBox;
	
	/**
	 * the view that controls the count of numbers in each group.
	 */
	private EditText numbersInAGroupBox;
	
	/**
	 * the view that controls whether or not repeats are allowed
	 * in each group.
	 */
	private CheckBox repeatsAllowedCheckBox;
	
	/**
	 * the engine parameter for the maximum number.
	 */
	private ParameterMaxNumber maxNumberParameter =
		new DefaultParameterMaxNumber();
	
	/**
	 * the engine parameter for the minimum number.
	 */
	private ParameterMinNumber minNumberParameter =
		new DefaultParameterMinNumber();
	
	/**
	 * the engine parameter for number count in each group.
	 */
	private ParameterNumbersInAGroup numbersInAGroupParameter =
		new DefaultParameterNumbersInAGroup();
	
	/**
	 * the engine parameter for number of groups to generate.
	 */
	private ParameterNumberOfGroups numberOfGroupsParameter =
		new DefaultParameterNumberOfGroups();
	
	/**
	 * the random number generator. 
	 */
	private RandomNumberGeneratorIF numberGenerator;
	
	/**
	 * the random group generator.
	 */
	private RandomGroupGeneratorIF groupGenerator;
	
	/**
	 * the random group set generator.
	 */
	private RandomGroupSetGeneratorIF groupSetGenerator;
	
	/**
	 * the engine parameter for repeats allowed in each group.
	 */
	private ParameterRepeatNumbersAllowed repeatsAllowedParameter =
		new DefaultParameterRepeatNumbersAllowed();
	
	/**
	 * the button to retrieve the numbers with.
	 */
	private Button getMyNumbersButton;

	/**
	 * the on click listener for the get my lucky numbers button.
	 */
	private GetMyLuckyNumbersClickListener clickListener;
    
	/** 
     * Called when the activity is first created. 
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	Log.d(LOG_TAG, "onCreate-enter");
    	
    	// Invoke the super class behavior.
        super.onCreate(savedInstanceState);
        
        // Set the content view.
        setContentView(R.layout.main);
 
        // Cache a local reference to the min number box.
        this.minBox =
        	(EditText) findViewById(R.id.BoxMinNumber);
        
        // Cache a local reference to the max number box.
        this.maxBox =
        	(EditText) findViewById(R.id.BoxMaxNumber);
                
        // Cache a local reference to number of groups box.
        this.groupCountBox =
        	(EditText) findViewById(R.id.BoxNumberOfGroups);
        
        // Cache a local reference to the numbers in a group box.
        this.numbersInAGroupBox =
        	(EditText) findViewById(R.id.BoxHowManyNumbersInGroup);
        
        // Cache a local reference to the repeats allowed check box.
        this.repeatsAllowedCheckBox =
        	(CheckBox) findViewById(R.id.CheckBoxNoRepeatNumbers);
        
        // Cache a local reference to the get my lucky numbers buttons.
        this.getMyNumbersButton =
        	(Button) findViewById(R.id.ButtonGetMyLuckyNumbers);
        
        // Set the defaults
        setDefaults();
        
        // Create the random number generator.
        numberGenerator = 
        	new RandomNumberGenerator(minNumberParameter, maxNumberParameter);
        
        // Create the group generator.
        groupGenerator =
        	new RandomGroupGenerator(numbersInAGroupParameter, 
                                     repeatsAllowedParameter, 
                                     numberGenerator);
        
        // Create the group set generator.
        groupSetGenerator =
        	new RandomGroupSetGenerator(groupGenerator);
        
        // Setup listeners for changes to the parameters
        setChangeListeners();
        
        // Grab the numbers text view.
        final TextView pastNumbersBox =
        	(TextView) findViewById(R.id.PastNumbers);
        
        // Create the focus adjuster.
        final FocusAdjusterIF adjuster =
        	new FocusAdjuster(minBox, maxBox, groupCountBox, numbersInAGroupBox);
        
        // Create the click listener.
        this.clickListener =
        	new GetMyLuckyNumbersClickListener(pastNumbersBox, 
                                               groupSetGenerator, 
                                               adjuster);
        
        // Set click listener on the get my numbers button.
        getMyNumbersButton.setOnClickListener(clickListener);
    	
        // Add the validation objects.
        addValidation();
        
		Log.d(LOG_TAG, "onCreate-exit");
    }
    
    /**
     * Sets the default values on the box's.
     */
    private void setDefaults() {

    	Log.d(LOG_TAG, "setDefaults-enter");
    	
    	// Set the minimum value box.
    	minBox.setText(String.valueOf(minNumberParameter.intValue()));
    	
    	// Set the maximum value box.
    	maxBox.setText(String.valueOf(maxNumberParameter.intValue()));
    	
    	// Set the number of groups box.
    	groupCountBox.setText(String.valueOf(numberOfGroupsParameter.intValue()));
    	
    	// Set the numbers in a group box.
    	numbersInAGroupBox.setText(String.valueOf(numbersInAGroupParameter.intValue()));
    	
    	// Set the repeats allowed check box.
    	repeatsAllowedCheckBox.setChecked(Boolean.valueOf(repeatsAllowedParameter.areRepeatNumbersAllowed()));
    	
    	Log.d(LOG_TAG, "setDefaults-exit");
    }
    
    /**
     * Sets up the change listeners for the individual parameters
     * that control the random number generation. 
     */
    private void setChangeListeners() {

    	Log.d(LOG_TAG, "setChangeListeners-enter");
    	
        maxBox.setOnFocusChangeListener(new 
        		MaxNumberFocusChangeListener(numberGenerator, 
                                             maxBox));
    	
        minBox.setOnFocusChangeListener(new 
        		MinNumberFocusChangeListener(numberGenerator, 
                                             minBox));
        
        numbersInAGroupBox.setOnFocusChangeListener(new 
        		NumbersInAGroupFocusChangeListener(groupGenerator, numbersInAGroupBox));
        
        repeatsAllowedCheckBox.setOnCheckedChangeListener(new 
        		RepeatNumbersAllowedCheckedChangeListener(groupGenerator, repeatsAllowedCheckBox));
        
        groupCountBox.setOnFocusChangeListener(new 
        		GroupCountFocusChangeListener(groupSetGenerator, groupCountBox));
        
    	Log.d(LOG_TAG, "setChangeListeners-exit");
    }
    
    /**
     * Adds the validation objects to the button.
     */
    private void addValidation() {
    	
    	Log.d(LOG_TAG, "addValidation-enter");
    	
    	// Add the number of groups validator.
    	clickListener.addValidator(new NumberOfGroupsValidator(groupCountBox));
    	
    	// Add the minimum number validator.
    	clickListener.addValidator(new MinNumberValidator(minBox, maxBox));
    	
    	// Add the maximum number validator.
    	clickListener.addValidator(new MaxNumberValidator(minBox, maxBox));

    	// Add the group size validator.
    	clickListener.addValidator(
    			new GroupSizeValidator(minBox, 
                                       maxBox, 
                                       numbersInAGroupBox, 
                                       repeatsAllowedCheckBox,
                                       this));
    	
    	Log.d(LOG_TAG, "addValidation-exit");
    }
}

