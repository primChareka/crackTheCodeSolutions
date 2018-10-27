/**Cracking-The-Coding-Interview
 * Chapter 1 - Arrays and Strings
 * Q1_06.java
 */
package c1_StringQuestions;

public class C1_07 {

	public static void Rotate90(int array[][]) {

		printArray(array);
		int temp;
		int n = array.length - 1;
		for (int j = 0; j < 2; j++) {//n-2
			for (int i = j; i-j < n-2*j; i++) {//n-1
						temp = array[j][i]; //(0,0)|(0,1)|(0,2)
/*(0,0)|(0,1)|(0,2)*/	array[j][i] = array[i][n-j]; /*(0,3)|(1,3)|(2,3)*/
/*(0,3)|(1,3)|(2,3)*/	array[i][n-j] = array[n-j][n - i]; /*(3,3)|(3,2)|(3,1)*/
/*(3,3)|(3,2)|(3,1)*/	array[n-j][n - i] = array[n-i][j]; /*(3,0)|(3,1)|(3,2)*/
				array[n-i][j] = temp;
			}
		}
		printArray(array);
	}

	public static void main(String[] args) {
		int[][] array = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		Rotate90(array);
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
	}
}
