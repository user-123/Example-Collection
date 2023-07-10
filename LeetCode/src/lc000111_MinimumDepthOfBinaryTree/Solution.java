package lc000111_MinimumDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public Solution() {}

	//思路：找到第一個有left和right的node，找他的最小深度；或是最後一個node

	public int minDepth(TreeNode root) {
		//思路：DP比較，DFS
		if(root==null) {return 0;}
		int leftDepth = minDepth(root.left), rightDepth = minDepth(root.right);
		return leftDepth==0 || rightDepth==0 ? leftDepth+rightDepth+1 : Math.min(leftDepth, rightDepth)+1;
	}

	public int minDepth2(TreeNode root) {
		//思路：BFS
		int depth=0;
		if(root==null) {return depth;}
		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.offer(root);
		depth++;
		while(!nodes.isEmpty()) {
			int width=nodes.size();
			for(int i=0; i<width; i++) {	//切記不能寫成"for(int i=0; i<nodes.size(); i++) {"，因為for每跑一次(不是一輪迴圈的意思)迴圈，都會再取一次nodes.size()，又nodes.size()會隨著取出和放入而有浮動，所以要先將每層數量暫存起來
				TreeNode node = nodes.poll();
				if(node.left==null && node.right==null) {return depth;}
				if(node.left!=null) {nodes.offer(node.left);}
				if(node.right!=null) {nodes.offer(node.right);}
			}
			depth++; //算完一層就+1
		}
		return depth;
	}

}
