package lc001207_UniqueNumberOfOccurrences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

	public Solution() {}

	public boolean uniqueOccurrences(int[] arr) {
		//思路：使用map統計array element出現的次數，將所有element出現的次數映射到set，比較兩者size是否一樣
		Map<Integer, Integer> freq = new HashMap<>();
		Set<Integer> uniFreq = new HashSet<>();
		for(int element : arr) {
			//if(freq.containsKey(element)) {freq.put(element, freq.get(element)+1);continue;}
			//freq.put(element, 1);
			freq.put(element, freq.containsKey(element) ? freq.get(element)+1 : 1);
		}
		//return freq.size()==new HashSet<>(freq.values()).size();
		for(int element : freq.keySet()) {
			uniFreq.add(freq.get(element));
		}
		return uniFreq.size()==freq.size();
	}

	public boolean uniqueOccurrences2(int[] arr) {
		//思路：前一方法的微調，使用Map.values()直接取值放入set
		Map<Integer, Integer> freq = new HashMap<>();
		Set<Integer> uniFreq = new HashSet<>();
		for(int element : arr) {
			//freq.put(element, freq.containsKey(element) ? freq.get(element)+1 : 1);
			freq.put(element, freq.getOrDefault(element, 0)+1);
		}
		for(int value : freq.values()) {
			uniFreq.add(value);
		}
		return uniFreq.size()==freq.size();
	}

	public boolean uniqueOccurrences3(int[] arr) {
		//思路：微優化前兩個方法，直接判斷set裡有沒有已存在的相同值，如果有就代表不唯一，return false
		Map<Integer, Integer> freq = new HashMap<>();
		Set<Integer> uniFreq = new HashSet<>();
		for(int element : arr) {
			freq.put(element, freq.getOrDefault(element, 0)+1);
		}
		for(int value : freq.values()) {
			if(!uniFreq.add(value)) {return false;}
		}
		return true;
	}

}
