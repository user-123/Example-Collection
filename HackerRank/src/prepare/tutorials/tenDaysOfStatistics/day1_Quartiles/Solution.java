package prepare.tutorials.tenDaysOfStatistics.day1_Quartiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;
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
	 * Complete the 'quartiles' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY.
	 * The function accepts INTEGER_ARRAY arr as parameter.
	 */

	public static List<Integer> quartiles(List<Integer> arr) {
		// Write your code here
		//思路：double medianIndex = startIndex+(endIndex-startIndex)/2 = (startIndex+endIndex)/2		//當array長度在Integer.MAX_VALUE的三分之二以上，則不推薦使用相加除2的計算方法，會overflow
		//firstQuartile(first/lowerHalfMedian): q1, secondQuartile(median): q2, thirdQuartile(second/upperHalfMedian): q3;
		int length=arr.size(), q2, q1, q3;	//這裡q1、q2、q3應該用double，不過依照題意使用int
		List<Double> quartilesIndex = getQuartilesIndex(length);
		return getQuartilesValue(arr, quartilesIndex);
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

	private static List<Integer> getQuartilesValue(List<Integer> array, List<Double> quartilesIndex) {
		List<Integer> quartilesValue = new ArrayList<>(3);
		array.sort(Comparator.naturalOrder());
		//arr.sort((num1, num2) -> num1-num2);
		//Collections.sort(arr);
		for(double qIndex : quartilesIndex) {
			int quartile;
			if(qIndex/(int)qIndex==1) {
				quartile=array.get((int)qIndex);
			}else {
				quartile=( array.get((int)qIndex) + array.get((int)qIndex+1) )/2;
			}
			quartilesValue.add(quartile);
		}
		return quartilesValue;
	}

	public static List<Integer> quartiles2(List<Integer> arr) {
		//思路：參考別人的邏輯改寫(https://www.hackerrank.com/rest/contests/master/challenges/s10-quartiles/hackers/ajjgabriel/download_solution)
		//待測試
		List<Integer> result = new ArrayList<>(3);
		int numberOfInput = arr.size(), q1, q2, q3;
		arr.sort(null);

        int second = numberOfInput/4;
        int third = numberOfInput/2;
        //2nd
        if(third%2 == 0){
            q1=(arr.get(second - 1) + arr.get(second)) / 2;
        }else{
        	q1=arr.get(second);
        }

        //third

        if(numberOfInput%2 == 0){
        	q2=(arr.get(third - 1) + arr.get(third)) / 2;
        }else{
        	q2=arr.get(third);
        }


        //fourth
        if(numberOfInput%2 == 1){
            third = third + 1;
        }

        int fourth = numberOfInput - third;
        int fourthHalf = fourth/2 + third;
        if(fourth%2 == 0){
            q3=(arr.get(fourthHalf - 1) + arr.get(fourthHalf)) / 2;
        }else{
        	q3=arr.get(fourthHalf);
        }


		return result;
	}

}



public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> data = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(toList());

		List<Integer> res = Result.quartiles(data);

		bufferedWriter.write(
			res.stream()
				.map(Object::toString)
				.collect(joining("\n"))
			+ "\n"
		);

		bufferedReader.close();
		bufferedWriter.close();
	}

}