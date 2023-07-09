package lc000080_RemoveDuplicatesFromSortedArrayII;

public class Solution {

	public Solution() {}

	public int removeDuplicates(int[] nums) {
		if(nums.length==1) {return 1;}
		int checkPointer = 0, putPointer = 0, count = 1;
		for(checkPointer=1; checkPointer<nums.length; checkPointer++) {
			if(nums[checkPointer]==nums[putPointer]) {
				if(count==2) {
					continue;
				}
				nums[putPointer+1]=nums[checkPointer];
				count++;
			}else {
				nums[putPointer+=count]=nums[checkPointer];
				count=1;
			}
		}
		return putPointer+=count;
	}

	public int removeDuplicates2(int[] nums) {
		if(nums.length==1) {return 1;}
		int checkPointer = 0, putPointer = 0, count = 1;
		for(checkPointer=1; checkPointer<nums.length; checkPointer++) {
			if(nums[checkPointer]==nums[putPointer]) {
				if(count==1) {
					nums[putPointer+1]=nums[checkPointer];
					count++;
				}
			}else {
				nums[putPointer+=count]=nums[checkPointer];
				count=1;
			}
		}
		return putPointer+=count;
	}

	public int removeDuplicates3(int[] nums) {
		if(nums.length==1) {return 1;}
		int putPointer = 0, count = 1;
		for(int checkPointer=1; checkPointer<nums.length; checkPointer++) {
			if(nums[checkPointer]==nums[putPointer]) {
				if(count==1) {
					nums[putPointer+1]=nums[checkPointer];
					count++;
				}
			}else {
				nums[putPointer+=count]=nums[checkPointer];
				count=1;
			}
		}
		return putPointer+=count;
	}

}
