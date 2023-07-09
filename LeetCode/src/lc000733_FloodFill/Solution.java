package lc000733_FloodFill;

public class Solution {

	public Solution() {}

	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		return fill(image, sr, sc, color, image[sr][sc]);
	}

	private int[][] fill(int[][] image, int row, int column, int color, int initColor) {
		if(row>=0 && row<image.length && column>=0 && column<image[row].length) {
			if(image[row][column]==color || image[row][column]!=initColor) {return image;}
			image[row][column]=color;
			fill(image, row-1, column, color, initColor);
			fill(image, row+1, column, color, initColor);
			fill(image, row, column-1, color, initColor);
			fill(image, row, column+1, color, initColor);
		}
		return image;
	}

}
