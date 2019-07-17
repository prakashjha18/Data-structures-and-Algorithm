class TwoDimensionalArray {
	int arr[][] = null;

	// Constructor
	public TwoDimensionalArray(int numberOfRows, int numberOfColumns) {
		this.arr = new int[numberOfRows][numberOfColumns];
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				arr[row][col] = Integer.MIN_VALUE;
			}
		}
	}
	

	// Traverse the array
	public void traverseArray() {
		try {
			System.out.println("Printing the array now...");
			for (int row = 0; row < arr.length; row++) {
				for (int col = 0; col < arr[0].length; col++) {
					System.out.print(arr[row][col] + "   ");
				}
				System.out.println();
			}
			System.out.println("\n");
		} catch (Exception e) {
			System.out.println("Array does not exists");
		}

	}
	
	
	// Inserting value in the Array
	public void insertValueInTheArray(int row, int col, int value) {
		try {
			if (arr[row][col] == Integer.MIN_VALUE) {
				arr[row][col] = value;
				System.out.println("Successfully inserted " + value + " in the array.");
			} else {
				System.out.println("This cell is already occupied by another value.");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid index to access array !");
			// e.printStackTrace();
		}
	}
	
	
	// Accessing single value from given array
	public void accessSingleCell(int row, int col) {
		System.out.println("\nAccessing Row#" + row + ", Col#" + col + "...");
		try {
			System.out.println("Cell value is: " + arr[row][col]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid index to access array !");
			// e.printStackTrace();
		}
		System.out.println();
	}
	
	
	// Searching a single value from the Array
	public void searchingSingleValue(int value) {
		System.out.println("\nSearching value " + value + " in the array");
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				if (arr[row][col] == value) {
					System.out.println("Value is founud at location Row:" + row + " & Col:" + col + "\n\n");
					return;
				}
			}
		}
		System.out.println("Value is not found in Array\n");

	}
	
	
	// Deleting a value from Array
	public void deleteValuefromArray(int deleteValueFromThisRow, int deleteValueFromThisCol) {
		System.out.println(
				"Deleting value from Row#" + deleteValueFromThisRow + " & Col#" + deleteValueFromThisCol + "...");
		try {
			System.out.println("Successfully deleted: " + arr[deleteValueFromThisRow][deleteValueFromThisCol]);
			arr[deleteValueFromThisRow][deleteValueFromThisCol] = Integer.MIN_VALUE;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println();
			System.out.println("Cant delete the value as cell# provided is not in the range of array !");
			// e.printStackTrace();
		}
	}
	
	
	// Delete the entire Array
	public void deleteThisArray() {
			arr = null;
			System.out.println("Array has been succefully deleted");
	}
	
}
public class TwoDimensionalArrayMain {

	public static void main(String[] args) {

		System.out.println("Creating a blank array of size 5X5...");
		TwoDimensionalArray sda = new TwoDimensionalArray(5,5);
		sda.traverseArray();
		
		
		sda.insertValueInTheArray(0,2,1000000001);
		sda.traverseArray();
				
		sda.insertValueInTheArray(0,2,1000000001);
		sda.traverseArray();
		
		
		sda.accessSingleCell(0,2);
		sda.accessSingleCell(6,2);
		sda.accessSingleCell(2,2);
		
		
		sda.searchingSingleValue(10);
		sda.searchingSingleValue(-2147483648);
		sda.searchingSingleValue(1000000001);
		
		
		sda.deleteValuefromArray(0,2);
		sda.traverseArray();
		
		
		sda.deleteThisArray();
		sda.traverseArray();
		
    }
}
