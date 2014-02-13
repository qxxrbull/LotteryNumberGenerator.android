package lottery.random.ui.validation;

/**
 * ValidationUserIF is an interface which implementors
 * can use to implement functionality that adds and
 * removes validators to be used during its implementation
 * specific validation logic.
 * 
 * @author Chris Adamson
 * @version 1.0
 * @see ValidatorIF
 */
public interface ValidationUserIF {

	/**
	 * Adds the specified validator.
	 * 
	 * @param validator the validator to add.
	 */
	void addValidator(ValidatorIF validator);
	
	/**
	 * Removes the specified validator.
	 * 
	 * @param validator the validator to remove.
	 */
	void removeValidator(ValidatorIF validator);
}
