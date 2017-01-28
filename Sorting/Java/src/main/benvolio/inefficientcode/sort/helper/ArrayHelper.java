package benvolio.inefficientcode.sort.helper;

import java.util.Random;

import org.apache.commons.lang3.Validate;

/**
 * Helper methods for arrays. Some of these methods can be found in common java
 * libraries. However, to be sure of the instruction count, it is necessary to
 * have a custom implementation (and if possible, the most inefficient one).
 *
 * @author Kardyne
 *
 */
public final class ArrayHelper {

	/**
	 * Checks if the array is sorted.
	 *
	 * @param array
	 *            the array to check
	 * @return true if the array is sorted
	 */
	public static boolean isSorted(final int[] array) {
		Validate.notNull(array);
		if (array.length == 0) {
			throw new UnspecifiedBehaviorException("Cannot determine if an empty array is sorted.");
		}
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if the value is the minimum in the array between the two indexes.
	 *
	 * @param value
	 *            the potential minimum
	 * @param array
	 *            the array containing the values
	 * @param start
	 *            the start index
	 * @param end
	 *            the end index
	 * @return true if the value is the minimum between the two indexes
	 */
	public static boolean isMin(final int value, final int[] array, final int start, final int end) {
		Validate.notNull(array);
		return value == ArrayHelper.min(array, start, end);
	}

	/**
	 * Computes the minimum in the array between the two indexes
	 *
	 * @param array
	 *            the array containing the values
	 * @param start
	 *            the start index
	 * @param end
	 *            the end index
	 * @return the minimum between the two indexes
	 * @throws ArrayIndexOutOfBoundsException
	 *             if the start index is negative, or if the end index is
	 *             greater than the array length
	 * @throws IllegalArgumentException
	 *             if the starting index is greater than the end index
	 */
	public static int min(final int[] array, final int start, final int end) {
		Validate.notNull(array);
		if (array.length == 0) {
			throw new UnspecifiedBehaviorException("Cannot determine if an empty array is sorted.");
		} else if (start > end) {
			throw new IllegalArgumentException("start index cannot be greater than end index");
		} else if (start < 0) {
			throw new ArrayIndexOutOfBoundsException("start index cannot be negative");
		} else if (end > array.length) {
			throw new ArrayIndexOutOfBoundsException("end index cannot be greater than the length of the array");
		}
		int minValue = array[start];
		for (int i = start; i < end; i++) {
			if (array[i] < minValue) {
				minValue = array[i];
			}
		}
		return minValue;
	}

	/**
	 * Computes the minimum in the array
	 *
	 * @param array
	 *            the array containing the values
	 * @return the minimum
	 * @throws IllegalArgumentException
	 *             if the starting index is greater than the end index, or if
	 *             the start index is negative, or if the end index is greater
	 *             than the array length
	 */
	public static int min(final int[] array) {
		Validate.notNull(array);
		return ArrayHelper.min(array, 0, array.length);
	}

	/**
	 * Creates a new int array of specified size with random values less than
	 * the given maximum.
	 *
	 * @param size
	 *            the size of the new array
	 * @param maxValue
	 *            the maximum values
	 * @return a new random array
	 */
	public static int[] createRandomArray(final int size, final int maxValue) {
		if (size == 0) {
			throw new UnspecifiedBehaviorException("Cannot determine if an empty array is sorted.");
		}
		final Random rand = new Random();
		final int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = rand.nextInt(maxValue);
		}
		return array;
	}

}
