package lc000034_FindFirstAndLastPositionOfElementInSortedArray;

public class Solution {

	public Solution() {}

	public int[] searchRange(int[] nums, int target) {
		return new int[] {findFirst(nums, target), findLast(nums, target)};
	}

	private int findFirst(int[] nums, int target) {
		int index=-1, start=0, end=nums.length-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			/*
			if(nums[mid]>=target) {
				end=mid-1;
			}else {
				start=mid+1;
			}
			if(nums[mid]==target) {index=mid;}
			*/
			if(nums[mid]==target) {index=mid;}
			if(nums[mid]>=target) {end=mid-1;continue;}
			start=mid+1;
		}
		return index;
	}

	private int findLast(int[] nums, int target) {
		int index=-1, start=0, end=nums.length-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			/*
			if(nums[mid]<=target) {
				start=mid+1;
			}else {
				end=mid-1;
			}
			if(nums[mid]==target) {index=mid;}
			*/
			if(nums[mid]==target) {index=mid;}
			if(nums[mid]<=target) {start=mid+1;continue;}
			end=mid-1;
		}
		return index;
	}

}
