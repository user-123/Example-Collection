package lc000088_MergeSortedArray;

public class Solution {

	public Solution() {}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if(m==0) {
			for(int i=0; i<n; i++) {
				nums1[i]=nums2[i];
			}
			return;
		}
		if(n==0) {return;}
		int nums1Pointer = m-1, nums2Pointer = n-1, temp = 0, nullElement = Integer.MIN_VALUE;
		while(nums1Pointer+nums2Pointer+1 >= 0) {
			//if(nums1[nums1Pointer]==nullElement) {nums1Pointer--; continue;}
			//if(nums1[nums1Pointer]==nullElement) {nums2Pointer--; continue;}
			if(nums1Pointer < 0) {
				nums1[nums1Pointer+nums2Pointer+1]=nums2[nums2Pointer];
				nums2Pointer--;
				continue;
			}
			if(nums2Pointer < 0) {
				nums1[nums1Pointer+nums2Pointer+1]=nums1[nums1Pointer];
				nums1Pointer--;
				continue;
			}
			if(nums1[nums1Pointer]>nums2[nums2Pointer]) {
				nums1[nums1Pointer+nums2Pointer+1]=nums1[nums1Pointer];
				//nums1[nums1Pointer]=nullElement;
				nums1Pointer--;
			}else {
				//temp=nums1[nums1Pointer];
				nums1[nums1Pointer+nums2Pointer+1]=nums2[nums2Pointer];
				//nums2[nums2Pointer]=temp;
				nums2Pointer--;
			}
		}


		return;
	}

}
