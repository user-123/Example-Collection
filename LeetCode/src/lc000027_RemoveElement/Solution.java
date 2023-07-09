package lc000027_RemoveElement;

public class Solution {

	public Solution() {}

	public int removeElement(int[] nums, int val) {
		int checkPointer = 0, grabPointer = nums.length-1, count = 0;
		while(checkPointer<=grabPointer) {
			if(nums[checkPointer]==val) {
				/*
				while(nums[grabPointer]==val) {
					grabPointer--;
				}
				nums[checkPointer]=nums[grabPointer];
				count++;
				grabPointer--;
				*/
				if(nums[grabPointer]!=val) {
					nums[checkPointer]=nums[grabPointer];
					count++;
					checkPointer++;
				}
				grabPointer--;
			}else {
				count++;
				checkPointer++;
			}
		}


		return count;
	}

}
