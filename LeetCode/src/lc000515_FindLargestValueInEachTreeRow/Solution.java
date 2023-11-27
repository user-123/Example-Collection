package lc000515_FindLargestValueInEachTreeRow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public Solution() {}

	public List<Integer> largestValues(TreeNode root) {
		//思路：傳統BFS作法，不過多了取最大值的步驟
		List<Integer> result = new ArrayList<>();
		if(root==null) {return result;}
		Queue<TreeNode> nodes = new LinkedList<>();
		TreeNode node = root;
		nodes.offer(node);
		while(!nodes.isEmpty()) {
			int width=nodes.size(), max=Integer.MIN_VALUE;
			for(int i=0; i<width; i++) {
				node = nodes.poll();
				max = node.val>max ? node.val : max;
				if(node.left!=null) {nodes.offer(node.left);}
				if(node.right!=null) {nodes.offer(node.right);}
			}
			result.add(max);
		}
		return result;
	}

}
