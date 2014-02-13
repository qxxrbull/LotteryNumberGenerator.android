package lottery.random.focus;

/**
 * Clears the focus as determined by the implementing object.
 * 
 * @author Chris Adamson
 * @version 1.0
 */
public interface FocusAdjusterIF {

	/**
	 * Clears the focus (the exact definition of what
	 * it means to clear the focus is up to the implementor).
	 */
	void clearFocus();
}
