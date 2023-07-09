package lc000572_SubtreeOfAnotherTree;

public class Solution {

	public Solution() {}

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if(subRoot==null) {return true;}	//第一次檢查subRoot是否為null
		if(root==null) {return false;}		//每一次檢查root是否為null，第一次如果為null，則一定不是子樹(因為前一條已經排除了root和subRoot均為null的情況)；之後檢查用來設定"樹尋找節點的邊界"
		return checkSubtree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	private boolean checkSubtree(TreeNode node, TreeNode subNode) {
		if(node==null || subNode==null) {return node==subNode;}
		if(node.val==subNode.val) {
			return checkSubtree(node.left, subNode.left) && checkSubtree(node.right, subNode.right);
		}
		/* 因為不是BST所以不能用以下判斷做動態規劃
		if(node.val<subNode.val) {
			return checkSubtree(node.right, subNode);
		}
		if(node.val>subNode.val) {
			return checkSubtree(node.left, subNode);
		}
		*/

		return false;
	}

}
