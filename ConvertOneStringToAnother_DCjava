public class ConvertOneStringToAnother_DC { // convert one string to another using add, delete, replace

	public int findMinOperations(String s1, String s2) {
		return findMinOperationsAux(s1, s2, 0, 0);
	}//end of method

	private int findMinOperationsAux(String s1, String s2, int i1, int i2) {
		if (i1 == s1.length()) // if we have reached the end of s1, then insert all the remaining characters of s2
			return s2.length() - i2;

		if (i2 == s2.length()) // if we have reached the end of s2, then delete all the remaining characters of s1
			return s1.length() - i1;

		if (s1.charAt(i1) == s2.charAt(i2)) // If the strings have a matching character, recursively match for the remaining lengths.
			return findMinOperationsAux(s1, s2, i1 + 1, i2 + 1);

		int c1 = 1 + findMinOperationsAux(s1, s2, i1 + 1, i2); // perform insertion
		int c2 = 1 + findMinOperationsAux(s1, s2, i1, i2 + 1); // perform deletion
		int c3 = 1 + findMinOperationsAux(s1, s2, i1 + 1, i2 + 1); // perform replacement
		System.out.println(c1+""+c2+""+c3);
		return Math.min(c1, Math.min(c2, c3));
	}//end of method

	public static void main(String[] args) {
		ConvertOneStringToAnother_DC editDisatnce = new ConvertOneStringToAnother_DC();
		System.out.println(editDisatnce.findMinOperations("table", "tacble"));

	}//end of method
}// end of class
