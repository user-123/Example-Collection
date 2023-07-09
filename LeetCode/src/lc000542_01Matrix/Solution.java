package lc000542_01Matrix;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public int[][] updateMatrix(int[][] mat) {
		int[][] result = new int[mat.length][mat[0].length];
		final int maxDistance=mat.length-1+mat[0].length-1;	//constant
		for(int row=0; row<mat.length; row++) {
			for(int col=0; col<mat[0].length; col++) {
				if(mat[row][col]==0) {result[row][col]=0;continue;}
				int up = row>0 ? result[row-1][col] : maxDistance, left = col>0 ? result[row][col-1] : maxDistance;
				result[row][col]=Math.min(up, left)+1;
			}
		}

		for(int row=mat.length-1; row>=0; row--) {
			for(int col=mat[0].length-1; col>=0; col--) {
				if(result[row][col]==0) {continue;}
				int down = row<mat.length-1 ? result[row+1][col] : maxDistance, right = col<mat[0].length-1 ? result[row][col+1] : maxDistance;
				result[row][col] = Math.min(result[row][col], Math.min(down, right)+1);
			}
		}

		return result;
	}

	public int[][] updateMatrix2(int[][] mat) {
		//有問題，需修改
		int[][] result = new int[mat.length][mat[0].length];
		for(int[] array : result) {
			Arrays.fill(array, -1);
		}
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[0].length; j++) {
				if(mat[i][j]==0) {result[i][j]=0;continue;}
				if(i==0 && j==0) {continue;}
				if(i==0) {
					result[i][j] = result[i][j-1]==-1 ? -1 : result[i][j-1]+1;
					continue;
				}
				if(j==0) {
					result[i][j] = result[i-1][j]==-1 ? -1 : result[i-1][j]+1;
					continue;
				}
				if(mat[i-1][j]==-1 || mat[i][j-1]==-1) {continue;}
				result[i][j]=Math.min(mat[i-1][j], mat[i][j-1])+1;
			}

		}

		for(int i=mat.length-1; i>=0; i--) {
			for(int j=mat[0].length-1; j>=0; j--) {
				if(result[i][j]==0) {continue;}
				if(i==mat.length-1 && j==mat[0].length-1) {continue;}
				if(i==mat.length-1) {
					result[i][j] = result[i][j]==-1 ? result[i][j+1]+1 : Math.min(result[i][j], result[i][j+1]+1);
					continue;
				}
				if(j==mat[0].length-1) {
					result[i][j] = result[i][j]==-1 ? result[i+1][j]+1 : Math.min(result[i][j], result[i+1][j]+1);
					continue;
				}
				result[i][j] = result[i][j]==-1 ? Math.min(mat[i+1][j], mat[i][j+1])+1 : Math.min(result[i][j], Math.min(mat[i+1][j], mat[i][j+1])+1);
			}

		}

		return result;
	}

	private int findNearbyZero(int up, int down, int left, int right) {
		return up!=-1 && down !=-1 && left!=-1 && right!=-1 ? Math.min(Math.min(up, down), Math.min(left, right)) : -1 ;
	}
}
