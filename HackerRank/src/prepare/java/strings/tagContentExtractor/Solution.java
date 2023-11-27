package prepare.java.strings.tagContentExtractor;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0) {
			String line = in.nextLine();

			//Write your code here
			String regex="<(.+)>([^<]+)<(/\\1)>";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(line);
			boolean flag=false;
			while(matcher.find()) {
				System.out.println(matcher.group(2));
				flag=true;
			}
			if(!flag) {System.out.println("None");}

			testCases--;
		}
	}
}
