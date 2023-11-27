package lc001877_MinimizeMaximumPairSumInArray;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public int minPairSum(int[] nums) {
		//思路：要讓sum的max最小化，就盡量把最大和最小的num加在一起
		Arrays.sort(nums);
		int n=nums.length, maxSum=0;
		for(int i=0; i<n/2; i++) {
			maxSum = nums[i]+nums[n-1-i]>maxSum ? nums[i]+nums[n-1-i] : maxSum;
		}
		return maxSum;
	}

}
