package lc000215_KthLargestElementInAnArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	public Solution() {}

	public int findKthLargest(int[] nums, int k) {
		//直覺想到分治法，畢竟我學過的排序最高效的就是它@@
		//思路：
		//假設給定目標是第40大，array有100項
		//隨機取一個數當pivot，分完後如果，
		//1.大於pivot的數有30個，顯然小於40的目標，所以捨棄大於的，並在小於之中取新的pivot
		//2.大於pivot的數有50個，捨棄小於的，取大於的，並在之中取新的pivot
		//使用遞迴大法，quickSort時間複雜度是O(nlogn)，而題目要求O(N)
		//我思來想去這應該算"二分搜尋法"(學藝不精QQ，我不知道名字，不過有找到一個名字叫"Prune and Search"，應該就它了吧)的概念吧，因為資料是無序的，時間複雜度為O(2n-1)=O(n)，有待確認確切名字XDDDDDD
		//├─────────┼─────────┤

		return k<0 || nums.length==0 || nums.length<k ? -2147483648 : partition (nums, k);
	}

	public int partition(int[] nums, int targetNum) {
		System.out.println(Arrays.toString(nums));
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
		//int pivot = nums[nums.length/2+1-1];
		//int[] greaterNums = new int[100];
		//int[] lesserNums = new int[100];
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
			//Set<Integer> lesserNumsWithoutDuplicates = new HashSet<>(lesserNums);
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
			//Set<Integer> greaterNumsWithoutDuplicates = new HashSet<>(greaterNums);
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
			//int[] greaterNumsArray = greaterNums.stream().mapToInt(i -> i).toArray();
			int[] greaterNumsArray = greaterNums.stream().mapToInt(Integer::intValue).toArray();
			result = partition(greaterNumsArray, targetNum);
		}else{
			//int[] lesserNumsArray = greaterNums.stream().mapToInt(i -> i).toArray();
			int[] lesserNumsArray = lesserNums.stream().mapToInt(Integer::intValue).toArray();
			result = partition(lesserNumsArray, targetNum-greaterNums.size());
		}
		return result;
	}

	public int partition(List<Integer> nums, int targetNum, int antiPivot) {
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
			//int[] greaterNumsArray = greaterNums.stream().mapToInt(i -> i).toArray();
			int[] greaterNumsArray = greaterNums.stream().mapToInt(Integer::intValue).toArray();
			result = partition(greaterNumsArray, targetNum);
		}else {
			//int[] lesserNumsArray = greaterNums.stream().mapToInt(i -> i).toArray();
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
