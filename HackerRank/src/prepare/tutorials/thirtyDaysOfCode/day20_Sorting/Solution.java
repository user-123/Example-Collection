package prepare.tutorials.thirtyDaysOfCode.day20_Sorting;

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

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(toList());

		// Write your code here

		bufferedReader.close();



		bubbleSort(a);
		//System.out.println("Array is sorted in " + swap + " swaps.");
		System.out.println("First Element: " + a.get(0));
		System.out.println("Last Element: " + a.get(a.size()-1));
	}

	private static void bubbleSort(List<Integer> nums) {
		int swapCount=0;
		for(int i=0; i<nums.size(); i++) {
			int numberOfSwaps=0;
			for(int j=0; j<nums.size()-1; j++) {
				if(nums.get(j)>nums.get(j+1)) {
					swap(nums, j, j+1);
					numberOfSwaps++;
				}
			}
			if(numberOfSwaps==0) {break;}
			swapCount+=numberOfSwaps;
		}
		System.out.println("Array is sorted in " + swapCount + " swaps.");
	}

	private static void swap(List<Integer> array, int left, int right) {
		int temp=array.get(left);
		array.set(left, array.get(right));
		array.set(right, temp);
	}
}
