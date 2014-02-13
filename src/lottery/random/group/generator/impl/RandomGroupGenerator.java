package lottery.random.group.generator.impl;

import lottery.random.generation.parameters.ParameterNumbersInAGroup;
import lottery.random.generation.parameters.ParameterRepeatNumbersAllowed;
import lottery.random.group.RandomGroup;
import lottery.random.group.generator.RandomGroupGeneratorIF;
import lottery.random.number.RandomNumber;
import lottery.random.number.generator.RandomNumberGeneratorIF;

/**
 * RandomGroupGenerator implements {@link RandomGroupGeneratorIF} to 
 * produce a group of random numbers, which can have a configurable
 * count of numbers in the group, as well as repeat numbers or not.
 * 
 * @author Chris Adamson
 * @version 1.0
 * @see RandomGroupGeneratorIF
 */
public class RandomGroupGenerator 
implements RandomGroupGeneratorIF {

	/**
	 * the count of numbers per group generated.
	 */
	private ParameterNumbersInAGroup numberCountPerGroup;
	
	/**
	 * whether or not repeat numbers are allowed. 
	 */
	private ParameterRepeatNumbersAllowed repeatNumbersAllowed;
	
	/**
	 * the generator to retrieve random numbers from.
	 */
	private final RandomNumberGeneratorIF numberGenerator;
	
	/**
	 * Constructs using the parameters, and generator that
	 * produces random numbers.
	 * 
	 * @param groupCount the total count of numbers in a group.
	 * @param repeatsAllowed whether or not repeat numbers are allowed.
	 * @param generator the generator to produce random numbers.
	 * @throws IllegalArgumentException if any argument is null.
	 * @see ParameterNumbersInAGroup
	 * @see ParameterRepeatNumbersAllowed
	 * @see RandomNumberGeneratorIF
	 */
	public RandomGroupGenerator(final ParameterNumbersInAGroup groupCount,
                                final ParameterRepeatNumbersAllowed repeatsAllowed,
                                final RandomNumberGeneratorIF generator) {
		
		// Set the two parameters (checks are done in the setters).
		setCountOfNumbersInAGroup(groupCount);
		setRepeatNumbersAllowed(repeatsAllowed);
		
		// Sanity Check the last argument.
		if (null == groupCount) {
			throw new IllegalArgumentException("groupCount can not be null");
		}
	
		this.numberCountPerGroup = groupCount;
		this.repeatNumbersAllowed = repeatsAllowed;
		this.numberGenerator = generator;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see lottery.random.group.generator.RandomGroupGeneratorIF#getNextRandomGroup()
	 */
	@Override
	public RandomGroup getNextRandomGroup() {

		final RandomGroup group =
			new RandomGroup();
		
		final int groupSize =
			numberCountPerGroup.intValue();
		
		final boolean repeats =
			repeatNumbersAllowed.areRepeatNumbersAllowed().booleanValue();
			
		// Simple total to keep track of whether or not we have
		// the group size total.
		int total = 0;
		
		// Loop until we have the group size we are looking for.
		while (total < groupSize) {
			
			final RandomNumber number =
				numberGenerator.getNextRandomNumber();
			
			if (repeats) {
				// If repeats are allowed, we don't care, 
				// simply add the number, and increment the total.
				group.add(number);
				total++;
			} else {
				// Otherwise, make sure it doesn't already exist,
				// and if it doesn't add the number, and increment
				// the total.
				if (! group.contains(number)) {
					group.add(number);
					total++;
				}
			}
		}		
		return group;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalArgumentException if count is null.
	 * @see lottery.random.group.generator.RandomGroupGeneratorIF#setCountOfNumbersInAGroup(lottery.random.generation.parameters.ParameterNumbersInAGroup)
	 */
	@Override
	public void setCountOfNumbersInAGroup(ParameterNumbersInAGroup count) {

		// Sanity Check the argument.
		if (null == count) {
			throw new IllegalArgumentException("count can not be null");
		}
		
		this.numberCountPerGroup =
			count;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalArgumentException if allowed is null.
	 * @see lottery.random.group.generator.RandomGroupGeneratorIF#setRepeatNumbersAllowed(lottery.random.generation.parameters.ParameterRepeatNumbersAllowed)
	 */
	@Override
	public void setRepeatNumbersAllowed(ParameterRepeatNumbersAllowed allowed) {
		
		// Sanity Check the argument.
		if (null == allowed) {
			throw new IllegalArgumentException("allowed can not be null");
		}
		
		this.repeatNumbersAllowed = 
			allowed;
	}
}

