package benvolio.inefficientcode.sort.helper;

/**
 * An instruction counter. Makes it easy to get and set the number of read and
 * write instructions. Useful for instrumenting algorithms.
 *
 * @author Kardyne
 *
 */
public class InstructionCounter {

	/**
	 * The number of 'set' instructions
	 */
	private int writeInstCount = 0;

	/**
	 * The number of 'get' instructions
	 */
	private int readInstCount = 0;

	/**
	 * Increases the current number of 'set' instructions
	 */
	public void incWriteInstCount() {
		this.writeInstCount++;
	}

	/**
	 * Increases the current number of 'get' instructions
	 */
	public void incReadInstCount() {
		this.readInstCount++;
	}

	/**
	 * Gets the total instruction count (both 'set' and 'get' instructions).
	 *
	 * @return the total instruction count
	 */
	public int getTotalInstCount() {
		return this.getWriteInstCount() + this.getReadInstCount();
	}

	/**
	 * Gets the number of 'set' instructions used
	 *
	 * @return the number of 'set' instructions
	 */
	public int getWriteInstCount() {
		return this.writeInstCount;
	}

	/**
	 * Gets the number of 'get' instructions used
	 *
	 * @return the number of 'get' instructions
	 */
	public int getReadInstCount() {
		return this.readInstCount;
	}

	/**
	 * Resets the number of read instructions
	 */
	public void resetReadInstCount() {
		this.readInstCount = 0;
	}

	/**
	 * Resets the number of write instructions
	 */
	public void resetWriteInstCount() {
		this.writeInstCount = 0;
	}

}
