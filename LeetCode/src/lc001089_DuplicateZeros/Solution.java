package lc001089_DuplicateZeros;

public class Solution {

	public Solution() {}

	public void duplicateZeros(int[] arr) {
		//思路：偽in-place，直接將輸入的array映射到resultArray，同時補0；最後將resultArray寫回array，嘿嘿XDDD
		int[] result = new int[arr.length];
		int originalPointer=0, resultPointer=0;
		while(resultPointer<=result.length) {
			if(arr[originalPointer]==0) {
				result[resultPointer++]=0;
				if(resultPointer>result.length) {break;}
				result[resultPointer++]=0;
			}else {
				result[resultPointer++]=arr[originalPointer];
			}
			originalPointer++;
		}
		for(int i=0; i<arr.length; i++) {
			arr[i]=result[i];
		}
		return;
	}

	public void duplicateZeros2(int[] arr) {
		//思路：真in-place，先計算出補0後沒有截斷的array長度，方法是先遍歷一次array，計算有多少個0，然後從array末端，補上result的數字(模擬前一個方法的映射，不過這裡是真in-place，所以必須從末端來，才能避免需要的element被取代)
		int zeroCount=0;
		for(int num : arr) {zeroCount+= num==0 ? 1 : 0;}
		for(int originalPointer=arr.length-1, resultPointer=arr.length+zeroCount-1; originalPointer<resultPointer; originalPointer--, resultPointer--) {
			if(resultPointer<arr.length) {arr[resultPointer]=arr[originalPointer];}
			if(arr[originalPointer]==0) {
				if(--resultPointer<arr.length) {arr[resultPointer]=arr[originalPointer];}
			}
		}
		return;
	}

}
