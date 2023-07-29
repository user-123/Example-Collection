package lc000345_ReverseVowelsOfAString;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
	private static final boolean[] VOWELS = new boolean[128];	//ASCII table size

	static {
		//set vowels
		VOWELS['a'] = VOWELS['e'] = VOWELS['i'] = VOWELS['o'] = VOWELS['u'] = true;
		VOWELS['A'] = VOWELS['E'] = VOWELS['I'] = VOWELS['O'] = VOWELS['U'] = true;
	}

	public Solution() {}

	public String reverseVowels(String s) {
		//思路：使用two pointer
		char[] result = s.toCharArray();
		int left=0, right=s.length()-1;
		char temp;
		while(left<right) {
			if(isVowel(result[left]) && isVowel(result[right])) {
				temp=result[left];
				result[left]=result[right];
				result[right]=temp;
				left++;
				right--;
				continue;
			}
			if(isVowel(result[left])) {right--;continue;}
			if(isVowel(result[right])) {left++;continue;}
			left++;
			right--;
		}
		return new String(result);
		//return String.valueOf(result);
		//return String.copyValueOf(result);
	}

	private boolean isVowel(char character) {
		return character=='a' || character=='e' || character=='i' || character=='o' || character=='u' || character=='A' || character=='E' || character=='I' || character=='O' || character=='U';
	}

	public String reverseVowels2(String s) {
		//思路：先遍歷一遍，記錄進stack，利用stack的FILO特性，在第二次遍歷時取代掉vowel
		char[] result = s.toCharArray();
		Deque<Character> vowels = new ArrayDeque<>();
		for(char character : result) {
			if(isVowel(character)) {vowels.push(character);}
		}
		for(int i=0; i<result.length; i++) {
			result[i] = isVowel(result[i]) ? vowels.pop() : result[i];
		}
		return new String(result);
	}

	public String reverseVowels3(String s) {
		//思路：建一個vowels table查詢，利用static final boolean[] VOWELS和static block，避免重複建構table；table查詢速度快(利用table查詢，不需要跑一堆判斷，且array的查詢速度快)
		char[] result = s.toCharArray();
		int left=0, right=s.length()-1;
		char temp;
		while(left<right) {
			if(VOWELS[result[left]] && VOWELS[result[right]]) {
				temp=result[left];
				result[left]=result[right];
				result[right]=temp;
				left++;
				right--;
				continue;
			}
			if(VOWELS[result[left]]) {right--;continue;}
			if(VOWELS[result[right]]) {left++;continue;}
			left++;
			right--;
		}
		return new String(result);
	}
}
