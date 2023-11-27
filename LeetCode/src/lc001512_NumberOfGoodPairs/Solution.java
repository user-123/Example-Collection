package lc001512_NumberOfGoodPairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public Solution() {}

	public int numIdenticalPairs(int[] nums) {
		//思路：當有數字沒有重複(0或1個)，0對；當重複1次(2個)，1對；當重複2次(3個)，3=1+2對；當重複3次(4個)，6=1+2+3對；依此類推
		Map<Integer, Integer> numsQuantity = new HashMap<>();
		for(int num : nums) {
			numsQuantity.put(num, numsQuantity.getOrDefault(num, 0)+1);
		}
		int pairsQuantity=0;
		for(int quantity : numsQuantity.values()) {
			pairsQuantity+=(1+(quantity-1))*(quantity-1)/2;
		}
		return pairsQuantity;
	}

	public int numIdenticalPairs2(int[] nums) {
		//思路：前一方法的優化版，查詢map之後直接計算(利用前面找到的規律)
		Map<Integer, Integer> numsQuantity = new HashMap<>();
		int pairsQuantity=0;
		for(int num : nums) {
			int foundQuantity=numsQuantity.getOrDefault(num, 0);
			pairsQuantity+=foundQuantity;
			numsQuantity.put(num, foundQuantity+1);
		}
		return pairsQuantity;
	}

	public int numIdenticalPairs3(int[] nums) {
		//思路：前一方法的魔改版，利用題目的約束條件，只要生成一個長度為101的array即可模擬map
		int[] numsQuantity = new int[101];
		int pairsQuantity=0;
		for(int num : nums) {
			pairsQuantity+=numsQuantity[num]++;
		}
		return pairsQuantity;
	}

}
