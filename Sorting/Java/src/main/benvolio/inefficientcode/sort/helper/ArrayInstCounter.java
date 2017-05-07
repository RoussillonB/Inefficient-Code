package benvolio.inefficientcode.sort.helper;

import java.util.Arrays;

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
	private final InstructionCounter counter;

	/**
	 * Instantiates a new array instruction counter.
	 *
	 * @param array
	 *            the array the instrument
	 */
	public ArrayInstCounter(final int[] array) {
		Validate.notNull(array);
		this.array = array;
		this.counter = new InstructionCounter();
	}
	
	public ArrayInstCounter(ArrayInstCounter arrayCounter) {
		this.array = arrayCounter.array.clone();
		this.counter = arrayCounter.getInstructionCounter();
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

	public String printContents() {
		return Arrays.toString(this.array);
	}
}