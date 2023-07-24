package lc000153_FindMinimumInRotatedSortedArray;

public class Solution {

	public Solution() {}

	public int findMin(int[] nums) {
		//思路：使用類似 33. Search in Rotated Sorted Array 的邏輯
		//找到最小的element，其index k與第一項的index(index 0)的差值(即k)即為rotate的次數
		int left=0, right=nums.length-1, start=-1;
		while(left<=right) {
			int mid=left+(right-left)/2;
			if(left==right) {start=mid;break;}	//如果是要求rotate幾次，則要多加判斷，如果k=0時rotate次數為nums.length，其餘start index即為rotate次數
			if(nums[right]<nums[mid]) {left=mid+1;continue;}
			if(nums[left]>=nums[mid]) {right=mid;continue;}
			if(nums[left]<nums[mid] || nums[right]>=nums[mid]) {
				if(nums[left]<nums[right]) {
					right=mid;
				}else {
					left=mid+1;
				}
			}
		}
		return nums[start];
	}

}
