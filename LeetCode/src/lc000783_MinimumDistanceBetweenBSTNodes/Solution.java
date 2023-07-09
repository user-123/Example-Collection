package lc000783_MinimumDistanceBetweenBSTNodes;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public Solution() {}

	//private Set<Integer> nodeSet = new HashSet<>();

	public int minDiffInBST(TreeNode root) {
		return nodesMinimumDistance(root);
	}

	private int nodesMinimumDistance(TreeNode node) {
		//待修改，再想想，題邀要問的是最小差值之間的"距離"
		int minimumDistance = 100000;
		if(node.left!=null) {
			minimumDistance=Math.min(minimumDistance, Math.abs(node.val-node.left.val));
			minimumDistance=Math.min(minimumDistance, nodesNearbyMinimumDistance(node.left));
		}
		if(node.right!=null) {
			minimumDistance=Math.min(minimumDistance, Math.abs(node.val-node.right.val));
			minimumDistance=Math.min(minimumDistance, nodesNearbyMinimumDistance(node.right));
		}
		System.out.println(minimumDistance);
		return minimumDistance;
	}

	private int nodesNearbyMinimumDistance(TreeNode node) {
		//這是計算相鄰兩點最小的"差植"，只比較距離為1的兩點差值
		int minimumDistance = 100000;
		if(node.left!=null) {
			minimumDistance=Math.min(minimumDistance, Math.abs(node.val-node.left.val));
			minimumDistance=Math.min(minimumDistance, nodesNearbyMinimumDistance(node.left));
		}
		if(node.right!=null) {
			minimumDistance=Math.min(minimumDistance, Math.abs(node.val-node.right.val));
			minimumDistance=Math.min(minimumDistance, nodesNearbyMinimumDistance(node.right));
		}
		System.out.println(minimumDistance);
		return minimumDistance;
	}

}
