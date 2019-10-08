public class House_Thieft_BottomUp {

	public int findMaxSteal(int[] wealth) {
		int dp[] = new int[wealth.length + 2]; // '+1' to handle the zero house
		dp[wealth.length] = 0; // if there are no houses, the thief can't steal anything
		for (int i = wealth.length - 1; i >= 0; i--) {
			dp[i] = Math.max(wealth[i] + dp[i + 2], dp[i + 1]);
		}
		return dp[0];
	}

	public static void main(String[] args) {
		House_Thieft_BottomUp ht = new House_Thieft_BottomUp();
		int[] wealth = { 6, 7, 1, 30, 8, 2, 4 };
		System.out.println(ht.findMaxSteal(wealth));
		wealth = new int[] { 20, 5, 1, 13, 6, 11, 40 };
		System.out.println(ht.findMaxSteal(wealth));
	}
}
