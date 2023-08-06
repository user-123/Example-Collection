package prepare.tutorials.thirtyDaysOfCode.day25_RunningTimeAndComplexity;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		int caseCount;
		int[] testCase;
		try (Scanner scanner = new Scanner(System.in)) {
			caseCount=Integer.valueOf(scanner.nextLine());
			testCase=new int[caseCount];
			for(int i=0; i<caseCount; i++) {
				testCase[i]=Integer.valueOf(scanner.nextLine());
			}
        }
		printIsPrimeOrNot(testCase);
	}

	private static void printIsPrimeOrNot(int[] array) {
		for(int num : array) {
			System.out.println(isPrime(num) ? "Prime" : "Not prime");
		}
	}

	private static boolean isPrime(int num) {
		if(num<2) {return false;}
		if(num==2) {return true;}
		//if(num==2 || num==3 || num==5 || num==7 || num==11 || num==13 || num==17 || num==19) {return true;}
		if(num%2==0) {return false;}
		for(int i=3; i<=Math.sqrt(num); i+=2) {
			if(num%i==0) {return false;}
		}
		return true;
	}
}