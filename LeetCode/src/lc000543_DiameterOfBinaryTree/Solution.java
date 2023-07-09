package lc000543_DiameterOfBinaryTree;


public class Solution {
	
	int diameter = 0;

	public Solution() {}

	public int diameterOfBinaryTree(TreeNode root) {
		//思路：每個node的最長diameter為其左支高(最深)+右支高(最深)+1(該node)
		
		
		
		return diameter;
	}
	public int depth(TreeNode root) {
		
		return 0;
	}

	public int diameterOfBinaryTree2(TreeNode root) {
		int diameter = maxDepth(root.left)+maxDepth(root.right)+1;
		


		return Math.max(diameter, diameter);
	}

	private int maxDepth(TreeNode node) {
		//利用 104. Maximum Depth of Binary Tree 的算法，再加上XXXXXX
		if(node==null) {return 0;}
		diameter = Math.max(diameter, maxDepth(root.left)+maxDepth(root.right)+1);
		return Math.max(maxDepth(node.left), maxDepth(node.right))+1;
	}
}
