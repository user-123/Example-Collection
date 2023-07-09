package lc000530_MinimumAbsoluteDifferenceInBST;

public class Solution {

	public Solution() {}

	int previous = -100000, minimum = Integer.MAX_VALUE;

	public int getMinimumDifference(TreeNode root) {
		if(root == null) {return minimum;}

		getMinimumDifference(root.left);
		minimum = Math.min(minimum, root.val-previous);
		previous = root.val;
		getMinimumDifference(root.right);

		return minimum;
	}

}
