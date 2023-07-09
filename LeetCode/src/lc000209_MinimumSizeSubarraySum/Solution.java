package lc000209_MinimumSizeSubarraySum;

public class Solution {

	public Solution() {}

	public int minSubArrayLen(int target, int[] nums) {
		if(nums==null || nums.length==0) {return 0;}
		int slowPointer=0, fastPointer=0, sum=0, minLength=Integer.MAX_VALUE;
		while(fastPointer<nums.length) {
			sum+=nums[fastPointer++];
			while (sum>=target) {
				minLength=Math.min(fastPointer-slowPointer, minLength);
				sum-=nums[slowPointer++];
			}
		}
		return minLength==Integer.MAX_VALUE ? 0 :minLength;
	}

}
