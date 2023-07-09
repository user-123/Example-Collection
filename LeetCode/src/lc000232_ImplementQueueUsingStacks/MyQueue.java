package lc000232_ImplementQueueUsingStacks;

import java.util.Stack;

public class MyQueue {
	private Stack<Integer> obverseStack, reverseStack;

	public MyQueue() {
		obverseStack = new Stack<>();
		reverseStack = new Stack<>();
	}

	public void push(int x) {
		while(!obverseStack.isEmpty()) {
			reverseStack.push(obverseStack.pop());
		}
		reverseStack.push(x);
		return;
	}

	public int pop() {
		while(!reverseStack.isEmpty()) {
			obverseStack.push(reverseStack.pop());
		}
		return obverseStack.isEmpty() ? -1 : obverseStack.pop();
	}

	public int peek() {
		while(!reverseStack.isEmpty()) {
			obverseStack.push(reverseStack.pop());
		}
		return obverseStack.isEmpty() ? -1 : obverseStack.peek();
	}

	public boolean empty() {
		return obverseStack.isEmpty() && reverseStack.isEmpty();
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
