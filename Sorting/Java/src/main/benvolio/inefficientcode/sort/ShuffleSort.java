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

}
