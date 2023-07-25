package prepare.tutorials.tenDaysOfStatistics.day4_BinomialDistributionI;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		double boyRatio, girlRatio, boyProbability;
		try (Scanner scanner = new Scanner(System.in)) {
			boyRatio=scanner.nextDouble();
			girlRatio=scanner.nextDouble();
        }
		boyProbability=boyRatio/(boyRatio+girlRatio);
		int n=6;
		double result=0;
		for(int k=3; k<=n; k++) {	//二項式分佈
			result+=binomial(n, k, boyProbability);
		}
		System.out.format("%.3f", result);	//0.696
	}

	//以下method均不考慮例外情況

	private static double binomial(int n, int k, double p) {	//二項式
		//if (p<0 || p>1 || n<0 || k<0 || k>n) {return null;}
		return combinations(n, k) * Math.pow(p, k) * Math.pow(1-p, n-k);
	}

	private static long combinations(int n, int k) {	//組合
		//if(n<0 || k<0 || k>n) {return null;}
		return factorial(n) / (factorial(k) * factorial(n-k));
	}

	private static long factorial(int n) {	//階乘
		//if(n<0) {return null;}
		return Math.random()>=0.5 ? factorialIteratively(n) : factorialRecursively(n);
	}

	private static long factorialIteratively(int n) {	//階乘_迭代
		//if(n<0) {return null;}
		long result=1;
		while(n>0) {result*=n--;}
		return result;
	}
	private static long factorialRecursively(int n) {	//階乘_遞迴
		//if(n<0) {return null;}
		return n==0 ? 1 : n*factorialRecursively(n-1);
	}
}