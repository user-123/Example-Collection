package prepare.algorithms.implementation.electronicsShop;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

	/*
	 * Complete the getMoneySpent function below.
	 */
	static int getMoneySpent(int[] keyboards, int[] drives, int b) {
		/*
		 * Write your code here.
		 */
		int sum, maximum=-1;
        for(int i=0; i<keyboards.length; i++) {
            for(int j=0; j<drives.length; j++) {
                sum=keyboards[i]+drives[j];
                maximum = sum>=maximum && sum<=b ? sum : maximum;
            }
        }
        return maximum;
	}

	static int getMoneySpent2(int[] keyboards, int[] drives, int b) {
		//思路：因為題目有給定約束條件，所以此方法的剔除keyboards[i]>b和drives[i]>b的項目，是沒必要要的
		Arrays.sort(keyboards);
		Arrays.sort(drives);
		if(keyboards[0]+drives[0]>=b) {return keyboards[0]+drives[0]>b ? -1 : b;}
		int keyboardsLow=0, keyboardsHigh=keyboards.length-1, drivesLow=0, drivesHigh=drives.length-1;
		while(keyboardsLow<keyboardsHigh) {
			int keyboardsMid=keyboardsLow+(keyboardsHigh-keyboardsLow+1)/2;
			if(keyboardsMid<=b) {
				keyboardsLow=keyboardsMid;
			}else {
				keyboardsHigh=keyboardsMid-1;
			}
		}
		while(drivesLow<drivesHigh) {
			int drivesMid=drivesLow+(drivesHigh-drivesLow+1)/2;
			if(drivesMid<=b) {
				drivesLow=drivesMid;
			}else {
				drivesHigh=drivesMid-1;
			}
		}
		int sum, maximum=-1;
		for(int i=0; i<=keyboardsHigh; i++) {
			for(int j=0; j<=drivesHigh; j++) {
				sum=keyboards[i]+drives[j];
				maximum = sum>=maximum && sum<=b ? sum : maximum;
			}
		}
		return maximum;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] bnm = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		int b = Integer.parseInt(bnm[0]);

		int n = Integer.parseInt(bnm[1]);

		int m = Integer.parseInt(bnm[2]);

		int[] keyboards = new int[n];

		String[] keyboardsItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
			int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
			keyboards[keyboardsItr] = keyboardsItem;
		}

		int[] drives = new int[m];

		String[] drivesItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		for (int drivesItr = 0; drivesItr < m; drivesItr++) {
			int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
			drives[drivesItr] = drivesItem;
		}

		/*
		 * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
		 */

		int moneySpent = getMoneySpent(keyboards, drives, b);

		bufferedWriter.write(String.valueOf(moneySpent));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
