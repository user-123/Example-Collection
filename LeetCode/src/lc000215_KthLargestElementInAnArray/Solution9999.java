package lc000215_KthLargestElementInAnArray;

public class Solution9999 {

	public Solution9999() {}

	public int findKthLargest(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>max) {
                max=nums[i];
            }
            if(nums[i]<min)
            min=nums[i];
        }
        int[] arr=new int[max-min+1];
        for(int i=0;i<nums.length;i++) {
            arr[max-nums[i]]++;
        }
        for(int i=0;i<arr.length;i++) {
            if(arr[i]!=0) {
                k=k-arr[i];
            }
            if(k<=0)
            return max-i;
        }
        return 0;
    }
}
