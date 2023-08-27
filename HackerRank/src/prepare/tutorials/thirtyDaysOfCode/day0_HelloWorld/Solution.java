package prepare.tutorials.thirtyDaysOfCode.day0_HelloWorld;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		System.out.println("Hello, World.");
		try (Scanner scanner = new Scanner(System.in)) {
			String inputString = scanner.nextLine();
			System.out.println(inputString);
		}
	}
}
