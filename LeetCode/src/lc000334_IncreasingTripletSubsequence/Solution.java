package lc000334_IncreasingTripletSubsequence;

public class Solution {

	public Solution() {}

	public boolean increasingTriplet(int[] nums) {
		//思路：用兩個變數存下"局部"最小與次小兩個值，當出現比兩者都大的數時，代表true
		int length=nums.length;
		if(length<3) {return false;}
		int least=Integer.MAX_VALUE, lesser=Integer.MAX_VALUE;
		/*
		for(int i=0; i<length; i++) {
			if(nums[i]<least) {least=nums[i];continue;}
			if(nums[i]<lesser && nums[i]>least) {lesser=nums[i];continue;}
			if(nums[i]>lesser) {return true;}
		}
		*/
		for(int i=0; i<length; i++) {
			if(nums[i]<=least) {least=nums[i];continue;}
			if(nums[i]<lesser) {lesser=nums[i];continue;}
			if(nums[i]>lesser) {return true;}
		}
		return false;
	}

	public boolean increasingTriplet2(int[] nums) {
		//思路：上一個解法的for each版
		if(nums.length<3) {return false;}
		int least=Integer.MAX_VALUE, lesser=Integer.MAX_VALUE;
		/*
		for(int num : nums) {
			if(num<least) {least=num;continue;}
			if(num<lesser && num>least) {lesser=num;continue;}
			if(num>lesser) {return true;}
		}
		*/
		for(int num : nums) {
			if(num<=least) {least=num;continue;}
			if(num<lesser) {lesser=num;continue;}
			if(num>lesser) {return true;}
		}
		return false;
	}

}
