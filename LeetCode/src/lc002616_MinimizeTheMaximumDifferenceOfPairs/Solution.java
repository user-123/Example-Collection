package lc002616_MinimizeTheMaximumDifferenceOfPairs;

import java.util.Arrays;

public class Solution {
	//題意：在盡量讓differenc小的同時，滿足在這個條件下還能從array中找出符合條件的p對組合，求最小的differenc

	public Solution() {}

	public int minimizeMax(int[] nums, int p) {
		//思路：將nums排序後，永遠貪心的選擇相鄰或相近的兩個數作為組合，因為這樣能保證所有的組合差值都是盡量小的，且能在條件下滿足越多對pair
		//參考：https://www.youtube.com/watch?v=90Fyca_wwe8
		Arrays.sort(nums);
		int minDiff=0, maxDiff=nums[nums.length-1]-nums[0];
		while(minDiff<maxDiff) {
			int midDiff=minDiff+(maxDiff-minDiff)/2;
			if(isEnoughPairs(nums, p, midDiff)) {
				maxDiff=midDiff;
			}else {
				minDiff=midDiff+1;
			}
		}
		return minDiff;
	}

	public boolean isEnoughPairs(int[] nums, int targetPairs, int differenceMaximum) {
		int count=0;
		/*
		for(int i=0; i<nums.length; i++) {
			if(i+1<nums.length && nums[i+1]-nums[i]<=differenceMaximum) {count++;i++;}
		}
		*/
		for(int i=1; i<nums.length; i++) {
			if(nums[i]-nums[i-1]<=differenceMaximum) {count++;i++;}
		}
		return count>=targetPairs;
	}

	public int minimizeMax49(int[] nums, int p) {
		//思路：此算法與題意不符，若要符合必須窮舉所有difference，並分組求取，複雜度大幅提升，可能會LTE
		//待思考，待完成
		if(p==0) {return -1;}
		Arrays.sort(nums);
		/*
		int[] result = new int[nums.length/2];
		for(int i=1; i<nums.length; i+=2) {
			result[i/2]=nums[i]-nums[i-1];
		}
		 */
		int[] result = new int[nums.length-1];
		for(int i=1; i<nums.length; i++) {
			result[i-1]=nums[i]-nums[i-1];
		}
		Arrays.sort(result);
		return result[p-1];
	}

}
