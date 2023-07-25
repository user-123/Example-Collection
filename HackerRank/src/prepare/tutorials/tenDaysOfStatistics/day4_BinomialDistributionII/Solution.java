package prepare.tutorials.tenDaysOfStatistics.day4_BinomialDistributionII;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		double rejectedProbability;
		int quantity;
		try (Scanner scanner = new Scanner(System.in)) {
			rejectedProbability=scanner.nextDouble()/100;
			quantity=scanner.nextInt();
        }
		//No more than 2 rejects (k<=2)
		double result1=0;
		for(int k=0; k<=2; k++) {	//二項式分佈
			result1+=binomial(quantity, k, rejectedProbability);
		}
		System.out.format("%.3f%n", result1);
		//At least 2 rejects (k>=2)
		double result2=1;
		for(int k=0; k<2; k++) {	//二項式分佈
			result2-=binomial(quantity, k, rejectedProbability);
		}
		System.out.format("%.3f", result2);
	}

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