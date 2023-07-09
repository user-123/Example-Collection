package lc000191_NumberOf1Bits;

public class Solution {

	public Solution() {}

	public int hammingWeight(int n) {
		//可利用338. Counting Bits的方法法計算
		//待完成
		return countBits(n)[n];
	}

	private int[] countBits(int n) {
		int[] result = new int[n+1];
		for(int i=1; i<=n; i++) {
			result[i] = result[i>>1]+(i&1);
		}
		return result;
	}

	public int hammingWeight2(int n) {
		int count = 0;
		while(n!=0) {
			count+=n&1;
			n=n>>>1;
		}
		return count;
	}

}
