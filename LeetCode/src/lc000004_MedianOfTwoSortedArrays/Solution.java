package lc000004_MedianOfTwoSortedArrays;

import java.util.LinkedList;
import java.util.List;

public class Solution {

	public Solution() {}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		//思路：太久以前寫到一半想不起來啦XDDD
		double result = 0;
		int nums1Length = nums1.length, nums2Length = nums2.length;
		double medianTerm = (nums1Length+nums2Length+1)/2;
		//TODO 待完成
		if()




		if(nums1[nums1Length-1] < nums2[0]) {

		}
		if(nums1[0] > nums2[nums2Length-1]) {

		}



		return result;
	}

	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		//思路：同時對兩個array做binary search，如果num1Median<num2Median，num1向後半段做binary search，num2向前半段做binary search；持續如此(不過要怎麼讓迴圈停止要再想想)
		//TODO 待完成
		return 0;
	}

}
