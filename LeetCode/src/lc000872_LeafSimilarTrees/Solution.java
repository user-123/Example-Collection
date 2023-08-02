package lc000872_LeafSimilarTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	public Solution() {}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		//思路：比較leaf清單，如果一樣則能判定similar
		List<Integer> root1Leaves = getLeaves(root1), root2Leaves = getLeaves(root2);
		if(root1Leaves.size()!=root2Leaves.size()) {return false;}
		for(int i=0; i<root1Leaves.size(); i++) {
			if(root1Leaves.get(i)!=root2Leaves.get(i)) {return false;}
		}
		return true;
	}

	private List<Integer> getLeaves(TreeNode node) {
		//方法：產生leaf清單
		List<Integer> leavesRecord = new ArrayList<>();
		traverse(node, leavesRecord);
		return leavesRecord;
	}

	private void traverse(TreeNode node, List<Integer> leavesRecord) {
		//方法：由左至右DFS
		if(node==null) {return;}
		if(node.left==null && node.right==null) {leavesRecord.add(node.val);}
		traverse(node.left, leavesRecord);
		traverse(node.right, leavesRecord);
	}

	public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
		//思路：使用stack來取代recursive DFS
		//待完成
		List<Integer> root1Leaves = new ArrayList<>(), root2Leaves = new ArrayList<>();
		// TODO
		return true;
	}
}
