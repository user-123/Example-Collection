package lc000905_SortArrayByParity;

public class Solution {

	public Solution() {}

	public int[] sortArrayByParity(int[] nums) {
		//思路：in place
		int left=0, right=nums.length-1;
		while(left<right) {
			while(left<=nums.length-1 && nums[left]%2==0) {left++;}
			while(right>=0 && nums[right]%2==1) {right--;}
			if(left<right) {
				int temp=nums[left];
				nums[left]=nums[right];
				nums[right]=temp;
			}
		}
		return nums;
	}

	public int[] sortArrayByParity2(int[] nums) {
		//思路：產生新array
		int[] result = new int[nums.length];
		int left=0, right=nums.length-1;
		for(int num : nums) {
			result[num%2==0 ? left++ : right--]=num;
		}
		return result;
	}

}
