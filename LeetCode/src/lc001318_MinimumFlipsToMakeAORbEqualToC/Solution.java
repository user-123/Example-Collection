package lc001318_MinimumFlipsToMakeAORbEqualToC;

public class Solution {

	public Solution() {}

	public int minFlips(int a, int b, int c) {
		int count=0;
		String aBit=Integer.toBinaryString(a), bBit=Integer.toBinaryString(b), cBit=Integer.toBinaryString(c);

		for(int i=cBit.length()-1; i>=0; i--) {

		}



		System.out.println(aBit);
		System.out.println(bBit);
		System.out.println(cBit);

		return count;
	}

	public int minFlips2(int a, int b, int c) {
		return Integer.bitCount(c^=(a|b))+Integer.bitCount(a&b&c);
	}

	private int bitCount(int num) {
		num=num-((num>>>1)&0x55555555);
        num=(num&0x33333333)+((num>>>2)&0x33333333);
        num=(num+(num>>>4))&0x0f0f0f0f;
        num=num+(num>>>8);
        num=num+(num>>>16);
        return num&0x3f;
	}

}
