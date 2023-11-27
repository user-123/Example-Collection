package prepare.java.dataStructures.javaSubarray;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		int[] input;
		try(Scanner scanner = new Scanner(System.in)) {
			int length=scanner.nextInt();
			input=new int[length];
			for(int i=0; i<length; i++) {
				input[i]=scanner.nextInt();
			}
		}
		System.out.println(negativeSubArraySumQuantity(input));
	}

	private static int negativeSubArraySumQuantity(int[] nums) {
		//思路：檢查sum[0:0]，再檢查sum[0:1]，再檢查sum[0:2]...sum[0:nums.length-1], sum[1:1], sum[1:2], ...,sum[2:2], sum[2:3], ...sum[nums.length-1:nums.length-1]
		int length=nums.length, count=0;
		for(int i=0; i<length; i++) {
			for(int j=i; j<length; j++) {
				int sum=0;
				for(int k=i; k<=j; k++) {
					sum+=nums[k];
				}
				count += sum<0 ? 1 : 0;
			}
		}
		return count;
	}

	private static int negativeSubArraySumQuantity2(int[] nums) {
		//思路：前一個方法的優化，換個角度思考，試想以nums[i]為開頭的，取一個、取兩個、取三個...，這樣不需要重複計算，只要一直累加並檢查是否小於0就好了
		int length=nums.length, count=0;
		for(int i=0; i<length; i++) {
			int sum=0;
			for(int j=i; j<length; j++) {
				sum+=nums[j];
				count += sum<0 ? 1 :0;
			}
		}
		return count;
	}

	private static int negativeSubArraySumQuantity3(int[] nums) {
		//思路：先檢查所有一個一組的，再檢查兩個一組的，再檢查...，最後檢查nums.length一組的
		int length=nums.length, count=0;
		//TODO 待完成
		return count;
	}
}