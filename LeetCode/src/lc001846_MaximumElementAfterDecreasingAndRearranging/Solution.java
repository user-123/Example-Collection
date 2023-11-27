package lc001846_MaximumElementAfterDecreasingAndRearranging;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		//思路：條件就是第一項為1，然後數字只能減小；那其實很簡單，只要將最小的當作1，接著的每一項都比前一項大1就能得到最大值；不過要考慮不能增大(只能減小)這個條件，所以在兩個數字中取小的那一個；這算是貪婪解法吧
		Arrays.sort(arr);
		int prevNum=0;
		for(int num : arr) {
			//prevNum=Math.min(num, prevNum+1);
			prevNum = num<prevNum+1 ? num : prevNum+1;
		}
		return prevNum;
	}

}
