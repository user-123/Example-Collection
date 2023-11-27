package lc001980_FindUniqueBinaryString;

public class Solution {

	public Solution() {}

	public String findDifferentBinaryString(String[] nums) {
		//思路：只要結果的某一位都與某num的某一位相反(不一樣)，就能保證結果與nums裡的每一個都不一樣
		char[] result = new char[nums[0].length()];
		for(int i=0; i<nums.length; i++) {
			result[i] = nums[i].charAt(i)=='1' ? '0' : '1';
		}
		return new String(result);
	}

}
