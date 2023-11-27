package prepare.java.dataStructures.javaBitSet;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		//BitSet bitArray1, bitArray2;
		BitSet[] bitSet = new BitSet[2];
		try(Scanner scanner = new Scanner(System.in)) {
			int init=scanner.nextInt(), caseCount=scanner.nextInt();
			//bitArray1 = new BitSet(init);
			//bitArray2 = new BitSet(init);
			bitSet[0]=new BitSet(init);
			bitSet[1]=new BitSet(init);
			while(caseCount-- >0) {
				String operation=scanner.next();
				int num1=scanner.nextInt(), num2=scanner.nextInt();
				switch(operation) {
					case "AND" -> bitSet[num1-1].and(bitSet[num2-1]);
					case "OR" -> bitSet[num1-1].or(bitSet[num2-1]);
					case "XOR" -> bitSet[num1-1].xor(bitSet[num2-1]);
					case "FLIP" -> bitSet[num1-1].flip(num2);
					case "SET" -> bitSet[num1-1].set(num2);
					default -> throw new IllegalArgumentException("Illegal Operation");
				}
				//System.out.println(bitSet[0] + " " + bitSet[1]);
				System.out.println(bitSet[0].cardinality() + " " + bitSet[1].cardinality());
			}
		}
	}
}