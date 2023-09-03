package lc001448_CountGoodNodesInBinaryTree;

public class Solution {

	public Solution() {}

	//思路：按照題意，可以將概念轉化為，node.left.val或node.right.val要大於或等於Math.max(node.val, root.val)才算是"good node"

	public int goodNodes(TreeNode root) {
		return goodNodes(root, Integer.MIN_VALUE, 0);
	}

	private int goodNodes(TreeNode node, int prevVal, int count) {
		if(node==null) {return count;}
		if(node.val>=prevVal) {
			count++;
			prevVal=node.val;
		}
		//if(node.left!=null) {count=goodNodes(node.left, prevVal, count);}
		//count = node.left!=null ? goodNodes(node.left, prevVal, count) : count;
		count=goodNodes(node.left, prevVal, count);
		//if(node.right!=null) {count=goodNodes(node.right, prevVal, count);}
		//count = node.right!=null ? goodNodes(node.right, prevVal, count) : count;
		count=goodNodes(node.right, prevVal, count);
		return count;
	}

	private int goodNodes12(TreeNode node, int prevVal, int count) {
		if(node==null) {return count;}
		if(node.val>=prevVal) {
			count++;
			prevVal=node.val;
		}
		return goodNodes12(node.left, prevVal, count)+goodNodes12(node.right, prevVal, count)-count;
	}

	private int goodNodes13(TreeNode node, int prevVal, int count) {
		if(node==null) {return count;}
		if(node.val>=prevVal) {
			count++;
			prevVal=node.val;
		}
		return count+goodNodes13(node.left, prevVal, 0)+goodNodes13(node.right, prevVal, 0);
	}



	public int goodNodes2(TreeNode root) {
		if(root==null) {return 0;}
		return goodNodes2(root, Integer.MIN_VALUE, 0);
	}

	private int goodNodes2(TreeNode node, int prevVal, int count) {
		if(node.val>=prevVal) {
			count++;
			prevVal=node.val;
		}
		if(node.left!=null) {count=goodNodes(node.left, prevVal, count);}
		//if(node.left!=null) {count+=goodNodes(node.left, prevVal, 0);}
		if(node.right!=null) {count=goodNodes(node.right, prevVal, count);}
		//if(node.right!=null) {count+=goodNodes(node.right, prevVal, 0);}
		return count;
	}



	public int goodNodes3(TreeNode root) {
		return goodNodes3(root, Integer.MIN_VALUE);
	}

	private int goodNodes3(TreeNode node, int prevVal) {
		if(node==null) {return 0;}
		if(node.val>=prevVal) {return 1+goodNodes3(node.left, node.val)+goodNodes3(node.right, node.val);}
		return goodNodes3(node.left, prevVal)+goodNodes3(node.right, prevVal);
	}

	private int goodNodes32(TreeNode node, int prevVal) {
		if(node==null) {return 0;}
		return node.val>=prevVal ? 1+goodNodes32(node.left, node.val)+goodNodes32(node.right, node.val) : goodNodes32(node.left, prevVal)+goodNodes32(node.right, prevVal);
	}

}
