package lottery.random.generation.parameters;

/**
 * ParameterNumbersInAGroup represents a parameter to an engine,
 * and is the count of numbers in a group (e.g. 5 numbers to a group, etc).
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class ParameterNumbersInAGroup 
extends Number {

	/**
	 * for serialization purposes. 
	 */
	private static final long serialVersionUID = -6639040881863344528L;
	
	/**
	 * the total count of numbers in a group of random numbers. 
	 */
	private final Integer numbersInAGroup;
	
	/**
	 * Constructs the parameter using the passed in Integer
	 * to represent the numbers to be in a given group.
	 * 
	 * @param groupCount the count of numbers in a group.
	 * @throws IllegalArgumentException if groupCount is null.
	 */
	public ParameterNumbersInAGroup(final Integer groupCount) {
		
		// Sanity Check the argument.
		if (null == groupCount) {
			throw new IllegalArgumentException("groupCount can not be null");
		}
		
		this.numbersInAGroup = groupCount;
	}
	
	/**
	 * @see java.lang.Number#doubleValue()
	 */
	@Override
	public double doubleValue() {
		return numbersInAGroup.doubleValue();
	}

	/**
	 * @see java.lang.Number#floatValue()
	 */
	@Override
	public float floatValue() {
		return numbersInAGroup.floatValue();
	}

	/**
	 * @see java.lang.Number#intValue()
	 */
	@Override
	public int intValue() {
		return numbersInAGroup.intValue();
	}

	/**
	 * @see java.lang.Number#longValue()
	 */
	@Override
	public long longValue() {
		return numbersInAGroup.longValue();
	}
}
