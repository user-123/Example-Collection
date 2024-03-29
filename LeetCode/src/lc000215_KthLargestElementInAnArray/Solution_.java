package lc000215_KthLargestElementInAnArray;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution_ {

	public Solution_() {}

	public int findKthLargest(int[] nums, int k) {
		//直覺想到分治法，畢竟我學過的排序最高效的就是它@@
		//思路：
		//假設給定目標是第40大，array有100項
		//隨機取一個數當pivot，分完後如果，
		//1.大於pivot的數有30個，顯然小於40的目標，所以捨棄大於的，並在小於之中取新的pivot
		//2.大於pivot的數有50個，捨棄小於的，取大於的，並在之中取新的pivot
		//使用遞迴大法，quickSort時間複雜度是O(nlogn)，而題目要求O(n)
		//我思來想去這應該算"二分搜尋法"的概念吧(雖然資料沒有排序，學藝不精QQ，我不知道名字，不過有找到一個名字叫"Prune and Search"，應該就它了吧)
		//因為資料是無序的，預估時間複雜度為T(2n-1)=O(n)，有待確認確切名字XDDDDDD
		//├─────────┼─────────┤  =>  ├────┼────┤  =>  ├────┤
		List<Integer> numsList = intArrayToIntegerList(nums);
		return k<=0 || nums.length==0 || nums.length<k ? -2147483648 : partition (numsList, k, null);
	}

	public int partition(List<Integer> nums, int targetNum, Integer antiPivot) {
		if(nums.size()==1) {return nums.get(0);}
		Integer result = null;
		if(targetNum==1) {
			for (int num : nums) {
				if(result==null || result<num) {result=num;}
			}
			return result;
		}
		if(targetNum==nums.size()) { // || targetNum==0
			for (int num : nums) {
				if(result==null || result>num) {result=num;}
			}
			return result;
		}
		int pivot;
		do{
			pivot = nums.get((int) (Math.random()*nums.size()));
		}while(antiPivot!=null && pivot==antiPivot);
		List<Integer> greaterNums = new ArrayList<>();
		List<Integer> lesserNums = new ArrayList<>();
		for(int num : nums) {
			if(num>=pivot) {greaterNums.add(num);continue;}
			lesserNums.add(num);
		}
		if(greaterNums.isEmpty()) {
			result = checkPivot(lesserNums, targetNum);
		}else if(lesserNums.isEmpty()) {
			result = checkPivot(greaterNums, targetNum);
		}else if(greaterNums.size()>=targetNum) {
			result = partition(greaterNums, targetNum, antiPivot);
		}else{
			result = partition(lesserNums, targetNum-greaterNums.size(), antiPivot);
		}
		return result;
	}

//	public int partition(List<Integer> nums, int targetNum, int antiPivot) {
//		Integer result = null;
//		int pivot;
//		do{
//			pivot = nums.get((int) (Math.random()*nums.size()));
//		}while(pivot==antiPivot);
//		List<Integer> greaterNums = new ArrayList<>();
//		List<Integer> lesserNums = new ArrayList<>();
//		for(int num : nums) {
//			if(num>=pivot) {greaterNums.add(num);continue;}
//			lesserNums.add(num);
//		}
//		System.out.print("greaterNums");
//		System.out.println(greaterNums);
//		System.out.print("lesserNums");
//		System.out.println(lesserNums);
//		if(greaterNums.size()>=targetNum) {
//			int[] greaterNumsArray = greaterNums.stream().mapToInt(Integer::intValue).toArray();
//			result = partition(greaterNumsArray, targetNum);
//		}else {
//			int[] lesserNumsArray = lesserNums.stream().mapToInt(Integer::intValue).toArray();
//			result = partition(lesserNumsArray, targetNum-greaterNums.size());
//		}
//		return result;
//	}

	public Map<Integer, Integer> getNumsMap(List<Integer> nums) {
		Map<Integer, Integer> numsMap = new HashMap<>();
		nums.forEach(num -> {
			Integer counts = numsMap.get(num);
			numsMap.put(num, counts == null ? 1 : ++counts);
		});
		return numsMap;
	}
	public int checkPivot(List<Integer> Nums, int targetNum) {
		Integer result;
		Integer antiPivot;
		Map<Integer, Integer> NumsMap = getNumsMap(Nums);
		Set<Integer> NumsKey = NumsMap.keySet();
		if(NumsKey.size()==1) {
			result = NumsKey.iterator().next();
		}else {
			antiPivot = getAntiPivot(NumsMap, NumsKey);
			result = partition(Nums, targetNum, antiPivot);
		}
		return result;
	}

	public int getAntiPivot(Map<Integer, Integer> numsMap,Set<Integer> numsKey) {
		Integer antiPivot = null;
		for(int numForPivot : numsKey) {
			if(antiPivot  == null || numsMap.get(antiPivot)<numsMap.get(numForPivot)) {
				antiPivot = numForPivot;
			}
		}
		return antiPivot;
	}

	public List<Integer> intArrayToIntegerList(final int[] intArray) {
//		return (new AbstractList<Integer>() {
//			public Integer get(int index) {return intArray[index];}
//			public int size() {return intArray.length;}
//		});
		return new ArrayList<Integer>() {{for(int i : intArray) {add(i);}}};
	}
}
