package lc000779_KthSymbolInGrammar;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public Solution() {}

	public int kthGrammar(int n, int k) {
		//觀察：
		//       0
		//       01
		//      0110
		//    01101001
		//0110100110010110
		//思路：當作binary tree看待；當node.val=0時，node.left=0，node.right=1；node.val=1時，node.left=1，node.right=0
		if(n<1 || k<1 || k>Math.pow(2L, n-1)) {return -1;}
		if(n==1 && k==1) {return 0;}
		return k%2==0 ? (kthGrammar(n-1, k/2)==0 ? 1 : 0) : (kthGrammar(n-1, (k+1)/2)==0 ? 0 : 1);
	}

	public int kthGrammar2(int n, int k) {
		//觀察：
		//0
		//0 1
		//01 10
		//0110 1001
		//01101001 10010110
		//思路：每個row前半段為前一row；後半段為前一row的取反(0->1，1->0)；邏輯正確，但是因為要維持array，所以容易Memory Limit Exceeded
		if(n<1 || k<1 || k>Math.pow(2L, n-1)) {return -1;}
		if(n==1 && k==1) {return 0;}
		List<Integer> array = new ArrayList<>((int)Math.pow(2L, n-1));
		int row=0;
		array.add(0);
		row++;
		while(row++<n) {
			int prevArrayLength=array.size();
			for(int i=0; i<prevArrayLength; i++) {
				array.add(array.get(i)^1);
			}
		}
		return array.get(k-1);
	}

}
