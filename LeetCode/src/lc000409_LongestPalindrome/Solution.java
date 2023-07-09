package lc000409_LongestPalindrome;

public class Solution {

	public Solution() {}

	public int longestPalindrome(String s) {
		int [] charUsedCounts = new int[122-65+1];	//'A'==65, 'Z'==90, 'a'==97, 'z'==122, '0'==48, '9'==57 (十進位)
		int pairCount=0, singleCount=0;
		for(char character : s.toCharArray()) {
			charUsedCounts[character-'A']++;
		}
		for(int charUsed : charUsedCounts) {
			if(charUsed%2==0) {
				pairCount+=charUsed;
			}else {
				pairCount+=charUsed/2*2;
				singleCount++;
			}
		}
		return pairCount+(singleCount>0 ? 1:0);
	}

	public int longestPalindrome2(String s) {
		int [] charUsedCounts = new int[122-65+1];	//'A'==65, 'Z'==90, 'a'==97, 'z'==122, '0'==48, '9'==57 (十進位)
		int pairCount=0;
		for(char character : s.toCharArray()) {
			charUsedCounts[character-'A']++;
		}
		for(int charUsed : charUsedCounts) {
				pairCount+=charUsed/2*2;
		}
		return pairCount<s.length() ? pairCount+1 : pairCount;
	}

}
