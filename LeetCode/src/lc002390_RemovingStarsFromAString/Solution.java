package lc002390_RemovingStarsFromAString;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Solution {

	public Solution() {}

	public String removeStars(String s) {
		//思路：直接使用string builder模擬stack操作；當遇到'*'時將最後一位刪除(模擬stack.pop())
		StringBuilder result = new StringBuilder();
		for(char character : s.toCharArray()) {
			if(character=='*') {result.setLength(result.length()-1);continue;}
			result.append(character);
		}
		return result.toString();
	}

	public String removeStars2(String s) {
		//思路：利用指針的移動，模擬stack操作；當遇到'*'將指針回退一位(之後的輸出會覆蓋掉，等同刪除行為，模擬stack.pop())
		char[] result = new char[s.length()], string = s.toCharArray();
		int output=0;
		for(int input=0; input<string.length; input++) {
			if(string[input]=='*') {output--;continue;}
			result[output++]=string[input];
		}
		return new String(result, 0, output);
	}

	public String removeStars3(String s) {
		//思路：利用stack操作，遇到'*'時，將最後進的element pop出，等同刪除行為
		Deque<Character> charStack = new ArrayDeque<>();
		for(char character : s.toCharArray()) {
			if(character=='*') {charStack.pop();continue;}
			charStack.push(character);
		}
		StringBuilder result = new StringBuilder();
		for(char character : charStack) {
			result.append(character);
		}
		return result.reverse().toString();
	}

	public String removeStars4(String s) {
		//思路：與前一方法思路相同，不過輸出時使用deque的反向iterator，descendingIterator()，利用反向遍歷的方式，將element讀出，放進string builder時已經是順序的，不過此操作違反stack的LIFO規則
		Deque<Character> charStack = new ArrayDeque<>();
		for(char character : s.toCharArray()) {
			if(character=='*') {charStack.pop();continue;}
			charStack.push(character);
		}
		StringBuilder result = new StringBuilder();
		Iterator<Character> iterator = charStack.descendingIterator();
		while(iterator.hasNext()) {
			result.append(iterator.next());
		}
		return result.toString();
	}

}
