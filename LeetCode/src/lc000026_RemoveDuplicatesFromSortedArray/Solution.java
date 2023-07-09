package lc000026_RemoveDuplicatesFromSortedArray;

public class Solution {

	public Solution() {}

	public int removeDuplicates(int[] nums) {
		int checkPointer = 0, putPointer = 0, count = 0;
		for(checkPointer=0; checkPointer<nums.length; checkPointer++) {
			if(nums[checkPointer]==nums[putPointer]) {
				nums[putPointer]=nums[checkPointer];
			}else {
				nums[++putPointer]=nums[checkPointer];
				count++;
			}
		}
		return count;
	}

	public int removeDuplicates2(int[] nums) {
		int putPointer = 0;
		for(int checkPointer=0; checkPointer<nums.length; checkPointer++) {
			if(nums[checkPointer]==nums[putPointer]) {
				nums[putPointer]=nums[checkPointer];
			}else {
				nums[++putPointer]=nums[checkPointer];
			}
		}
		return ++putPointer;
	}

	public int removeDuplicates3(int[] nums) {
		int putPointer = 0;
		for(int checkPointer=0; checkPointer<nums.length; checkPointer++) {
			if(nums[checkPointer]!=nums[putPointer]) {
				nums[++putPointer]=nums[checkPointer];
			}
		}
		return ++putPointer;
	}

}
