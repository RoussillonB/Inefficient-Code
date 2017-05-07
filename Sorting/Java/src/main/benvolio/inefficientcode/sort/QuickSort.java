package benvolio.inefficientcode.sort;

import org.apache.commons.lang3.Validate;

import benvolio.inefficientcode.sort.helper.ExtendedArrayInstCounter;

/**
 * Very basic implementation of a QuickSort.
 * Only used for reference instruction count.
 * 
 * @author Kardyne
 *
 */

public class QuickSort extends InefficientSort {

	@Override
	protected void doSort(ExtendedArrayInstCounter array) {
		Validate.notNull(array);
		this.doSort(array, 0, array.length()-1);
	}
	
	/**
	 * doSort method used for recursive calls of the quick sort algorithm.
	 * 
	 * @param array the array to sort
	 * @param start the starting index for this subset
	 * @param end the ending index for this subset
	 */
	private void doSort(ExtendedArrayInstCounter array, int start, int end) {
		Validate.notNull(array);
		if (start < end) {
			int pivot = array.get(start + (end - start)/2);
			int left = start;
			int right = end;
			while (left <= right) {
				while (array.get(left) < pivot) {
					left++;
				}
				while (array.get(right) > pivot) {
					right--;
				}
				if (left <= right) {
					array.swap(left, right);
					left++;
					right--;
				}
			}
			this.doSort(array, start, right);
			this.doSort(array, left, end);
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
		return "O(n log n)";
	}

	@Override
	public String getWorstCaseSpaceComplexity() {
		return "O(n)";
	}

	@Override
	public long getAveragePerformance(int size) {
		return (int) Math.floor(size * Math.log(size));
	}
}
