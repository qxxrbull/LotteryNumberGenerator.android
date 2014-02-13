package lottery.random.group.set.generator;

import lottery.random.generation.parameters.ParameterNumberOfGroups;
import lottery.random.group.set.RandomGroupSet;

/**
 * RandomGroupSetGeneratorIF is interface which concrete implementations
 * can use to produce random groups (for which each group is a list
 * of random numbers).
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public interface RandomGroupSetGeneratorIF {

	/**
	 * Generates a set of random groups of numbers.
	 * 
	 * @return a new set of random groupings.
	 * @see RandomGroupSet
	 */
	RandomGroupSet generateRandomGroupSet();
	
	/**
	 * Sets the parameter which represents the number
	 * of groups to return each time a set is generated.
	 * 
	 * @param number the parameter.
	 * @see ParameterNumberOfGroups
	 */
	void setGroupCountParameter(ParameterNumberOfGroups number);	
}
