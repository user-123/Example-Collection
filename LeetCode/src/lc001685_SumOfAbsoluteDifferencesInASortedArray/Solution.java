package lc001685_SumOfAbsoluteDifferencesInASortedArray;

public class Solution {

	public Solution() {}

	public int[] getSumAbsoluteDifferences(int[] nums) {
		//思路：在nums[i]-nums[n](n>i)的運算取絕對值都會正負反轉，nums[i]-nums[m](m<i)的則不會，可以分開計算
		int n=nums.length, prefixSum=0, suffixSum=0;
		int[] result = new int[n];
		for(int num : nums) {
			suffixSum+=num;
		}
		for(int i=0; i<n; i++) {
			result[i]=nums[i]*i-prefixSum+suffixSum-nums[i]*(n-i);
			prefixSum+=nums[i];
			suffixSum-=nums[i];
		}
		return result;
	}

}
