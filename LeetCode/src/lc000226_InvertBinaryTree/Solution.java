package lc000226_InvertBinaryTree;

public class Solution {

	public Solution() {}

	public TreeNode invertTree(TreeNode root) {
		TreeNode temp;
		if(root!=null) {
			temp=root.left;
			root.left=root.right;
			root.right=temp;
			invertTree(root.left);
			invertTree(root.right);
		}
		return root;
	}

}
