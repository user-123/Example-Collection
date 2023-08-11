package lc000700_SearchInABinarySearchTree;

public class Solution {

	public Solution() {}

	public TreeNode searchBST(TreeNode root, int val) {
		return searchNode(root, val);
	}

	private TreeNode searchNode(TreeNode node, int val) {
		if(val==node.val) {return node;}
		if(val<node.val && node.left==null) {return null;}
		if(val>node.val && node.right==null) {return null;}
		return searchNode(val<node.val ? node.left : node.right, val);
	}

}
