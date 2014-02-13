package lottery.random.generation.parameters.defaults;

import lottery.random.generation.parameters.ParameterNumbersInAGroup;

/**
 * DefaultParameterNumbersInAGroup is a {@link ParameterNumbersInAGroup} which 
 * serves as a default in absence  of a value provided from some other source 
 * (e.g. user, external agents).
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class DefaultParameterNumbersInAGroup 
extends ParameterNumbersInAGroup {

	/**
	 * for serialization purposes.
	 */
	private static final long serialVersionUID = 4888610417286933648L;

	/**
	 * the default value for this parameter. 
	 */
	public static final Integer DEFAULT_VALUE =
		Integer.valueOf(5);
	
	/**
	 * Constructs the parameter using 
	 * {@link DefaultParameterNumbersInAGroup#DEFAULT_VALUE} as the default.
	 */
	public DefaultParameterNumbersInAGroup() {
		super(DEFAULT_VALUE);
	}
}
