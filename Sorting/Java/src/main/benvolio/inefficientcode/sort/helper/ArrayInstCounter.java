package benvolio.inefficientcode.sort.helper;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang3.Validate;

/**
 * An array instruction counter. This class is used to instrument an array: the
 * actual array is hidden, and other classes must use encapsulating methods to
 * access the array. Thus, each time an element of the array is read or written
 * to, the instruction count is increased.
 *
 * This is really helpful to test the implemented sorting algorithms.
 *
 * This should not be used for performance as the overhead on large arrays is
 * quite important.
 *
 * @author Kardyne
 *
 */

public class ArrayInstCounter {

	/**
	 * The instrumented array
	 */
	private final int[] array;

	/**
	 * The instruction counter to keep track of the number of read and write
	 */
	private final InstructionCounter counter = new InstructionCounter();

	/**
	 * Instantiates a new array instruction counter.
	 *
	 * @param array
	 *            the array the instrument
	 */
	public ArrayInstCounter(final int[] array) {
		Validate.notNull(array);
		this.array = array;
	}

	/**
	 * Gets the length of the array
	 *
	 * @return the length of the array
	 */
	public int length() {
		return this.array.length;
	}

	/**
	 * Gets the instruction counter of this instance
	 *
	 * @return the current instruction counter
	 */
	public InstructionCounter getInstructionCounter() {
		return this.counter;
	}

	/**
	 * Gets the element at the specified index
	 *
	 * @param index
	 *            the index of the element
	 * @return the value of the element at the index
	 * @throws ArrayIndexOutOfBoundsException
	 *             if the index is negative or if if the index is greater than
	 *             the length of the array
	 */
	public int get(final int index) {
		if (index < 0) {
			throw new ArrayIndexOutOfBoundsException("index cannot be negative");
		} else if (index > this.array.length) {
			throw new ArrayIndexOutOfBoundsException("index cannot be greater than the length of the array");
		}
		this.counter.incReadInstCount();
		return this.array[index];
	}

	/**
	 * Sets the element at the specified index with the new value
	 *
	 * @param index
	 *            the index of the element to change
	 * @param value
	 *            the new value of the element
	 * @throws ArrayIndexOutOfBoundsException
	 *             if the index is negative or if the index is greater than the
	 *             length of the array
	 */
	public void set(final int index, final int value) {
		if (index < 0) {
			throw new ArrayIndexOutOfBoundsException("index cannot be negative");
		} else if (index > this.array.length) {
			throw new ArrayIndexOutOfBoundsException("index cannot be greater than the length of the array");
		}
		this.counter.incWriteInstCount();
		this.array[index] = value;
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
		for (int i = 0; i < this.length() - 1; i++) {
			if (this.get(i) > this.get(i + 1)) {
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
		for (int i = start; i < end; i++) {
			if (this.get(i) < minValue) {
				minValue = this.get(i);
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
			throw new UnspecifiedBehaviorException("Cannot determine minimum value on an empty array.");
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
			final int a = this.get(index);
			this.set(index, this.get(i));
			this.set(i, a);
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
		if (this.length() == 0) {
			throw new UnspecifiedBehaviorException("Cannot determine minimum value on an empty array.");
		}
		this.shuffle(0, this.length());
	}

	public String printContents() {
		return Arrays.toString(this.array);
	}
}