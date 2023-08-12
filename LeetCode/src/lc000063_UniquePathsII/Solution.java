package lc000063_UniquePathsII;

public class Solution {

	public Solution() {}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		//思路：到任一個點的方法，為該點的top和left的方法數相加
		if(obstacleGrid[0][0]==1) {return 0;}
		int m=obstacleGrid.length, n=obstacleGrid[0].length;
		int[][] pathGrid = new int[m][n];
		for(int i=0; i<m; i++) {
			if(obstacleGrid[i][0]==1) {break;}
			pathGrid[i][0]=1;
		}
		for(int j=0; j<n; j++) {
			if(obstacleGrid[0][j]==1) {break;}
			pathGrid[0][j]=1;
		}
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				if(obstacleGrid[i][j]==1) {continue;}
				pathGrid[i][j]=pathGrid[i-1][j]+pathGrid[i][j-1];
			}
		}
		return pathGrid[m-1][n-1];
	}

	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		//思路：前一方法的空間優化，處理路徑時是一個row一個row(或一個col一個col)進行，所以完全可以將資料存成array，而不需要使用matrix
		if(obstacleGrid[0][0]==1) {return 0;}
		int m=obstacleGrid.length, n=obstacleGrid[0].length;
		int[] pathGrid = new int[n];
		pathGrid[0]=1;
		for(int[] row : obstacleGrid) {
			for(int j=0; j<n; j++) {
				if(row[j]==1) {pathGrid[j]=0;continue;}
				if(j==0) {continue;}
				pathGrid[j]+=pathGrid[j-1];
			}
		}
		return pathGrid[n-1];
	}

}
