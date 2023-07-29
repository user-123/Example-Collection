package prepare.algorithms.implementation.NumberLineJumps;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'kangaroo' function below.
	 *
	 * The function is expected to return a STRING.
	 * The function accepts following parameters:
	 *  1. INTEGER x1
	 *  2. INTEGER v1
	 *  3. INTEGER x2
	 *  4. INTEGER v2
	 */

	public static String kangaroo(int x1, int v1, int x2, int v2) {
	// Write your code here
		//思路：依照題意，x1<x2，推得v1>v2，所以v1-v2<=0必為false(distance會越來越遠或維持不變)；再來考慮x1會不會超過x2，超過的時候"距離"為負，這時候為false；只有distance==0時才為true
		int distance=x2-x1;
		//if(v1-v2<=0) {return "NO";}
		while(distance>0 && distance+v2-v1<distance) {
			//distance+=v2-v1;
			distance-=v1-v2;
		}
		return distance==0 ? "YES" : "NO";
	}

	public static String kangaroo2(int x1, int v1, int x2, int v2) {
		//思路：將前一個邏輯簡化，直接確認v1-v2是否能整除x2-x1，如果可以就代表true，當然要排除v1-v2不為正數的情況
		return v1>v2 && (x2-x1)%(v1-v2)==0 ? "YES" : "NO";
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int x1 = Integer.parseInt(firstMultipleInput[0]);

		int v1 = Integer.parseInt(firstMultipleInput[1]);

		int x2 = Integer.parseInt(firstMultipleInput[2]);

		int v2 = Integer.parseInt(firstMultipleInput[3]);

		String result = Result.kangaroo(x1, v1, x2, v2);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
