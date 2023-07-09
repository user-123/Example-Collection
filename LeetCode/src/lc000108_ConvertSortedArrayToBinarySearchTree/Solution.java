package lc000108_ConvertSortedArrayToBinarySearchTree;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length-1);
	}

	private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
		if(start>end) {return null;}
		int midPointer = start+(end-start)/2;
		TreeNode node = new TreeNode(nums[midPointer]);
		node.left = sortedArrayToBST(nums, start, midPointer-1);
		node.right = sortedArrayToBST(nums, midPointer+1, end);
		return node;
	}

	public TreeNode sortedArrayToBST2(int[] nums) {
		if(nums.length==3) {return new TreeNode(nums[1], new TreeNode(nums[0]), new TreeNode(nums[2]));}
		if(nums.length==2) {return new TreeNode(nums[1], new TreeNode(nums[0]), null);}
		if(nums.length==1) {return new TreeNode(nums[0]);}
		if(nums.length==0) {return null;}
		int midPointer = (nums.length-1+1)/2;
		TreeNode result = new TreeNode(nums[midPointer]);
		result.left = sortedArrayToBST2(Arrays.copyOfRange(nums, 0, midPointer));
		result.right = sortedArrayToBST2(Arrays.copyOfRange(nums, midPointer+1, nums.length));
		return result;
	}

}
