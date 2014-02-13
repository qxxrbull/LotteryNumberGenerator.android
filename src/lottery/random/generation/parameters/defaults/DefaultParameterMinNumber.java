package lottery.random.generation.parameters.defaults;

import lottery.random.generation.parameters.ParameterMinNumber;

/**
 * DefaultParameterMinNumber is a {@link ParameterMinNumber} which 
 * serves as a default in absence  of a value provided from some other source 
 * (e.g. user, external agents).
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class DefaultParameterMinNumber 
extends ParameterMinNumber {

	/**
	 * for serialization purposes.
	 */
	private static final long serialVersionUID = 8991435314598116288L;

	/**
	 * the default value for this parameter. 
	 */
	public static final Integer DEFAULT_VALUE =
		Integer.valueOf(0);
	
	/**
	 * Constructs the parameter using 
	 * {@link DefaultParameterMinNumber#DEFAULT_VALUE} as the default.
	 */
	public DefaultParameterMinNumber() {
		super(DEFAULT_VALUE);
	}
}
