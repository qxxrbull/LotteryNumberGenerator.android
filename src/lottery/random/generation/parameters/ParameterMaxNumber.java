package lottery.random.generation.parameters;

/**
 * ParameterMaxNumber represents a parameter to an engine,
 * and is the biggest number possible (for whatever the engine
 * defines the maximum to be used for).
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class ParameterMaxNumber 
extends Number {
	
	/**
	 * for serialization purposes. 
	 */
	private static final long serialVersionUID = -2114553182613277834L;
	
	/**
	 * represents the biggest number possible. 
	 */
	private final Integer maxNumber;
	
	/**
	 * Constructs the number using the passed
	 * in value to represent the maximum.
	 * 
	 * @param max the maximum number.
	 * @throws IllegalArgumentException if max is null.
	 */
	public ParameterMaxNumber(final Integer max) {

		// Sanity Check the argument.
		if (null == max) {
			throw new IllegalArgumentException("max can not be null");
		}
		
		this.maxNumber = max;
	}

	/**
	 * @see java.lang.Number#doubleValue()
	 */
	@Override
	public double doubleValue() {
		return maxNumber.doubleValue();
	}

	/**
	 * @see java.lang.Number#floatValue()
	 */
	@Override
	public float floatValue() {
		return maxNumber.floatValue();
	}

	/**
	 * @see java.lang.Number#intValue()
	 */
	@Override
	public int intValue() {
		return maxNumber.intValue();
	}

	/**
	 * @see java.lang.Number#longValue()
	 */
	@Override
	public long longValue() {
		return maxNumber.longValue();
	}
}
