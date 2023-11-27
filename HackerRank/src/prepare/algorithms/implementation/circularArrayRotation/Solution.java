package prepare.algorithms.implementation.circularArrayRotation;

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
	 * Complete the 'circularArrayRotation' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY.
	 * The function accepts following parameters:
	 *  1. INTEGER_ARRAY a
	 *  2. INTEGER k
	 *  3. INTEGER_ARRAY queries
	 */

	public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
	// Write your code here
		//思路：不需要真的去產生新的array，只要將起始index隨著做k次rotation，(當k<a.size()時)起始index為a.size()-k(如果k==0，a.size()-k==a.size()⇒0)；若是k==a.size()，等於做了一輪變回原本的array；最後在查詢時將query加上偏移量startIndex(超過a.size()的部份，startIndex+queryIndex==a.size()⇒0)
		int startIndex=a.size()-k%a.size();	//這邊正確一點的寫法要再對a.size()-k%a.size()做一次%a.size()，不過因為下面也會執行%a.size()，所以可以順便一起做
		List<Integer> result = new ArrayList<>(queries.size());
		for(int queryIndex : queries) {
			result.add(a.get((startIndex+queryIndex)%a.size()));
		}
		return result;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int k = Integer.parseInt(firstMultipleInput[1]);

		int q = Integer.parseInt(firstMultipleInput[2]);

		List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(toList());

		List<Integer> queries = IntStream.range(0, q).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		})
			.map(String::trim)
			.map(Integer::parseInt)
			.collect(toList());

		List<Integer> result = Result.circularArrayRotation(a, k, queries);

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
