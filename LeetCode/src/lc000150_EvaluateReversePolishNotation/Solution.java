package lc000150_EvaluateReversePolishNotation;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

	public Solution() {}

	public int evalRPN(String[] tokens) {
		//思路：利用Stack的FILO特性，當遇到運算符時取出會後放進的兩個運算元做計算，算完後結果再放回
		Deque<Integer> sequence = new ArrayDeque<>();
		for(String token : tokens) {
			if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
				int b=sequence.pop(), a=sequence.pop();
				switch (token) {
					case "+": {sequence.push(a+b);break;}
					case "-": {sequence.push(a-b);break;}
					case "*": {sequence.push(a*b);break;}
					case "/": {sequence.push(a/b);break;}
					default: {throw new IllegalArgumentException("Unexpected value: " + token);}
				}
				continue;
			}
			sequence.push(Integer.valueOf(token));
		}
		return sequence.pop();
	}

	public int evalRPN_2(String[] tokens) {
		//思路：上一個方法的小改寫
		Deque<Integer> sequence = new ArrayDeque<>();
		for(String token : tokens) {
			switch (token) {
				case "+": {
					int b=sequence.pop(), a=sequence.pop();
					sequence.push(a+b);
					break;
				}
				case "-": {
					int b=sequence.pop(), a=sequence.pop();
					sequence.push(a-b);
					break;
				}
				case "*": {
					int b=sequence.pop(), a=sequence.pop();
					sequence.push(a*b);
					break;
				}
				case "/": {
					int b=sequence.pop(), a=sequence.pop();
					sequence.push(a/b);
					break;
				}
				default: {
					sequence.push(Integer.valueOf(token));
				}
			}
		}
		return sequence.pop();
	}

	public int evalRPN_3(String[] tokens) {
		//思路：將上上一個方法改為if寫法
		Deque<Integer> sequence = new ArrayDeque<>();
		for(String token : tokens) {
			int b, a;
			if(token.equals("+")) {
				b=sequence.pop();
				a=sequence.pop();
				sequence.push(a+b);
				continue;
			}
			if(token.equals("-")) {
				b=sequence.pop();
				a=sequence.pop();
				sequence.push(a-b);
				continue;
			}
			if(token.equals("*")) {
				b=sequence.pop();
				a=sequence.pop();
				sequence.push(a*b);
				continue;
			}
			if(token.equals("/")) {
				b=sequence.pop();
				a=sequence.pop();
				sequence.push(a/b);
				continue;
			}
			sequence.push(Integer.valueOf(token));
		}
		return sequence.pop();
	}

	public int evalRPN_4(String[] tokens) {
		//思路：將上上上一個方法改為if/else if寫法
		Deque<Integer> sequence = new ArrayDeque<>();
		for(String token : tokens) {
			int b, a;
			if(token.equals("+")) {
				b=sequence.pop();
				a=sequence.pop();
				sequence.push(a+b);
			}else if(token.equals("-")) {
				b=sequence.pop();
				a=sequence.pop();
				sequence.push(a-b);
			}else if(token.equals("*")) {
				b=sequence.pop();
				a=sequence.pop();
				sequence.push(a*b);
			}else if(token.equals("/")) {
				b=sequence.pop();
				a=sequence.pop();
				sequence.push(a/b);
			}else {
				sequence.push(Integer.valueOf(token));
			}
		}
		return sequence.pop();
	}

	String[] tokens;
	int index;

	public int evalRPN2(String[] tokens) {
		//思路：既然遇到運算符時要將運算符前兩個運算元做計算，那就可以從array後面開始讀取，遇到運算符時就將鄰近的前兩個值使用recursion求出來
		//["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
		//((10 * (6 / ((9 + 3) * -11))) + 17) + 5
		// = ((10 * (6 / (12 * -11))) + 17) + 5
		// = ((10 * (6 / -132)) + 17) + 5
		// = ((10 * 0) + 17) + 5
		// = (0 + 17) + 5
		// = 17 + 5
		// = 22
		this.tokens=tokens;
		index=tokens.length-1;
		return calculate();
	}

	private int calculate() {
		int b, a;
		String token = tokens[index--];
		switch (token) {
			case "+": {
				b=calculate();
				a=calculate();
				return a+b;
			}
			case "-": {
				b=calculate();
				a=calculate();
				return a-b;
			}
			case "*": {
				b=calculate();
				a=calculate();
				return a*b;
			}
			case "/": {
				b=calculate();
				a=calculate();
				return a/b;
			}
			default: {
				return Integer.valueOf(token);
			}
		}
	}

}
