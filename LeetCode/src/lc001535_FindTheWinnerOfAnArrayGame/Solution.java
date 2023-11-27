package lc001535_FindTheWinnerOfAnArrayGame;

public class Solution {

	public Solution() {}

	public int getWinner(int[] arr, int k) {
		//思路：如果勝利次數等於k就是答案；若是沒有則比到最後一個的肯定就是答案(因為為arr[]最大值)，不管之後怎麼比都肯定會勝利
		int previousNum=Integer.MIN_VALUE, winCount=0;
		for(int currentNum : arr) {
			previousNum = currentNum>previousNum ? currentNum : previousNum;
			if(currentNum==arr[0]) {continue;}
			if(currentNum==previousNum) {winCount=0;}
			winCount++;
			if(winCount==k) {break;}
		}
		return previousNum;
	}

	public int getWinner2(int[] arr, int k) {
		//思路：將前一個方法改為for，捨棄for each的好處是可以少一個是否為arr[0]的判斷
		int previousNum=arr[0], winCount=0;
		for(int i=1; i<arr.length; i++) {
			if(arr[i]>previousNum) {
				winCount=0;
				previousNum=arr[i];
			}
			if(++winCount==k) {break;}
		}
		return previousNum;
	}

	public int getWinner22(int[] arr, int k) {
		//思路：將前一個方法改為三元運算
		int previousNum=arr[0], winCount=0;
		for(int i=1; i<arr.length; i++) {
			winCount = arr[i]>previousNum ? 0 : winCount;
			previousNum = arr[i]>previousNum ? arr[i] : previousNum;
			if(++winCount==k) {break;}
		}
		return previousNum;
	}

}
