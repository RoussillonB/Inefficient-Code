package benvolio.inefficientcode.sort;

import java.util.Random;

import org.apache.commons.lang3.Validate;

import benvolio.inefficientcode.sort.helper.ExtendedArrayInstCounter;

/**
 * Implements a true random sort. This algorithm swaps two elements randomly
 * until the array is sorted.
 *
 * @author Kardyne
 *
 */
public class RandomSort extends InefficientSort {

	@Override
	protected void doSort(final ExtendedArrayInstCounter array) {
		Validate.notNull(array);
		final Random rand = new Random();
		while (!array.isSorted()) {
			final int i = rand.nextInt(array.length());
			final int j = rand.nextInt(array.length());
			array.swap(i, j);
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
