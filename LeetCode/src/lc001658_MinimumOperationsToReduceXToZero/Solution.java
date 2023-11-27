package lc001658_MinimumOperationsToReduceXToZero;

public class Solution {

	public Solution() {}

	public int minOperations(int[] nums, int x) {
		//思路：將題目的目標(從左右兩側取最少的數字組出x)反過來想，就是用sliding window取總合為numsSum-x的subArray，計算去掉subArray的array長度，代表有幾個數字，然後長度取小
		if(nums[0]>x && nums[nums.length-1]>x) {return -1;}
		int sum=0;
		for(int num : nums) {
			sum+=num;
		}
		int target=sum-x, left=0, right, minOperations=Integer.MAX_VALUE;
		for(right=0; right<nums.length; right++) {
			target-=nums[right];
			while(target<0 && left<=right) {target+=nums[left++];}
			if(target==0) {minOperations = (left-0)+(nums.length-1-right)<minOperations ? (left-0)+(nums.length-1-right) : minOperations;}
		}
		return minOperations==Integer.MAX_VALUE ? -1 : minOperations;
	}

}
