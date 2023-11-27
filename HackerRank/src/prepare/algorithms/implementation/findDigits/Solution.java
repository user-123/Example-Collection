package prepare.algorithms.implementation.findDigits;

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

class Result {

	/*
	 * Complete the 'findDigits' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts INTEGER n as parameter.
	 */

	public static int findDigits(int n) {
	// Write your code here
		int count=0;
		char[] digits = Integer.toString(n).toCharArray();
		for(char digit : digits) {
			int digitValue=digit-'0';
			count += digitValue!=0 && n%digitValue==0 ? 1 : 0;
			//count += digit-'0'!=0 && n%(digit-'0')==0 ? 1 : 0;
		}
		return count;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				int n = Integer.parseInt(bufferedReader.readLine().trim());

				int result = Result.findDigits(n);

				bufferedWriter.write(String.valueOf(result));
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
