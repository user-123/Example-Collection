package prepare.java.strings.javaStringReverse;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		String input;
		try(Scanner scanner = new Scanner(System.in)) {
			input=scanner.nextLine();
		}
		StringBuilder reverse = new StringBuilder(input);
		reverse.reverse();
		System.out.println(input.equals(reverse.toString()) ? "Yes" : "No");
	}
}