package lc002215_FindTheDifferenceOfTwoArrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public Solution() {}

	public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		List<List<Integer>> resultList = new ArrayList<>(2);
		List<Integer> result1 = new ArrayList<>();
		List<Integer> result2 = new ArrayList<>();
		Set<Integer> nums1Difference = new HashSet<>();
		Set<Integer> nums2Difference = new HashSet<>();
		for(int num1 : nums1) {
			nums1Difference.add(num1);
		}
		for(int num2 : nums2) {
			nums2Difference.add(num2);
		}
		for(int num1 : nums1Difference) {
			if(!nums2Difference.contains(num1)) {result1.add(num1);}
		}
		for(int num2 : nums2Difference) {
			if(!nums1Difference.contains(num2)) {result2.add(num2);}
		}
		resultList.add(result1);
		resultList.add(result2);
		return resultList;
	}

}
