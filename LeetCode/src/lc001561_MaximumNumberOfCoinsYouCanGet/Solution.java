package lc001561_MaximumNumberOfCoinsYouCanGet;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public int maxCoins(int[] piles) {
		//思路：只能取第二大的硬幣堆，最大化的策略就是每次盡量取兩個最大的堆與一個最小堆(貪婪解法)
		Arrays.sort(piles);
		int coinSum=0, twoThirdsGreaterIndex=piles.length/3;
		for(int i=piles.length-1-1; i>=twoThirdsGreaterIndex; i=i-2) {
			coinSum+=piles[i];
		}
		return coinSum;
	}

}
