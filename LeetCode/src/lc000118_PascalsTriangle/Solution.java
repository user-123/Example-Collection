package lc000118_PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public Solution() {}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> pascalsTriangle = new ArrayList<>(numRows);
		int row=1;
		while(row<=numRows) {
			List<Integer> rowNums = new ArrayList<>(row);
			if(row==1) {rowNums.add(1);pascalsTriangle.add(rowNums);row++;continue;}
			if(row==2) {rowNums.add(1);rowNums.add(1);pascalsTriangle.add(rowNums);row++;continue;}
			rowNums.add(1);
			for(int i=1; i<row-1; i++) {
				rowNums.add(pascalsTriangle.get(row-1-1).get(i-1)+pascalsTriangle.get(row-1-1).get(i));
			}
			rowNums.add(1);
			pascalsTriangle.add(rowNums);
			row++;
		}
		return pascalsTriangle;
	}

}
