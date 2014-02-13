package lottery.random.group;

import java.util.ArrayList;

import lottery.random.number.RandomNumber;

/**
 * RandomGroup is a simple extension on {@link ArrayList} using
 * {@link RandomNumber} as the concrete type that it holds.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class RandomGroup 
extends ArrayList < RandomNumber > {

	/**
	 * for serialization purposes. 
	 */
	private static final long serialVersionUID = 123748150171741453L;
}
