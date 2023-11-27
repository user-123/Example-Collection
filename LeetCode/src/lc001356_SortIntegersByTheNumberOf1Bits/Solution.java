package lc001356_SortIntegersByTheNumberOf1Bits;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public int[] sortByBits(int[] arr) {
		//思路：將所有的數依二進位有幾個1乘上一個數(大於題目給定的arr[i]最大值10^4)，這樣能讓arr[i]的權重變為以bit count為主，這樣依大小排序就會以bit count為主；最後再利用取餘運算還原為原本的array
		for(int i=0; i<arr.length; i++) {
			arr[i]+=Integer.bitCount(arr[i])*10001;
		}
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++) {
			arr[i]%=10001;
		}
		return arr;
	}

}
