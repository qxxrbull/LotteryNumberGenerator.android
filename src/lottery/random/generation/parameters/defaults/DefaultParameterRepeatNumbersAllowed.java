package lottery.random.generation.parameters.defaults;

import lottery.random.generation.parameters.ParameterRepeatNumbersAllowed;

/**
 * DefaultParameterRepeatNumbersAllowed is a 
 * {@link ParameterRepeatNumbersAllowed} which serves as a default in absence 
 * of a value provided from some other source (e.g. user, external agents).
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class DefaultParameterRepeatNumbersAllowed 
extends ParameterRepeatNumbersAllowed {

	/**
	 * the default value for this parameter. 
	 */
	public static final Boolean DEFAULT_VALUE =
		Boolean.TRUE;
	
	/**
	 * Constructs the parameter using 
	 * {@link DefaultParameterRepeatNumbersAllowed#DEFAULT_VALUE} as the default.
	 */
	public DefaultParameterRepeatNumbersAllowed() {
		super(DEFAULT_VALUE);
	}
}
