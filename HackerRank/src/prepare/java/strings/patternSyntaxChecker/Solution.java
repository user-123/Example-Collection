package prepare.java.strings.patternSyntaxChecker;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		String[] testcases;
		try(Scanner scanner = new Scanner(System.in)) {
			int caseQuantity = scanner.nextInt();
			scanner.nextLine();
			testcases=new String[caseQuantity];
			for(int i=0; i<caseQuantity; i++) {
				testcases[i]=scanner.nextLine();
			}
		}
		for(String testCase : testcases) {
			printPatternSyntaxCheckResult(testCase);
		}
	}

	private static void printPatternSyntaxCheckResult(String pattern) {
		try {
			Pattern.compile(pattern);
			System.out.println("Valid");
		}catch (PatternSyntaxException ex) {
			System.out.println("Invalid");
		}
	}
}