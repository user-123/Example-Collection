package lc000136_SingleNumber;

public class Solution {

	public Solution() {}

	public int singleNumber(int[] nums) {
		//1 <= nums.length <= 3 * 10^4
		//-3 * 10^4 <= nums[i] <= 3 * 10^4
		int[] usedCount = new int[60001];
		for(int num : nums) {
			usedCount[num+30000]++;
		}
		for(int i=0; i<usedCount.length; i++) {
			if(usedCount[i]==1) {
				return i-30000;
			}
		}
		return Integer.MIN_VALUE;
	}

	public int singleNumber2(int[] nums) {
		//方法：利用xor計算(0^0=0, 0^1=1, 1^0=1, 1^1=0)，重複的數字會使結果為0(0^n=n, n^n=0)
		int result = 0;
		for(int i=0; i<nums.length; i++) {
			result = result^nums[i];
		}
		System.gc();	//硬要GC XDD
		return result;
	}

}
