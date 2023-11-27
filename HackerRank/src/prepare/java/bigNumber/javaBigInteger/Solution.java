package prepare.java.bigNumber.javaBigInteger;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		BigInteger a, b;
		try(Scanner scanner = new Scanner(System.in)) {
			a=new BigInteger(scanner.nextLine());
			b=new BigInteger(scanner.nextLine());
		}
		System.out.println(a.add(b));
		System.out.println(a.multiply(b));
	}
}
