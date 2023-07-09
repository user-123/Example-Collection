package lc000977_SquaresOfASortedArray;

public class Solution {

	public Solution() {}

	public int[] sortedSquares(int[] nums) {
		int[] result = new int[nums.length];
		int left = 0, right = nums.length-1, insert = result.length-1;
		while(left<=right) {
			if(nums[left]*nums[left]>nums[right]*nums[right]) {
				result[insert] = nums[left]*nums[left];
				left++;
			}else {
				result[insert] = nums[right]*nums[right];
				right--;
			}
			insert--;
		}
		return result;
	}

}
