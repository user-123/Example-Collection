package lc000239_SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	public Solution() {}

	public int[] maxSlidingWindow(int[] nums, int k) {
		//思路：XXXXXXXXXXXXXXXXXXXX
		if(nums==null || nums.length==0 || k<=0) {return new int[0];}
		int[] result = new int[nums.length-(k-1)];
		//Queue<Integer> pq = new PriorityQueue<>((num1, num2) -> num2-num1);
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i=0; i<nums.length; i++) {
			if(!deque.isEmpty() && deque.peekFirst()<i-k+1) {deque.pollFirst();}
			while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]) {deque.pollLast();}
			deque.offerLast(i);
			if(i>=k-1) {result[i-k+1]=nums[deque.peekFirst()];}
		}
		return result;
	}

	public int[] maxSlidingWindow2(int[] nums, int k) {
		//思路：XXXXXXXXXX
		if(nums==null || nums.length==0 || k<=0) {return new int[0];}
		int[] result = new int[nums.length-(k-1)];
		int maxNumIndex=getMaxNumIndex(nums, k, k-1);
		result[0]=nums[maxNumIndex];
		for(int i=k; i<nums.length; i++) {
			if(i-(k-1)>maxNumIndex) {
				maxNumIndex=getMaxNumIndex(nums, k, i);
			}else if(nums[i]>nums[maxNumIndex]) {
				maxNumIndex=i;
			}
			result[i-(k-1)]=nums[maxNumIndex];
		}
		return result;
	}

	private int getMaxNumIndex(int[] nums, int windowSize, int rightIndex) {
		int maxNumIndex=rightIndex;
		for(int i=rightIndex; i>rightIndex-windowSize; i--) {
			maxNumIndex = nums[i]>nums[maxNumIndex] ? i : maxNumIndex;
		}
		return maxNumIndex;
	}

}
