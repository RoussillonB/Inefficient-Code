package benvolio.inefficientcode.sort.helper;

import org.junit.Assert;
import org.junit.Test;

public class ArrayInstCounterTest {

	@Test
	public void testEmptyGet0() {
		final int[] array = {};
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		try {
			counter.get(0);
			Assert.fail();
		} catch (final ArrayIndexOutOfBoundsException e) {
		}
	}

	@Test
	public void testEmptyGet1() {
		final int[] array = {};
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		try {
			counter.get(1);
			Assert.fail();
		} catch (final ArrayIndexOutOfBoundsException e) {
		}
	}

	@Test
	public void testSize1Get0() {
		final int[] array = { 0 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		Assert.assertTrue(counter.get(0) == 0);
	}

	@Test
	public void testSize1Get1() {
		final int[] array = { 0 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		try {
			counter.get(1);
			Assert.fail();
		} catch (final ArrayIndexOutOfBoundsException e) {
		}
	}

	@Test
	public void testGetInBounds() {
		final int[] array = { 0, 1, 2, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		Assert.assertTrue(counter.get(1) == 1);
	}

	@Test
	public void testGetOutOfBounds() {
		final int[] array = { 0, 1, 2, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		try {
			counter.get(4);
			Assert.fail();
		} catch (final ArrayIndexOutOfBoundsException e) {
		}
	}

	@Test
	public void testGetNegative() {
		final int[] array = {};
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		try {
			counter.get(-1);
			Assert.fail();
		} catch (final ArrayIndexOutOfBoundsException e) {
		}
	}

	@Test
	public void testConstructorNull() {
		try {
			new ArrayInstCounter((int[])null);
			Assert.fail();
		} catch (final NullPointerException e) {
		}
	}

	@Test
	public void testConstructorArrayChange() {
		final int[] array = { 0, 1 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		array[1] = -1;
		Assert.assertTrue(counter.get(1) == -1);
	}

	@Test
	public void testConstructorCountChange() {
		final int[] array = { 0, 1 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		counter.set(1, -1);
		Assert.assertTrue(array[1] == -1);
	}

	@Test
	public void testEmptySet0() {
		final int[] array = {};
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		try {
			counter.set(0, 0);
			Assert.fail();
		} catch (final ArrayIndexOutOfBoundsException e) {
		}
	}

	@Test
	public void testEmptySet1() {
		final int[] array = {};
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		try {
			counter.set(1, 0);
			Assert.fail();
		} catch (final ArrayIndexOutOfBoundsException e) {
		}
	}

	@Test
	public void testSize1Set0() {
		final int[] array = { 0 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		counter.set(0, 1);
		Assert.assertTrue(array[0] == 1);
	}

	@Test
	public void testSize1Set1() {
		final int[] array = { 0 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		try {
			counter.set(1, 0);
			Assert.fail();
		} catch (final ArrayIndexOutOfBoundsException e) {
		}
	}

	@Test
	public void testSetInBounds() {
		final int[] array = { 0, 1, 2, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		counter.set(2, -2);
		Assert.assertTrue(array[2] == -2);
	}

	@Test
	public void testSetOutOfBounds() {
		final int[] array = { 0, 1, 2, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		try {
			counter.set(4, 4);
			Assert.fail();
		} catch (final ArrayIndexOutOfBoundsException e) {
		}
	}

	@Test
	public void testSetNegative() {
		final int[] array = {};
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		try {
			counter.set(-1, 0);
			Assert.fail();
		} catch (final ArrayIndexOutOfBoundsException e) {
		}
	}

	@Test
	public void testEmptyLength() {
		final int[] array = {};
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		Assert.assertTrue(counter.length() == 0);
	}

	@Test
	public void testSize1() {
		final int[] array = { 0 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		Assert.assertTrue(counter.length() == 1);
	}

	@Test
	public void testLength() {
		final int[] array = { 0, 1, 2, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		Assert.assertTrue(counter.length() == 4);
	}

	@Test
	public void testEmptyPrintContents() {
		final int[] array = {};
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		Assert.assertTrue(counter.printContents().equals("[]"));
	}

	@Test
	public void testSize1PrintContents() {
		final int[] array = { 0 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		Assert.assertTrue(counter.printContents().equals("[0]"));
	}

	@Test
	public void testPrintContents() {
		final int[] array = { 0, 1, 2, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		Assert.assertTrue(counter.printContents().equals("[0, 1, 2, 3]"));
	}

}
