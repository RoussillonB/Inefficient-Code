package benvolio.inefficientcode.sort;

import java.util.Random;

import org.apache.commons.lang3.Validate;

import benvolio.inefficientcode.sort.helper.ArrayInstCounter;

/**
 * Implements a true random sort. This algorithm swaps two elements randomly
 * until the array is sorted.
 *
 * @author Kardyne
 *
 */
public class RandomSort extends InefficientSort {

	@Override
	protected void doSort(final ArrayInstCounter array) {
		Validate.notNull(array);
		final Random rand = new Random();
		while (!array.isSorted()) {
			final int i = rand.nextInt(array.length());
			final int j = rand.nextInt(array.length());
			final int value = array.get(i);
			array.set(j, array.get(i));
			array.set(i, value);
		}
	}

}
