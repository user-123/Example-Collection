package lc000003_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution99 {

	public Solution99() {}

	public int lengthOfLongestSubstring(String s) {
		Set<Character> record = new HashSet<>();
		int maxLength = 0;
		int start = 0;
		for (int end = 0; end < s.length(); end++) {
			while(!record.add(s.charAt(end))) {
				record.remove(s.charAt(start++));
			}
			maxLength = Math.max(maxLength, end-start+1);
		}
		return maxLength;
	}
}
