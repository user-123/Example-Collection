package lc000013_RomanToInteger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution2 {

	public Solution2() {}

	public int romanToInt(String s) {
		int sum = 0;
		Map<Character, Integer> romanNumerals = new HashMap<>();
		romanNumerals.put('I', 1);
		romanNumerals.put('V', 5);
		romanNumerals.put('X', 10);
		romanNumerals.put('L', 50);
		romanNumerals.put('C', 100);
		romanNumerals.put('D', 500);
		romanNumerals.put('M', 1000);
		s = s.replace("IV", "IIII");
		s = s.replace("IX", "VIIII");
		s = s.replace("XL", "XXXX");
		s = s.replace("XC", "LXXXX");
		s = s.replace ("CD", "CCCC");
		s = s.replace("CM", "DCCCC");
		for(int i = 0; i < s.length(); i++) {
			sum += romanNumerals.get(s.charAt(i));
		}
		return sum;
	}
}
