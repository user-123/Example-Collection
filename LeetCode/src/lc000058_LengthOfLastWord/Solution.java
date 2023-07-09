package lc000058_LengthOfLastWord;

public class Solution {

	public Solution() {}

	public int lengthOfLastWord(String s) {
		//從前面開始比
		int pointer = 0, count = 0;
		while(pointer<s.length()) {
			if(s.charAt(pointer)==' ') {
				do {
					pointer++;
				}while(pointer<s.length() && s.charAt(pointer)==' ');
				if(!(pointer<s.length())) {break;}
				count=0;
			}
			count++;
			pointer++;
		}
		return count;
	}

	public int lengthOfLastWord2(String s) {
		//從後面開始比
		int pointer = s.length()-1, counter = 0;
		while(pointer>=0 && s.charAt(pointer)==' ') {
			pointer--;
		}
		while(pointer>=0 && s.charAt(pointer)!=' ') {
			counter++;
			pointer--;
		}
		return counter;
	}

}
