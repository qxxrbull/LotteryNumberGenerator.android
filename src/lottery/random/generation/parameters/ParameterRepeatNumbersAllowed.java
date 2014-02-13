package lottery.random.generation.parameters;

/**
 * ParameterRepeatNumbersAllowed represents a parameter to an engine,
 * and indicates whether or not repeat numbers are allowed in a
 * group of numbers.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class ParameterRepeatNumbersAllowed {

	/**
	 * if true, repeat numbers are allowed; false otherwise.
	 */
	private final Boolean repeatNumbersAllowed;
	
	/**
	 * Constructs the parameter using the passed in valid
	 * to indicate whether or not repeat numbers are allowed.
	 * 
	 * @param allowed whether or not repeat numbers are allowed in a group.
	 * @throws IllegalArgumentException if allowed is null.
	 */
	public ParameterRepeatNumbersAllowed(final Boolean allowed) {

		// Sanity Check the argument.
		if (null == allowed) {
			throw new IllegalArgumentException("allowed can not be null");
		}
		
		this.repeatNumbersAllowed =
			allowed;
	}
	
	/**
	 * Returns whether or not repeat numbers are allowed.
	 * 
	 * @return {@link Boolean#TRUE} if repeats are allowed, 
	 * {@link Boolean#FALSE} otherwise.
	 */
	public Boolean areRepeatNumbersAllowed() {
		return repeatNumbersAllowed;
	}
}
