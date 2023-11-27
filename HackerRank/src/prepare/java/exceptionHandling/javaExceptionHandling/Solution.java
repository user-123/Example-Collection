package prepare.java.exceptionHandling.javaExceptionHandling;

import java.io.*;
import java.util.*;

class MyCalculator {
	/*
	 * Create the method long power(int, int) here.
	 */
	long power(int n, int p) throws Exception {
		if(n<0 || p<0) {throw new Exception("n or p should not be negative.");}
		if(n==0 && p==0) {throw new Exception("n and p should not be zero.");}
		long product=1L;
		/*
		while(p-- >0) {
			product*=n;
		}
		*/
		while(p>0) {
			product *= p%2!=0 ? n : 1;
			p/=2;
			n*=n;
		}
		return product;
	}
}

public class Solution {
	public static final MyCalculator my_calculator = new MyCalculator();
	public static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		while (in .hasNextInt()) {
			int n = in .nextInt();
			int p = in .nextInt();

			try {
				System.out.println(my_calculator.power(n, p));
			}catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}