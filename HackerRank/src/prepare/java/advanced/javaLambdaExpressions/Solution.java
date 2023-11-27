package prepare.java.advanced.javaLambdaExpressions;

import java.io.*;
import java.util.*;

interface PerformOperation {
	boolean check(int a);
}
class MyMath {

	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}

	public PerformOperation isOdd() {
		//PerformOperation performOperation = (int n) -> n%2==0 ? false : true;
		//return performOperation;
		return (int num) -> num%2==0 ? false : true;
	}
	public PerformOperation isPrime() {
		PerformOperation performOperation = (int num) -> {
			if(num<2) {return false;}
			if(num%2==0) {return num==2;}
			for(long i=3; i<=Math.sqrt(num); i+=2) {
				if(num%i==0) {return false;}
			}
			return true;
		};
		return performOperation;
	}
	public PerformOperation isPalindrome() {
		PerformOperation performOperation = (int num) -> {
			String numString = String.valueOf(num);
			char[] numStringCharArray = numString.toCharArray();
			int length = numString.length();
			for(int i=0; i<length/2; i++) {
				if(numStringCharArray[i]!=numStringCharArray[length-1-i]) {return false;}
			}
			return true;
		};
		return performOperation;
	}
}

	// Write your code here

public class Solution {

	public static void main(String[] args) throws IOException {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		MyMath ob = new MyMath();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		PerformOperation op;
		boolean ret = false;
		String ans = null;
		while (T-- >0) {
			String s = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(s);
			int ch = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (ch == 1) {
				op = ob.isOdd();
				ret = ob.checker(op, num);
				ans = (ret) ? "ODD" : "EVEN";
			}else if (ch == 2) {
				op = ob.isPrime();
				ret = ob.checker(op, num);
				ans = (ret) ? "PRIME" : "COMPOSITE";
			}else if (ch == 3) {
				op = ob.isPalindrome();
				ret = ob.checker(op, num);
				ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
			}
			System.out.println(ans);
		}
	}
}