package lc000013_RomanToInteger;

import java.util.LinkedList;
import java.util.List;

public class Solution {

	public Solution() {}

	public int romanToInt(String s) {
		int result = 0, num = 0;
		for(int i=s.length()-1; i>=0; i--) {
			switch (s.charAt(i)) {
			case 'I': {num = 1; break;}	//不須加break，不過不清楚是否影響效能
			case 'V': {num = 5; break;}
			case 'X': {num = 10; break;}
			case 'L': {num = 50; break;}
			case 'C': {num = 100; break;}
			case 'D': {num = 500; break;}
			case 'M': {num = 1000; break;}
			default: {throw new IllegalArgumentException("Unexpected value: " + s.charAt(i));}
			}
			result=(num*4 < result) ? (result-num) : (result+num);	//將這條判斷塞進case裡，然後V、L、D不需要是加還是減的判斷，應該可以再增加一點點效能
		}
		return result;
	}
}
