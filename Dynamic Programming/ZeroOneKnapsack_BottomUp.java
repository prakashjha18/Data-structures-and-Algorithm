public class ZeroOneKnapsack_BottomUp {

	public int solveKnapsack(int[] profits, int[] weights, int capacity) {
		if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)  //Base case
			return 0;
		
		int numberOfRows = profits.length + 1;// adding a dummy row to avoid array index issues
		int[][] dp = new int[numberOfRows][capacity + 1];// Create a 2D Array to store all the results

		for (int i = 0; i < numberOfRows; i++) { // Insert 0 in 1st column as it is dummy column to avoid array index issues
			dp[i][0] = 0;
		}
		
		for (int i = 0; i <= capacity; i++) {// Insert 0 in last row as it is dummy column to avoid array index issues
			dp[numberOfRows - 1][i] = 0;
		}

		for (int row = numberOfRows - 2; row >= 0; row--) {
			for (int column = 1; column <= capacity; column++) {
				int profit1 = 0, profit2 = 0;
				if (weights[row] <= column) { // column represents current capacity
					profit1 = profits[row] + dp[row + 1][column - weights[row]];  // Taking current element
				}
				profit2 = dp[row + 1][column]; // Not taking current element
				dp[row][column] = Math.max(profit1, profit2);
			}
		}//end of loop
		return dp[0][capacity];
	}// end of method

	public static void main(String[] args) {
		ZeroOneKnapsack_BottomUp ks = new ZeroOneKnapsack_BottomUp();
		int[] profits = { 31, 26, 72, 17 };
		int[] weights = { 3, 1, 5, 2 };
		System.out.println(ks.solveKnapsack(profits, weights, 7));
	}// end of method
}// end of class
