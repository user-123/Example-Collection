package lc000075_SortColors;

public class Solution {

	public Solution() {}

	public void sortColors(int[] nums) {
		//思路：Dutch national flag problem(DNF) (荷蘭國旗問題)
		int index=0, start=0, end=nums.length-1;
		while(index<=end) {
			if(nums[index]==0) {swapColor(nums, start++, index++);continue;}
			if(nums[index]==2) {swapColor(nums, end--, index);continue;}
			index++;
		}
		return;
	}

	private void swapColor(int[] nums, int left, int right) {
		int temp=nums[left];
		nums[left]=nums[right];
		nums[right]=temp;
	}

}
