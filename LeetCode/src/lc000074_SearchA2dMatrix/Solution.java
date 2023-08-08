package lc000074_SearchA2dMatrix;

public class Solution {

	public Solution() {}

	public boolean searchMatrix(int[][] matrix, int target) {
		//思路：兩段binary search，先定位到row再定位column；指針移動方式的設計為XXXXXXXXXX
		int m=matrix.length, n=matrix[0].length;
		int row_up=0, row_down=m-1, col_left=0, col_right=n-1;
		while(row_up<row_down) {
			int row_mid=row_up+(row_down-row_up+1)/2;
			if(matrix[row_mid][0]>target) {
				row_down=row_mid-1;
			}else {
				row_up=row_mid;
			}
		}
		int targetRow=row_up;	//targetRow=row_down
		while(col_left<col_right) {
			int col_mid=col_left+(col_right-col_left+1)/2;
			//if(matrix[targetRow][col_mid]==target) {return true;}
			if(matrix[targetRow][col_mid]>target) {
				col_right=col_mid-1;
			}else {
				col_left=col_mid;
			}
		}
		int targetCol=col_left;	//targetCol=col_right
		return matrix[targetRow][targetCol]==target;
	}

	public boolean searchMatrix2(int[][] matrix, int target) {
		//思路：將整個matrix攤開，化為array，等於直接對線性數列做BST
		//待完成
		int m=matrix.length, n=matrix[0].length;
		//TODO
		return false;
	}

}
