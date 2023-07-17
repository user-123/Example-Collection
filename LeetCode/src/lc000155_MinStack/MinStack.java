package lc000155_MinStack;

class MinStack {
	private Node head;

	public MinStack() {}

	public void push(int val) {
		if(head==null) {
			head=new Node(val, val, null);
		}else {
			head=new Node(val, Math.min(val, head.min), head);
		}
	}

	public void pop() {
		if(head==null) {System.err.println("MinStack is empty.");return;}
		head=head.next;
	}

	public int top() {
		return head.val;
	}

	public int getMin() {
		return head.min;
	}

	private class Node {	//實作一個Linked List
		int val;
		int min;
		Node next;

		Node(int val, int min, Node next) {
			this.val=val;
			this.min=min;
			this.next=next;
		}
	}

}

class MinStack2 {
	private int[] stack;
	private int[] minStack;
	private int index;

	public MinStack2() {
		stack = new int[1000000];
		minStack = new int[1000000];
		index = 0;
	}

	public void push(int val) {
		minStack[index] = index==0 ? val : Math.min(val, minStack[index-1]);
		stack[index++] = val;
	}

	public void pop() {
		if(index==0) {System.err.println("MinStack is empty.");return;}
		index--;
	}

	public int top() {
		return stack[index-1];
	}

	public int getMin() {
		return minStack[index-1];
	}

}