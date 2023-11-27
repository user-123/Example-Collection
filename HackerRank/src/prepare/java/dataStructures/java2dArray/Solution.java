package prepare.java.dataStructures.java2dArray;

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



public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		List<List<Integer>> arr = new ArrayList<>();

		IntStream.range(0, 6).forEach(i -> {
			try {
				arr.add(
					Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt)
						.collect(toList())
				);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();

		System.out.println(maxHourglassSum(arr));
	}

	private static int maxHourglassSum(List<List<Integer>> matrix) {
		int sum, maxSum=Integer.MIN_VALUE;
		if(matrix==null || matrix.size()<3) {return 0;}
		for(int i=0; i<matrix.size()-2; i++) {
			for(int j=0; j<matrix.get(0).size()-2; j++) {
				sum = matrix.get(i).get(j)+matrix.get(i).get(j+1)+matrix.get(i).get(j+2)+matrix.get(i+1).get(j+1)+matrix.get(i+2).get(j)+matrix.get(i+2).get(j+1)+matrix.get(i+2).get(j+2);
				maxSum = sum>maxSum ? sum : maxSum;
			}
		}
		return maxSum;
	}
}
