package lc000050_Pow_x_n_;

public class Solution {

	public Solution() {}

	public double myPow(double x, int n) {
		double result=1;
		long _n=Math.abs((long)n);
		while(_n>0) {
			if(_n%2==1) {
				result*=x;
				_n--;
			}else {
				x*=x;
				_n/=2;
			}
		}
		return n>=0 ? result : 1/result;
	}

	public double myPow2(double x, int n) {
		return n>=0 ? findPositivePower(x, n) : 1/findPositivePower(x, -(long)n);	//-n就可以耶0.0
	}

	private double findPositivePower(double x, long n) {
		//n=Math.abs(n);
		if(n==0) {return 1.0;}
		double result=findPositivePower(x, n/2);
		if(n%2==0) {
			return result*result;
		}else {
			return result*result*x;
		}
	}

	public double myPow3(double x, int n) {
		//if(x==0 || x==1) {return x==0 ? 0 : 1;}
		double result=1;
		for(long i=0; i<Math.abs((long)n); i++) {
			result*=x;
		}
		return n>=0 ? result : 1/result;
	}

	public double myPow99(double x, int n) {
		return Math.pow(x, n);
	}

}
