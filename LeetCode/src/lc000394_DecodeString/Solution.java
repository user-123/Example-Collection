package lc000394_DecodeString;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

	public Solution() {}

	/*
		Example 1:
			Input: s = "3[a]2[bc]"
			Output: "aaabcbc"
		Example 2:
			Input: s = "3[a2[c]]"
			Output: "accaccacc"
		Example 3:
			Input: s = "2[abc]3[cd]ef"
			Output: "abcabccdcdcdef"
	*/

	public String decodeString(String s) throws IllegalArgumentException {
		//思路：將所有的char push進stack裡，直到遇到']'；當遇到']'時，依次取出stack中的字母，直到遇到'['；當遇到'['時，將其取出，並繼續取出數字部份；最後依照數字部份將字母部份做重複；最後將已經經過重複的字母依序push進stack
		char[] string = s.toCharArray();
		Deque<Character> stack = new ArrayDeque<>(string.length);
		StringBuilder temporaryStorage = new StringBuilder();
		for(char character : string) {
			if(character!=']') {stack.push(character);continue;}
			while(!stack.isEmpty() && Character.isLetter(stack.peek())) {
				//temporaryStorage.insert(0, stack.pop());
				temporaryStorage.append(stack.pop());
			}
			//String subString = temporaryStorage.toString();
			String subString = temporaryStorage.reverse().toString();
			temporaryStorage.setLength(0);

			if(stack.peek()=='[') {stack.pop();}else {throw new IllegalArgumentException("輸入的string為：\"" + s + "\"，不符合規範");}

			while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
				//temporaryStorage.insert(0, stack.pop());
				temporaryStorage.append(stack.pop());
			}
			//int repeatTime = Integer.valueOf(temporaryStorage.toString());
			int repeatTime = Integer.valueOf(temporaryStorage.reverse().toString());
			temporaryStorage.setLength(0);

			char[] subStringCharArray=subString.toCharArray();
			while(repeatTime-- >0) {
				for(char subStringChar : subStringCharArray) {
					stack.push(subStringChar);
				}
			}
		}

		StringBuilder result = new StringBuilder();
		while(!stack.isEmpty()) {result.append(stack.pop());}
		return result.reverse().toString();
	}

	public String decodeString2(String s) throws IllegalArgumentException {
		//思路：與上一個解法相同，不過直接使用StringBuilder模擬stack，可以省掉return時取出stack的步驟
		char[] string = s.toCharArray();
		StringBuilder stack = new StringBuilder(), temporaryStorage = new StringBuilder();
		for(char character : string) {
			if(character!=']') {stack.append(character);continue;}
			while(!stack.isEmpty() && Character.isLetter(stack.charAt(stack.length()-1))) {
				temporaryStorage.append(stack.charAt(stack.length()-1));
				stack.setLength(stack.length()-1);
			}
			String subString = temporaryStorage.reverse().toString();
			temporaryStorage.setLength(0);

			if(stack.charAt(stack.length()-1)=='[') {stack.setLength(stack.length()-1);}else {throw new IllegalArgumentException("輸入的string為：\"" + s + "\"，不符合規範");}

			while(!stack.isEmpty() && Character.isDigit(stack.charAt(stack.length()-1))) {
				temporaryStorage.append(stack.charAt(stack.length()-1));
				stack.setLength(stack.length()-1);
			}
			int repeatTime = Integer.valueOf(temporaryStorage.reverse().toString());
			temporaryStorage.setLength(0);

			while(repeatTime-- >0) {stack.append(subString);}
		}

		return stack.toString();
	}

	public String decodeString3(String s) {
		//思路：使用pointer模擬stack操作
		char[] string = s.toCharArray();
		StringBuilder result = new StringBuilder();
		int pointer=0, count=0;
		for(int i=0; i<string.length; i++) {
			//TODO
			if(string[i]=='[') {count++;break;}
			if(string[i]!=']') {break;}
			StringBuilder splitString = new StringBuilder();
			pointer=i;
			int countTemp=count;
			while(countTemp==count) {
				if(string[pointer]!='[') {
					splitString.append(string[pointer--]);
				}else {

				}
			}
		}
		//TODO

		int left=0, right=string.length-1, count_=0;
		while(left<=right) {
			if(string[left]=='[') {}
			if(string[right]==']') {}
		}

		return "";
	}
}
