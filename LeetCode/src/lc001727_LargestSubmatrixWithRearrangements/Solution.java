package lc001727_LargestSubmatrixWithRearrangements;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public int largestSubmatrix(int[][] matrix) {
		int rows=matrix.length, columns=matrix[0].length;
		for(int i=1; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				matrix[i][j] += matrix[i][j]==1 ? matrix[i-1][j] : 0;
			}
		}
		int maxArea=0;
		for(int i=0; i<rows; i++) {
			Arrays.sort(matrix[i]);
			for(int j=0; j<columns; j++) {
				int area=matrix[i][j]*(columns-j);
				maxArea = area>maxArea ? area : maxArea;
			}
		}
		return maxArea;
	}

}
