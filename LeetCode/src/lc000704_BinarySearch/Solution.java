package lc000704_BinarySearch;

public class Solution {

	public Solution() {}

	public int search(int[] nums, int target) {
		//1 <= nums.length <= 104
		//-10^4 < nums[i], target < 10^4
		//All the integers in nums are unique.
		//nums is sorted in ascending order.
		int result=-1;
		int startPointer=0, endPointer=nums.length-1;
		while(startPointer<=endPointer) {
			int currentPointer=(startPointer+endPointer)/2;
			if(nums[currentPointer]<target) {
				startPointer=currentPointer+1;
			}else if(nums[currentPointer]>target) {
				endPointer=currentPointer-1;
			}else {
				result=currentPointer;
				break;
			}
		}
		return result;
	}

	public int search2(int[] nums, int target) {
		int result=-1;
		int startPointer=0, endPointer=nums.length-1;
		while(startPointer<=endPointer) {
			int currentPointer=(startPointer+endPointer)/2;
			if(nums[currentPointer]==target) {
				result=currentPointer;
				break;
			}
			if(nums[currentPointer]<target) {
				startPointer=currentPointer+1;
			}else {
				endPointer=currentPointer-1;
			}
		}
		return result;
	}

}
