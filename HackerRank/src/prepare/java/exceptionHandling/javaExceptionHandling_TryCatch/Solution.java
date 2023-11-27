package prepare.java.exceptionHandling.javaExceptionHandling_TryCatch;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		try(Scanner scanner = new Scanner(System.in)) {
			int x=scanner.nextInt(), y=scanner.nextInt();
			System.out.println(x/y);
		}catch (InputMismatchException ex) {
			System.out.println(ex.getClass().getName());
		}catch (ArithmeticException ex) {
			System.out.println(ex);
		}
	}
}