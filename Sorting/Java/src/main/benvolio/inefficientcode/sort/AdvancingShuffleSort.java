package benvolio.inefficientcode.sort;

import org.apache.commons.lang3.Validate;

import benvolio.inefficientcode.sort.helper.ExtendedArrayInstCounter;

/**
 * Implements a 'advancing' shuffle sort. For each element, it checks if the element is the
 * minimum of the array. If it is not, it shuffles unsorted part of the array. If
 * the element is the minimum, it gets to the next unsorted element.
 * 
 * @author Kardyne
 *
 */
public class AdvancingShuffleSort extends InefficientSort {

	@Override
	protected void doSort(ExtendedArrayInstCounter array) {
		Validate.notNull(array);
		for (int i = 0; i < array.length(); i++) {
			while (!array.isMin(array.get(i), i, array.length())) {
				array.shuffle(i, array.length());
			}
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
