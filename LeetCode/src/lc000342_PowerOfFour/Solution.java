package lc000342_PowerOfFour;

import java.util.LinkedList;
import java.util.List;

public class Solution {

	public Solution() {}

	public boolean isPowerOfFour(int n) {
		if(n==1) {return true;}
		if(n<4) {return false;}
		while(n>=4) {
			if(n==0 || n%4!=0) {return false;}
			if(n==1) {break;}
			n/=4;
		}
		return n==1;
	}

	public boolean isPowerOfFour2(int n) {
		while(n>=4) {
			if(n%4!=0) {return false;}
			n/=4;
		}
		return n==1;
	}

	public boolean isPowerOfFour22(int n) {
		while(n>4) {
			if(n%4!=0) {return false;}
			n/=4;
		}
		return n==1 || n==4;
	}

}
