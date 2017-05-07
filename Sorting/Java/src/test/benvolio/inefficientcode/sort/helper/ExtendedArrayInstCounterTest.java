package benvolio.inefficientcode.sort.helper;

import org.junit.Assert;
import org.junit.Test;

public class ExtendedArrayInstCounterTest {

	private final static int MAX_LOOP = 100000;
	
	@Test
	public void testEmptyMin() {
		final int[] array = {};
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array);
		try {
			counter.min();
			Assert.fail();
		} catch (final UnspecifiedBehaviorException e) {
		}
	}

	@Test
	public void testSize1Min() {
		final int[] array = { 0 };
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array);
		Assert.assertTrue(counter.min() == 0);
	}

	@Test
	public void testMinSorted() {
		final int[] array = { 0, 1, 2, 3 };
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array);
		Assert.assertTrue(counter.min() == 0);
	}

	@Test
	public void testMinReverseSorted() {
		final int[] array = { 3, 2, 1, 0 };
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array);
		Assert.assertTrue(counter.min() == 0);
	}

	@Test
	public void testMinNotSorted() {
		final int[] array = { 1, 2, 0, 3 };
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array);
		Assert.assertTrue(counter.min() == 0);
	}

	@Test
	public void testEmptyIsSorted() {
		final int[] array = {};
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array);
		try {
			counter.isSorted();
			Assert.fail();
		} catch (final UnspecifiedBehaviorException e) {
		}
	}

	@Test
	public void testSize1IsSorted() {
		final int[] array = { 0 };
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array);
		Assert.assertTrue(counter.isSorted());
	}

	@Test
	public void testIsSortedSorted() {
		final int[] array = { 0, 1, 2, 3 };
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array);
		Assert.assertTrue(counter.isSorted());
	}

	@Test
	public void testIsSortedReverseSorted() {
		final int[] array = { 3, 2, 1, 0 };
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array);
		Assert.assertFalse(counter.isSorted());
	}

	@Test
	public void testIsSortedNotSorted() {
		final int[] array = { 1, 2, 0, 3 };
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array);
		Assert.assertFalse(counter.isSorted());
	}

	@Test
	public void testEmptyIsMin() {
		final int[] array = {};
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array);
		try {
			counter.isMin(0);
			Assert.fail();
		} catch (final UnspecifiedBehaviorException e) {
		}
	}

	@Test
	public void testSize1IsMin() {
		final int[] array = { 0 };
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array);
		Assert.assertTrue(counter.isMin(0));
		Assert.assertFalse(counter.isMin(1));
		Assert.assertFalse(counter.isMin(-1));
	}

	@Test
	public void testIsMinSorted() {
		final int[] array = { 0, 1, 2, 3 };
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array);
		Assert.assertTrue(counter.isMin(0));
		Assert.assertFalse(counter.isMin(1));
		Assert.assertFalse(counter.isMin(-1));
	}

	@Test
	public void testIsMinReverseSorted() {
		final int[] array = { 3, 2, 1, 0 };
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array);
		Assert.assertTrue(counter.isMin(0));
		Assert.assertFalse(counter.isMin(1));
		Assert.assertFalse(counter.isMin(-1));
	}

	@Test
	public void testIsMinNotSorted() {
		final int[] array = { 1, 2, 0, 3 };
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array);
		Assert.assertTrue(counter.isMin(0));
		Assert.assertFalse(counter.isMin(1));
		Assert.assertFalse(counter.isMin(-1));
	}

	@Test
	public void testShuffleSubsetOutOfBounds() {
		final int[] array = { 0, 1, 2, 3 };
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array);
		try {
			counter.shuffle(0, 5);
			Assert.fail();
		} catch (final ArrayIndexOutOfBoundsException e) {
		}
	}

	@Test
	public void testShuffleSubsetNegative() {
		final int[] array = { 0, 1, 2, 3 };
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array);
		try {
			counter.shuffle(-1, 2);
			Assert.fail();
		} catch (final ArrayIndexOutOfBoundsException e) {
		}
	}

	@Test
	public void testShuffleSubsetEmpty() {
		final int[] array = {};
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array);
		try {
			counter.shuffle(0, 0);
			Assert.fail();
		} catch (final UnspecifiedBehaviorException e) {
		}
	}

	@Test
	public void testShuffleSubset00() {
		final int[] array = { 0, 1, 2, 3 };
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array.clone());
		for (int loop = 0; loop < ExtendedArrayInstCounterTest.MAX_LOOP; loop++) {
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
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array.clone());
		for (int loop = 0; loop < ExtendedArrayInstCounterTest.MAX_LOOP; loop++) {
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
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array.clone());
		for (int loop = 0; loop < ExtendedArrayInstCounterTest.MAX_LOOP; loop++) {
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
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array.clone());
		for (int loop = 0; loop < ExtendedArrayInstCounterTest.MAX_LOOP; loop++) {
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
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array.clone());
		for (int loop = 0; loop < ExtendedArrayInstCounterTest.MAX_LOOP; loop++) {
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
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array.clone());
		for (int loop = 0; loop < ExtendedArrayInstCounterTest.MAX_LOOP; loop++) {
			counter.shuffle(1, 2);
			Assert.assertTrue(array.length == counter.length());
			Assert.assertTrue(array[0] == counter.get(0));
			Assert.assertTrue(array[3] == counter.get(3));
		}
	}

	@Test
	public void testShuffleSubset23() {
		final int[] array = { 0, 1, 2, 3 };
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array.clone());
		for (int loop = 0; loop < ExtendedArrayInstCounterTest.MAX_LOOP; loop++) {
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
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array.clone());
		for (int loop = 0; loop < ExtendedArrayInstCounterTest.MAX_LOOP; loop++) {
			counter.shuffle(0, 2);
			Assert.assertTrue(array.length == counter.length());
			Assert.assertTrue(array[3] == counter.get(3));
		}
	}

	@Test
	public void testShuffleSubset13() {
		final int[] array = { 0, 1, 2, 3 };
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array.clone());
		for (int loop = 0; loop < ExtendedArrayInstCounterTest.MAX_LOOP; loop++) {
			counter.shuffle(1, 3);
			Assert.assertTrue(array.length == counter.length());
			Assert.assertTrue(array[0] == counter.get(0));
		}
	}

	@Test
	public void testShuffleSubset03() {
		final int[] array = { 0, 1, 2, 3 };
		final ExtendedArrayInstCounter counter = new ExtendedArrayInstCounter(array.clone());
		for (int loop = 0; loop < ExtendedArrayInstCounterTest.MAX_LOOP; loop++) {
			counter.shuffle(0, 3);
			Assert.assertTrue(array.length == counter.length());
		}
	}

}
