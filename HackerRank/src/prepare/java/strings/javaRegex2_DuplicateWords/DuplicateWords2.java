package prepare.java.strings.javaRegex2_DuplicateWords;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWords2 {	//TODO

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";	/* Write a RegEx matching repeated words here. */
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE	/* Insert the correct Pattern flag here.*/);	//參考：https://www.hackerrank.com/challenges/duplicate-word/forum

		Scanner in = new Scanner(System.in);
		int numSentences = Integer.parseInt(in.nextLine());

		while (numSentences-- > 0) {
			String input = in.nextLine();

			Matcher m = p.matcher(input);

			// Check for subsequences of input that match the compiled pattern
			while (m.find()) {
				input = input.replaceAll(m.group()	/* The regex to replace */, m.group(1)	/* The replacement. */);
			}

			// Prints the modified sentence.
			System.out.println(input);
		}

		in.close();
	}
}