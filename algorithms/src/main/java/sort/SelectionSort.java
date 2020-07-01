package sort;

public class SelectionSort {

	public static void sort(int[] arr) {
		if (arr == null) {
			throw new IllegalArgumentException("Array is required");
		}

		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}

			if (min != i) {
				SortUtil.swap(arr, i, min);
			}
		}
	}

}
