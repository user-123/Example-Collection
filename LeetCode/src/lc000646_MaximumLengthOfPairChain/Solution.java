package lc000646_MaximumLengthOfPairChain;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

	public Solution() {}

	public int findLongestChain(int[][] pairs) {
		//思路：將所有pair按照末端大小排序，每次比較的時候都"貪婪的"選擇可以加進chain的pair
		Arrays.sort(pairs, (a, b) -> a[1]-b[1]);
		/*
		Arrays.sort(pairs, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[1], b[1]);
			}
		});
		*/
		int prev=0, result=1;
		for(int i=1; i<pairs.length; i++) {
			if(pairs[prev][1]<pairs[i][0]) {
				prev=i;
				result++;
			}
		}
		return result;
	}
}
