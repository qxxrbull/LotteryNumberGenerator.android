package lottery.random.group.generator;

import lottery.random.generation.parameters.ParameterNumbersInAGroup;
import lottery.random.generation.parameters.ParameterRepeatNumbersAllowed;
import lottery.random.group.RandomGroup;

/**
 * RandomGroupGeneratorIF represents the interface for
 * which a concrete generator will produce groups of
 * random numbers.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public interface RandomGroupGeneratorIF {

	/**
	 * Returns the next random number of numbers
	 * from the generator.
	 * 
	 * @return the next random group of numbers.
	 */
	RandomGroup getNextRandomGroup();
	
	/**
	 * Used to set a flag indicating whether or not repeat numbers
	 * are allowed in a group.
	 * 
	 * @param allowed whether or not repeat numbers are allowed in a group.
	 * @see ParameterRepeatNumbersAllowed
	 */
	void setRepeatNumbersAllowed(ParameterRepeatNumbersAllowed allowed);
	
	/**
	 * Used to set the total count of numbers per group
	 * generated.
	 * 
	 * @param count the total count of numbers in each group.
	 * @see ParameterNumbersInAGroup
	 */
	void setCountOfNumbersInAGroup(ParameterNumbersInAGroup count);
}
