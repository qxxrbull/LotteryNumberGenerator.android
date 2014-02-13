package lottery.random.number.generator.impl;

import java.util.Random;

import lottery.random.generation.parameters.ParameterMaxNumber;
import lottery.random.generation.parameters.ParameterMinNumber;
import lottery.random.number.RandomNumber;
import lottery.random.number.generator.RandomNumberGeneratorIF;

/**
 * RandomNumberGenerator is an implementation of
 * {@link RandomNumberGeneratorIF} which generates
 * random numbers which are integers in a range
 * as determined by the minimum and maximum number
 * parameters provided.
 * 
 * @author Chris Adamson
 * @version 1.0
 * @see RandomNumberGeneratorIF
 */
public class RandomNumberGenerator 
implements RandomNumberGeneratorIF {

	/**
	 * Generates the actual numbers.
	 */
	private final Random randomGenerator =
		new Random();
	
	/**
	 * the minimum number possible.
	 */
	private ParameterMinNumber minNumber;
	
	/**
	 * the maximum number possible.
	 */
	private ParameterMaxNumber maxNumber;
	
	/**
	 * Constructs the generator using the minimum number
	 * parameter provided, and the maximum number parameter
	 * provided.
	 * 
	 * @param min the minimum number possible.
	 * @param max the maximum number possible.
	 */
	public RandomNumberGenerator(final ParameterMinNumber min, 
                                 final ParameterMaxNumber max) {
		this.minNumber = min;
		this.maxNumber = max;
	}
	
	/**
	 * @see lottery.random.number.generator.RandomNumberGeneratorIF#getNextRandomNumber()
	 */
	@Override
	public RandomNumber getNextRandomNumber() {
		
		final int minValue =
			minNumber.intValue();
		
		final int maxValue =
			maxNumber.intValue();
		
		final int randomValue =
			randomGenerator.nextInt(maxValue - minValue + 1) + minValue;
			
		return new RandomNumber(Integer.valueOf(randomValue));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalArgumentException if max is null.
	 * @see lottery.random.number.generator.RandomNumberGeneratorIF#setMaximumNumberParameter(lottery.random.generation.parameters.ParameterMinNUmber)
	 */
	@Override
	public void setMaximumNumberParameter(final ParameterMaxNumber max) {
		
		// Sanity Check the argument.
		if (null == max) {
			throw new IllegalArgumentException("max can not be null");
		}
		
		// Change the maximum number possible.
		this.maxNumber = max;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalArgumentException if min is null.
	 * @see lottery.random.number.generator.RandomNumberGeneratorIF#setMinimumNumberParameter(lottery.random.generation.parameters.ParameterMinNumber)
	 */
	@Override
	public void setMinimumNumberParameter(final ParameterMinNumber min) {
		
		// Sanity Check the argument.
		if (null == min) {
			throw new IllegalArgumentException("min can not be null");
		}
		
		// Change the minimum number possible.
		this.minNumber = min;
	}
}

