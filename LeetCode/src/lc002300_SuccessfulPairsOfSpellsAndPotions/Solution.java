package lc002300_SuccessfulPairsOfSpellsAndPotions;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public int[] successfulPairs(int[] spells, int[] potions, long success) {
		int[] result = new int[spells.length];
		Arrays.sort(potions);
		int index=0;
		for(long spell : spells) {
			int left=0, right=potions.length-1, mid;
			while(left<=right) {
				mid=left+(right-left)/2;
				if(potions[mid]*spell<success) {left=mid+1;continue;}
				right=mid-1;
			}
			result[index++]=potions.length-left;
		}
		return result;
	}

}
