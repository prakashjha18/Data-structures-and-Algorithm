class MergeSort {

	public static void mergeSort(int[] Array, int left, int right) {
		if (right > left) {
			int m = (left + right) / 2;
			mergeSort(Array, left, m);
			mergeSort(Array, m + 1, right);
			merge(Array, left, m, right);
		}
	}//end of method

	
	static void merge(int[] A, int left, int middle, int right) {
		int [] leftTmpArray = new int[middle-left+2];  //Create tmp arrays
		int [] rightTmpArray = new int[right-middle+1];
		
		for(int i=0;i<=middle-left;i++) //Copy values from Array 'A' to these tmp arrays
			leftTmpArray[i]= A[left+i];
		for(int i=0;i<right-middle;i++)
			rightTmpArray[i]= A[middle+1+i];
		
		leftTmpArray[middle-left+1]= Integer.MAX_VALUE; //Merge values and insert into Array 'A'
		rightTmpArray[right-middle] = Integer.MAX_VALUE;
		int i = 0, j = 0;
		for (int k = left; k <= right; k++) {
			if (leftTmpArray[i] < rightTmpArray[j]) {
				A[k] = leftTmpArray[i];
				i++;
			} else {
				A[k] = rightTmpArray[j];
				j++;
			}
		}
	}//end of method
	
	
	public static void printArray(int []array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+"  ");
		}
	}//end of method

}//end of class


public class MergeSortMain {

	public static void main(String[] args) {
		
		int array[] = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};
		
		System.out.println("User entered Array: ");
		MergeSort.printArray(array);
		
		long start = System.nanoTime();
		MergeSort.mergeSort(array, 0, array.length-1);
		long end = System.nanoTime();
		System.out.println("\n\nTime to execute this algo: " + (end-start));
		
		System.out.println("\nAfter sorting: ");
		MergeSort.printArray(array);
	}//end of method

}//end of class
