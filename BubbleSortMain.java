class BubbleSort {

	void bubbleSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) //run from first cell to last cell
			for (int j = 0; j < n - i - 1; j++) //run from first cell to "last cell - iteration"
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}//end of method

	
	/* Prints the array */
	void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}// end of class

public class BubbleSortMain {

	public static void main(String[] args) {

		BubbleSort ob = new BubbleSort();
		int arr[] = { 10, 5, 30, 15, 50, 6 };
		System.out.println("Array to be sorted...");
		ob.printArray(arr);

		ob.bubbleSort(arr);

		System.out.println("Sorted Array...");
		ob.printArray(arr);

	}// end of method

}// end of class
