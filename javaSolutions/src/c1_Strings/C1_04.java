package c1_Strings;

/**
 * Cracking-The-Coding-Interview
 * Chapter 1 - Arrays and Strings
 * C1_04.java
 * 
 * Question:
 * Given a string, write a function to check if it is a
 * permutation of a palindrome. A palindrome is a word
 * or phrase that is same forwards and backwards. A
 * permutation is a rearrangement of letters. The palindrome
 * does not need to be limited to just dictionary words.
 * 
 * EXAMPLE
 * Input : Tact Coa
 * Output : True (permutations : "taco cat", "atco cta", etc.) 
 * 
 * @author primrosechareka
 *
 */
public class C1_04 {

	/**
	 * 
	 * 
	 * @param permu
	 *            String of permutation
	 * @param str
	 *            String in question of being a palindrome of the permutation string
	 * @return
	 * 		Returns true if the string in question is a palindrome of the first parameter.
	 *		returns false otherwise. A false value is also returned if either value is null
	 *		or if the first parameter is not a palindrome
	 */	
	public static boolean isPalindromePermutation(String permu, String str) {
		int[] letters = new int[256];
		int length = permu.length();
		int i = 0;
		permu = permu.toLowerCase();

		if (permu == null || str == null) {
			return false;
		} else if (!isPalindrome(permu)||length != str.length()) {
			return false;
		}

		// For even string only need to go through half length
		if (length % 2 == 0) {
			length /= 2;
			for (i = 0; i < length; i++) {
				letters[permu.charAt(i)] += 2;
			}

		} else {
			// For odd length need to go to round up the midway point
			length /= 2;
			length++;

			for (i = 0; i < length - 1; i++) {
				letters[permu.charAt(i)] += 2;
			}
			letters[permu.charAt(i)]++;
		}

		for (char test : str.toCharArray()) {
			letters[test]--;
			if (letters[test] < 0) {
				return false;
			}
		}

		return true;
	}

	public static boolean isPalindrome(String str) {
		int length = str.length();
		str = str.toLowerCase();
		int i;

		for (i = 0; i < length / 2; i++) {
			if (str.charAt(i) != str.charAt(length - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(C1_04.isPalindromePermutation("tacocat", "ttacaoc"));
		System.out.println(C1_04.isPalindromePermutation("heyyeh", "yyeehh"));
		System.out.println(C1_04.isPalindromePermutation("heyyeh", "yyehh"));
		System.out.println(C1_04.isPalindromePermutation("heyyeh", "yyeshh"));
		System.out.println(C1_04.isPalindromePermutation("heYyeh", "yyeehh"));
		System.out.println(C1_04.isPalindromePermutation("heYyzh", "yyeehh"));
	}

}
