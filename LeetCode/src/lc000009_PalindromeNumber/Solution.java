package lc000009_PalindromeNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public Solution() {}

	public boolean isPalindrome(int x) {
		if(x<0) {return false;}
		int num = x, reverseNum = 0;
		while(num>0) {
			reverseNum=reverseNum*10+num%10;
			num/=10;
		}
		if(x!=reverseNum) {return false;}
		return true;
	}

	public boolean isPalindrome2(int x) {
		if(x==0) {return true;}
		if(x<0 || x%10==0) {return false;}
		int num = x, reverseNum = 0;
		while(num>0) {
			reverseNum=reverseNum*10+num%10;
			num/=10;
		}
		if(x!=reverseNum) {return false;}
		return true;
	}

	public boolean isPalindrome3(int x) {
		if(x==0) {return true;}
		if(x<0 || x%10==0) {return false;}
		if(x<10) {return true;}
		int reverseNum = 0;
		while(x>reverseNum) {
			reverseNum=reverseNum*10+x%10;
			x/=10;
		}
		return x==reverseNum || x==reverseNum/10;
	}

	public boolean isPalindrome4(int x) {
		if(x<0 || (x%10==0 && x!=0)) {return false;}
		if(x<10) {return true;}
		int reverseNum = 0;
		while(x>reverseNum) {
			reverseNum=reverseNum*10+x%10;
			x/=10;
		}
		return x==reverseNum || x==reverseNum/10;
	}

	public boolean isPalindrome5(int x) {
		if(x<0) {return false;}
		List<Integer> digits = new ArrayList<>(10);
		while(x>0) {
			digits.add(x%10);
			x/=10;
		}
		for(int i=0; i<(digits.size()+1)/2; i++) {
			if(digits.get(i)!=digits.get(digits.size()-1-i)) {return false;}
		}
		return true;
	}

	public boolean isPalindrome6(int x) {
		if(x<0) {return false;}
		char[] digits = Integer.toString(x).toCharArray();
		for(int i=0; i<(digits.length+1)/2; i++) {
			if(digits[i]!=digits[digits.length-1-i]) {return false;}
		}
		return true;
	}

}
