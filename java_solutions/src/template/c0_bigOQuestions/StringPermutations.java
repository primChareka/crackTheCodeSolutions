package template.c0_bigOQuestions;

import java.util.Scanner;

public class StringPermutations {
	
	
	static void permutation(String str) {
		Scanner scan = new Scanner(System.in);
		scan.next();
		System.out.println("in permutation(str) for value " + str);
		permutation(str, "");
		scan.close();
	}
	
	static void permutation(String str, String prefix) {
		Scanner scan = new Scanner(System.in);
		scan.next();
		System.out.println("in permutation(str, str) for values (" + str + ") and (" +prefix+")");
		if(str.length() == 0) {
			System.out.println(prefix);
		}else {
			for(int i=0; i<str.length(); i++) {
				String rem = str.substring(0,i) + str.substring(i+1);
				System.out.println("i is:" +i +"rem is made up of: "+str.substring(0,i) +" and "+ str.substring(i+1));
				permutation(rem, prefix+str.charAt(i));
			}
		}
		
	}

	public static void main(String[] args) {
		StringPermutations.permutation("HAT");

	}

}
