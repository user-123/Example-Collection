package prepare.tutorials.thirtyDaysOfCode.day27_Testing;

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



//思路：此題有問題且題意不清，依照現已知題意，猜測編碼需求，實際需求去問問出題者吧；純粹要過測的話main方法加一條 System.out.println("OK"); 就行啦XDDD
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

				int n = Integer.parseInt(firstMultipleInput[0]);

				int k = Integer.parseInt(firstMultipleInput[1]);

				List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
					.map(Integer::parseInt)
					.collect(toList());
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();


		/*
		TestWithEmptyArray();
		TestWithUniqueValues();
		TestWithExactlyTwoDifferentMinimums();
		System.out.println("OK");
		*/
	}

	public static int minimum_index(int[] seq) {
		if(seq.length==0) {throw new IllegalArgumentException("Cannot get the minimum value index from an empty sequence");}
		int min_idx=0;
		for(int i=1; i<seq.length; i++) {
			min_idx = seq[i]<seq[min_idx] ? i : min_idx;
		}
		return min_idx;
	}

	public static void TestWithEmptyArray() {
		try {
			int[] seq=TestDataEmptyArray.get_array();
			int result=minimum_index(seq);
		} catch (IllegalArgumentException ex) {
			//ex.printStackTrace();
			return;
		}
		throw new AssertionError("Exception wasn't thrown as expected");
	}
	public static void TestWithUniqueValues() {
		int[] seq=TestDataUniqueValues.get_array();
		if(seq.length<2) {throw new AssertionError("less than 2 elements in the array");}
		Integer[] tmp = new Integer[seq.length];
		for(int i=0; i<seq.length; i++) {
			tmp[i]=Integer.valueOf(seq[i]);
		}
		if(!(new HashSet<Integer>(Arrays.asList(tmp)).size()==seq.length)) {throw new AssertionError("not all values are unique");}
		int expectedResult=TestDataUniqueValues.get_expected_result();
		int result=minimum_index(seq);
		if(result!=expectedResult) {throw new AssertionError("result is different than the expected result");}
	}
	public static void TestWithExactlyTwoDifferentMinimums() {
		int[] seq=TestDataExactlyTwoDifferentMinimums.get_array();
		if(seq.length<2) {throw new AssertionError("less than 2 elements in the array");}
		int[] tmp=seq.clone();
		Arrays.sort(tmp);
		if(tmp[0]!=tmp[1] || tmp.length!=2 && tmp[1]==tmp[2]) {	//if (!(tmp[0]==tmp[1] && (tmp.length==2 || tmp[1]!=tmp[2]))) {
			throw new AssertionError("there are not exactly two minimums in the array");
		}
		int expectedResult=TestDataExactlyTwoDifferentMinimums.get_expected_result();
		int result=minimum_index(seq);
		if(result!=expectedResult) {throw new AssertionError("result is different than the expected result");}
	}

	static class TestDataEmptyArray {
		private static int[] get_array() {
			return new int[0];
		}
	}

	static class TestDataUniqueValues {
		private static Integer minNum;
		private static Integer minNumMinIndex;
		private static int[] get_array() {
			int arrayLength=(int)(Math.random()*(Integer.MAX_VALUE-2+1)+2);
			int[] array = new int[arrayLength];
			Set<Integer> numSet = new HashSet<>(arrayLength);
			long valueMaximum = Integer.MAX_VALUE, valueMinimum = Integer.MIN_VALUE;
			minNum=Integer.MAX_VALUE;
			while(numSet.size()<arrayLength) {
				int numRandom = (int) (Math.random()*(valueMaximum-valueMinimum+1)+valueMinimum);
				numSet.add(numRandom);
				minNum = numRandom<minNum ? numRandom : minNum;
			}
			int index=0;
			for(int num : numSet) {
				if(num==minNum) {minNumMinIndex=index;}
				array[index++]=num;
			}
			return array;
		}
		private static int get_expected_result() {
			return minNumMinIndex;
		}
	}

	static class TestDataExactlyTwoDifferentMinimums {
		private static Integer minNum;
		private static Integer minNumMinIndex;
		private static int[] get_array() {
			int arrayLength=(int)(Math.random()*(Integer.MAX_VALUE-2+1)+2);
			int[] array = new int[arrayLength];
			Set<Integer> numSet = new HashSet<>(arrayLength-1);
			long valueMaximum = Integer.MAX_VALUE, valueMinimum = Integer.MIN_VALUE;
			minNum=Integer.MAX_VALUE;
			while(numSet.size()<arrayLength-1) {
				int numRandom = (int) (Math.random()*(valueMaximum-valueMinimum+1)+valueMinimum);
				numSet.add(numRandom);
				minNum = numRandom<minNum ? numRandom : minNum;
			}
			int index=0, randomIndex=(int)(Math.random()*(arrayLength-0+1)+0);
			for(int num : numSet) {
				if(index==randomIndex) {
					minNumMinIndex = minNumMinIndex==null ? index : minNumMinIndex;
					array[index++]=minNum;
				}
				if(num==minNum) {minNumMinIndex = minNumMinIndex==null ? index : minNumMinIndex;}
				array[index++]=num;
			}
			return array;
		}
		private static int get_expected_result() {
			return minNumMinIndex;
		}
	}
}
