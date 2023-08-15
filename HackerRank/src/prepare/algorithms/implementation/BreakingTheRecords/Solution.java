package prepare.algorithms.implementation.BreakingTheRecords;

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
	 * Complete the 'breakingRecords' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY.
	 * The function accepts INTEGER_ARRAY scores as parameter.
	 */

	public static List<Integer> breakingRecords(List<Integer> scores) {
	// Write your code here
		//思路：當前的score<當前的min，minCount++，並刷新min；當前的score>當前的max，maxCount++，並刷新max
		List<Integer> result = new ArrayList<>(2);
		int max=scores.get(0), min=scores.get(0), maxCount=0, minCount=0;
		for(int i=1; i<scores.size(); i++) {
			int score=scores.get(i);
			if(score<min) {
				min=score;
				minCount++;
			}
			if(score>max) {
				max=score;
				maxCount++;
			}
		}
		result.add(maxCount);
		result.add(minCount);
		return result;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(toList());

		List<Integer> result = Result.breakingRecords(scores);

		bufferedWriter.write(
			result.stream()
				.map(Object::toString)
				.collect(joining(" "))
			+ "\n"
		);

		bufferedReader.close();
		bufferedWriter.close();
	}
}