package prepare.algorithms.implementation.PickingNumbers;

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
	 * Complete the 'pickingNumbers' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts INTEGER_ARRAY a as parameter.
	 */

	public static int pickingNumbers(List<Integer> a) {
	// Write your code here
		//思路：排序順反向取(小->大，大->小)；或是交錯取，從頭取(小->大)加上從第二小取(第二小->大)，理論上交錯取比較完整
		Collections.sort(a);
		int maxLength=0, length=1, prev=a.get(0);
		for(int i=1; i<a.size(); i++) {
			if(a.get(i)==prev || a.get(i)-1==prev) {length++;continue;}
			prev=a.get(i);
			maxLength = length>maxLength ? length : maxLength;
			length=1;
		}
		maxLength = length>maxLength ? length : maxLength;
		//後半段的逆向檢查貌似不需要??測資沒設計好??或是題目沒說清楚??
		//Collections.reverse(a);
		prev=a.get(a.size()-1);
		length=1;
		for(int i=a.size()-2; i>=0; i--) {
			if(a.get(i)==prev || a.get(i)+1==prev) {length++;continue;}
			prev=a.get(i);
			maxLength = length>maxLength ? length : maxLength;
			length=1;
		}
		maxLength = length>maxLength ? length : maxLength;
		return maxLength;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(toList());

		int result = Result.pickingNumbers(a);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
