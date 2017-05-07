package benvolio.inefficientcode.sort;

import org.apache.commons.lang3.Validate;

import benvolio.inefficientcode.sort.helper.ExtendedArrayInstCounter;

/**
 * Very basic implementation of an InsertionSort.
 * Only used for reference instruction count.
 * 
 * @author Kardyne
 *
 */

public class InsertionSort extends InefficientSort {

	@Override
	protected void doSort(ExtendedArrayInstCounter array) {
		Validate.notNull(array);
		for (int i = 1; i<array.length(); i++) {
			int value = array.get(i);
			int j = i - 1;
			while (j>= 0 && array.get(j) > value) {
				array.swap(j, j+1);
				j--;
			}
			array.set(j+1, value);
		}
	}

	@Override
	public String getWorstCasePerformance() {
		return "O(n^2)";
	}

	@Override
	public String getBestCasePerformance() {
		return "O(n)";
	}

	@Override
	public String getAveragePerformance() {
		return "O(n^2)";
	}

	@Override
	public String getWorstCaseSpaceComplexity() {
		return "O(n)";
	}
	
	@Override
	public long getAveragePerformance(int size) {
		return size*size;
	}
}
