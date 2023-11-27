package lc001359_CountAllValidPickupAndDeliveryOptions;

public class Solution {

	public Solution() {}

	public int countOrders(int n) {
		//思路：n==0，只有一種可能，就是全空，所以選擇有1
		//n==1，序列長度為0，第1次插入p1或d1有1個選擇，第2次插入p1或d1有2個選擇，總共有2種組合，但是p1必須在d1之前，所以必須除2；
		//n==2，序列長度為2，第1次插入p1或d1有3個選擇，第2次插入p1或d1有4個選擇，總共有12種組合，但是p1必須在d1之前，所以必須除2；
		//n==3，序列長度為4，第1次插入p1或d1有5個選擇，第2次插入p1或d1有6個選擇，總共有兩種組合，但是p1必須在d1之前，所以必須除2；
		//所以n>0時通式是countOrders(n-1)*((n-1)*2+1)*((n-1)*2+2)/2
		//if(n==0) {return 1;}
		//return countOrders(n-1)*((n-1)*2+1)*((n-1)*2+2)/2;
		//return n>0 ? countOrders(n-1)*((n-1)*2+1)*((n-1)*2+2)/2 : 1;
		return n>0 ? (int)((long)countOrders(n-1)*(2*n-1)*n%(1e9+7)) : 1;
	}

}
