package lc000373_FindKPairsWithSmallestSums;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	public Solution() {}

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		int nums1Quantity=nums1.length, nums2Quantity=nums2.length;
		List<List<Integer>> resultList = new ArrayList<>(k);
		if(nums1Quantity==0 || nums2Quantity==0) {return resultList;}
		//l=0, i=0, j=0
		//l=1, i=1, j=0
		//l=1, i=0, j=1
		//l=2, i=0, j=2
		//l=2, i=1, j=1
		//l=2, i=2, j=0
		//l=3, i=1, j=2
		//l=3, i=2, j=1
		//l=4, id=2, j=2
		Queue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
			return (nums1[o1[0]]+nums2[o1[1]]) - (nums1[o2[0]]+nums2[o2[1]]);
			}
		});

		for(int i=0; i<nums1Quantity; i++) {
			priorityQueue.add(new int[] {i, 0});
		}

		priorityQueue.size();

		for(int i=0; i<Math.min(k, nums1Quantity*nums2Quantity); i++) {
			int[] pair = priorityQueue.remove();
			if(pair[1]<nums2Quantity-1) {
				priorityQueue.add(new int[] {pair[0], pair[1]+1});
			}
			List<Integer> result = new ArrayList<>(2);
			result.add(nums1[pair[0]]);
			result.add(nums2[pair[1]]);
			resultList.add(result);
		}



		return resultList;
	}

}
