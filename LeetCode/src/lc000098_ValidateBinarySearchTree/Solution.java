package lc000098_ValidateBinarySearchTree;

public class Solution {

	public Solution() {}

	public boolean isValidBST(TreeNode root) {
		//思路：node.left的所有val不能>=root.val，同樣的node.right的所有val不能<=root.val；又因為最大值與最小值會超出int範圍，所以在不增加其它判斷的情況下，直接使用long省事
		//if(root==null || root.left==null && root.right==null) {return true;}
		return isValidNode(root, Integer.MIN_VALUE-1L, Integer.MAX_VALUE+1L);
		//return isValidNode(root, Long.valueOf(Integer.MIN_VALUE)-1, Long.valueOf(Integer.MAX_VALUE)+1);
	}

	private boolean isValidNode(TreeNode node, long min, long max) {
		if(node==null) {return true;}
		if(node.val<=min || node.val>=max) {return false;}
		return isValidNode(node.left, min, node.val) && isValidNode(node.right, node.val, max);
	}

	public boolean isValidBST2(TreeNode root) {
		//思路：與上一個方法同樣思路，不過使用Integer搭配null檢查判斷，來避免使用long(如果哪天要處理long範圍的數據，就可以使用這個套路，前一個方法就無法了，因為沒有比long(int64)更大範圍的int128)
		return isValidNode2(root, null, null);
	}

	private boolean isValidNode2(TreeNode node, Integer min, Integer max) {
		if(node==null) {return true;}
		if(min!=null && node.val<=min || max!=null && node.val>=max) {return false;}
		return isValidNode2(node.left, min, node.val) && isValidNode2(node.right, node.val, max);
	}

	public boolean isValidBST3(TreeNode root) {
		//思路：與上一個方法同樣思路，不過改為使用node作為載體，一樣搭配null檢查判斷，邏輯上也更為"貼近(有效的BST)"(node.left.val<node.val<node.right.val)
		return isValidNode3(root, null, null);
	}

	private boolean isValidNode3(TreeNode node, TreeNode min, TreeNode max) {
		if(node==null) {return true;}
		if(min!=null && node.val<=min.val || max!=null && node.val>=max.val) {return false;}
		return isValidNode3(node.left, min, node) && isValidNode3(node.right, node, max);
	}

}
