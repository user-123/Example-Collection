package lc000053_MaximumSubarray;

public class Solution {

	public Solution() {}

	public int maxSubArray(int[] nums) {
		//Kadane’s Algorithm
		if(nums==null || nums.length==0) {return 0;}
		//if(nums.length==1) {return nums[0];}
		int pointer=0, sum=0, maxSum=nums[0];
		while(pointer<nums.length) {
			sum+=nums[pointer++];
			maxSum=Math.max(maxSum, sum);
			if(sum<0) {sum=0;}
		}
		return maxSum;
	}

}
