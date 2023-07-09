package lc000202_HappyNumber;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public Solution() {}

	public boolean isHappy(int n) {
		int num = numberDigitsSum(n);
		Set<Integer> record = new HashSet<>();
		while(!record.contains(num) && n!=1) {
			record.add(num);
			num=numberDigitsSum(num);
		}
		return num==1;
	}

	private int numberDigitsSum(int number) {
		int sum = 0;
		while(number>0) {
			sum += (number%10)*(number%10);
			number/=10;
		}
		return sum;
	}
	public boolean isHappy2(int n) {
		//全新思路，稍微計算一下，只有當結果收斂到1或7結果才為真
		//7 -> 49 -> 97 -> 130 -> 10 -> 1
		//2 -> 4 -> 8 -> 64 -> 52 -> 29 -> 85 -> 89 -> 145 -> 42 -> 20 -> 2
		//3 -> 9 -> 81 -> 65 -> 61 -> 37 -> 58 -> 89 -> 145 -> 42 -> 20 -> 2
		//5 -> 25 -> 29 -> 85 -> 89 -> 145 -> 42 -> 20 -> 2
		//6 -> 36 -> 45 -> 41 -> 17 -> 50 -> 5
		//所以由結論推導出新的判斷方式，為各位數結果是否為1或7
		while(n>=10) {
			int num = 0;
			while(n!=0) {
				num += (n%10)*(n%10);
				n /=10;
			}
			n=num;
		}
		return n==1 || n==7;
	}
}
