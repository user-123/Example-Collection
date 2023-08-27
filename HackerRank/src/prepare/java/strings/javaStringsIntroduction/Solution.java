package prepare.java.strings.javaStringsIntroduction;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		String a, b;
		try(Scanner scanner = new Scanner(System.in)) {
			a=scanner.nextLine();
			b=scanner.nextLine();
		}
		System.out.println(a.length()+b.length());
		System.out.println(a.compareTo(b)>0 ? "Yes" : "No");
		System.out.println(a.substring(0, 1).toUpperCase() + a.substring(1) + " " + b.substring(0, 1).toUpperCase() + b.substring(1));
	}
}