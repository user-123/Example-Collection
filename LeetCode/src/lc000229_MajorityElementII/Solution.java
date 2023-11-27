package lc000229_MajorityElementII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.Map.Entry;

public class Solution {

	public Solution() {}

	public List<Integer> majorityElement(int[] nums) {
		//思路：雙Boyer–Moore majority vote algorithm(博耶-摩爾多數投票算法)，依照題意只有出現次數大於nums.length/3的數才符合，而符合此條件的num數量最多只會有兩個
		List<Integer> result = new ArrayList<>(2);	//最多只會有兩個
		if(nums==null || nums.length==0) {return result;}
		int firstMajority=Integer.MAX_VALUE, firstSum=0, secondMajority=Integer.MIN_VALUE, secondSum=0;
		for(int num : nums) {
			if(num==firstMajority) {firstSum++;continue;}
			if(num==secondMajority) {secondSum++;continue;}
			if(firstSum==0) {firstMajority=num;firstSum++;continue;}
			if(secondSum==0) {secondMajority=num;secondSum++;continue;}
			firstSum--;
			secondSum--;
		}
		firstSum=secondSum=0;
		for(int num : nums) {
			if(num==firstMajority) {firstSum++;continue;}
			if(num==secondMajority) {secondSum++;}
		}
		if(firstSum>nums.length/3) {result.add(firstMajority);}
		if(secondSum>nums.length/3) {result.add(secondMajority);}
		return result;
	}

	public List<Integer> majorityElement2(int[] nums) {
		//思路：暴力hashMap
		List<Integer> result = new ArrayList<>(2);
		if(nums==null || nums.length==0) {return result;}
		int threshold = nums.length/3;
		Map<Integer, Integer> elementCount = new HashMap<>();
		for(int num : nums) {
			elementCount.put(num, elementCount.getOrDefault(num, 0)+1);
		}
		for(Map.Entry<Integer, Integer> keyValuePair : elementCount.entrySet()) {
			if(keyValuePair.getValue()>threshold) {result.add(keyValuePair.getKey());}
		}
		return result;
	}

}
