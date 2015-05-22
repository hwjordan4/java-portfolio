package assignment5;

/*
 * Harrison Jordan
 * CS3401
 * Section 02
 * Prof. Gayler
 * 02/27/2015
 * Assignment 5
 */
public class assignment_5_1 {
/*
 * Write a program that finds the maximum increasingly ordered subsequence of characters in a string.  
 * Analyze the time complexity of your program.
 */
	public static void main(String[] args) {
		String s = "MaximumincreasinglyorderedsubsequenceABCDEz"+
					"MaximumincreasinglyorderedsubsequenceABCDEz"+
					"MaximumincreasinglyorderedsubsequenceABCDEz";
		
		String s2 = "MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreabsinglyorderfedsubsequenghijceABCDEz"+
				"MaximuminklmcreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz";
		
		String s3 = "MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximuminTUVsuWXbsequYZencemaxumumorderedZZ"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximuminTUVsuWXbsequYZencemaxumumorderedZZ"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximumincreasinglyorderedsubsequenceABCDEz"+
				"MaximuminTUVsuWXbsequYZencemaxumumorderedZZ";
		
		String s4 = "Welcome";
		
		long startTime1 = System.currentTimeMillis();
		String maxSS = findMaxSS(s);
		long executionTime1 = System.currentTimeMillis() - startTime1;
		
		long startTime2 = System.currentTimeMillis();
		String maxSS2 = findMaxSS(s2);
		long executionTime2 = System.currentTimeMillis() - startTime2;
		
		long startTime3 = System.currentTimeMillis();
		String maxSS3 = findMaxSS(s3);
		long executionTime3 = System.currentTimeMillis() - startTime3;
		
		String maxSS4 = findMaxSS(s4);

		System.out.println(maxSS);
		System.out.println(maxSS2);
		System.out.println(maxSS3);
		System.out.println(maxSS4);
		
		
		System.out.println("\nLength (n)\tTime");
		System.out.println(s.length()+"\t\t" + executionTime1);
		System.out.println(s2.length()+"\t\t" + executionTime2);
		System.out.println(s3.length()+"\t\t" + executionTime3);
		
		System.out.println("\nTime Complexity: O(n^2)");

	}
	
	/**
	 * @param A string that cannot be empty or null
	 * @return the maximum increasingly ordered subsequence of the string
	 */
	
	private static String findMaxSS(String s) {

		assert (!s.isEmpty());
		assert (s != null);

		String currentSS = s.substring(0, 1);
		String bestSS = s.substring(0, 1);
		char currentChar = s.charAt(0);

		for (int i = 0; i < s.length(); i++) {
			
			currentChar = s.charAt(i);
			currentSS = "" + s.charAt(i);

			for (int j = i + 1; j < s.length(); j++) {
				if ((s.charAt(j) - currentChar) > 0) {
					currentSS += s.charAt(j);
					currentChar = s.charAt(j);
				}

				if (bestSS.length() < currentSS.length())
					bestSS = currentSS;
			}
			
		}

		return bestSS;
	}

}
