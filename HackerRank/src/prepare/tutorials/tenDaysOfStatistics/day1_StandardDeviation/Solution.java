package prepare.tutorials.tenDaysOfStatistics.day1_StandardDeviation;

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
	 * Complete the 'stdDev' function below.
	 *
	 * The function accepts INTEGER_ARRAY arr as parameter.
	 */

	public static void stdDev(List<Integer> arr) {
	// Print your answers to 1 decimal place within this function

		DecimalFormat df = new DecimalFormat("0.0");
		System.out.println(df.format(getStandardDeviation(arr)));
	}

	private static double getStandardDeviation(List<Integer> array) {
		//變異數：variance，標準差：standard deviation，變異數是標準差的平方
		double variance=0, avg = getAverage(array);
		for(int num : array) {
			variance+=Math.pow(num-avg, 2);
		}
		variance/=array.size();
		return Math.sqrt(variance);
	}

	private static double getAverage(List<Integer> array) {
		//mean = average
		int sum = getSum(array);
		return (double)sum /array.size();
	}

	private static int getSum(List<Integer> array) {
		int sum=0;
		for(int num : array) {
			sum+=num;
		}
		return sum;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> vals = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(toList());

		Result.stdDev(vals);

		bufferedReader.close();
	}
}
