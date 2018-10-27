package c1_StringQuestions;

public class C1_08 {
	public static void setToZero(int[][] array) {

		for(int i =0;i<array.length;i++) {
			for(int j = 0; j<array[i].length;j++) {
				if(array[i][j]==0) {
					array[i]=new int[(array.length)];
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		int[][] array = new int[][] { { 1, 0, 3, 4 }, { 5, 6, 7, 8 }, { 0, 10, 11, 12 }, { 13, 14, 15, 16 } };
		setToZero(array);
		printArray(array);
	}
	

	public static void printArray(int array[][]) {
		System.out.println("============= Array =============");
		for (int i = 0; i < array.length; i++) {
			System.out.print("|  ");
			for (int j = 0; j < array.length; j++) {
				System.out.print("  " + array[i][j] + "\t|");
			}
			System.out.println();
		}	
		System.out.println("=================================");
	}
	
	public static void printArray(int array[]) {
		System.out.println("============= Array =============");
			System.out.print("|  ");
			for (int j = 0; j < array.length; j++) {
				System.out.print("  " + array[j] + "\t|");
			}
			System.out.println();
		System.out.println("=================================");
	}

}
