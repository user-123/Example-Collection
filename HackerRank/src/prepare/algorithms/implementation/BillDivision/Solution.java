package prepare.algorithms.implementation.BillDivision;

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
	 * Complete the 'bonAppetit' function below.
	 *
	 * The function accepts following parameters:
	 *  1. INTEGER_ARRAY bill
	 *  2. INTEGER k
	 *  3. INTEGER b
	 */

	public static void bonAppetit(List<Integer> bill, int k, int b) {
	// Write your code here
		/*
		double sum=0.0;
		for(int perBill : bill) {
			sum+=perBill;
		}
		double difference=b-(sum-bill.get(k))/2;
		DecimalFormat df = new DecimalFormat("#.#");
		System.out.println(difference==0 ? "Bon Appetit" : df.format(difference));
		*/
		//因為有約束條件，The amount of money due Anna will always be an integer，所以不需考慮小數的問題
		int sum=0;
		for(int perBill : bill) {
			sum+=perBill;
		}
		int difference=b-(sum-bill.get(k))/2;
		System.out.println(difference==0 ? "Bon Appetit" : difference);
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int k = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(toList());

		int b = Integer.parseInt(bufferedReader.readLine().trim());

		Result.bonAppetit(bill, k, b);

		bufferedReader.close();
	}
}
