package lc001299_ReplaceElementsWithGreatestElementOnRightSide;

public class Solution {

	public Solution() {}

	public int[] replaceElements(int[] arr) {
		//思路：直接in-place，方法是從末端開始取值，同時記錄最大的值
		int rightSideMax=-1, current;
		for(int i=arr.length-1; i>=0; i--) {
			current=arr[i];
			arr[i]=rightSideMax;
			rightSideMax = current>rightSideMax ? current : rightSideMax;
		}
		return arr;
	}

	public int[] replaceElements2(int[] arr) {
		//思路：使用resultArray記錄，與前一方法同樣邏輯，不過改為直接取值，省略暫存數值的步驟
		int[] result = new int[arr.length];
		int rightSideMax=-1;
		for(int i=arr.length-1; i>=0; i--) {
			result[i]=rightSideMax;
			rightSideMax = arr[i]>rightSideMax ? arr[i] : rightSideMax;
		}
		return result;
	}

}
