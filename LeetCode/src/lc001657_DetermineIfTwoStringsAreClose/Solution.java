package lc001657_DetermineIfTwoStringsAreClose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public Solution() {}

	public boolean closeStrings(String word1, String word2) {
		//思路：依照題意，兩個字串要接近，就是兩者能通過不限次數的兩種操作互相轉換：操作一、任意互換兩個char的位置，操作二、將兩種不同的所有char互相反轉(即將所有'a'替換成'b'，所有'b'換成'a')；
		//遵照以上的操作，能得出幾個特點，if word1 is close to word2，1.string.length()相等，2.兩者使用的key相同，3.key的使用次數"相同"(可能為不同key，不過使用次數排序後要相等)
		if(word1.length()!=word2.length()) {return false;}
		char[] word1Array = word1.toCharArray(), word2Array = word2.toCharArray();
		Map<Character, Integer> word1Map = new HashMap<>(), word2Map = new HashMap<>();
		for(char char1 : word1Array) {
			word1Map.put(char1, word1Map.getOrDefault(char1, 0)+1);
		}
		for(char char2 : word2Array) {
			word2Map.put(char2, word2Map.getOrDefault(char2, 0)+1);
		}
		if(!word1Map.keySet().equals(word2Map.keySet())) {return false;}
		List<Integer> word1Count = new ArrayList<>(word1Map.values()), word2Count = new ArrayList<>(word2Map.values());
		//word1Count.sort((c1, c2) -> c1-c2);	//小->大
		//word2Count.sort((c1, c2) -> c1-c2);
		Collections.sort(word1Count);	//小->大
		Collections.sort(word2Count);
		return word1Count.equals(word2Count);
	}

	public boolean closeStrings2(String word1, String word2) {
		//思路：將table由map替換成array，極大優化速度
		if(word1.length()!=word2.length()) {return false;}
		//if(word1.equals(word2)) {return true;}
		char[] word1Array = word1.toCharArray(), word2Array = word2.toCharArray();
		if(word1Array.equals(word2Array)) {return true;}
		int[] word1Count = new int[26], word2Count = new int[26];
		for(char char1 : word1Array) {
			word1Count[char1-'a']++;
		}
		for(char char2 : word2Array) {
			word2Count[char2-'a']++;
		}
		for(int i=0; i<26; i++) {
			//if(word1Count[i]==0 && word2Count[i]!=0 || word1Count[i]!=0 && word2Count[i]==0) {return false;}
			if(word1Count[i]==0 ^ word2Count[i]==0) {return false;}
			//if(word1Count[i]!=0 ^ word2Count[i]!=0) {return false;}
		}
		Arrays.sort(word1Count);
		Arrays.sort(word2Count);
		for(int i=0; i<26; i++) {
			if(word1Count[i]!=word2Count[i]) {return false;}
		}
		return true;
	}

}
