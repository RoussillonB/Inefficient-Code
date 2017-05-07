package benvolio.inefficientcode.sort;

import java.util.Random;

import org.apache.commons.lang3.Validate;

import benvolio.inefficientcode.sort.helper.ExtendedArrayInstCounter;

/**
 * Really inefficient sorting method. Keeps shuffling random subsets of the
 * array until the whole array is sorted. The random subset contains at least
 * one element.
 *
 * @author Kardyne
 *
 */

public class ShuffleSubsetSort extends InefficientSort {

	@Override
	protected void doSort(final ExtendedArrayInstCounter array) {
		Validate.notNull(array);
		final Random rand = new Random();
		while (!array.isSorted()) {
			final int start = rand.nextInt(array.length() - 1);
			final int end = start + rand.nextInt(array.length() - start + 1);
			array.shuffle(start, end);
		}
	}

}
