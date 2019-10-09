public class ConvertOneStringToAnother_BU {

	public int findMinOperations(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i1 = 0; i1 <= s1.length(); i1++) // if we have reached the end of s1, then insert all the remaining characters of s2
			dp[i1][0] = i1;

		for (int i2 = 0; i2 <= s2.length(); i2++) // if we have reached the end of s2, then delete all the remaining characters of s1
			dp[0][i2] = i2;

		for (int i1 = 1; i1 <= s1.length(); i1++) {
			for (int i2 = 1; i2 <= s2.length(); i2++) { // If the strings have a matching character, recursively match for the remaining lengths.
				if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1))
					dp[i1][i2] = dp[i1 - 1][i2 - 1];
				else
					dp[i1][i2] = 1 + Math.min(dp[i1 - 1][i2], // delete
							         Math.min(dp[i1][i2 - 1], // insert
								      	dp[i1 - 1][i2 - 1])); // replace
			}
		}
		return dp[5][5];
		
	}

	public static void main(String[] args) {
		ConvertOneStringToAnother_BU editDisatnce = new ConvertOneStringToAnother_BU();
		System.out.println(editDisatnce.findMinOperations("table", "tbres"));

	}
}
