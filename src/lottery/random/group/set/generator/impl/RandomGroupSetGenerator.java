package lottery.random.group.set.generator.impl;

import lottery.random.generation.parameters.ParameterNumberOfGroups;
import lottery.random.generation.parameters.defaults.DefaultParameterNumberOfGroups;
import lottery.random.group.generator.RandomGroupGeneratorIF;
import lottery.random.group.set.RandomGroupSet;
import lottery.random.group.set.generator.RandomGroupSetGeneratorIF;

/**
 * RandomGroupSetGenerator is a concrete {@link RandomGroupGeneratorIF}
 * which produces sets of random groups.
 * 
 * @author Chris Adamson
 * @version 1.0
 * @see RandomGroupGeneratorIF
 */
public class RandomGroupSetGenerator 
implements RandomGroupSetGeneratorIF {

	/**
	 * the number of groups to generate.
	 */
	private ParameterNumberOfGroups numberOfGroups;
	
	/**
	 * the random group generator. 
	 */
	private RandomGroupGeneratorIF groupGenerator;

	/**
	 * Creates the random group set generator using
	 * the passed group generator, and a default number
	 * of groups to generate. 
	 */
	public RandomGroupSetGenerator(final RandomGroupGeneratorIF generator) {
		this(generator, new DefaultParameterNumberOfGroups());
	}
	
	/**
	 * Creates the random group set generator using
	 * the passed group generator, and the number of
	 * groups to generate.
	 * 
	 * @param generator the generator to create groups from.
	 * @param countOfGroups the number of groups to generate.
	 * @throws IllegalArgumentException if any argument is null.
	 */
	public RandomGroupSetGenerator(final RandomGroupGeneratorIF generator,
                                   final ParameterNumberOfGroups countOfGroups) {
		
		// Attempt to set the parameter.
		setGroupCountParameter(countOfGroups);
		
		// Sanity check the generator argument.
		if (null == generator) {
			throw new IllegalArgumentException("generator can not be null");
		}
		
		// Set the group generator.
		this.groupGenerator = generator;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see lottery.random.group.set.generator.RandomGroupSetGeneratorIF#generateRandomGroupSet()
	 */
	@Override
	public RandomGroupSet generateRandomGroupSet() {
		
		final RandomGroupSet set =
			new RandomGroupSet();
		
		final int count =
			numberOfGroups.intValue();
		
		for(int idx = 0; idx < count; idx++) {
			set.add(groupGenerator.getNextRandomGroup());
		}
		
		return set;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see lottery.random.group.set.generator.RandomGroupSetGeneratorIF#setGroupCountParameter(lottery.random.generation.parameters.ParameterNumberOfGroups)
	 * @throws IllegalArgumentException if number is null.
	 */
	@Override
	public void setGroupCountParameter(ParameterNumberOfGroups number) {

		// Sanity Check the argument.
		if (null == number) {
			throw new IllegalArgumentException("number can not be null");
		}
		
		this.numberOfGroups = number;
	}
}
