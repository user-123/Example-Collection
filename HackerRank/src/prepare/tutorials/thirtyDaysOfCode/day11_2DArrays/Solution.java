package prepare.tutorials.thirtyDaysOfCode.day11_2DArrays;

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



		System.out.println(getMaxHourglassesValue(arr));
	}

	private static int getMaxHourglassesValue(List<List<Integer>> matrix) {
		int height=matrix.size(), width=matrix.get(0).size(), row=0, col=0, maxSum=Integer.MIN_VALUE;
		if(height<3 || width<3) {return 0;}	//此題不需要這個判斷，因為已經限制輸入matrix必為6x6
		while(row<=height-3) {
			while(col<=width-3) {
				int sum = matrix.get(row).get(col)+matrix.get(row).get(col+1)+matrix.get(row).get(col+2)+matrix.get(row+1).get(col+1)+matrix.get(row+2).get(col)+matrix.get(row+2).get(col+1)+matrix.get(row+2).get(col+2);
				maxSum=Math.max(sum, maxSum);
				col++;
			}
			col=0;
			row++;
		}
		return maxSum;
	}
}
