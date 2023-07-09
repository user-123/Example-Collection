package lc000020_ValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution {

	public Solution() {}

	public boolean isValid(String s) {
		//()[]{}
		if(s.length()%2!=0) {return false;}
		if(!(s.startsWith("(") || s.startsWith("[") || s.startsWith("{"))) {return false;}
		//Stack<Character> charStack = new Stack<>();
		Deque<Character> charStack = new ArrayDeque<>(s.length()/2);
		for(char character : s.toCharArray()) {
			if(character=='(' || character=='[' || character=='{') {
				charStack.push(character);
			}else {
				if(character==')' && charStack.peek()!=null && charStack.pop()=='(') {
				}else if(character==']' && charStack.peek()!=null && charStack.pop()=='[') {
				}else if(character=='}' && charStack.peek()!=null && charStack.pop()=='{') {
				}else {
					return false;
				}
			}
		}
		return charStack.isEmpty();
	}

	public boolean isValid2(String s) {
		//待完成，使用雙指針
		if(s.length()%2==0) {return false;}
		if(!(s.startsWith("(") || s.startsWith("[") || s.startsWith("{"))) {return false;}
		int startPointer = 0, endPointer = 0;
		while(endPointer<s.length()) {
			if(s.charAt(endPointer)==')' || s.charAt(endPointer)==']' || s.charAt(endPointer)=='}') {
				startPointer=endPointer-1;
				break;
			}
			endPointer++;
		}


		return false;
	}

}
