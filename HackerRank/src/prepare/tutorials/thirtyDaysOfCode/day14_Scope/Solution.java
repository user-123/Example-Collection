package prepare.tutorials.thirtyDaysOfCode.day14_Scope;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		int elementsQuantity;
		int[] array;
		try (Scanner scanner = new Scanner(System.in)) {
			elementsQuantity=Integer.valueOf(scanner.nextLine());
			array=new int[elementsQuantity];
			for(int i=0; i<elementsQuantity; i++) {
				array[i]=scanner.nextInt();
			}
        }
		Difference difference = new Difference(array);
		System.out.println(difference.getMaximumDifference());
	}

}
class Difference {
	private int[] elements;
	private int maximumDifference;

	public Difference(int[] elements) {
		this.elements=elements;
		this.maximumDifference=calculateMaxDifference();
	}

	private int calculateMaxDifference() {
		//int maxNum = Arrays.stream(elements).max().getAsInt();
		//int minNum = Arrays.stream(elements).min().getAsInt();
		int maxNum=Integer.MIN_VALUE, minNum=Integer.MAX_VALUE;
		for(int num : elements) {
			maxNum = num>maxNum ? num : maxNum;
			minNum = num<minNum ? num : minNum;
		}
		return maxNum-minNum;
	}

	public int[] getElements() {
		return elements;
	}

	public int getMaximumDifference() {
		return maximumDifference;
	}
}