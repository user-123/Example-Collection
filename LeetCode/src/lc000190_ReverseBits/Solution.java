package lc000190_ReverseBits;

public class Solution {

	public Solution() {}

	public int reverseBits(int n) {
		int result = 0;

		/*	會有問題：如過最後面為0，不會補0；除非多一個count
		while(n>0) {
			result=(result*2)+(n&1);	//result=(result<<1)+(n&1);
			n=n>>>1;
		*/

		/*
		int count = 0;
		while(count++<32) {
			result=(result<<1)+(n&1);	//result=(result<<1)|(n&1);
			n=n>>>1;	//n>>>=1;
		}
		*/

		/*
		for(int i=0; i<32; i++) {
			result=(result<<1)|(n&1);	//result=(result<<1)+(n&1);
			n>>>=1;
		}
		*/

		for(int i=0; i<32; i++) {
			result=(result<<1)|(n>>>i&1);	//result=(result<<1)+(n>>>i&1);
		}

		return result;
	}

	public int reverseBits2(int n) {
		//思路：reverse digit
		//參考：https://leetcode.com/problems/reverse-bits/solutions/1232842/java-c-0ms-o-1-time-complexity-in-place-detailed-explanation/
		int result = 0;
		//待完成

		return result;
	}

}
