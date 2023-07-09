package lc000101_SymmetricTree;

public class Solution {

	public Solution() {}

	public boolean isSymmetric(TreeNode root) {
		return root==null || checkSymmetric(root.left, root.right);
	}

	private boolean checkSymmetric(TreeNode nodeLeft, TreeNode nodeRight) {
		/*
		if(nodeLeft==null && nodeRight==null) {return true;}
		if(nodeLeft==null || nodeRight==null) {return false;}
		if(nodeLeft.val!=nodeRight.val) {return false;}
		if(checkSymmetric(nodeLeft.left, nodeRight.right) && checkSymmetric(nodeLeft.right, nodeRight.left)) {return true;}
		return false;
		*/
		if(nodeLeft==null || nodeRight==null) {return nodeLeft==nodeRight;}
		if(nodeLeft.val!=nodeRight.val) {return false;}
		return checkSymmetric(nodeLeft.left, nodeRight.right) && checkSymmetric(nodeLeft.right, nodeRight.left);

	}
}
