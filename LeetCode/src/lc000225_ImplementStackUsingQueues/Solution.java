package lc000225_ImplementStackUsingQueues;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
	Queue<Integer> queue;

	public MyStack() {
		queue = new LinkedList<>();
	}

	public void push(int x) {
		Queue<Integer> temp = new LinkedList<>();
		temp.offer(x);
		//while(!queue.isEmpty()) {temp.offer(queue.poll());}
		for(Iterator<Integer> iterator = queue.iterator(); iterator.hasNext();) {	//使用迭代器進行"LinkedList"的遍歷，效能不確定跟純poll()比起來是否有比較高????
			temp.offer(iterator.next());
		}
		queue=temp;
	}

	public int pop() {
		return queue.poll();
	}

	public int top() {
		return queue.peek();
	}

	public boolean empty() {
		return queue.isEmpty();
	}
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */