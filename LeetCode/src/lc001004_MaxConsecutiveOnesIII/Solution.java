package lc001004_MaxConsecutiveOnesIII;

public class Solution {

	public Solution() {}

	public int longestOnes(int[] nums, int k) {
		//思路：right持續往右走，當遇到0就翻轉並記錄數量，當zeroCount==k的時候，就代表length最長了，此時比較並做記錄，接著將right、left同時向右移動
		int left=0, right, maxLength=0, zeroCount=0;
		for(right=0; right<nums.length; right++) {
			if(nums[right]==0) {zeroCount++;}
			if(zeroCount>k) {
				if(nums[left]==0) {zeroCount--;}
				left++;
			}
			if(zeroCount<=k) {maxLength=Math.max(right-left+1, maxLength);}
		}
		return maxLength;
	}

	public int longestOnes2(int[] nums, int k) {
		//思路：因為要return的是"最大窗口大小"，所以只要維持left、right最大距離即可
		int left=0, right;
		for(right=0; right<nums.length; ++right) {
			if(nums[right]==0) {k--;}
			if(k<0 && nums[left++]==0) {k++;}
		}
		return right-left;
	}

	public int longestOnes3(int[] nums, int k) {
		//思路：前一個解法的另一種寫法，使用for each的num當作right pointer，因為right永遠向右走
		int left=0;
		for(int num : nums) {
			k-=1-num;
			if(k<0) {k+=1-nums[left++];}
		}
		return nums.length-left;
	}

}
