package StringQuestions;

public class Q1_06 {
	
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
