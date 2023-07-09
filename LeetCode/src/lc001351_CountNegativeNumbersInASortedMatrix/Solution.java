package lc001351_CountNegativeNumbersInASortedMatrix;

public class Solution {

	public Solution() {}

	 public int countNegatives(int[][] grid) {
		 //想嘗試平行處理
		 //參考：https://hackmd.io/@aaronlife/java-topic-parallelism-concurrency
		 //不過題目給定的matrix為行列均為降冪排列，所以只要列(row)開頭為負數，則整個列都是負數
		int result = 0;
		final int m = grid.length;	//rows
		final int n = grid[0].length;	//columns
		int i = m - 1;
		int j = 0;

		while (i >= 0 && j < n) {
			if (grid[i][j] < 0) {
				result += n - j;
				--i;
			} else {
				++j;
			}
		}
		return result;
	}

}
