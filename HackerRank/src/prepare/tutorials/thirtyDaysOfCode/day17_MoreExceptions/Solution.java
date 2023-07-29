package prepare.tutorials.thirtyDaysOfCode.day17_MoreExceptions;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		try (Scanner scanner = new Scanner(System.in)) {
			int caseQuantity = Integer.parseInt(scanner.nextLine());
			Calculator calculator = new Calculator();
			while(scanner.hasNext()) {
				int n=scanner.nextInt();
				int p=scanner.nextInt();
				try {
					System.out.println(calculator.power(n, p));
				} catch (Exception ex) {
		        	System.out.println(ex.getMessage());
		        	//System.err.println(ex.getMessage());
		        }
			}
        }
	}
}

class Calculator {

	protected int power(int n, int p) throws Exception {
		if(n<0 || p<0) {throw new Exception("n and p should be non-negative");}
		return (int)Math.pow(n, p);
	}

}