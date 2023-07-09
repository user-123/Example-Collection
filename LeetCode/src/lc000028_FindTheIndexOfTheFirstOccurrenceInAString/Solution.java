package lc000028_FindTheIndexOfTheFirstOccurrenceInAString;

public class Solution {

	public Solution() {}

	public int strStr(String haystack, String needle) {

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
