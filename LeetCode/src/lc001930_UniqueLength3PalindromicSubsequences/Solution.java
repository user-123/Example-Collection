package lc001930_UniqueLength3PalindromicSubsequences;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {

	public Solution() {}

	public int countPalindromicSubsequence(String s) {
		//思路：依照題意，只要第1和第3是同樣的char，中間(第2)的char可為任意，但若是這段substring(除去第1和第3char，兩者之間的char)中有重複的char(為了取第2個char)，也只計算一次
		int[] firstAppear = new int[26], lastAppear = new int[26];
		Arrays.fill(firstAppear, Integer.MAX_VALUE);
		char[] charArray = s.toCharArray();
		for(int i=0; i<s.length(); i++) {
			firstAppear[charArray[i]-'a'] = i<firstAppear[charArray[i]-'a'] ? i : firstAppear[charArray[i]-'a'];
			lastAppear[charArray[i]-'a'] = i;
		}
		int count=0;
		for(int i=0; i<firstAppear.length; i++) {
			count += firstAppear[i]<lastAppear[i] ? s.substring(firstAppear[i]+1, lastAppear[i]).chars().distinct().count() : 0;
			//count += firstAppear[i]<lastAppear[i] ? IntStream.range(firstAppear[i]+1, lastAppear[i]).map(j->charArray[j]).distinct().count() : 0;
		}
		return count;
	}

}
