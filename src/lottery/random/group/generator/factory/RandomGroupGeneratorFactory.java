package lottery.random.group.generator.factory;

import lottery.random.generation.parameters.ParameterNumbersInAGroup;
import lottery.random.generation.parameters.ParameterRepeatNumbersAllowed;
import lottery.random.group.generator.RandomGroupGeneratorIF;
import lottery.random.group.generator.impl.RandomGroupGenerator;
import lottery.random.number.generator.RandomNumberGeneratorIF;

/**
 * RandomGroupGeneratorFactory is a simple factory which
 * generates concrete implementations of RandomGroupGeneratorIF.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class RandomGroupGeneratorFactory {

	/**
	 * Returns a new group generator using the passed in values.
	 * 
	 * @param groupCount the total count of numbers in each group.
	 * @param repeatsAllowed whether or not repeat numbers are allowed.
	 * @param generator the number generator to use.
	 * @return the created random group generator.
	 */
	public static RandomGroupGeneratorIF 
           createRandomGroupGenerator(final ParameterNumbersInAGroup groupCount,
			                          final ParameterRepeatNumbersAllowed repeatsAllowed,
                                      final RandomNumberGeneratorIF generator) {
		return new RandomGroupGenerator(groupCount, repeatsAllowed, generator);
	}
}
