/**
 * Cracking-The-Coding-Interview
 * Chapter 1 - Arrays and Strings
 * Q1_02.java
 * 
 * Question:
 * Given two strings, write a method to decide if one is the permutation of other.
 * 
 */

package StringQuestions;
import java.util.ArrayList;

public class Q1_02 {
	/**
	 * Method to check if two strings are permutation 
	 * 
	 * Time Complexity: O(n^2) in case of string are palindrome (must search to end of values array each time)
	 * 
	 * @param 
	 * @param str2
	 * @return {@link boolean}
	 */
	public static boolean Permutation(String string1, String string2) {
		
		if(string1==null||string2==null||string1==""||string2 == "") {
			return false;
		}else if(string1.length()!=string2.length()) {
			return false;
		}else {		
			ArrayList<Character> values = new ArrayList<Character>();
			for(char i : string1.toCharArray()) {
				values.add(i);
			}
			
			for(char i : string2.toCharArray()) {
				if(values.contains(i)) {
					values.remove(Character.valueOf(i));
				}else {
					return false;
				}
			}
			return true;
		}
	}

	public static void main(String[] args) {
		String string1 = "Hey";
		String string2 ="euH";
		System.out.println(Permutation(string1,string2));
		
		string1 = "Hey";
		string2 ="eyH";
		System.out.println(Permutation(string1,string2));
		
		string1 = "Hey";
		string2 ="eyH1";
		System.out.println(Permutation(string1,string2));
		
		string1 = null;
		string2 = null;
		System.out.println(Permutation(string1,string2));
		
		string1 = "";
		string2 = "";
		System.out.println(Permutation(string1,string2));

	}

}
