package prepare.java.introduction.javaLoopsII;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		int a, b, n;
		try(Scanner scanner = new Scanner(System.in)) {
			int q=scanner.nextInt();
			while(q-- >0) {
				a=scanner.nextInt();
				b=scanner.nextInt();
				n=scanner.nextInt();
				print(a, b, n);
			}
		}
	}

	private static void print(int a, int b, int n) {
		int sum=a;
		for(int i=0; i<n; i++) {
			System.out.print(sum+=Math.pow(2, i)*b);
			System.out.print(i!=n-1 ? " " : "\n");
		}
	}
}