package lc000739_DailyTemperatures;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

	public Solution() {}

	public int[] dailyTemperatures(int[] temperatures) {
		//思路：Monotonic Stack方式，用two pointer模擬
		int quantity=temperatures.length;
		int[] result = new int[quantity];
		for(int end=quantity-1; end>=0; end--) {
			for(int start=end-1; start>=0 && temperatures[start]<temperatures[end]; start--) {
				result[start]=end-start;
			}
		}
		return result;
	}

	public int[] dailyTemperatures2(int[] temperatures) {
		//思路：Monotonic Stack方式，用stack去計數
		int quantity=temperatures.length;
		int[] result = new int[quantity];
		Deque<Integer> stack = new ArrayDeque<>(quantity);
		for(int i=0; i<quantity; i++) {
			while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]) {
				//result[stack.peek()] = i-stack.peek();
				//stack.pop();
				result[stack.peek()] = i-stack.pop();
			}
			stack.push(i);
		}
		return result;
	}

	public int[] dailyTemperatures9(int[] temperatures) {
		//思路：傳統遍歷，算暴力解，會Time Limit Exceeded
		int quantity=temperatures.length;
		int[] result = new int[quantity];
		for(int start=0; start<quantity; start++) {
			int end=start;
			while(++end<quantity) {
				if(temperatures[end]>temperatures[start]) {result[start]=end-start;break;}
			}
		}
		return result;
	}

}
