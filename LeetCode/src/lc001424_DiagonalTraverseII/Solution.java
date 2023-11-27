package lc001424_DiagonalTraverseII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public Solution() {}

	public int[] findDiagonalOrder(List<List<Integer>> nums) {
		//思路：				//Time Limit Exceeded
		int resultLength=0, width=0, height=nums.size(), index=0;
		for(List<Integer> numArray : nums) {
			int numArrayLength=numArray.size();
			resultLength+=numArrayLength;
			width = numArrayLength>width ? numArrayLength : width;
		}
		int[] result = new int[resultLength];
		for(int i=0; i<height+width-1; i++) {
			for(int j=Math.min(i, height-1); j>=0; j--) {
				if(i-j>=nums.get(j).size()) {continue;}
				result[index++]=nums.get(j).get(i-j);
			}
		}
		return result;
	}

	public int[] findDiagonalOrder2(List<List<Integer>> nums) {
		int count = 0;
		List<List<Integer>> lists = new ArrayList<>();
		for(int i=0; i<nums.size(); i++) {
			List<Integer> row = nums.get(i);
			for(int j=0; j<row.size(); j++) {
				int index=i+j;
				if(lists.size()<index+1) {lists.add(new ArrayList<>());}
				lists.get(index).add(row.get(j));
				count++;
			}
		}
		int[] result = new int[count];
		int index=0;
		for(List<Integer> list : lists) {
			for(int i=list.size()-1; i>=0; i--) {
				result[index++]=list.get(i);
			}
		}
		return result;
	}

}
