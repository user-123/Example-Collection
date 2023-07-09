package lc000215_KthLargestElementInAnArray;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution998 {

	public Solution998() {}

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i=0;i<nums.length;i++){
			pq.add(nums[i]);
		}
		if (k==1){
			return pq.remove();
		}
		for (int i=1;i<=k-1;i++){
			pq.remove();
		}
		return pq.remove();
	}
}
