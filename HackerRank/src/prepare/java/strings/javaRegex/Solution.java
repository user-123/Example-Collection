package prepare.java.strings.javaRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

class Solution{

	public static void main(String[] args){
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		try(Scanner scanner = new Scanner(System.in)) {
			while(scanner.hasNext()){
				String ip = scanner.next();
				System.out.println(ip.matches(new MyRegex().pattern));
			}
		}
	}
}


class MyRegex {
	protected String pattern;

	protected MyRegex() {
		this.pattern = "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";	//IP的正則表達式
	}
}