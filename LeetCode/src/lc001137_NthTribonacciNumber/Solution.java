package lc001137_NthTribonacciNumber;

public class Solution {
	final static int[] tribonacciNumbers;

	static {
		tribonacciNumbers = new int[38];
		tribonacciNumbers[0]=0;
		tribonacciNumbers[1]=1;
		tribonacciNumbers[2]=1;
		for(int i=3; i<=37; i++) {
			tribonacciNumbers[i]=tribonacciNumbers[i-3]+tribonacciNumbers[i-2]+tribonacciNumbers[i-1];
		}
	}

	public Solution() {}

	public int tribonacci(int n) {
		return tribonacciNumbers[n];
	}
}
