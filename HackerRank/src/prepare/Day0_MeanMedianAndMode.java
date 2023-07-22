package prepare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day0_MeanMedianAndMode {

	public Day0_MeanMedianAndMode() {}

	public static void main(String[] args) {

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

		//平均值(mean)
		System.out.println((double)sum /arrayLength);
		//中位數(median)
		System.out.println(median);
		//眾數(mode)
		System.out.println(mode);

	}

}
