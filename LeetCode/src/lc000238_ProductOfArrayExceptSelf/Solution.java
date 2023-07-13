package lc000238_ProductOfArrayExceptSelf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public Solution() {}

	public int[] productExceptSelf(int[] nums) {
		//思路：每一項=它的前面所有項乘積*它的後面所有項乘積
		int numsLength = nums.length, sumProduct=1;
		int[] result = new int[numsLength];
		Arrays.fill(result, 1);
		for(int i=1; i<numsLength; i++) {
			sumProduct*=nums[i-1];
			result[i]=sumProduct; //result[i]*=sumProduct;
		}
		sumProduct=1;
		for(int i=numsLength-2; i>=0; i--) {
			sumProduct*=nums[i+1];
			result[i]*=sumProduct;
		}
		return result;
	}

	public int[] productExceptSelf_2(int[] nums) {
		//思路：上一解法優化
		int numsLength = nums.length, sumProduct=1;
		int[] result = new int[numsLength];
		result[0]=1;
		for(int i=1; i<numsLength; i++) {
			sumProduct*=nums[i-1];
			result[i]=sumProduct;
		}
		sumProduct=1;
		for(int i=numsLength-2; i>=0; i--) {
			sumProduct*=nums[i+1];
			result[i]*=sumProduct;
		}
		return result;
	}

	public int[] productExceptSelf_3(int[] nums) {
		//思路：上一解法好理解寫法
		int numsLength = nums.length;
		int[] result = new int[numsLength];
		result[0]=1;
		int prefixSumProduct=1;
		for(int i=1; i<numsLength; i++) {
			prefixSumProduct*=nums[i-1];
			result[i]=prefixSumProduct;
		}
		int suffixSumProduct=1;
		for(int i=numsLength-2; i>=0; i--) {
			suffixSumProduct*=nums[i+1];
			result[i]*=suffixSumProduct;
		}
		return result;
	}

	public int[] productExceptSelf2(int[] nums) {
		//思路：簡單的想法，每一項為總乘積除以該項(雖然與題目要求不符)；不過要考慮值為0有幾項，多於2項，每個項均為0；有1項，就只有為0項有值，其餘項為0
		int numsLength = nums.length, sumProduct=1;
		int[] result = new int[numsLength];
		List<Integer> indexOfZero = new ArrayList<>();
		for(int i=0; i<numsLength; i++) {
			if(nums[i]==0) {indexOfZero.add(i);continue;}
			sumProduct*=nums[i];
		}
		if(indexOfZero.size()==0) {
			for(int i=0; i<numsLength; i++) {
				result[i]=sumProduct/nums[i];
			}
		}else if(indexOfZero.size()==1) {
			result[indexOfZero.get(0)]=sumProduct;
		}
		return result;
	}

	public int[] productExceptSelf2_2(int[] nums) {
		//思路：上一個解法的同思路變體，但不使用list
		int numsLength = nums.length, sumProduct=1, zeroCount=0;
		int[] result = new int[numsLength];
		for(int num : nums) {
			if(num==0) {zeroCount++;continue;}
			sumProduct*=num;
		}
		if(zeroCount>1) {return result;}
		if(zeroCount==1) {
			for(int i=0; i<numsLength; i++) {
				if(nums[i]==0) {
					result[i]=sumProduct;
					return result;
				}
			}
		}
		for(int i=0; i<numsLength; i++) {
			result[i]=sumProduct/nums[i];
		}
		return result;
	}

}
