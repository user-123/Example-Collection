package lc000235_LowestCommonAncestorOfABinarySearchTree;

public class Solution {

	public Solution() {}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//The number of nodes in the tree is in the range [2, 105].
		//-10^9 <= Node.val <= 10^9
		//All Node.val are unique.
		//p != q
		//p and q will exist in the BST
		//if(root==null) {throws new Exception("XXX");}
		if(p.val==root.val || q.val==root.val) {return root;}
		if(p.val>root.val && q.val<root.val || p.val<root.val && q.val>root.val) {return root;}
		if(p.val<root.val && q.val<root.val) {return lowestCommonAncestor(root.left, p, q);}
		if(p.val>root.val && q.val>root.val) {return lowestCommonAncestor(root.right, p, q);}

		return null;
	}

}
