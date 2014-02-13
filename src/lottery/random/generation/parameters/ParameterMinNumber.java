package lottery.random.generation.parameters;

/**
 * ParameterMinNumber represents a parameter to an engine,
 * and is the smallest number possible (for whatever the engine
 * defines the minimum to be used for).
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class ParameterMinNumber 
extends Number {

	/**
	 * for serialization purposes. 
	 */
	private static final long serialVersionUID = -5407940812500920060L;
	
	/**
	 * represents the smallest number possible. 
	 */
	private final Integer minNumber;
	
	/**
	 * Constructs the number using the passed
	 * in value to represent the minimum.
	 * 
	 * @param min the minimum number.
	 * @throws IllegalArgumentException if min is null.
	 */
	public ParameterMinNumber(final Integer min) {
		
		// Sanity Check the argument.
		if (null == min) {
			throw new IllegalArgumentException("min can not be null");
		}
		
		this.minNumber = min;
	}
	
	/**
	 * @see java.lang.Number#doubleValue()
	 */
	@Override
	public double doubleValue() {
		return minNumber.doubleValue();
	}

	/**
	 * @see java.lang.Number#floatValue()
	 */
	@Override
	public float floatValue() {
		return minNumber.floatValue();
	}

	/**
	 * @see java.lang.Number#intValue()
	 */
	@Override
	public int intValue() {
		return minNumber.intValue();
	}

	/**
	 * @see java.lang.Number#longValue()
	 */
	@Override
	public long longValue() {
		return minNumber.longValue();
	}
}

