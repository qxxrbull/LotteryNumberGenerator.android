package lottery.random.ui.validation.list;

import java.util.ArrayList;

import lottery.random.ui.validation.ValidatorIF;

/**
 * ValidatorList is a simple extension on {@link ArrayList}, using
 * {@link ValidatorIF} as the concrete type.
 * 
 * @author Chris Adamson
 * @version 1.0
 * @see ValidatorIF
 */
public class ValidatorList 
extends ArrayList<ValidatorIF> {

	/**
	 * for serialization purposes.
	 */
	private static final long serialVersionUID = -1819043958462032578L;

}
