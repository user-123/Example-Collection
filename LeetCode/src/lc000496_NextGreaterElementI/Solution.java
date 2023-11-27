package lc000496_NextGreaterElementI;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	public Solution() {}

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		//思路：有點抽象，我不知道怎麼描述，大方向就是利用stack特性去找尋num下個大於num的數字，monotonic Stack的概念
		Deque<Integer> stack = new ArrayDeque<>(nums2.length);
		Map<Integer, Integer> map = new HashMap<>(nums2.length);
		for(int num : nums2) {
			while(!stack.isEmpty() && stack.peek()<num) {
				map.put(stack.pop(), num);
			}
			stack.push(num);
		}
		int[] result = new int[nums1.length];
		for(int i=0; i<nums1.length; i++) {
			result[i]=map.getOrDefault(nums1[i], -1);
		}
		return result;
	}

}
