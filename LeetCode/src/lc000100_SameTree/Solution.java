package lc000100_SameTree;

public class Solution {

	public Solution() {}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null && q==null) {
			return true;
		}else if(p==null || q==null) {
			return false;
		}
		if(p.val!=q.val) {
			return false;
		}
		if(!isSameTree(p.left, q.left) || !isSameTree(p.right, q.right)) {
			return false;
		}
		return true;
	}

	private boolean isSameTree2(TreeNode p, TreeNode q) {
		return (p==null && q==null) ? true : (p!=null && q!=null) && (p.val==q.val) && (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
	}

}
