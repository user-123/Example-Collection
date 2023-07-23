package prepare.tutorials.tenDaysOfStatistics.day1_InterquartileRange;

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
	 * Complete the 'interQuartile' function below.
	 *
	 * The function accepts following parameters:
	 *  1. INTEGER_ARRAY values
	 *  2. INTEGER_ARRAY freqs
	 */

	public static void interQuartile(List<Integer> values, List<Integer> freqs) {
	// Print your answer to 1 decimal place within this function
		List<Integer> array = getUncompressedArray(values, freqs);
		List<Double> quartilesIndex = getQuartilesIndex(array.size());
		List<Double> quartilesValue = getQuartilesValue(array, quartilesIndex);
		DecimalFormat df = new DecimalFormat("0.0");
		System.out.println(df.format(quartilesValue.get(2)-quartilesValue.get(0)));
	}

	private static List<Integer> getUncompressedArray(List<Integer> valuesArray, List<Integer> freqsArray) {
		List<Integer> uncompressedArray = new ArrayList<>();
		for(int i=0; i<valuesArray.size(); i++) {
			int value = valuesArray.get(i), frequency = freqsArray.get(i);
			while(frequency>0) {
				uncompressedArray.add(value);
				frequency--;
			}
		}
		return uncompressedArray;
	}

	private static List<Double> getQuartilesIndex(int arrayLength) {
		List<Double> quartilesIndex = new ArrayList<>(3);
		double q2Index=getMedianIndex(0, arrayLength-1);
		double q1Index=getMedianIndex(0, q2Index/(int)q2Index==1 ? (int)q2Index-1 : (int)q2Index);
		double q3Index=getMedianIndex((int)q2Index+1, arrayLength-1);	//注意：這裡不要忘記，double轉int會將小數位無條件捨去，假設medianIndex為4.5，那後半段的array start會是5，所以需要+1		//q2Index/(int)q2Index==1 ? (int)q2Index+1 : (int)q2Index+1
		quartilesIndex.add(q1Index);
		quartilesIndex.add(q2Index);
		quartilesIndex.add(q3Index);
		return quartilesIndex;
	}

	private static double getMedianIndex(int startIndex, int endIndex) {
		return startIndex+(endIndex-startIndex)/2.0;
	}

	private static List<Double> getQuartilesValue(List<Integer> array, List<Double> quartilesIndex) {
		List<Double> quartilesValue = new ArrayList<>(3);
		array.sort(Comparator.naturalOrder());
		//arr.sort((num1, num2) -> num1-num2);
		//Collections.sort(arr);
		for(double qIndex : quartilesIndex) {
			double quartile;
			if(qIndex/(int)qIndex==1) {
				quartile=array.get((int)qIndex);
			}else {
				quartile=( array.get((int)qIndex) + array.get((int)qIndex+1) )/2;
			}
			quartilesValue.add(quartile);
		}
		return quartilesValue;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> val = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(toList());

		List<Integer> freq = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(toList());

		Result.interQuartile(val, freq);

		bufferedReader.close();
	}
}
