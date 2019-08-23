import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

class BucketSort {
	int arr[];
	
	
	//Constructor
	public BucketSort(int arr[]) {
		this.arr = arr;
	}
	
	
	//Prints Array
	public void printArray() {
		int tmp = 0;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
			tmp++;
			if(tmp == 20) {
				System.out.println();
				tmp = 0;
			}
		}	
	}
	
	
	//Prints Buckets
	public void printBucket(ArrayList<Integer>[] buckets) {
		for(int i=0; i<buckets.length; i++) {
			System.out.println("\nBucket#" + i + " :");
			for (int j=0; j<buckets[i].size(); j++) {
				System.out.print(buckets[i].get(j)+"  ");
			}
		}
		
	}
	
	//Sorting method
	public void bucketSort() {
		
		//Create sqrt# of buckets, so that the distribution is even
		int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
		int maxValue = Integer.MIN_VALUE;
		int minValue = Integer.MAX_VALUE;
		
		
		//Find the min and max value from the array
		for(int value: arr) {
			if(value < minValue) {
				minValue = value;
			}else if (value > maxValue) {
				maxValue = value;
			}
		}
		
		
		//Create an array of buckets
		ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
		
		
		//initializing empty buckets
		for(int i =0;i<buckets.length;i++) {
			buckets[i] = new ArrayList<Integer>();	 
		}
		
		
		for(int value: arr) {
			int bucketNumber = (int) Math.ceil ((value *  numberOfBuckets) / maxValue);
			//System.out.println("bucketNumber: " + bucketNumber);
			buckets[bucketNumber-1].add(value);
		}
				
		
		System.out.println("\n\nPrinting buckets before Sorting...");
		printBucket(buckets);
		
		
		//Sort Buckets
		for(ArrayList<Integer> bucket: buckets) {
			Collections.sort(bucket);
		}
		
		
		System.out.println("\n\nPrinting buckets after Sorting...");
		printBucket(buckets);
		
		
		//concatenate buckets
		int index=0;
		for(ArrayList<Integer> bucket: buckets) {
			for(int value: bucket) {
				arr[index] = value;
				index++;
			}
		}
	}//end of method 
	
}//end of class


public class BucketSortMain {
	public static void main(String[] args) {
		
		int arr[] = new int[100];
		
		//Generating 100 random numbers in the range of 0-100
		Random random = new Random();
		for(int i=0;i<100;i++) {
			arr[i] = random.nextInt(100)+100;
		}
		
		
		//Passing this array to BucketSort method
		BucketSort bs = new BucketSort(arr);
		System.out.println("Array before Sorting: ");
		bs.printArray();
		bs.bucketSort();
		
		
		System.out.println("\n\nArray after Sorting: ");
		bs.printArray();
		
	}
}
