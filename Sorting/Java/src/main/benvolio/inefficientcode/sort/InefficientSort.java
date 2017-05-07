package benvolio.inefficientcode.sort;

import org.apache.commons.lang3.Validate;

import benvolio.inefficientcode.sort.helper.ExtendedArrayInstCounter;
import benvolio.inefficientcode.sort.helper.InstructionCounter;
import benvolio.inefficientcode.sort.helper.UnspecifiedBehaviorException;

/**
 * Inefficient sorting class
 *
 * @author Kardyne
 *
 */
public abstract class InefficientSort {

	/**
	 * Sorts the array. This method counts the number of instructions for the
	 * current call, and sets the instCount appropriately using an
	 * ArrayInstCounter.
	 *
	 * @param array
	 *            the array to sort
	 */
	public InstructionCounter sort(final int[] array) {
		Validate.notNull(array);
		final ExtendedArrayInstCounter arrayCounter = new ExtendedArrayInstCounter(array);
		this.doSort(arrayCounter);
		return arrayCounter.getInstructionCounter();
	}

	/**
	 * Method effectively sorting the array. Uses an ArrayInstCounter to ensure
	 * that the number of instruction counted is truly the number of instruction
	 * used.
	 *
	 * @param array
	 *            the array to sort
	 */
	protected abstract void doSort(ExtendedArrayInstCounter array);
}
