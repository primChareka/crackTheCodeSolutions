package StringQuestions;

import java.util.ArrayList;

public class Q1_02 {

	public static boolean Permutation(String first, String second) {
		
		if(first==null||second==null) {
			return false;
		}else if(first.length()!=second.length()) {
			return false;
		}else {
			
			ArrayList values = new ArrayList<Character>();
			for(char i : first.toCharArray()) {
				values.add(i);
			}
			
			for(char i : second.toCharArray()) {
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
		String first = "Hey";
		String second ="euH";
		System.out.println(Permutation(first,second));

	}

}
