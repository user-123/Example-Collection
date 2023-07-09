package lc000137_SingleNumberII;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public int singleNumber(int[] nums) {
		Arrays.sort(nums);
		for(int i=0; i<nums.length/3*3; i=i+3) {
			if(nums[i]!=nums[i+1] || nums[i]!=nums[i+2]) {
				if(nums[i]==nums[i+1]) {
					return nums[i+2];
				}else if(nums[i]==nums[i+2]) {
					return nums[i+1];
				}else if(nums[i+1]==nums[i+2]) {
					return nums[i];
				}
			}
		}
		return nums[nums.length-1];
	}

	public int singleNumber2(int[] nums) {
		//待完成
		//思路：不知是否可以利用136. Single Number的類似邏輯完成
		//思路2：或是利用位元運算，再想想
		return 0;
	}

	public int singleNumberˇ(int[] nums) {
		//待完成
		//Bitwise operations
		//參考1：https://leetcode.com/problems/single-number-ii/solutions/3527570/mastering-bitwise-operations-a-guide-to-boost-your-interview-preparation/
		//參考2：https://leetcode.com/problems/single-number-ii/solutions/43294/challenge-me-thx/comments/42094
		//參考3：https://leetcode.com/problems/single-number-ii/solutions/43295/detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers/
		return 0;
	}
}
