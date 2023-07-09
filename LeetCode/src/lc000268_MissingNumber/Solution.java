package lc000268_MissingNumber;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public int missingNumber(int[] nums) {
		Arrays.sort(nums);
		for(int i=0; i<nums.length; i++) {	//可以進階為二分搜尋
			if(nums[i]!=i) {return i;}
		}
		return nums.length;
	}

	public int missingNumber2(int[] nums) {
		int total = (0+nums.length)*(nums.length+1)/2, sum = 0;
		for(int num : nums) {
			sum+=num;
		}
		return total-sum;
	}

}
