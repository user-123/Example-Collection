package lc000896_MonotonicArray;

public class Solution {

	public Solution() {}

	public boolean isMonotonic(int[] nums) {
		boolean isIncreasing = nums[0]<=nums[nums.length-1], isDecreasing = nums[0]>=nums[nums.length-1];
		for(int i=1; i<nums.length; i++) {
			isIncreasing&=nums[i-1]<=nums[i];
			isDecreasing&=nums[i-1]>=nums[i];
		}
		return isIncreasing||isDecreasing;
	}

	public boolean isMonotonic2(int[] nums) {
		int i=1;
		while(i<nums.length-1 && nums[i-1]==nums[i]) {
			i++;
		}
		if(i==nums.length-1 || nums.length==1 || nums.length==0) {return true;}
		boolean isIncreasing = nums[i-1]<nums[i];
		for(i=i; i<nums.length; i++) {
			if(isIncreasing && nums[i-1]>nums[i] || !isIncreasing && nums[i-1]<nums[i]) {return false;}
		}
		return true;
	}

	public boolean isMonotonic22(int[] nums) {
		int i=1;
		while(i<nums.length-1 && nums[i-1]==nums[i]) {
			i++;
		}
		//if(i==nums.length-1 || nums.length==1 || nums.length==0) {return true;}
		boolean isIncreasing = i<nums.length && nums[i-1]<nums[i];
		for(i=i; i<nums.length; i++) {
			if(isIncreasing && nums[i-1]>nums[i] || !isIncreasing && nums[i-1]<nums[i]) {return false;}
		}
		return true;
	}

	public boolean isMonotonic3(int[] nums) {
		boolean isIncreasing = nums[0]<nums[nums.length-1];
		if(isIncreasing==true) {
			for(int i=1; i<nums.length; i++) {
				if(nums[i-1]>nums[i]) {return false;}
			}
		}else {
			for(int i=1; i<nums.length; i++) {
				if(nums[i-1]<nums[i]) {return false;}
			}
		}
		return true;
	}
}
