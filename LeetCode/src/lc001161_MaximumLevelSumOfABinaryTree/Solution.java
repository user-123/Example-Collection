package lc001161_MaximumLevelSumOfABinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public Solution() {}

	//int[] layerSum;
	Integer[] testArray = {1, 2, 3, null, 5, 6, 7, 8};
	TreeNode testTree = new TreeNode();
	int testArrayLength = testArray.length;
	int testTreeLayer = (int) Math.ceil(Math.log(testArrayLength+1)/Math.log(2));
	int testTreeLayer2 = (int) Math.ceil(Math.log1p(testArrayLength)/Math.log(2));

	public int maxLevelSum(TreeNode root) {

		//第一層的總和是root.val
		//第二層的總和是root.right.val+root.left.val
		//等同node1.val+node2.val
		//第三層的總和是node.right.val+node.left.val
		//等同(node3.val+node4.val)+(node5.val+node6.val)
		//1   2 3   4 5 6 7   8 9 10 11 12 13 14 15
		//第n層有幾個，為累加到這層的個數-累加到上層的個數
		//((2^n)-1) - ((2^(n-1))-1) => (2^n) - (2^(n-1))
		///第n層array index
		//start=(2^(n-1))-1+1-1, end=(2^n)-1-1

		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);	//nodeQueue.offer(root);
		int maxSum=Integer.MIN_VALUE, maxSumLayer=1, nowLayer=1;
		while(!nodeQueue.isEmpty()) {
			int layerSum = 0;
			int layerSize = nodeQueue.size();

			for(int i=0; i<layerSize; i++) {
				TreeNode node = nodeQueue.poll();
				layerSum += node.val;
				if(node.left!=null) {nodeQueue.add(node.left);}
				if(node.right!=null) {nodeQueue.add(node.right);}
			}

			if(layerSum>maxSum) {
				maxSum=layerSum;
				maxSumLayer=nowLayer;
			}
			nowLayer++;
		}
		return maxSumLayer;
	}

	private void treeNodeToArray(TreeNode node, int layer) {
		//未完成的其它解法，待完成
		List<Integer> nodeToArray = new ArrayList<>();
		int start=(int) ((Math.pow(2, layer-1)-1)+1-1) ,end=(int) ((Math.pow(2, layer)-1)-1);
		for(int i=start; i<=end; i++) {
			nodeToArray.add(null);

		}


		if(node.left==null && node.right==null) {

		}else if(node.left==null) {

		}else if(node.right==null) {

		}else {

		}

		return;
	}
}
