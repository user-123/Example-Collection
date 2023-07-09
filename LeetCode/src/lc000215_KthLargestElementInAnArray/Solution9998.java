package lc000215_KthLargestElementInAnArray;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution9998 {

	public Solution9998() {}

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i=0;i<nums.length;i++){
			pq.add(nums[i]);
		}
		int output=0;
		for (int i=1;i<=k;i++){
			output=pq.remove();
			if (i==k){
				return output;
			}
		}
		return output;
	}
}
