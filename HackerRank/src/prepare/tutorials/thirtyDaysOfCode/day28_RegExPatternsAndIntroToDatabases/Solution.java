package prepare.tutorials.thirtyDaysOfCode.day28_RegExPatternsAndIntroToDatabases;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> result = new ArrayList<>(N);

		IntStream.range(0, N).forEach(NItr -> {
			try {
				String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

				String firstName = firstMultipleInput[0];

				String emailID = firstMultipleInput[1];

				if(isLegalEmail(emailID)) {result.add(firstName);}

			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();

		Collections.sort(result);
		for(String name : result) {
			System.out.println(name);
		}
	}

	private static boolean isLegalEmail(String emailAddress) {
		Pattern pattern = Pattern.compile("[a-z]+@gmail.com");
		return matchRegex(emailAddress, pattern);
	}

	private static boolean matchRegex(String string, Pattern regex) {
		Matcher matcher = regex.matcher(string);
		return matcher.find();
		//return regex.matcher(string).find();
	}
}
