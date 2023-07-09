package lc000232_ImplementQueueUsingStacks;

import java.util.Stack;

public class MyQueue3 {
	Stack<Integer> obverseStack = new Stack<>();
	Stack<Integer> reverseStack = new Stack<>();

	public MyQueue3() {}

	public void push(int x) {
		while(!obverseStack.isEmpty()) {
			reverseStack.push(obverseStack.pop());
		}
		obverseStack.push(x);
		while(!reverseStack.isEmpty()) {
			obverseStack.push(reverseStack.pop());
		}
		return;
	}

	public int pop() {
		return obverseStack.isEmpty() ? -1 : obverseStack.pop();
	}

	public int peek() {
		return obverseStack.isEmpty() ? -1 : obverseStack.peek();
	}

	public boolean empty() {
		return obverseStack.isEmpty();
	}

	/**
	 * Your MyQueue object will be instantiated and called as such:
	 * MyQueue obj = new MyQueue();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.peek();
	 * boolean param_4 = obj.empty();
	 */
}
