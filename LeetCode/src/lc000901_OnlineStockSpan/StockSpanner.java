package lc000901_OnlineStockSpan;

import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {
	Deque<int[]> stack;

	public StockSpanner() {
		stack = new ArrayDeque<>();
	}

	public int next(int price) {
		int span=1;
		while(!stack.isEmpty() && price>=stack.peek()[0]) {	//TODO 思考為何不是>，而是>=
			span+=stack.pop()[1];
		}
		stack.push(new int[] {price, span});
		return span;
	}
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */