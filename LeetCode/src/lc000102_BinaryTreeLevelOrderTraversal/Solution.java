package lc000102_BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public Solution() {}

	public List<List<Integer>> levelOrder(TreeNode root) {
		//思路：BFS traverse，用queue將每一層元素逐一取出(iteration)
		List<List<Integer>> resultList = new ArrayList<>();
		if(root==null) {return resultList;}
		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.offer(root);
		while(!nodes.isEmpty()) {
			List<Integer> result=new ArrayList<>();
			int quantity = nodes.size();
			for(int i=0; i<quantity; i++) {
				TreeNode node = nodes.poll();
				if(node.left!=null) {nodes.offer(node.left);}
				if(node.right!=null) {nodes.offer(node.right);}
				result.add(node.val);
			}
			resultList.add(result);
		}
		return resultList;
	}

	public List<List<Integer>> levelOrder2(TreeNode root) {
		//思路：DFS traverse，將元素沿著branch逐一取出放進各層list(recursion)
		List<List<Integer>> result = new ArrayList<>();
		traverse(root, 0, result);
		return result;
	}

	private void traverse(TreeNode node, int layer, List<List<Integer>> result) {
		if(node==null) {return;}
		if(result.size()==layer) {result.add(new ArrayList<Integer>());}
		result.get(layer).add(node.val);
		traverse(node.left, layer+1, result);
		traverse(node.right, layer+1, result);
		return;
	}

}
