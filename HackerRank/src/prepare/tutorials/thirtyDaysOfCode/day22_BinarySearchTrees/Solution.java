package prepare.tutorials.thirtyDaysOfCode.day22_BinarySearchTrees;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		int nodeCount;
		TreeNode tree=null;
		try (Scanner scanner = new Scanner(System.in)) {
			nodeCount=scanner.nextInt();
			while(nodeCount-- >0) {
				tree=insert(tree, scanner.nextInt());
			}
		}
		System.out.println(getHeight(tree));
	}

	private static TreeNode insert(TreeNode root, int value) {
		if(root==null) {return new TreeNode(value);}
		if(value<root.val) {root.left=insert(root.left, value);}
		if(value>root.val) {root.right=insert(root.right, value);}
		//if(value==root.val) {throw new Throwable("value重複");}
		return root;
	}

	public static int getHeight(TreeNode root) {
		return root==null ? -1 : Math.max(getHeight(root.left), getHeight(root.right))+1;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	protected TreeNode(int val) {
		this.val=val;
	}

	protected TreeNode(int val, TreeNode left, TreeNode right) {
		this.val=val;
		this.left=left;
		this.right=right;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}

}