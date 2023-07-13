package lc000199_BinaryTreeRightSideView;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public Solution() {}

	//思路：找每一層最右側的元素

	public List<Integer> rightSideView(TreeNode root) {
		//思路：傳統BFS
		List<Integer> result = new LinkedList<>();
		if(root==null) {return result;}
		Queue<TreeNode> nodes = new LinkedList<>();
		TreeNode node = root;
		nodes.offer(node);
		result.add(node.val);
		while(!nodes.isEmpty()) {
			int width=nodes.size();
			for(int i=0; i<width; i++) {
				node = nodes.poll();
				if(node.left!=null) {nodes.offer(node.left);}
				if(node.right!=null) {nodes.offer(node.right);}
			}
			result.add(node.val);
		}
		return result;
	}

	public List<Integer> rightSideView2(TreeNode root) {
		//思路：優先檢查每層最右側的node，如果有就加入結果，剩餘不處理，使用recursive
		//待重新做題鞏固
		List<Integer> result = new LinkedList<>();
		rightView(root, result, 0);
		return result;
	}

	private void rightView(TreeNode currentNode, List<Integer> result, int currentDepth){
		if(currentNode==null) {return;}
		if(currentDepth==result.size()) {result.add(currentNode.val);}	//每層最右側的node會先碰到這條判斷，然後加入list，剩餘均會被跳過
		rightView(currentNode.right, result, currentDepth+1);
		rightView(currentNode.left, result, currentDepth+1);
	}

}
