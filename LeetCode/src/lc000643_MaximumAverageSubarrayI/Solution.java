package lc000643_MaximumAverageSubarrayI;

public class Solution {

	public Solution() {}

	public double findMaxAverage(int[] nums, int k) {
		//思路：sliding window
		int start=0, end=k, sum=0, maxSum;
		for(int i=0; i<k; i++) {
			sum+=nums[i];
		}
		maxSum=sum;
		while(end<nums.length) {
			sum=sum-nums[start++]+nums[end++];
			//maxSum=Math.max(sum, maxSum);
			if(sum>maxSum) {maxSum=sum;}
		}
		return (double)maxSum /k;
	}

}
