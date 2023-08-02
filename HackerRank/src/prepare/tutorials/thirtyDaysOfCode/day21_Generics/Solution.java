package prepare.tutorials.thirtyDaysOfCode.day21_Generics;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		int array1Length, array2Length;
		Integer[] intArray;
		String[] stringArray;
		try (Scanner scanner = new Scanner(System.in)) {
			array1Length=scanner.nextInt();
			intArray = new Integer[array1Length];
			for(int i=0; i<array1Length; i++) {
				intArray[i]=scanner.nextInt();
			}

			array2Length=scanner.nextInt();
			stringArray = new String[array2Length];
			for(int i=0; i<array2Length; i++) {
				stringArray[i]=scanner.next();
			}
        }
		//思路：兩個方法達成，一個封裝成method，一個進一步封裝成class

		/*
		Printer<Integer> intPrinter = new Printer<>(intArray);
		Printer<String> stringPrinter = new Printer<>(stringArray);
		*/

		printArray(intArray);
		printArray(stringArray);
	}

	private static <T> void printArray(T[] array) {
		//方法：寫一個接受泛型輸入的方法
		for(T element : array) {
			System.out.println(element);
		}
	}
}

class Printer <T> {
	//方法：寫一個使用泛型的class
	protected Printer(T[] array) {
		//建構子直接呼叫printArray
		printArray(array);
	}

	private void printArray(T[] array) {
		for(T element : array) {
			System.out.println(element);
		}
	}
}