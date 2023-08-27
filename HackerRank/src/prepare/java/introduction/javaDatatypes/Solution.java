package prepare.java.introduction.javaDatatypes;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		String[] input;
		try(Scanner scanner = new Scanner(System.in)) {
			int t=scanner.nextInt();
			input=new String[t];
			scanner.nextLine();
			for(int i=0; i<t; i++) {
				input[i]=scanner.nextLine();
			}
		}
		for(int i=0; i<input.length; i++) {
			String nString=input[i];
			try {
				long n=Long.parseLong(nString);
				System.out.println(nString + " can be fitted in:");
				if(n>=Byte.MIN_VALUE && n<=Byte.MAX_VALUE) {System.out.println("* byte");}
				if(n>=Short.MIN_VALUE && n<=Short.MAX_VALUE) {System.out.println("* short");}
				if(n>=Integer.MIN_VALUE && n<=Integer.MAX_VALUE) {System.out.println("* int");}
				//if(n>=Long.MIN_VALUE && n<=Long.MAX_VALUE) {System.out.println("* long");}
				System.out.println("* long");
			}catch(Exception ex) {
				System.out.println(nString + " can't be fitted anywhere.");
			}
		}
	}
}