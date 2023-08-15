package prepare.tutorials.thirtyDaysOfCode.day29_BitwiseAND;

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
	 * Complete the 'bitwiseAnd' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER N
	 *  2. INTEGER K
	 */

	public static int bitwiseAnd(int N, int K) {
	// Write your code here
		//思路：&運算，若想得到最大則必定會是兩個1盡量靠高位，待觀察規律
		Set<Integer> result = new HashSet<>();
		//TODO
		return 0;
	}
	public static int bitwiseAnd2(int N, int K) {
		//思路：遍歷解
		Set<Integer> resultSet = new HashSet<>();
		for(int n=1; n<=N; n++) {
			for(int m=n+1; m<=N; m++) {
				resultSet.add(n&m);
			}
		}
		int result=0;
		for(int element : resultSet) {
			result = element<K && element>result ? element : result ;
		}
		return result;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

				int count = Integer.parseInt(firstMultipleInput[0]);

				int lim = Integer.parseInt(firstMultipleInput[1]);

				int res = Result.bitwiseAnd(count, lim);

				bufferedWriter.write(String.valueOf(res));
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}