package benvolio.inefficientcode.sort.helper;

import java.util.Random;

public class ExtendedArrayInstCounter extends ArrayInstCounter {

	public ExtendedArrayInstCounter(int[] array) {
		super(array);
	}
	
	public ExtendedArrayInstCounter(ExtendedArrayInstCounter arrayCounter) {
		super(arrayCounter);
	}

	/**
	 * Checks if the array is sorted.
	 *
	 * @return true if the array is sorted
	 * @throws UnspecifiedBehaviorException
	 *             if this method is called on an empty array
	 */
	public boolean isSorted() {
		if (this.length() == 0) {
			throw new UnspecifiedBehaviorException("Cannot determine if an empty array is sorted.");
		}
		int lastValue = this.get(0);
		for (int i = 0; i < this.length() - 1; i++) {
			int nextValue = this.get(i + 1);
			if (lastValue > nextValue) {
				return false;
			}
			lastValue = nextValue;
		}
		return true;
	}

	/**
	 * Checks if the value is the minimum in the array between the two indexes.
	 *
	 * @param value
	 *            the potential minimum
	 * @param start
	 *            the start index
	 * @param end
	 *            the end index - it will be excluded from the search
	 * @return true if the value is the minimum between the two indexes
	 * @throws ArrayIndexOutOfBoundsException
	 *             if the start index is negative, or if the end index is
	 *             greater than the array length
	 * @throws UnspecifiedBehaviorException
	 *             if this method is called on an empty array
	 */
	public boolean isMin(final int value, final int start, final int end) {
		return value == this.min(start, end);
	}

	/**
	 * Computes the minimum in the array
	 *
	 * @return the minimum
	 * @throws IllegalArgumentException
	 *             if the starting index is greater than the end index, or if
	 *             the start index is negative, or if the end index is greater
	 *             than the array length
	 * @throws UnspecifiedBehaviorException
	 *             if this method is called on an empty array
	 */
	public int min() {
		return this.min(0, this.length());
	}

	/**
	 * Checks if the value is the minimum in the array
	 *
	 * @param value
	 *            the potential minimum
	 * @return true if the value is the minimum
	 * @throws UnspecifiedBehaviorException
	 *             if this method is called on an empty array
	 */
	public boolean isMin(final int value) {
		return this.isMin(value, 0, this.length());
	}

	/**
	 * Computes the minimum in the array between the two indexes.
	 *
	 * @param start
	 *            the start index
	 * @param end
	 *            the end index - it will be excluded from the search
	 * @return the minimum between the two indexes
	 * @throws ArrayIndexOutOfBoundsException
	 *             if the start index is negative, or if the end index is
	 *             greater than the array length
	 * @throws IllegalArgumentException
	 *             if the starting index is greater than the end index
	 * @throws UnspecifiedBehaviorException
	 *             if this method is called on an empty array
	 */
	public int min(final int start, final int end) {
		if (this.length() == 0) {
			throw new UnspecifiedBehaviorException("Cannot determine minimum value on an empty array.");
		} else if (start > end) {
			throw new IllegalArgumentException("start index cannot be greater than end index");
		} else if (start < 0) {
			throw new ArrayIndexOutOfBoundsException("start index cannot be negative");
		} else if (end > this.length()) {
			throw new ArrayIndexOutOfBoundsException("end index cannot be greater than the length of the array");
		}
		int minValue = this.get(start);
		for (int i = start + 1; i < end; i++) {
			int nextValue = this.get(i);
			if (this.get(i) < minValue) {
				minValue = nextValue;
			}
		}
		return minValue;
	}

	/**
	 * Shuffles the array between the two indexes using the Fisher–Yates shuffle
	 * with the Durstenfeld implementation.
	 *
	 * @param array
	 *            the array to shuffle
	 * @param start
	 *            the starting index
	 * @param end
	 *            the ending index - it will be excluded from the shuffle
	 * @throws UnspecifiedBehaviorException
	 *             if this method is called on an empty array
	 */
	public void shuffle(final int start, final int end) {
		if (this.length() == 0) {
			throw new UnspecifiedBehaviorException("Cannot shuffle an empty array.");
		} else if (start > end) {
			throw new IllegalArgumentException("start index cannot be greater than end index");
		} else if (start < 0) {
			throw new ArrayIndexOutOfBoundsException("start index cannot be negative");
		} else if (end > this.length()) {
			throw new ArrayIndexOutOfBoundsException("end index cannot be greater than the length of the array");
		}
		final Random rand = new Random();
		for (int i = end - 1; i > start; i--) {
			final int index = start + rand.nextInt(i + 1 - start);
			this.swap(index, i);
		}
	}

	/**
	 * Shuffles the array between the two indexes using the Fisher–Yates shuffle
	 * with the Durstenfeld implementation.
	 *
	 * @param array
	 *            the array to shuffle
	 * @throws UnspecifiedBehaviorException
	 *             if this method is called on an empty array
	 */
	public void shuffle() {
		this.shuffle(0, this.length());
	}
	
	/**
	 * Swaps the elements at the i and j indexes
	 * 
	 * @param i first element
	 * @param j second element
	 */
	public void swap(int i, int j) {
		if (i < 0 || j < 0) {
			throw new ArrayIndexOutOfBoundsException("the indexes cannot be negative");
		} else if (i > this.length() || j > this.length()) {
			throw new ArrayIndexOutOfBoundsException("the indexes cannot be greater than the length of the array");
		}
		int value = this.get(i);
		this.set(i, this.get(j));
		this.set(j, value);
	}
}
