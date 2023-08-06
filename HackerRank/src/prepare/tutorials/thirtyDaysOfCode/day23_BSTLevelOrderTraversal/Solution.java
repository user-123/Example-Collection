package prepare.tutorials.thirtyDaysOfCode.day23_BSTLevelOrderTraversal;

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
		printLevelOrder(tree);
	}

	private static TreeNode insert(TreeNode root, int value) {
		if(root==null) {return new TreeNode(value);}
		if(value<root.val) {root.left=insert(root.left, value);}
		if(value>root.val) {root.right=insert(root.right, value);}
		//if(value==root.val) {throw new Throwable("value重複");}
		return root;
	}

	public static void printLevelOrder(TreeNode root) {
		if(root==null) {System.out.println("");}
		Queue<TreeNode> nodeQueue = new ArrayDeque<>();
		//int layerCount=0;
		StringBuilder nodeString = new StringBuilder();
		nodeQueue.offer(root);
		while(!nodeQueue.isEmpty()) {
			int quantity=nodeQueue.size();
			for(int i=0; i<quantity; i++) {
				TreeNode node = nodeQueue.poll();
				nodeString.append(node.val);
				nodeString.append(" ");
				if(node.left!=null) {nodeQueue.offer(node.left);}
				if(node.right!=null) {nodeQueue.offer(node.right);}
			}
		}
		nodeString.setLength(nodeString.length()-1);
		System.out.println(nodeString);
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