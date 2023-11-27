package lc000316_RemoveDuplicateLetters;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solution {

	public Solution() {}

	public String removeDuplicateLetters(String s) {
		//思路：//TODO 待思考
		int[] lastAppearIndex = new int[128];
		char[] sCharArray = s.toCharArray();
		for(int i=0; i<sCharArray.length; i++) {
			lastAppearIndex[sCharArray[i]]=i;
		}
		boolean[] seen = new boolean[128];
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0; i<sCharArray.length; i++) {
			char character=sCharArray[i];
			if(seen[character]) {continue;}
			while(!stringBuilder.isEmpty() && stringBuilder.charAt(stringBuilder.length()-1)>character && i<lastAppearIndex[stringBuilder.charAt(stringBuilder.length()-1)]) {
				seen[stringBuilder.charAt(stringBuilder.length()-1)]=false;
				stringBuilder.setLength(stringBuilder.length()-1);
			}
			stringBuilder.append(character);
			seen[character]=true;
		}
		return stringBuilder.toString();
	}

	public String removeDuplicateLetters48(String s) {
		int[] usedCount = new int[127];
		char[] sCharArray = s.toCharArray();
		for(char character : sCharArray) {
			usedCount[character]+=1;
		}
		StringBuilder stringBuilder = new StringBuilder();
		for(char character : sCharArray) {
			while(!stringBuilder.isEmpty() && stringBuilder.charAt(stringBuilder.length()-1)>character && usedCount[character]>=1) {
				stringBuilder.setLength(stringBuilder.length()-1);
				usedCount[character]--;
			}
			//TODO 待思考、待完成
			stringBuilder.append(character);
			usedCount[character]--;
		}
		return stringBuilder.toString();
	}

	@Deprecated
	public String removeDuplicateLetters49(String s) {
		//思路：直接統計所有數字出現的總數，然後去除多餘的，不過題目沒說清楚，所以此方法不合題意
		int[] usedCount = new int[127];
		char[] sCharArray = s.toCharArray();
		for(char character : sCharArray) {
			usedCount[character]+=1;
		}
		List<Character> result = new ArrayList<>();
		for(char character : sCharArray) {
			if(usedCount[character]-- >1) {continue;}
			result.add(character);
		}
		return result.stream().map(String::valueOf).collect(Collectors.joining());
	}

}
