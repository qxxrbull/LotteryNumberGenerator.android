package lottery.random.group.set;

import java.util.HashSet;

import lottery.random.group.RandomGroup;

/**
 * RandomGroupSet is a simple extension on the super-class
 * to concrete {@link RandomGroup} as the type it holds.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public class RandomGroupSet 
extends HashSet < RandomGroup > {

	/**
	 * for serialization purposes.
	 */
	private static final long serialVersionUID = 7927357633575501853L;
}
