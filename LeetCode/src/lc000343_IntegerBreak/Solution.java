package lc000343_IntegerBreak;

public class Solution {

	public Solution() {}

	public int integerBreak(int n) {
		//思路：當我們想要得到最大值的話，我們會盡量地將所有的數切分成大於1且越小越好的數，這樣才能使乘積越大；根據觀察，會發現一個有趣規律，當n=6時候，3*3=9>2*2*2=8；同時當n=4時，3*1=3<2*2=4；所以要盡量的將n分解為許多個3，如果剩下的數字為4時則分解為兩個2才會得到最大乘積
		if(n<=3) {return n==2 ? 1 : 2;}
		int product=1;
		while(n>4) {
			product*=3;
			n-=3;
		}
		return product*n;
	}

}
