package benvolio.inefficientcode.sort;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;

import benvolio.inefficientcode.sort.helper.ArrayHelper;
import benvolio.inefficientcode.sort.helper.InstructionCounter;
import benvolio.inefficientcode.sort.helper.SortingError;

public class TestInefficientSort {

	private static final int ARRAY_SIZE = 10;
	private static final int MAX_VALUE = 20 * TestInefficientSort.ARRAY_SIZE;

	public static void main(final String[] args) {
		final int[] array = ArrayHelper.createRandomArray(TestInefficientSort.ARRAY_SIZE,
				TestInefficientSort.MAX_VALUE);
		TestInefficientSort.testAndPrintResults(new QuickSort(), array);
		TestInefficientSort.testAndPrintResults(new InsertionSort(), array);
		TestInefficientSort.testAndPrintResults(new PermutationSort(), array);
		TestInefficientSort.testAndPrintResults(new AdvancingRandomSort(), array);
		TestInefficientSort.testAndPrintResults(new AdvancingShuffleSort(), array);
		TestInefficientSort.testAndPrintResults(new RandomSort(), array);
		TestInefficientSort.testAndPrintResults(new ShuffleSubsetSort(), array);
		TestInefficientSort.testAndPrintResults(new ShuffleSort(), array);
	}

	private static void testAndPrintResults(final InefficientSort sortAlgorithm, final int[] array) {
		Validate.notNull(sortAlgorithm);
		Validate.notNull(array);
		final String algorithmName = sortAlgorithm.getClass().getSimpleName();
		try {
			final InstructionCounter counter = TestInefficientSort.testSort(sortAlgorithm, array);
			System.out.println("[" + algorithmName + "] " + 
					sortAlgorithm.getAveragePerformance() + " : O(" + 
					sortAlgorithm.getAveragePerformance(array.length) + ")");
			System.out.println("\t\tRead: " + counter.getReadInstCount());
			System.out.println("\t\tWrite: " + counter.getWriteInstCount());
			System.out.println("\t\tTotal: " + counter.getTotalInstCount());
		} catch (final SortingError e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	private static InstructionCounter testSort(final InefficientSort sortAlgorithm, final int[] array)
			throws SortingError {
		Validate.notNull(sortAlgorithm);
		Validate.notNull(array);
		final int[] testArray = array.clone();
		final int[] cloneArray = array.clone();
		Arrays.sort(cloneArray);
		Arrays.sort(testArray);
		final InstructionCounter counter = sortAlgorithm.sort(testArray);
		if (!ArrayHelper.isSorted(testArray) || !Arrays.equals(cloneArray, testArray)) {
			throw new SortingError(
					"The algorithm [" + sortAlgorithm.getClass().getSimpleName() + "] did not sort correctly the array.");
		}
		return counter;
	}

}
