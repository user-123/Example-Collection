package lc000215_KthLargestElementInAnArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution99 {

	public Solution99() {}

	public int findKthLargest(int[] nums, int k) {
		return k<0 || nums.length==0 || nums.length<k ? -2147483648 : partition (nums, k);
	}

	public int partition(int[] nums, int targetNum) {
		System.out.println("nums");
		System.out.println(Arrays.toString(nums));
		System.out.print("targetNum");
		System.out.println(targetNum);
		if(nums.length==1) {return nums[0];}
		Integer result = null;
		if(targetNum==1) {
			for (int num : nums) {
				if(result==null || result<num) {result=num;}
			}
			return result;
		}
		if(targetNum==nums.length || targetNum==0) {
			for (int num : nums) {
				if(result==null || result>num) {result=num;}
			}
			return result;
		}
		int pivot = nums[(int) (Math.random()*nums.length)];
		List<Integer> greaterNums = new ArrayList<>();
		List<Integer> lesserNums = new ArrayList<>();
		for(int num : nums) {
			if(num>=pivot) {greaterNums.add(num);continue;}
			lesserNums.add(num);
		}
		System.out.print("greaterNums");
		System.out.println(greaterNums);
		System.out.print("lesserNums");
		System.out.println(lesserNums);
		if(greaterNums.isEmpty()) {
			Map<Integer, Integer> lesserNumsMap = new HashMap<>();
			lesserNums.forEach(num -> {
				Integer counts = lesserNumsMap.get(num);
				lesserNumsMap.put(num, counts == null ? 1 : ++counts);
			});
			Set<Integer> lesserNumsWithoutDuplicates = lesserNumsMap.keySet();
			if(lesserNumsWithoutDuplicates.size()==1) {
				return lesserNumsWithoutDuplicates.iterator().next();
			}else {
				Integer antiPivot = null;
				for(int numForPivot : lesserNumsWithoutDuplicates) {
					if(antiPivot  == null || lesserNumsMap.get(antiPivot)<lesserNumsMap.get(numForPivot)) {
						antiPivot = numForPivot;
					}
				}
				result = partition(lesserNums, targetNum, antiPivot);
			}
		}else if(lesserNums.isEmpty()) {
			Map<Integer, Integer> greaterNumsMap = new HashMap<>();
			greaterNums.forEach(num -> {
				Integer counts = greaterNumsMap.get(num);
				greaterNumsMap.put(num, counts == null ? 1 : ++counts);
			});
			Set<Integer> greaterNumsWithoutDuplicates = greaterNumsMap.keySet();
			if(greaterNumsWithoutDuplicates.size()==1) {
				return greaterNumsWithoutDuplicates.iterator().next();
			}else {
				Integer antiPivot = null;
				for(int numForPivot : greaterNumsWithoutDuplicates) {
					if(antiPivot  == null || greaterNumsMap.get(antiPivot)<greaterNumsMap.get(numForPivot)) {
						antiPivot = numForPivot;
					}
				}
				result = partition(greaterNums, targetNum, antiPivot);
			}
		}else if(greaterNums.size()>=targetNum) {
			int[] greaterNumsArray = greaterNums.stream().mapToInt(Integer::intValue).toArray();
			result = partition(greaterNumsArray, targetNum);
		}else{
			int[] lesserNumsArray = lesserNums.stream().mapToInt(Integer::intValue).toArray();
			result = partition(lesserNumsArray, targetNum-greaterNums.size());
		}
		return result;
	}

	public int partition(List<Integer> nums, int targetNum, int antiPivot) {

		System.out.println("nums");
		System.out.println(nums);
		System.out.print("targetNum");
		System.out.println(targetNum);
		System.out.println(nums);
		System.out.print("antiPivot");
		System.out.println(antiPivot);
		Integer result = null;
		int pivot;
		do{
			pivot = nums.get((int) (Math.random()*nums.size()));
		}while(pivot==antiPivot);
		List<Integer> greaterNums = new ArrayList<>();
		List<Integer> lesserNums = new ArrayList<>();
		for(int num : nums) {
			if(num>=pivot) {greaterNums.add(num);continue;}
			lesserNums.add(num);
		}
		System.out.print("greaterNums");
		System.out.println(greaterNums);
		System.out.print("lesserNums");
		System.out.println(lesserNums);
		if(greaterNums.size()>=targetNum) {
			int[] greaterNumsArray = greaterNums.stream().mapToInt(Integer::intValue).toArray();
			result = partition(greaterNumsArray, targetNum);
		}else {
			int[] lesserNumsArray = lesserNums.stream().mapToInt(Integer::intValue).toArray();
			result = partition(lesserNumsArray, targetNum-greaterNums.size());
		}
		return result;
	}

	public int partition2(List<Integer> nums, int targetNum) {
		if(nums.size()==1) {return nums.get(0);}
		Integer result = null;
		if(targetNum==1) {
			for (int num : nums) {
				if(result==null || result<num) {result=num;}
			}
			return result;
		}
		int pivot = nums.get((int) (Math.random()*nums.size()));
		List<Integer> greaterNums = new ArrayList<>();
		List<Integer> lesserNums = new ArrayList<>();
		for(int num : nums) {
			if(num>=pivot) {greaterNums.add(num);continue;}
			lesserNums.add(num);
		}
		if(greaterNums.size()>=targetNum) {
			result = partition2(greaterNums, targetNum);
		}else {
			result = partition2(lesserNums, targetNum-greaterNums.size());
		}
		return result;
	}

}
