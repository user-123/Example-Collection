package lc000344_ReverseString;

public class Solution {

	public Solution() {}

	public void reverseString(char[] s) {
		int startPointer = 0, endPointer = s.length-1;
		while(startPointer<endPointer) {	//startPointer<=endPointer
			char temp = s[startPointer];
			s[startPointer++] = s[endPointer];
			s[endPointer--] = temp;
		}
		return;
	}

}
