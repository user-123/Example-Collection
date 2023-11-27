package lc001095_FindInMountainArray;

import java.util.LinkedList;
import java.util.List;

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

public class Solution {

	public Solution() {}

	public int findInMountainArray(int target, MountainArray mountainArr) {
		//思路：先用binary search找到peak(最大值)；再分別對前後兩段array做binary search
		int length=mountainArr.length(), left=0, right=length-1, mid, peak=-1;
		while(left<right) {
			mid=left+(right-left)/2;
			if(mountainArr.get(mid)<mountainArr.get(mid+1)) {left=peak=mid+1;continue;}
			right=mid;
		}
		left=0;
		right=peak;
		while(left<=right) {
			mid=left+(right-left)/2;
			if(mountainArr.get(mid)<target) {left=mid+1;continue;}
			if(mountainArr.get(mid)>target) {right=mid-1;continue;}
			return mid;
		}
		left=peak;
		right=length-1;
		while(left<=right) {
			mid=left+(right-left)/2;
			if(mountainArr.get(mid)>target) {left=mid+1;continue;}
			if(mountainArr.get(mid)<target) {right=mid-1;continue;}
			return mid;
		}
		return -1;
	}

}
