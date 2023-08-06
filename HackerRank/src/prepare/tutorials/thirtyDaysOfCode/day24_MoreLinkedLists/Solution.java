package prepare.tutorials.thirtyDaysOfCode.day24_MoreLinkedLists;

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
		removeDuplicates(head);
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

	private static void removeDuplicates(Node head) {
		Set<Integer> uniData = new HashSet<>();
		Node node=head, prev=null;
		while(node!=null) {
			if(!uniData.add(node.getData())) {
				node=node.getNext();
				prev.setNext(node);
			}else {
				prev=node;
				node=node.getNext();
			}
		}
		return;
	}

	private static void removeDuplicates_2(Node head) {
		Node node=head, prev=null;
		while(node!=null) {
			if(prev!=null && node.getData()==prev.getData()) {
				node=node.getNext();
				prev.setNext(node);
			}else {
				prev=node;
				node=node.getNext();
			}
		}
		return;
	}

	private static void removeDuplicates_3(Node head) {
		Node node=head, prev=node;
		while(node!=null) {
			if(node.getData()==prev.getData()) {
				node=node.getNext();
				prev.setNext(node);
			}else {
				prev=node;
				node=node.getNext();
			}
		}
		return;
	}

	private static void removeDuplicates2(Node head) {
		if(head==null) {return;}
		Node node=head;
		while(node.getNext()!=null) {
			if(node.getNext().getData()==node.getData()) {
				node.setNext(node.getNext().getNext());
			}else {
				node=node.getNext();
			}
		}
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

	protected int getData() {
		return data;
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