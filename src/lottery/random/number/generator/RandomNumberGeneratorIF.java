package lottery.random.number.generator;

import lottery.random.generation.parameters.ParameterMaxNumber;
import lottery.random.generation.parameters.ParameterMinNumber;
import lottery.random.number.RandomNumber;

/**
 * RandomNumberGeneratorIF is the interface for which
 * concrete number generators can produce random
 * numbers.
 *  
 * @author Chris Adamson
 * @version 1.0
 */
public interface RandomNumberGeneratorIF {

	/**
	 * Returns the next random number
	 * from the generator.
	 * 
	 * @return the next random number.
	 */
	RandomNumber getNextRandomNumber();
	
	/**
	 * Changes the minimum number generator parameter
	 * 
	 * @param min the minimum number.
	 * @see ParameterMinNumber
	 */
	void setMinimumNumberParameter(ParameterMinNumber min);
	
	/**
	 * Changes the maximum number generator parameter
	 * 
	 * @param max the maximum number.
	 * @see ParameterMinNumber
	 */
	void setMaximumNumberParameter(ParameterMaxNumber max);
}
