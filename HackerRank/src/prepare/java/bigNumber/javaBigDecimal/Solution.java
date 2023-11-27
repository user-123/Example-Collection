package prepare.java.bigNumber.javaBigDecimal;

import java.math.BigDecimal;
import java.util.*;

class Solution{
	public static void main(String []args){
		//Input
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		String[] s = new String[n];
		for(int i=0; i<n; i++) {
			s[i]=sc.next();
		}
		sc.close();

		//Write your code here

		sort(s);

		//Output
		for(int i=0; i<n; i++) {
			System.out.println(s[i]);
		}
	}

	static private void sort(String[] nums) {
		/*
		Arrays.sort(nums, 0, nums.length, new Comparator<Object>() {
			@Override
			public int compare(Object num1, Object num2) {
				BigDecimal bigDecimalNum1 = new BigDecimal((String)num1);
				BigDecimal bigDecimalNum2 = new BigDecimal((String)num2);
				return bigDecimalNum2.compareTo(bigDecimalNum1);
			}
		});
		*/
		/*
		Arrays.sort(nums, 0, nums.length, new Comparator<String>() {
			@Override
			public int compare(String num1, String num2) {
				BigDecimal bigDecimalNum1 = new BigDecimal(num1);
				BigDecimal bigDecimalNum2 = new BigDecimal(num2);
				return bigDecimalNum2.compareTo(bigDecimalNum1);
			}
		});
		*/
		Arrays.sort(nums, 0, nums.length, new Comparator<String>() {
			@Override
			public int compare(String num1, String num2) {
				return new BigDecimal(num2).compareTo(new BigDecimal(num1));
			}
		});
		return;
	}
}