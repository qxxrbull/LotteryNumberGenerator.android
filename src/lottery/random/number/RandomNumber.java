package lottery.random.number;

/**
 * RandomNumber represents an integer number
 * that was randomly generated.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class RandomNumber 
extends Number {

	/**
	 * for serialization purposes.
	 */
	private static final long serialVersionUID = 767495540849512372L;
	
	/**
	 * the randomly generated value. 
	 */
	private final Integer randomValue;

	/**
	 * Constructs using the passed in value
	 * to represent the random value.
	 * 
	 * @param value the random value.
	 */
	public RandomNumber(final Integer value) {
		
		// Sanity Check
		if (null == value) {
			throw new IllegalArgumentException("value can not be null");
		}
		
		this.randomValue = value;
	}
	
	/**
	 * @see java.lang.Number#doubleValue()
	 */
	@Override
	public double doubleValue() {
		return randomValue.doubleValue();
	}

	/**
	 * @see java.lang.Number#floatValue()
	 */
	@Override
	public float floatValue() {
		return randomValue.floatValue();
	}

	/**
	 * @see java.lang.Number#intValue()
	 */
	@Override
	public int intValue() {
		return randomValue.intValue();
	}

	/**
	 * @see java.lang.Number#longValue()
	 */
	@Override
	public long longValue() {
		return randomValue.longValue();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((randomValue == null) ? 0 : randomValue.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RandomNumber other = (RandomNumber) obj;
		if (randomValue == null) {
			if (other.randomValue != null)
				return false;
		} else if (!randomValue.equals(other.randomValue))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return randomValue.toString();
	}
}

