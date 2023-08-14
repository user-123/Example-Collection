package dataStructure.tree;

import java.io.*;
import java.util.*;

public class BinaryTreeImpl {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		int nodeCount;
		TreeNode tree = new TreeNode();
		try (Scanner scanner = new Scanner(System.in)) {
			nodeCount=scanner.nextInt();
			while(nodeCount-- >0) {
				tree.insert(scanner.nextInt());
			}
        }
		Queue<Integer> nodeQueue = new ArrayDeque<>();
		TreeNode node = new TreeNode();
		if(tree!=null) {nodeQueue.offer(tree.getRoot().val);}
		System.out.println(tree);
	}

}




class TreeNode {
	private Node root;
	private int nodeCount;

	public TreeNode() {}

	public TreeNode(Node node) {
		this.root=node;
	}

	public void insert(int value) {
		root=insert(root, value);
	}

	private Node insert(Node node, int value) {
		if(node==null) {nodeCount++;return new Node(value);}
		if(value<node.val) {node.left=insert(node.left, value);}
		if(value>node.val) {node.right=insert(node.right, value);}
		if(value==node.val) {return null;}
		//if(value==root.val) {throw new Throwable("value重複");
		return node;
	}

	public Node getRoot() {
		return root;
	}

	public int getNode(Node node) {
		return node.val;
	}

	public Node getLeft(Node node) {
		return node.left;
	}

	public Node getRight(Node node) {
		return node.right;
	}

	public int getHeight() {
		return getHeight(root);
	}

	private int getHeight(Node node) {
		return node==null ? -1 : Math.max(getHeight(node.left), getHeight(node.right))+1;
	}





	private static class Node {
		Integer val;
		Node left;
		Node right;

		Node() {}

		Node(int val) {
			this.val=val;
		}

		Node(int val, Node left, Node right) {
			this.val=val;
			this.left=left;
			this.right=right;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}
	}

	@Override
	public String toString() {
		return root!=null ? root.toString() : "Tree is Empty!!!!!";
	}





	/*
	private static class Node<E> {
		E item;
		Node<E> left;
		Node<E> right;

		Node(E element, Node<E> left, Node<E> right) {
			this.item = element;
			this.left = left;
			this.right = right;
		}
	}
 */
}