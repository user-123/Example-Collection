package lc002265_CountNodesEqualToAverageOfSubtree;

public class Solution {
	private int result;

	public Solution() {
		result=0;
	}

	public int averageOfSubtree(TreeNode root) {
		averageOfTree(root);
		return result;
	}

	private int[] averageOfTree(TreeNode node) {
		int sum=node.val, countOfNode=1;
		int[] left = node.left!=null ? averageOfTree(node.left) : null;
		sum += left!=null ? left[0] : 0;
		countOfNode += left!=null ? left[1] : 0;
		int[] right = node.right!=null ? averageOfTree(node.right) : null;
		sum += right!=null ? right[0] : 0;
		countOfNode += right!=null ? right[1] : 0;
		result += sum/countOfNode==node.val ? 1 : 0;
		return new int[]{sum, countOfNode};
	}

	private int[] averageOfTree2(TreeNode node) {
		int sum=node.val, countOfNode=1;
		if(node.left!=null) {
			int[] left=averageOfTree(node.left);
			sum+=left[0];
			countOfNode+=left[1];
		}
		if(node.right!=null) {
			int[] right=averageOfTree(node.right);
			sum+=right[0];
			countOfNode+=right[1];
		}
		if(sum/countOfNode==node.val) {
			result++;
		}
		return new int[]{sum, countOfNode};
	}

}
