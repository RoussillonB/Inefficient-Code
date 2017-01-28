package benvolio.inefficientcode.sort.helper;

import org.junit.Assert;
import org.junit.Test;

public class ArrayInstCounterTest {

	private final static int MAX_LOOP = 100000;

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
			new ArrayInstCounter(null);
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

	@Test
	public void testEmptyMin() {
		final int[] array = {};
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		try {
			counter.min();
			Assert.fail();
		} catch (final UnspecifiedBehaviorException e) {
		}
	}

	@Test
	public void testSize1Min() {
		final int[] array = { 0 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		Assert.assertTrue(counter.min() == 0);
	}

	@Test
	public void testMinSorted() {
		final int[] array = { 0, 1, 2, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		Assert.assertTrue(counter.min() == 0);
	}

	@Test
	public void testMinReverseSorted() {
		final int[] array = { 3, 2, 1, 0 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		Assert.assertTrue(counter.min() == 0);
	}

	@Test
	public void testMinNotSorted() {
		final int[] array = { 1, 2, 0, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		Assert.assertTrue(counter.min() == 0);
	}

	@Test
	public void testEmptyIsSorted() {
		final int[] array = {};
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		try {
			counter.isSorted();
			Assert.fail();
		} catch (final UnspecifiedBehaviorException e) {
		}
	}

	@Test
	public void testSize1IsSorted() {
		final int[] array = { 0 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		Assert.assertTrue(counter.isSorted());
	}

	@Test
	public void testIsSortedSorted() {
		final int[] array = { 0, 1, 2, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		Assert.assertTrue(counter.isSorted());
	}

	@Test
	public void testIsSortedReverseSorted() {
		final int[] array = { 3, 2, 1, 0 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		Assert.assertFalse(counter.isSorted());
	}

	@Test
	public void testIsSortedNotSorted() {
		final int[] array = { 1, 2, 0, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		Assert.assertFalse(counter.isSorted());
	}

	@Test
	public void testEmptyIsMin() {
		final int[] array = {};
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		try {
			counter.isMin(0);
			Assert.fail();
		} catch (final UnspecifiedBehaviorException e) {
		}
	}

	@Test
	public void testSize1IsMin() {
		final int[] array = { 0 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		Assert.assertTrue(counter.isMin(0));
		Assert.assertFalse(counter.isMin(1));
		Assert.assertFalse(counter.isMin(-1));
	}

	@Test
	public void testIsMinSorted() {
		final int[] array = { 0, 1, 2, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		Assert.assertTrue(counter.isMin(0));
		Assert.assertFalse(counter.isMin(1));
		Assert.assertFalse(counter.isMin(-1));
	}

	@Test
	public void testIsMinReverseSorted() {
		final int[] array = { 3, 2, 1, 0 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		Assert.assertTrue(counter.isMin(0));
		Assert.assertFalse(counter.isMin(1));
		Assert.assertFalse(counter.isMin(-1));
	}

	@Test
	public void testIsMinNotSorted() {
		final int[] array = { 1, 2, 0, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		Assert.assertTrue(counter.isMin(0));
		Assert.assertFalse(counter.isMin(1));
		Assert.assertFalse(counter.isMin(-1));
	}

	@Test
	public void testShuffleSubsetOutOfBounds() {
		final int[] array = { 0, 1, 2, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		try {
			counter.shuffle(0, 5);
			Assert.fail();
		} catch (final ArrayIndexOutOfBoundsException e) {
		}
	}

	@Test
	public void testShuffleSubsetNegative() {
		final int[] array = { 0, 1, 2, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		try {
			counter.shuffle(-1, 2);
			Assert.fail();
		} catch (final ArrayIndexOutOfBoundsException e) {
		}
	}

	@Test
	public void testShuffleSubsetEmpty() {
		final int[] array = {};
		final ArrayInstCounter counter = new ArrayInstCounter(array);
		try {
			counter.shuffle(0, 0);
			Assert.fail();
		} catch (final UnspecifiedBehaviorException e) {
		}
	}

	@Test
	public void testShuffleSubset00() {
		final int[] array = { 0, 1, 2, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array.clone());
		for (int loop = 0; loop < ArrayInstCounterTest.MAX_LOOP; loop++) {
			counter.shuffle(0, 0);
			Assert.assertTrue(array.length == counter.length());
			for (int i = 0; i < array.length; i++) {
				Assert.assertTrue(array[i] == counter.get(i));
			}
		}
	}

	@Test
	public void testShuffleSubset11() {
		final int[] array = { 0, 1, 2, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array.clone());
		for (int loop = 0; loop < ArrayInstCounterTest.MAX_LOOP; loop++) {
			counter.shuffle(1, 1);
			Assert.assertTrue(array.length == counter.length());
			for (int i = 0; i < array.length; i++) {
				Assert.assertTrue(array[i] == counter.get(i));
			}
		}
	}

	@Test
	public void testShuffleSubset22() {
		final int[] array = { 0, 1, 2, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array.clone());
		for (int loop = 0; loop < ArrayInstCounterTest.MAX_LOOP; loop++) {
			counter.shuffle(2, 2);
			Assert.assertTrue(array.length == counter.length());
			for (int i = 0; i < array.length; i++) {
				Assert.assertTrue(array[i] == counter.get(i));
			}
		}
	}

	@Test
	public void testShuffleSubset33() {
		final int[] array = { 0, 1, 2, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array.clone());
		for (int loop = 0; loop < ArrayInstCounterTest.MAX_LOOP; loop++) {
			counter.shuffle(3, 3);
			Assert.assertTrue(array.length == counter.length());
			for (int i = 0; i < array.length; i++) {
				Assert.assertTrue(array[i] == counter.get(i));
			}
		}
	}

	@Test
	public void testShuffleSubset01() {
		final int[] array = { 0, 1, 2, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array.clone());
		for (int loop = 0; loop < ArrayInstCounterTest.MAX_LOOP; loop++) {
			counter.shuffle(0, 1);
			Assert.assertTrue(array.length == counter.length());
			for (int i = 2; i < 4; i++) {
				Assert.assertTrue(array[i] == counter.get(i));
			}
		}
	}

	@Test
	public void testShuffleSubset12() {
		final int[] array = { 0, 1, 2, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array.clone());
		for (int loop = 0; loop < ArrayInstCounterTest.MAX_LOOP; loop++) {
			counter.shuffle(1, 2);
			Assert.assertTrue(array.length == counter.length());
			Assert.assertTrue(array[0] == counter.get(0));
			Assert.assertTrue(array[3] == counter.get(3));
		}
	}

	@Test
	public void testShuffleSubset23() {
		final int[] array = { 0, 1, 2, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array.clone());
		for (int loop = 0; loop < ArrayInstCounterTest.MAX_LOOP; loop++) {
			counter.shuffle(2, 3);
			Assert.assertTrue(array.length == counter.length());
			for (int i = 0; i < 2; i++) {
				Assert.assertTrue(array[i] == counter.get(i));
			}
		}
	}

	@Test
	public void testShuffleSubset02() {
		final int[] array = { 0, 1, 2, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array.clone());
		for (int loop = 0; loop < ArrayInstCounterTest.MAX_LOOP; loop++) {
			counter.shuffle(0, 2);
			Assert.assertTrue(array.length == counter.length());
			Assert.assertTrue(array[3] == counter.get(3));
		}
	}

	@Test
	public void testShuffleSubset13() {
		final int[] array = { 0, 1, 2, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array.clone());
		for (int loop = 0; loop < ArrayInstCounterTest.MAX_LOOP; loop++) {
			counter.shuffle(1, 3);
			Assert.assertTrue(array.length == counter.length());
			Assert.assertTrue(array[0] == counter.get(0));
		}
	}

	@Test
	public void testShuffleSubset03() {
		final int[] array = { 0, 1, 2, 3 };
		final ArrayInstCounter counter = new ArrayInstCounter(array.clone());
		for (int loop = 0; loop < ArrayInstCounterTest.MAX_LOOP; loop++) {
			counter.shuffle(0, 3);
			Assert.assertTrue(array.length == counter.length());
		}
	}
}
