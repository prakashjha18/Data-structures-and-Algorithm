class SelectionSort {
	
	static void selectionSort(int[] a) {
		for (int j = 0; j<a.length; j++) {
			int minimumIndex = j;
			for (int i=j+1; i<a.length; i++) {
				if (a[i] < a[minimumIndex]) //find which is the smallest element to right of 'j'
					minimumIndex = i;
			}//end of inner loop
			if (minimumIndex != j) { // if j is not minimum index then swap
				int temp = a[j];
				a[j] = a[minimumIndex];
				a[minimumIndex] = temp;
			}
		}//end of outer loop
	}//end of method

	
	public static void printArray(int []array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+"  ");
		}
	}//end of method

}//end of class


public class SelectionSortMain {

	public static void main(String[] args) {
		int array[] = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};
		
		System.out.println("User entered Array: ");
		SelectionSort.printArray(array);
		
		SelectionSort.selectionSort(array);
		
		System.out.println("\n\nAfter sorting: ");
		SelectionSort.printArray(array);
	}//end of method

}//end of class
