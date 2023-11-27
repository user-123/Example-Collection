package prepare.algorithms.implementation.sequenceEquation;

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
	 * Complete the 'permutationEquation' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY.
	 * The function accepts INTEGER_ARRAY p as parameter.
	 */

	public static List<Integer> permutationEquation(List<Integer> p) {
	// Write your code here
		Map<Integer, Integer> indexOfNum = new HashMap<>();
		for(int i=1; i<=p.size(); i++) {
			indexOfNum.put(p.get(i-1), i);
		}
		//List<Integer> y = new ArrayList<>(Collections.nCopies(p.size(), 0));	//注意：不能用new ArrayList<>(p.size());，因為array尚未初始化(填0或其它)，所以如果直接set會報錯
		Integer[] y = new Integer[p.size()];
		for(int i=1; i<=p.size(); i++) {
			//y.set(i-1, indexOfNum.get(indexOfNum.get(i)));
			y[i-1]=indexOfNum.get(indexOfNum.get(i));
		}
		//return y;
		return Arrays.asList(y);
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> p = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(toList());

		List<Integer> result = Result.permutationEquation(p);

		bufferedWriter.write(
			result.stream()
				.map(Object::toString)
				.collect(joining("\n"))
			+ "\n"
		);

		bufferedReader.close();
		bufferedWriter.close();
	}
}
