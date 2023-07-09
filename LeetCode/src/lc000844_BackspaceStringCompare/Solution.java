package lc000844_BackspaceStringCompare;

import java.util.Stack;

public class Solution {

	public Solution() {}

	public boolean backspaceCompare(String s, String t) {
		StringBuilder sString = new StringBuilder(), tString = new StringBuilder();
		for(char sChar : s.toCharArray()) {
			if(sChar=='#') {
				if(sString.length()>0) {
					sString.deleteCharAt(sString.length()-1);
					//sString.setLength(sString.length()-1);
				}
				continue;
			}
			sString.append(sChar);
		}
		for(char tChar : t.toCharArray()) {
			if(tChar=='#') {
				if(tString.length()>0) {
					tString.deleteCharAt(tString.length()-1);
					//tString.setLength(tString.length()-1);
				}
				continue;
			}
			tString.append(tChar);
		}
		return sString.toString().equals(tString.toString());
	}

	public boolean backspaceCompare2(String s, String t) {
		Stack<Character> sCharStack = new Stack<>(), tCharStack = new Stack<>();
		for(char sChar : s.toCharArray()) {
			if(sChar=='#') {
				if(!sCharStack.isEmpty()) {
					sCharStack.pop();
				}
				continue;
			}
			sCharStack.push(sChar);
		}
		for(char tChar : t.toCharArray()) {
			if(tChar=='#') {
				if(!tCharStack.isEmpty()) {
					tCharStack.pop();
				}
				continue;
			}
			tCharStack.push(tChar);
		}
		return sCharStack.toString().equals(tCharStack.toString());
	}

	public boolean backspaceCompare3(String s, String t) {
		StringBuilder sString = new StringBuilder(), tString = new StringBuilder();
		for(char sChar : s.toCharArray()) {
			if(sChar!='#') {
				sString.append(sChar);
			}else if(sString.length()>0) {
				sString.deleteCharAt(sString.length()-1);
			}
		}
		for(char tChar : t.toCharArray()) {
			if(tChar!='#') {
				tString.append(tChar);
			}else if(tString.length()>0) {
				tString.deleteCharAt(tString.length()-1);
			}
		}
		return sString.toString().equals(tString.toString());
	}
}
