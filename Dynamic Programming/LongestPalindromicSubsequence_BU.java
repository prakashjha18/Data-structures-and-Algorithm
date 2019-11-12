public class LongestPalindromicSubsequence_BU {

	public int findLPSLength(String st) {
		int[][] dp = new int[st.length()][st.length()];
		for (int col = 0; col < st.length(); col++) {
			for (int row = st.length()-1; row >= 0; row--) {
				if (row > col) { // BASE CASE - If we have traversed more than 1/2 of string then return 0 as we dont need to process it
					dp[row][col] = 0;
				} else if (row == col) { // BASE CASE - If both the index are at same position then its a palindrome as its 1 character.
					dp[row][col] = 1;
				} else {
					if (st.charAt(row) == st.charAt(col)) {
						dp[row][col] = Math.max(2+dp[row + 1][col - 1], Math.max(dp[row][col - 1], dp[row + 1][col]));
					} else {
						dp[row][col] = Math.max(dp[row][col - 1], dp[row + 1][col]);
					}
				}
			} 
		}// end of loop
		return dp[0][st.length()-1];
	}// end of method

	
	public static void main(String[] args) {
		LongestPalindromicSubsequence_BU lps = new LongestPalindromicSubsequence_BU();
		System.out.println("Longest Palindromic Substring: " + lps.findLPSLength("elrmenmet"));
	}// end of method
}// end of class
