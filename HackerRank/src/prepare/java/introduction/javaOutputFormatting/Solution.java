package prepare.java.introduction.javaOutputFormatting;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		System.out.printf("================================%n");
		try(Scanner scanner = new Scanner(System.in)) {
			while(scanner.hasNext()) {
				String string = scanner.next();
				int num = scanner.nextInt();
				System.out.printf("%-15s%03d%n", string, num);	//%-15s代表寬度或長度15；%03d代表長度3位數，不足補0，%n換行
			}
		}
		System.out.printf("================================%n");
	}
}