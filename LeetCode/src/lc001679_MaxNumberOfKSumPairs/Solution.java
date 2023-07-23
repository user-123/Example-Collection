package lc001679_MaxNumberOfKSumPairs;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public int maxOperations(int[] nums, int k) {
		//思路：array排序後，使用雙指針
		Arrays.sort(nums);
		int count=0, left=0, right=nums.length-1;
		while(left<right) {
			if(nums[left]+nums[right]==k) {
				count++;
				left++;
				right--;
				continue;
			}
			if(nums[left]+nums[right]>k) {
				right--;
				continue;
			}
			if(nums[left]+nums[right]<k) {
				left++;
				continue;
			}
		}
		return count;
	}

	public int maxOperations2(int[] nums, int k) {
		//思路：array不排序，直接使用hashMap記錄
		//待完成
		int count=0;


		return count;
	}

}
