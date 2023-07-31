package lc000724_FindPivotIndex;

public class Solution {

	public Solution() {}

	public int pivotIndex(int[] nums) {
		//思路：pivot左右的sum必須相等，所以leftSum*2==rightSum*2==totalSum-pivot
		int leftSum=0, totalSum=0;
		for(int num : nums) {
			totalSum+=num;
		}
		for(int i=0; i<nums.length; i++) {
			if(leftSum*2==totalSum-nums[i]) {return i;}
			leftSum+=nums[i];
		}
		return -1;
	}

}
