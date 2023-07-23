package prepare.tutorials.tenDaysOfStatistics.day0_MeanMedianAndMode;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

		//sum
		int arrayLength, sum=0;
		int[] array;
		try (Scanner scanner = new Scanner(System.in)) {
			arrayLength = Integer.valueOf(scanner.nextLine());
			array = new int[arrayLength];
			for(int i=0; i<arrayLength; i++) {
				array[i] = scanner.nextInt();
				sum+=array[i];
			}
		}

		//sort
		Arrays.sort(array);

		//median
		int medianIndex = (arrayLength-1) /2;
		double median;
		if(arrayLength%2!=0) {
			median=array[medianIndex];
		}else {
			median=(double)(array[medianIndex]+array[medianIndex+1]) /2;
		}

		//mode
		Map<Integer, Integer> usedCount = new HashMap<>();
		for(int value : array) {
			usedCount.put(value, usedCount.getOrDefault(value, 0)+1);
		}
		int maxUsed = 0, mode=Integer.MAX_VALUE;
		List<Integer> maxUsedCount = new ArrayList<>();
		usedCount.forEach((k, v) -> maxUsedCount.add(v));	//usedCount.forEach((k, v) -> {Math.max(v, maxUsed);});
		for(int count : maxUsedCount) {
			maxUsed=Math.max(count, maxUsed);
		}
		for(Map.Entry<Integer, Integer> entry : usedCount.entrySet()) {
			if(entry.getValue()==maxUsed) {
				mode=Math.min(entry.getKey(), mode);
			}
		}

		//輸出
		//平均值(mean)
		System.out.println((double)sum /arrayLength);
		//中位數(median)
		System.out.println(median);
		//眾數(mode)
		System.out.println(mode);
	}
}
