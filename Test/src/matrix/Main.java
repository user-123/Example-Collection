package matrix;

import java.util.Arrays;

public class Main {

	public Main() {}

	public static void main(String[] args) {
		//生成row*col matrix
		int row=5, col=8;
		int[][] matrix = new int[row][col];
		System.out.println();
		for(int[] column : matrix) {
			System.out.println(Arrays.toString(column));
		}
		for(int[] column : matrix) {
			Arrays.fill(column, -1);
		}
		for(int[] column : matrix) {
			System.out.println(Arrays.toString(column));
		}
	}

}
