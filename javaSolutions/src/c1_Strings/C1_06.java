/**
 * Cracking-The-Coding-Interview
 * Chapter 1 - Arrays and Strings
 * Q1_06.java
 * 
 * Implement a method to perform basic string compression
 * using the count of repeated characters. If the sum compressed string
 * does not become smaller then the original string, then your 
 * method should return the original string. You can assume that
 * the string has only upper case and lower case letters.
 * 
 * EXAMPLE
 * Input: "aabcccccaaa" 
 * Output: "a2b1c5a3"
 * */
package c1_Strings;

public class C1_06 {
	
	public static String compress(String str) {
		StringBuilder string = new StringBuilder();
		char current = str.charAt(0);
		int count = 1;
		boolean hasBeenCompressed = false;
		
		for(int i=1;i<str.length();i++) {
			if(str.charAt(i)==current) {
				count++;
				if(count>1) {
					hasBeenCompressed = true;
				}
			}else{
				string.append(current);
				string.append(count);
				count = 1;
				current = str.charAt(i);
			}
		}
		string.append(current);
		string.append(count);
		
		if(hasBeenCompressed) {
			return string.toString();
		}else {
			return str;
		}
		
	}

	public static void main(String[] args) {
		System.out.println(compress("hey"));

	}

}
