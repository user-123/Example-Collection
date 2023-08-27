package prepare.java.introduction.javaIntToString;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		try(Scanner scanner = new Scanner(System.in)) {
			//流程邏輯上，沒有考慮exception的發生，就是當n無法轉為s(s=String.valueOf(n))或s無法轉為int(Integer.parseInt(s))，會拋出NullPointerException或NumberFormatException，雖然這個case永遠不會發生以上情況就是了
			//TODO 應該用try/catch包覆
			final int n=scanner.nextInt();
			final String s=String.valueOf(n);
			if(n==Integer.parseInt(s)) {
				System.out.println("Good job");
			}else {
				System.out.println("Wrong answer.");
			}
		}
	}
}