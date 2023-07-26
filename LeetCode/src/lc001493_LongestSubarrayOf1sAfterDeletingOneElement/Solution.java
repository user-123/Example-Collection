package lc001493_LongestSubarrayOf1sAfterDeletingOneElement;

public class Solution {

	public Solution() {}

	//思路：與1004. Max Consecutive Ones III思路相同

	public int longestSubarray(int[] nums) {
		//思路：因為要return的是"最大窗口大小-1"，所以只要維持left、right最大距離即可
		int zeroCount=0, left=0, right;
		for(right=0; right<nums.length; right++) {
			if(nums[right]==0) {zeroCount++;}
			if(zeroCount>1 && nums[left++]==0) {zeroCount--;}
		}
		return right-left-1;	//一定會去掉一個element
	}

	public int longestSubarray2(int[] nums) {
		//思路：right持續往右走，當遇到0就跳過並記錄數量，當zeroCount==1的時候，就代表length最長了，此時比較並做記錄，接著將right、left同時向右移動
		int left=0, right, maxLength=0, zeroCount=0;
		for(right=0; right<nums.length; right++) {
			if(nums[right]==0) {zeroCount++;}
			if(zeroCount>1) {
				if(nums[left]==0) {zeroCount--;}
				left++;
			}
			if(zeroCount<=1) {maxLength=Math.max(right-left+1, maxLength);}
			//if(zeroCount<=1) {maxLength=Math.max(right-left+1-1, maxLength);}	//一定會去掉一個element
		}
		return maxLength-1;	//一定會去掉一個element
		//return maxLength;
	}

}
