package lc001838_FrequencyOfTheMostFrequentElement;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public int maxFrequency(int[] nums, int k) {
		//思路：sliding window
		int maxCount=1, start=0, end;
		long sum=0;
		Arrays.sort(nums);
		for(end=0; end<nums.length; end++) {
			sum+=nums[end];
			while(sum+k<(long)nums[end]*(end-start+1)) {
				sum-=nums[start++];
			}
			//maxCount=Math.max(maxCount, end-start+1);
			maxCount = end-start+1>maxCount ? end-start+1 : maxCount;
		}
		return maxCount;
	}

	public int maxFrequency2(int[] nums, int k) {
		//思路：
		int start=0, end;
		long sum=k;
		Arrays.sort(nums);
		for(end=0; end<nums.length; end++) {
			sum+=nums[end];
			sum -= sum<(long)nums[end]*(end-start+1) ? nums[start++] : 0;
		}
		return end-start;
	}

}
