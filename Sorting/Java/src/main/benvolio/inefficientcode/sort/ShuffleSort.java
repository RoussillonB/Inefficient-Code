package benvolio.inefficientcode.sort;

import org.apache.commons.lang3.Validate;

import benvolio.inefficientcode.sort.helper.ExtendedArrayInstCounter;

/**
 * Really inefficient sorting method. Keeps shuffling the array randomly until
 * it is sorted.
 *
 * @author Kardyne
 *
 */

public class ShuffleSort extends InefficientSort {

	@Override
	protected void doSort(final ExtendedArrayInstCounter array) {
		Validate.notNull(array);
		while (!array.isSorted()) {
			array.shuffle();
		}
	}

	@Override
	public String getWorstCasePerformance() {
		return "Unknown";
	}

	@Override
	public String getBestCasePerformance() {
		return "Unknown";
	}

	@Override
	public String getAveragePerformance() {
		return "Unknown";
	}

	@Override
	public String getWorstCaseSpaceComplexity() {
		return "O(n)";
	}
	
	@Override
	public long getAveragePerformance(int size) {
		return -1;
	}
}
