package lottery.random.generation.parameters.defaults;

import lottery.random.generation.parameters.ParameterNumberOfGroups;

/**
 * DefaultParameterNumberOfGroups is a {@link ParameterNumberOfGroups} which 
 * serves as a default in absence  of a value provided from some other source 
 * (e.g. user, external agents).
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class DefaultParameterNumberOfGroups 
extends ParameterNumberOfGroups {

	/**
	 * for serialization purposes.
	 */
	private static final long serialVersionUID = -1793947676969798342L;

	/**
	 * the default value for this parameter. 
	 */
	public static final Integer DEFAULT_VALUE =
		Integer.valueOf(4);
	
	/**
	 * Constructs the parameter using 
	 * {@link DefaultParameterNumberOfGroups#DEFAULT_VALUE} as the default.
	 */
	public DefaultParameterNumberOfGroups() {
		super(DEFAULT_VALUE);
	}
}
