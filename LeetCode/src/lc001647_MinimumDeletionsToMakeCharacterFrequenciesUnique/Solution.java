package lc001647_MinimumDeletionsToMakeCharacterFrequenciesUnique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	public Solution() {}

	public int minDeletions(String s) {
		if(s==null || s.isEmpty()) {return 0;}
		char[] charArray = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>(26);
		for(char character : charArray) {
			map.put(character, map.getOrDefault(character, 0)+1);
		}
		List<Integer> frequency = new ArrayList<>(26);
		for(int value : map.values()) {
			frequency.add(value);
		}
		Collections.sort(frequency);
		int count=0, prevQuantity=Integer.MAX_VALUE;
		for(int i=frequency.size()-1; i>=0; i--) {
			int quantity = frequency.get(i);
			//if(quantity==0) {break;}
			while(quantity>=prevQuantity) {
				quantity--;
				count++;
				if(quantity==0) {break;}
			}
			prevQuantity=quantity;
		}
		return count;
	}

	public int minDeletions2(String s) {
		if(s==null || s.isEmpty()) {return 0;}
		char[] charArray = s.toCharArray();
		int[] frequency = new int[26];
		for(char character : charArray) {
			frequency[character-'a']++;
		}
		Arrays.toString(frequency);
		frequency=Arrays.stream(frequency).filter(i -> i!=0).toArray();
		Arrays.toString(frequency);
		Arrays.sort(frequency);
		Arrays.toString(frequency);
		int count=0, prevQuantity=Integer.MAX_VALUE;
		for(int i=frequency.length-1; i>=0; i--) {
			int quantity = frequency[i];
			if(quantity==0) {break;}
			while(quantity>=prevQuantity) {
				quantity--;
				count++;
				if(quantity==0) {break;}
			}
			prevQuantity=quantity;
		}
		return count;
	}

	public int minDeletions3(String s) {
		if(s==null || s.isEmpty()) {return 0;}
		char[] charArray = s.toCharArray();
		int[] frequency = new int[26];
		for(char character : charArray) {
			frequency[character-'a']++;
		}
		Set<Integer> uniqueQuantity = new HashSet<>();
		int count=0;
		for(int quantity : frequency) {
			//if(quantity==0) {break;}
			while(quantity>0) {
				if(!uniqueQuantity.contains(quantity)) {uniqueQuantity.add(quantity);break;}
				quantity--;
				count++;
			}
		}
		return count;
	}

}
