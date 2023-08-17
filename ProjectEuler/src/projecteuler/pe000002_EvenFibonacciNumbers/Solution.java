package projecteuler.pe000002_EvenFibonacciNumbers;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Solution {
	static long[] fibonacciSequence = new long[93];
	static {
		fibonacciSequence[0]=0;
		fibonacciSequence[1]=1;
		for(int i=2; i<93; i++) {
			fibonacciSequence[i]=fibonacciSequence[i-2]+fibonacciSequence[i-1];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				long n = Long.parseLong(bufferedReader.readLine().trim());

				System.out.println(evenFibonacciNumbersLessThanNSum(n));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
	}

	private static long evenFibonacciNumbersLessThanNSum(long n) {
		//思路：FibonacciNumbers={0, 1, 1, 2, 3, 5, 8, ...}，通過觀察，只有3m(也就是n%3==0)項為偶數，其餘均為奇數
		long sum=0;
		int i=0;
		/*
		while(true) {
			long fibNum=fibonacciSequence[i+=3];
			if(fibNum>n) {break;}
			sum+=fibNum;
		}
		*/
		while(fibonacciSequence[i+=3]<=n) {
			sum+=fibonacciSequence[i];	//不能將+=放在這邊，因為[]優先度最高會將[i+=3]優先計算完再做加總，與期望的先加總再i+=3不符
		}
		return sum;
	}

	@Deprecated
	private static long evenFibonacciNumbersLessThanNSum2(long n) {
		//思路：調用公式解(在72項(含)之後的運算結果有誤差)，故此方法棄用
		long sum=0;
		int i=0;
		while(true) {
			long fibNum=fibonacciNumbers(i+=3);
			if(fibNum>n) {break;}
			sum+=fibNum;
		}
		return sum;
	}

	@Deprecated
	private static long fibonacciNumbers(int n) {
		//思路：滿足F0=0, F1=F2=1且對任意n∈N，Fn+2=Fn+Fn+1=>Fn=Fn-1+Fn-2；費氏數列的一般項Fn=1/√5*{[(1+√5)/2]^n-[(1-√5)/2]^n}
		//已棄用，在72項(含)之後的運算結果有誤差
		double fiveSqrt=Math.sqrt(5);
		/*
		double pha = Math.pow(1+fiveSqrt, n);	//Math.sqrt(5) == Math.pow(5, 0.5)
	    double phb = Math.pow(1-fiveSqrt, n);
	    double div = Math.pow(2, n)*fiveSqrt;
		return (long)((pha-phb)/div);
		*/
		return (long)(1/fiveSqrt*(Math.pow((1+fiveSqrt)/2, n)-Math.pow((1-fiveSqrt)/2, n)));
	}
}
