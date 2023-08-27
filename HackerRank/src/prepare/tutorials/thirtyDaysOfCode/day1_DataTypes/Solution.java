package prepare.tutorials.thirtyDaysOfCode.day1_DataTypes;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		int i=4, i2;
		double d=4.0, d2;
		String s="HackerRank" , s2;
		try (Scanner scanner = new Scanner(System.in)) {
			i2 = Integer.valueOf(scanner.nextLine());
			d2 = Double.valueOf(scanner.nextLine());
			s2 = scanner.nextLine();
			System.out.println((int) (i+i2));
			System.out.println(d+d2);
			System.out.printf("%s %s%n", s, s2);
		}
	}
}
