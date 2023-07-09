package lc000003_LongestSubstringWithoutRepeatingCharacters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	public Solution() {}

	public int lengthOfLongestSubstring(String s) {//未完成
		//Map<Integer, String> result = new HashMap<>();
		Set<String> result = new HashSet<>();
		//List<String> result = new ArrayList<>();
		int start = 0, end = 0;
		while(start<=end && end<s.length()) {
			if(!result.contains(String. valueOf(s.charAt(end)))) {
				result.add(String. valueOf(s.charAt(end)));
			}


			if(result.contains(s.substring(start, end))) {
				start++;
				result.add(s.substring(start, end));
			}else {
				//result.put(s.substring(start, end).length(), s.substring(start, end));
				result.add(s.substring(start, end));
				end++;
			}
		}
		System.out.println(result);

		return (Collections.max(result)).length();
	}

	public int lengthOfLongestSubstring2(String s) {
		Set<Character> record = new HashSet<>();
		int start = 0, end = 0, maxLength = 0;
		while(end<s.length()) {	// && start<=end
			if(!record.contains(s.charAt(end))) {
			//if(!record.add(s.charAt(end))) {
				maxLength = Math.max(maxLength, end-start+1);
			}else {
				while(s.charAt(start) != s.charAt(end)) {
					record.remove(s.charAt(start));
					start++;
				}
				record.remove(s.charAt(start));
				start++;
			}
			record.add(s.charAt(end));
			end++;
		}
		System.out.println(record);

		return maxLength;
	}

	public int lengthOfLongestSubstring3(String s) {
		Set<Character> record = new HashSet<>();
		int start = 0, end = 0, maxLength = 0;
		while(end<s.length()) {	// && start<=end
			if(!record.contains(s.charAt(end))) {
				//if(!record.add(s.charAt(end))) {
				maxLength = Math.max(maxLength, end-start+1);
			}else {
				while(!record.add(s.charAt(end))) {
					record.remove(s.charAt(start));
					start++;
				}
			}
			record.add(s.charAt(end));
			end++;
		}
		System.out.println(record);

		return maxLength;
	}

	public int lengthOfLongestSubstring4(String s) {
		Set<Character> record = new HashSet<>();
		int start = 0, end = 0, maxLength = 0;
		while(end<s.length()) {	// && start<=end
			if(record.add(s.charAt(end))) {
				//if(!record.add(s.charAt(end))) {
				maxLength = Math.max(maxLength, end-start+1);
			}else {
				while(!record.add(s.charAt(end))) {
					record.remove(s.charAt(start));
					start++;
				}
			}
			end++;
		}
		System.out.println(record);

		return maxLength;
	}

	public int lengthOfLongestSubstring5(String s) {
		Set<Character> record = new HashSet<>();
		int start = 0, end = 0, maxLength = 0;
		while(end<s.length()) {
			while(!record.add(s.charAt(end))) {
				record.remove(s.charAt(start));
				start++;
			}
			maxLength = Math.max(maxLength, end-start+1);
			end++;
		}
		System.out.println(record);

		return maxLength;
	}

	public int lengthOfLongestSubstring6(String s) {
		Set<Character> record = new HashSet<>();
		int start = 0, end = 0, maxLength = 0;
		while(end<s.length()) {
			while(!record.add(s.charAt(end))) {
				record.remove(s.charAt(start++));
			}
			maxLength = Math.max(maxLength, end++-start+1);
		}
		System.out.println(record);

		return maxLength;
	}
}
