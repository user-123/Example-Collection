package prepare.dataStructures.arrays.arrayManipulation;

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
	 * Complete the 'arrayManipulation' function below.
	 *
	 * The function is expected to return a LONG_INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER n
	 *  2. 2D_INTEGER_ARRAY queries
	 */

	public static long arrayManipulation(int n, List<List<Integer>> queries) {
	// Write your code here
		long[] array = new long[n];
		for(List<Integer> query : queries) {
			int start=query.get(0)-1, end=query.get(1)-1, addition=query.get(2);
			for(int i=start; i<=end; i++) {
				array[i]+=addition;
			}
		}
		long max=Long.MIN_VALUE;
		for(long num : array) {
			max = num>max ? num : max;
		}
		return max;
	}

	public static long arrayManipulation2(int n, List<List<Integer>> queries) {
		// Write your code here
		//思路：prefix sum(前綴和)
		long[] prefixSum = new long[n+1];	//prefixSum[i]對應的是array[i-1](含)之前的sum
		for(List<Integer> query : queries) {
			int start=query.get(0)-1, end=query.get(1)-1, addition=query.get(2);
			prefixSum[start]+=addition;
			prefixSum[end+1]-=addition;
		}
		long sum=0, max=Long.MIN_VALUE;
		for(long num : prefixSum) {	//此題的prefixSum[0]不會影響結果，"正確的寫法"為for(int i=1; i<=n; i++) {}
			sum+=num;
			max = sum>max ? sum : max;
		}
		return max;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int m = Integer.parseInt(firstMultipleInput[1]);

		List<List<Integer>> queries = new ArrayList<>();

		IntStream.range(0, m).forEach(i -> {
			try {
				queries.add(
					Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt)
						.collect(toList())
				);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		long result = Result.arrayManipulation(n, queries);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
