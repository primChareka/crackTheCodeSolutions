package StringQuestions;

public class Q1_04 {

	public static boolean isPalindromPermutation(String permu, String str) {
		int[] letters = new int[256];
		int length = permu.length();
		int i = 0;
		permu = permu.toLowerCase();

		if (permu == null || str == null) {
			return false;
		} else if (length != str.length()) {
			return false;
		}

		
		// For even string only need to go through half length
		if (length % 2 == 0) {
			length /= 2;

			
			for (i = 0; i < length; i++) {
				System.out.println(permu.charAt(i));
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

	public static void main(String[] args) {
		System.out.println(Q1_04.isPalindromPermutation("tacocat", "ttacaoc"));
		System.out.println(Q1_04.isPalindromPermutation("heyyeh", "yyeehh"));
		System.out.println(Q1_04.isPalindromPermutation("heyyeh", "yyehh"));
		System.out.println(Q1_04.isPalindromPermutation("heyyeh", "yyeshh"));
		System.out.println(Q1_04.isPalindromPermutation("heYyeh", "yyeehh"));
	}

}
