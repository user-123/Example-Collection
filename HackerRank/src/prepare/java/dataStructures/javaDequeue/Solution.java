package prepare.java.dataStructures.javaDequeue;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
		Deque deque = new ArrayDeque<>();
		int n = in.nextInt();
		int m = in.nextInt();

		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			deque.offer(num);
		}
		System.out.println(maxQuantityUniqueNumberOfSubarray(deque, m));
	}

	private static int maxQuantityUniqueNumberOfSubarray(Deque<Integer> array, int subArrayLength) {
		int quantity=0;
		Set<Integer> uniqueNums = new HashSet<>();
		Deque<Integer> subArray = new ArrayDeque<>(subArrayLength);
		for(int num : array) {
			subArray.offer(num);
			uniqueNums.add(num);
			if(subArray.size()==subArrayLength) {
				quantity = uniqueNums.size()>quantity ? uniqueNums.size() : quantity;
				int removedNum=subArray.poll();
				if(!subArray.contains(removedNum)) {uniqueNums.remove(removedNum);}
			}
		}
		return quantity;
	}
}