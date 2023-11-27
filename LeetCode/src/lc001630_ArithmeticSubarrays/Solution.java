package lc001630_ArithmeticSubarrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public Solution() {}

	public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		List<Boolean> result = new ArrayList<>(l.length);
		for(int i=0; i<l.length; i++) {
			result.add(isArithmeticSequence(nums, l[i], r[i]));
		}
		return result;
	}

	private boolean isArithmeticSequence(int[] nums, int start, int end) {
		if(end-start<2) {return true;}
		int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
		Set<Integer> elements = new HashSet<>();
		for(int i=start; i<=end; i++) {
			min = nums[i]<min ? nums[i] : min;
			max = nums[i]>max ? nums[i] : max;
			elements.add(nums[i]);
		}
		if((max-min)%(end-start)!=0) {return false;}
		int interval=(max-min)/(end-start);
		for(int i=1; i<=end-start; i++) {
			if(!elements.contains(min+interval*i)) {return false;}
		}
		return true;
	}

}
