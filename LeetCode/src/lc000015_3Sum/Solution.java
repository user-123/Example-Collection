package lc000015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {

	public Solution() {}

	//思路：依照題意，不管輸出的nums[i]、nums[j]、nums[k]順序，只要組合不重複即可(且i!=j!=k)
	//意思是，(O) [[-1, 0, 1]]或[[0, -1, 1]]都可
	//			(X) [[-1, 0, 1], [0, -1, 1]]不可

	public List<List<Integer>> threeSum(int[] nums) {
		//思路：使用固定一個數i，然後剩餘兩個數j、k使用雙指針去計算；因為要避免重複組合的情況，必須要選其中兩項i、j去跳過重複，即可確保[nums[i], nums[j], nums[k]]組合不會出現重複
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);	//排列後不影響"答案"(當然啦，會影響"結果")，且方便控制和避免重複
		if(nums[0]>0) {return result;}	//當第一項大於0時，那肯定無解直接返回(邏輯：第一項必須小於或等於0才有可能會有解，否則總和總是會大於0)
		for(int i=0; i<nums.length; i++) {	//可以改為 for(int i=0; i<nums.length-2; i++) {
			if(i!=0 && nums[i]==nums[i-1]) {continue;}	//當前項等於前一項時，跳過避免重複
			int j=i+1, k=nums.length-1;
			//if(nums[i]==nums[j] && nums[j]==nums[k]) {return result;}
			while(j<k) {
				if(j-1>i && nums[j]==nums[j-1]) {j++;continue;}	//當前項等於前一項時，跳過避免重複
				//if(nums[j]==nums[k]) {break;}
				int sum = nums[i]+nums[j]+nums[k];
				if(sum>0) {k--;}	//代表k過大，向前找
				if(sum<0) {j++;}	//代表j過大，向後找
				if(sum==0) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
				}
			}
		}
		return result;
	}

	public List<List<Integer>> threeSum2(int[] nums) {
		//思路：與上一個解法同思路，但使用HashSet確保組合不重複，缺點很明顯是會多做很多次重複組合的計算
		//待測試
		Arrays.sort(nums);
		if(nums[0]>0) {return new ArrayList<List<Integer>>(0);}
		Set<List<Integer>> result = new HashSet<>();
		for(int i=0; i<nums.length-2; i++) {
			int j=i+1, k=nums.length-1;
			while(j<k) {
				int sum = nums[i]+nums[j]+nums[k];
				if(sum>0) {k--;}
				if(sum<0) {j++;}
				if(sum==0) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
				}
			}
		}
		return new ArrayList<>(result);
	}

	public List<List<Integer>> threeSum3(int[] nums) {
		//思路：與上上一個解法同思路，但使用HastMap確保組合不重複
		//待完成
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		if(nums[0]>0) {return result;}
		for(int i=0; i<nums.length-2; i++) {
			int j=i+1, k=nums.length-1;
			while(j<k) {
				//待完成
				int sum = nums[i]+nums[j]+nums[k];
				if(sum>0) {k--;}
				if(sum<0) {j++;}
				if(sum==0) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
				}
			}
		}
		return result;
	}

}
