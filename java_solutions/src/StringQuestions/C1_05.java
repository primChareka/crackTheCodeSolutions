/**
 * Cracking-The-Coding-Interview
 * Chapter 1 - Arrays and Strings
 * Q1_02.java
 * 
 * Question:
 * There are three types of edits that can be performed
 * on strings, insert a character, remove a character or
 * replace a character. Given two strings, write a function
 * to check of they are one edit (or zero edits) away.
 * 
 * EXAMPLE
 * Input: pale, ple
 * Output: true
 * 
 * Input: pales, pale
 * Output: true
 * 
 * Input: pale, bale
 * Output: true
 * 
 * Input: pale, bake
 * Output: false
 */
package StringQuestions;

import java.util.ArrayList;

public class C1_05 {
	public static ArrayList<Character> stack = new ArrayList<Character>();
	public static boolean oneEdit(String a, String b) {
		if(a==null||b==null) {
			return false;
		}else if(a.length() == b.length()) {
			return oneReplacement(a,b);
		}
		else if(a.length()>b.length()) {
			return oneInsertOrDelete(a, b);
		}else {
			return oneInsertOrDelete(b, a);
		}
	}
	
	public static boolean oneReplacement(String a, String b) {
		boolean flag = false;
		
		for(int i=0;i<a.length();i++){
			if(a.charAt(i)!=b.charAt(i)){
				if(flag) {
					return false;
				}else {
					flag = true;
				}
			}
		}	
		return true;
	}
	
	public static boolean oneInsertOrDelete(String large, String small) {
		int j=0;
		
		if(large.length()-small.length()>1) {
			return false;
		}
		
		for(int i=0;i<large.length()&&j<small.length();i++) {
			if(large.charAt(i)!=small.charAt(j)) {
			stack.add(large.charAt(i));//push to top
			}else {
				j++;
			}
			
			if(stack.size()>2) {
				return false;
			}
		}		
		return true;
	}

}
