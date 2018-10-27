/**
 * Cracking-The-Coding-Interview
 * Chapter 1 - Arrays and Strings
 * Q1_03.java
 * 
 * Question: 
 * Write a method to replace all spaces in a string with '%20: 
 * You may assume that the string has sufficient space at the 
 * end to hold the additional characters, and that you are given 
 * the "true" length of the string. (Note: If implementing in Java, 
 * please use a character array so that you can perform this 
 * operation in place.)
 * 
 * EXAMPLE
 * Input: "Mr John Smith " J 13 
 * Output: "Mr%20John%20Smith"
 */
package c1_StringQuestions;

public class C1_03 {
	
/**
 * 
 * @param string
 * @param trueLength the number of characters in string without space at the end
 */
	public static void replaceWhiteSpace(String string, int trueLength){
		char[] array = string.toCharArray();
		int whiteLength= array.length;
		int offset = whiteLength-trueLength;
		//need separate counter from i as this grows faster when there is a white space
		int j=0;
		
		//go through each character and adjust accordingly
		for(int i=0; i<trueLength;i++) {
			//if current letter is not a white space
			if(array[whiteLength-1-offset-j]!=' ') {
				//put letter at end of array and end of array move marker up one (towards beginning of array) 
				array[whiteLength-1-j]=array[whiteLength-1-offset-j];
				j++;
			}else {
				//if current letter is white space
				//fill current end of array with replacement values
				//decrement filler space as we have no put characters into it
				array[whiteLength-1-j++]='0';
				array[whiteLength-1-j++]='2';
				array[whiteLength-1-j++]='%';
				offset-=2;
			}
		}
		System.out.println(array);	
	}
	
	public static void main(String []args ) {		
		replaceWhiteSpace("  h ey      ", 6);
	}

}
