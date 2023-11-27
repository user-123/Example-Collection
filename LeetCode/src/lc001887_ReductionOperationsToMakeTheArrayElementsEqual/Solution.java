package lc001887_ReductionOperationsToMakeTheArrayElementsEqual;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public int reductionOperations(int[] nums) {
		//思路：依照題意就是將所有數字逐步減小到與最小數字一樣；所以先將所有數字排序，每次都將最大經"操作"後減到與次大一樣大，重複直到所有數都一樣大，每次"操作"數就是所有大於當下"次大"的數(當下的最大)的數量
		Arrays.sort(nums);
		int length=nums.length, pointer=length-1, operationCount=0;
		while(pointer>0) {
			operationCount += nums[pointer-1]!=nums[pointer] ? length-pointer : 0;
			pointer--;
		}
		return operationCount;
	}

}
