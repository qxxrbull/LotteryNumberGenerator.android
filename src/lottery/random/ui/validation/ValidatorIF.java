package lottery.random.ui.validation;

/**
 * ValidatorIF represents an object once implemented
 * validates something, and returns a boolean indicating
 * the valid-ness of it.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public interface ValidatorIF {

	/**
	 * Returns a Boolean indicating whether or not the item
	 * is valid (implementation-specific).
	 * 
	 * @return {@link Boolean#TRUE} if the item this Validator 
	 * validates is valid {@link Boolean#FALSE} otherwise,.
	 */
	Boolean isValid();
}
