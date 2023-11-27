package lc000076_MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {

	public Solution() {}

	public String minWindow(String s, String t) {

		//待完成
		if(s.length()<t.length()) {return "";}
		//int[] usedFrequency = new int[52];
		Map<Character, Integer> usedFrequency = new HashMap<>();
		for(char character : s.toCharArray()) {
			if(usedFrequency.get(character)==null) {
				usedFrequency.put(character, 1);
			}else {
				usedFrequency.put(character, usedFrequency.get(character)+1);
			}
		}
		int start=0, end=0, index=0;
		while(end<s.length()) {

		}

		return "";
	}

}
