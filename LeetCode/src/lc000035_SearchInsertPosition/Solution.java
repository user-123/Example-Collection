package lc000035_SearchInsertPosition;

import java.util.LinkedList;
import java.util.List;

public class Solution {

	public Solution() {}

	public int searchInsert(int[] nums, int target) {
		int left=0, right=nums.length-1, mid=-1;
		while(left<=right) {
			mid=left+(right-left)/2;
			if(nums[mid]==target) {return mid;}
			if(nums[mid]<target) {left=mid+1;continue;}
			right=mid-1;
		}
		return left;
	}

}
