package prepare.java.introduction.javaStdinAndStdoutII;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		int integer;
		double doubleNum;
		String string;
		try(Scanner scanner = new Scanner(System.in)) {
			integer=scanner.nextInt();
			doubleNum=scanner.nextDouble();
			scanner.nextLine();
			string=scanner.nextLine();
		}
		System.out.println("String: " + string);
		System.out.println("Double: " + doubleNum);
		System.out.println("Int: " + integer);
	}
}