package lc000287_FindTheDuplicateNumber;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public Solution() {}

	public int findDuplicate(int[] nums) {
		//思路：傳統set不能有重複的元素
		Set<Integer> set = new HashSet<>();
		for(int num : nums) {
			if(!set.add(num)) {return num;}
		}
		return 0;
	}

	public int findDuplicate2(int[] nums) {
		//思路：用boolean記錄每個數字是否有出現過
		boolean[] appeared = new boolean[nums.length+1];
		for(int num : nums) {
			if(appeared[num]) {return num;}
			appeared[num]=true;
		}
		return 0;
	}

	public int findDuplicate3(int[] nums) {
		//思路：跟前一個用boolean array記錄同一個概念，不過換成記錄出現次數
		int[] appearCount = new int[nums.length+1];
		for(int num : nums) {
			if(appearCount[num]==1) {return num;}
			appearCount[num]+=1;
		}
		return 0;
	}

	public int findDuplicate4(int[] nums) {
		//思路：
		//參考：https://leetcode.com/problems/find-the-duplicate-number/solutions/1892921/9-approaches-count-hash-in-place-marked-sort-binary-search-bit-mask-fast-slow-pointers/?envType=daily-question&envId=2023-09-19
		int[] appearCount = new int[nums.length+1];
		//TODO 待構思
		return 0;
	}

}
