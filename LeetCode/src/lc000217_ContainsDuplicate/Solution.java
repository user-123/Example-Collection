package lc000217_ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public Solution() {}

	public boolean containsDuplicate(int[] nums) {
		boolean result = false;
		Set<Integer> intSet = new HashSet<>();
		for(int num : nums) {
			if(!intSet.add(num)) {
				result=true;
				break;
			}
		}
		return result;
	}

	public boolean containsDuplicate2(int[] nums) {
		boolean result = false;
		//構思：使用frequency array
		//理論正確但是會使用爆量的空間XDD，故棄用
		//1 <= nums.length <= 10^5
		//-10^9 <= nums[i] <= 10^9
		int[] frequencyArray = new int[2000000001];
		for(int num : nums) {
			frequencyArray[num+1000000000]++;
		}
		for(int frequency : frequencyArray) {
			if(frequency>1) {
				result=true;
				break;
			}
		}
		return result;
	}

}
