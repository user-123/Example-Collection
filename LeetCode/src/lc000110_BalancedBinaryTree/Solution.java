package lc000110_BalancedBinaryTree;

public class Solution {

	public Solution() {}

	public boolean isBalanced(TreeNode root) {
		//利用 104. Maximum Depth of Binary Tree 的邏輯
		//if(root==null) {return true;}
		return maxDepth(root)!=-1;
	}

	private int maxDepth(TreeNode node) {
		//利用 104. Maximum Depth of Binary Tree 的算法，再加上高度平衡判斷，利用回傳-1或height判斷是否平衡
		if(node==null) {return 0;}
		int leftSubTreeDepth = maxDepth(node.left);
		int rightSubTreeDepth = maxDepth(node.right);
		if(leftSubTreeDepth==-1 || rightSubTreeDepth==-1) {return -1;}
		if(Math.abs(leftSubTreeDepth-rightSubTreeDepth)>1) {return -1;}
		return Math.max(leftSubTreeDepth, rightSubTreeDepth)+1;
	}
}
