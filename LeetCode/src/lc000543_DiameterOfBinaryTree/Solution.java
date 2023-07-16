package lc000543_DiameterOfBinaryTree;


public class Solution {

	private int diameter;

	public Solution() {
		diameter = 0;
	}

	//思路：求diameter時只出現3種情況：
	//1.最大直徑完全位於左子樹中
	//2.最大直徑完全位於右子樹中
	//3.通過根節點的最大直徑（lhs(left-hand side)高度+rhs(right-hand side)高度+2）

	public int diameterOfBinaryTree(TreeNode root) {
		//思路：每個node的diameter為其左支高(最深)+右支高(最深)+2(左右支到該node)；故將所有node的diameter求出並比較出最長的
		if(root==null) {return 0;}	//這邊要看如何定義空樹的diameter，決定return的是0或-1；(雖然與本題無關)同樣的道理要看如何定義空樹的height/depth決定return的是0或-1
		//if(root.left==null && root.right==null) {return 0;}
		maxDepth(root);
		return diameter;
	}

	private int maxDepth(TreeNode node) {
		//利用 104. Maximum Depth of Binary Tree 的算法邏輯，再加上利用instance variables(實例變數)儲存最大的diameter
		//原本的算法會造成一個小bug，那就是當root!=null && root.left==null && root.right==null，回傳的depth是1，是錯的，但diameter是正確的(不+2的情況下)；所以這邊改為if(node==null) {return -1;}
		if(node==null) {return -1;}
		int leftDepth=maxDepth(node.left), rightDepth=maxDepth(node.right);
		diameter = Math.max(diameter, leftDepth+rightDepth+2);
		return Math.max(leftDepth, rightDepth)+1;
	}
}
