package lc001759_CountNumberOfHomogenousSubstrings;

public class Solution {

	public Solution() {}

	public int countHomogenous(String s) {
		//思路：
		long times=0, count=0, modulo=1000000007;
		char[] charArray = s.toCharArray();
		char prev=charArray[0];
		for(char character : charArray) {
			if(character!=prev) {
				times+=(1+count)*count/2;
				//times%=modulo;
				prev=character;
				count=0;
			}
			count++;
		}
		return (int)((times+(1+count)*count/2)%modulo);
	}

	public int countHomogenous2(String s) {
		//思路：
		long times=0, count=0, modulo=1000000007;
		char[] charArray = s.toCharArray();
		char prev=charArray[0];
		for(char character : charArray) {
			if(character!=prev) {
				prev=character;
				count=0;
			}
			count++;
			times+=count;
		}
		return (int)(times%modulo);
	}

}
