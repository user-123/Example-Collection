package lc000232_ImplementQueueUsingStacks;

import java.util.Stack;

public class MyQueue2 {
	private Stack<Integer> obverseStack, reverseStack;

	public MyQueue2() {
		obverseStack = new Stack<>();
		reverseStack = new Stack<>();
	}

	public void push(int x) {
		reverseStack.push(x);
		return;
	}

	public int pop() {
		/*
		if(obverseStack.empty()) {
			while(!reverseStack.empty()) {
				obverseStack.push(reverseStack.pop());
			}
		}
		*/
		peek();
		return obverseStack.empty() ? -1 : obverseStack.pop();
	}

	public int peek() {
		if(obverseStack.empty()) {
			while(!reverseStack.empty()) {
				obverseStack.push(reverseStack.pop());
			}
		}
		return obverseStack.empty() ? -1 : obverseStack.peek();
	}

	public boolean empty() {
		return obverseStack.empty() && reverseStack.empty();
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
