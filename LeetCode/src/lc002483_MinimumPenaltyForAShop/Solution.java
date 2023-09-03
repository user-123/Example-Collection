package lc002483_MinimumPenaltyForAShop;

public class Solution {

	public Solution() {}

	public int bestClosingTime(String customers) {
		//思路：XXXXXXXXXX
		int score=0, maxScore=0, bestHour=-1;
		for(int i=0; i<customers.length(); i++) {
			score+=customers.charAt(i)=='Y' ? 1 : -1;
			if(score>maxScore) {
				maxScore=score;
				bestHour=i;
			}
		}
		return bestHour+1;
	}

}
