package prepare.tutorials.thirtyDaysOfCode.day19_Interfaces;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		int input;
		try (Scanner scanner = new Scanner(System.in)) {
			input=scanner.nextInt();
        }
		Calculator calculator = new Calculator();
		//System.out.println("I implemented: " + calculator.getClass().getInterfaces());
		System.out.println("I implemented: " + calculator.getClass().getInterfaces()[0].getName());
		System.out.println(calculator.divisorSum(input));
	}
}

class Calculator implements AdvancedArithmetic{

	@Override
	public int divisorSum(int n) {
		int sum=0, nSqrt=(int)Math.sqrt(n);
		for(int i=1; i<=nSqrt; i++) {
			if(n%i==0) {sum+=i+n/i;}
		}
		return nSqrt*nSqrt==n ? sum-nSqrt : sum;
	}

}

interface AdvancedArithmetic {
	int divisorSum(int n);
}