public class LongestPalindromicSubsequence_TD {

	public int findLPSLength(String string) {
		Integer[][] dp = new Integer[string.length()][string.length()];
		return lps_Aux(dp, string, 0, string.length() - 1);
	}// end of method

	
	private int lps_Aux(Integer[][] dp, String string, int startIndex, int endIndex) {
		if (startIndex > endIndex) { //BASE CASE - If we have traversed more than 1/2 of string then return 0 as we dont need to process it
			return 0;
		}
		if (startIndex == endIndex) { //BASE CASE - If both the index are at same position then its a palindrome as its 1 character.
			return 1;
		}
		int c3 = 0;
		if (dp[startIndex][endIndex] == null) { //If we have not solved this problem previously, only then solve it
			if (string.charAt(startIndex) == string.charAt(endIndex)) {
				c3 = 2 + lps_Aux(dp, string, startIndex + 1, endIndex - 1);//CASE#1 - If index pointed characters matches then we add 2 to the existing known palindrome length
			} 
			int c1 = lps_Aux(dp, string, startIndex + 1, endIndex);//CASE#2 - Skip one element from beginning
			int c2 = lps_Aux(dp, string, startIndex, endIndex - 1);//CASE#3 - Skip one element from end
			dp[startIndex][endIndex] = Math.max(c3,Math.max(c1, c2));//Take the max sized palindrome
			}
		return dp[startIndex][endIndex];
	}// end of method
	
	
	public static void main(String[] args) {
		LongestPalindromicSubsequence_TD lps = new LongestPalindromicSubsequence_TD();
		System.out.println("Longest Palindromic Sequence: " + lps.findLPSLength("elrmenmet"));
	}// end of method
}// end of class
