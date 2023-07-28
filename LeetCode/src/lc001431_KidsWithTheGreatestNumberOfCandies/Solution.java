package lc001431_KidsWithTheGreatestNumberOfCandies;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public Solution() {}

	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> result = new ArrayList<>(candies.length);
		int maxInitCandy=0;
		for(int candyQuantity : candies) {
			maxInitCandy = candyQuantity>maxInitCandy ? candyQuantity : maxInitCandy;
		}
		for(int candyQuantity : candies) {
			result.add(candyQuantity+extraCandies>=maxInitCandy ? true : false);
		}
		return result;
	}

}
