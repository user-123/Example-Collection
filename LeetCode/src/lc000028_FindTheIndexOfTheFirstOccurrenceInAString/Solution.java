package lc000028_FindTheIndexOfTheFirstOccurrenceInAString;

public class Solution {

	public Solution() {}

	public int strStr(String haystack, String needle) {
		//思路：不要重複造輪子XDDDD
		return haystack.indexOf(needle);
	}

	public int strStr_(String haystack, String needle) {
		//思路：KMP algorithm(Knuth–Morris–Pratt algorithm，Knuth-Morris-Pratt字符串查找算法)
		//LPS(Longest Prefix Suffix，最長相等前後綴)
		if(needle.length()==0) {return 0;}
		if(haystack.length()<needle.length()) {return -1;}

		//TODO
		return -1;
	}

	public int strStr2(String haystack, String needle) {
		int hPointer = 0, nPointer = 0, index = 0;
		while(nPointer<needle.length()) {
			while(haystack.charAt(hPointer)!=needle.charAt(nPointer)) {
				hPointer++;
			}
			index=hPointer-1;
			while(haystack.charAt(hPointer)==needle.charAt(nPointer)) {
				hPointer++;
				nPointer++;
				index++;
			}
			if(nPointer==needle.length()) {
				return index;
			}
		}
		return -1;
	}

}
