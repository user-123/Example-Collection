package lc000215_KthLargestElementInAnArray;

import java.util.Arrays;

public class SolutionCheck {

	public SolutionCheck() {}

	public static int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length-(k-1)-1];
	}

}
