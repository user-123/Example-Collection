package lc001814_CountNicePairsInAnArray;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public Solution() {}

	public int countNicePairs(int[] nums) {
		//思路：依照題意觀察，nums[i]+rev(nums[j])==nums[j]+rev(nums[i])⇒nums[i]-rev(nums[i])==nums[j]-rev(nums[j])，所以只要將nums裡的所有數減去各自的reverseNum，找出一樣的差數組合
		final int MODULO=(int)1e9+7;	//final int MODULO=1_000_000_007;
		long pairCount=0L;
		Map<Integer, Integer> count = new HashMap<>();
		for(int num : nums) {
			int reverseNum=rev(num), difference=num-reverseNum, sameDifferenceCount=count.getOrDefault(difference, 0);
			count.put(difference, sameDifferenceCount+1);
			pairCount+=sameDifferenceCount;
		}
		return (int)(pairCount%MODULO);
	}

	private int rev(int num) {
		int reverse=0;
		while(num>0) {
			reverse=reverse*10+num%10;
			num/=10;
		}
		return reverse;
	}

}
