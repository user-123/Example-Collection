package lc000852_PeakIndexInAMountainArray;

public class Solution {

	public Solution() {}

	public int peakIndexInMountainArray(int[] arr) {
		//思路：binary search
		int left=0, right=arr.length-1, mid;
		while(left<right) {
			mid=(left+right)/2;
			if(arr[mid]<arr[mid+1]) {
				left=mid+1;
			}else {
				right=mid;
			}
		}
		return left;
	}

}
