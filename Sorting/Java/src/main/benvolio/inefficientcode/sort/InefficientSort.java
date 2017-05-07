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
	
	/**
	 * Get worst case performance for the current sort.
	 * @return the string representing the worst case performance in O() form.
	 */
	public abstract String getWorstCasePerformance();
	
	/**
	 * Get best case performance for the current sort.
	 * @return the string representing the best case performance in O() form.
	 */
	public abstract String getBestCasePerformance();
	
	/**
	 * Get average performance for the current sort.
	 * @return the string representing the average performance in O() form.
	 */
	public abstract String getAveragePerformance();
	
	/**
	 * Get worst case space complexity for the current sort.
	 * @return the string representing the worst case space complexity in O() form.
	 */
	public abstract String getWorstCaseSpaceComplexity();
	
	/**
	 * Computes the supposed average performance using the size of the
	 * problem as an input.
	 * This should yield the same result as the getAveragePerformance()
	 * String. For instance, if the average is in O(n^2), 
	 * getAveragePerformance(10) should return 100.
	 * @param size the size of the current problem
	 * @return the supposed average performance
	 */
	public abstract long getAveragePerformance(int size);
}
