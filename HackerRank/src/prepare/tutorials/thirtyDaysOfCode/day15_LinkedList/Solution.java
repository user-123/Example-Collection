package prepare.tutorials.thirtyDaysOfCode.day15_LinkedList;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		int nodeQuantity;
		Node head;
		try (Scanner scanner = new Scanner(System.in)) {
			nodeQuantity=Integer.valueOf(scanner.nextLine());
			head=new Node(Integer.valueOf(scanner.nextLine()));
			while(scanner.hasNextLine()) {
				int data=Integer.valueOf(scanner.nextLine());
				insert(head, data);
			}
        }
		System.out.println(head);
	}

	private static void insert(Node head, int data) {
		Node node=head;
		while(node.getNext()!=null) {
			node=node.getNext();
		}
		node.setNext(new Node(data));
		return;
	}
}

class Node {
	private int data;
	private Node next;

	protected Node(int data) {
		this.data=data;
		//this.next=null;
	}

	protected Node getNext() {
		return next;
	}

	protected void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		StringBuilder print = new StringBuilder();
		print.append(data);
		Node node=next;
		while(node!=null) {
			print.append(" ");
			print.append(node.data);
			node=node.next;
		}
		return print.toString();
	}
}