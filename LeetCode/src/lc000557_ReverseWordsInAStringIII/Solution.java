package lc000557_ReverseWordsInAStringIII;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public String reverseWords(String s) {
		char[] sCharArray=s.toCharArray();
		StringBuilder result = new StringBuilder(), temp = new StringBuilder();
		for(char character : sCharArray) {
			if(character==' ') {
				result.append(temp.reverse()).append(' ');
				temp.setLength(0);
				continue;
			}
			temp.append(character);
		}
		result.append(temp.reverse());
		return result.toString();
	}

	public String reverseWords2(String s) {
		char[] sCharArray=s.toCharArray(), result=Arrays.copyOf(sCharArray, sCharArray.length);	//result=new char[sCharArray.length];
		int slow=0, fast=0;
		while(slow<sCharArray.length) {
			while(fast<sCharArray.length && sCharArray[fast]!=' ') {
				fast++;
			}
			while(slow<sCharArray.length && sCharArray[slow]!=' ') {
				result[--fast]=sCharArray[slow++];
			}
			//if(slow<sCharArray.length) {result[slow]=' ';}
			fast=slow+++1;	//if(slow<sCharArray.length) {fast=slow+++1;}	//if(slow<sCharArray.length && sCharArray[slow]==' ') {fast=slow+++1;}
		}
		return new String(result);
	}

}
