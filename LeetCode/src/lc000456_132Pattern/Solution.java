package lc000456_132Pattern;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public boolean find132pattern(int[] nums) {
		for(int j=0, min=Integer.MAX_VALUE; j<nums.length; j++) {
			min = nums[j]<min ? nums[j] : min;
			if(min==nums[j]) {continue;}
			for(int k=nums.length-1; k>j; k--) {
				if(min<nums[k] && nums[k]<nums[j]) {return true;}
			}
		}
		return false;
	}

	public boolean find132pattern2(int[] nums) {
		int[] minArray = Arrays.copyOf(nums, nums.length), maxArray = Arrays.copyOf(nums, nums.length);
		for(int i=1; i<nums.length; i++) {
			minArray[i] = nums[i-1]<minArray[i-1] ? nums[i-1] : minArray[i-1];
		}
		/* 這部份邏輯為錯的，需要修改或棄用
		for(int j=1; j<nums.length; j++) {
			maxArray[j] = nums[j-1]>maxArray[j-1] ? nums[j-1] : maxArray[j-1];
		}
		for(int k=0; k<nums.length; k++) {
			if(minArray[k]<nums[k] && nums[k]<maxArray[k]) {return true;}
		}
		*/
		for(int j=nums.length-1, end=nums.length; j>=0; j--) {
			if(nums[j]<=minArray[j]) {continue;}
			while(end<nums.length && maxArray[end]<=minArray[j]) {end++;}
			if(end<nums.length && nums[j]>maxArray[end]) {return true;}
			maxArray[--end]=nums[j];
		}
		return false;
	}

}
