package lc000122_BestTimeToBuyAndSellStockII;

public class Solution {

	public Solution() {}

	public int maxProfit(int[] prices) {
		int lowestPrice = Integer.MAX_VALUE, profit=0;
		for(int i=0; i<prices.length; i++) {
			if(prices[i]<lowestPrice) {
				lowestPrice=prices[i];
			}
			//lowestPrice=Math.min(lowestPrice, prices[i]);	//等價
			if(profit<prices[i]-lowestPrice) {
				profit=prices[i]-lowestPrice;
			}
			//profit=Math.max(profit, prices[i]-lowestPrice);	//等價
		}
		return profit;
	}

}
