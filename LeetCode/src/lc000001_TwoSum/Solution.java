package lc000001_TwoSum;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

	public Solution() {}

	public int[] twoSum(int[] nums, int target) {
		int[] result=new int[2];
		Map<Integer, Integer> numsMap = new HashMap<>();
		//int[] tableArray = new int[table.size()];
		//table.toArray(tableArray);
		for(int i=0; i<nums.length; i++) {
			if(numsMap.containsKey(nums[i])) {
				result[1] = i;
				result[0] = numsMap.get(nums[i]);
				break;
			}
			numsMap.put(target-nums[i], i);
		}
		return result;
	}

}
