package sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SelectionSortTest {

	@Test
	public void shouldSortSmallArray() {
		int[] arr = { 14, 33, 27, 10, 35, 19, 42, 44 };

		SelectionSort.sort(arr);

		int[] expected = { 10, 14, 19, 27, 33, 35, 42, 44 };
		assertArrayEquals(expected, arr);
	}

	@Test
	public void shouldSortSmallArrayWithAlreadySortedElements() {
		int[] arr = { 10, 14, 19, 27, 33, 35, 42, 44 };

		SelectionSort.sort(arr);

		int[] expected = { 10, 14, 19, 27, 33, 35, 42, 44 };
		assertArrayEquals(expected, arr);
	}

	@Test
	public void shouldSortSmallArrayWithAlmostSortedElements() {
		int[] arr = { 44, 14, 19, 27, 33, 35, 42, 10 };

		SelectionSort.sort(arr);

		int[] expected = { 10, 14, 19, 27, 33, 35, 42, 44 };
		assertArrayEquals(expected, arr);
	}

	@Test
	public void shouldSortArrayWithOneElement() {
		int[] arr = { 10 };

		SelectionSort.sort(arr);

		int[] expected = { 10 };
		assertArrayEquals(expected, arr);
	}

	@Test
	public void shouldSortArrayWithTwoElements() {
		int[] arr = { 10, 3 };

		SelectionSort.sort(arr);

		int[] expected = { 3, 10 };
		assertArrayEquals(expected, arr);
	}

	@Test
	public void shouldSortArrayWithTwoAlreadySortedElements() {
		int[] arr = { 1, 2 };

		SelectionSort.sort(arr);

		int[] expected = { 1, 2 };
		assertArrayEquals(expected, arr);
	}

	@Test
	public void shouldSortArrayWithNegativeNumbers() {
		int[] arr = { -342, 1, -60, -93 };

		SelectionSort.sort(arr);

		int[] expected = { -342, -93, -60, 1 };
		assertArrayEquals(expected, arr);
	}

	@Test
	public void shouldDoNothingWithEmptyArray() {
		int[] arr = {};

		SelectionSort.sort(arr);

		int[] expected = {};
		assertArrayEquals(expected, arr);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWithNullArray() {
		SelectionSort.sort(null);
	}

}
