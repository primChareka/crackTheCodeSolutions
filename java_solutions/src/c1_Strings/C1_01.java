package c1_Strings;

import java.util.HashMap;

public class C1_01 {

	public static boolean isUnique(String string) {
		HashMap<Integer, Character> map = new HashMap<Integer, Character>();
		for (Character c : string.toCharArray()) {
			if (map.put(Integer.valueOf(c), c) != null) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String string = "Primose";
		System.out.println(C1_01.isUnique(string));
	}
}
