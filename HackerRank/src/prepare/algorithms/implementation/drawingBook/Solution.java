package prepare.algorithms.implementation.drawingBook;

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
	 * Complete the 'pageCount' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER n
	 *  2. INTEGER p
	 */

	public static int pageCount(int n, int p) {
	// Write your code here

		//思路：如果n為2的倍數，則最後一頁為單頁；如果為否，則為雙頁。如果為最後一頁為單頁，則有兩種策略，不過底層邏輯相同；1.將最後一頁當作1開始計算(簡而言之，倒數第一頁為1，倒數第二頁為2，依此類推)，使用正算相同邏輯 2.補成雙頁，直接計算(n-p)/2，實作的方法為巧妙的小邏輯
		int flipFromOneCount, flipFromLastCount;
		boolean lastPageIsSingle;

		if(n%2==0) {
			lastPageIsSingle=true;
		}else {
			lastPageIsSingle=false;
		}

		flipFromOneCount=p/2;
		flipFromLastCount=(n-p)/2;
		if(lastPageIsSingle) {flipFromLastCount=(n+1-p)/2;}

		return Math.min(flipFromOneCount, flipFromLastCount);
	}

	public static int pageCount2(int n, int p) {
		//思路：將前一個方法優化並簡化code，通過觀察(n-p)/2會發現前面提到的兩種策略在底層實現是相同的，設想起始單雙頁面對於翻頁次數的影響，如題目，起始為單，則翻頁次數為p/2取商；若起始為雙，則翻頁次數為(p-1)/2取商
		boolean lastPageIsSingle = n%2==0;
		int flipFromOneCount = p/2;
		int flipFromLastCount = (n-p + (lastPageIsSingle ? 1 : 0))/2;

		return Math.min(flipFromOneCount, flipFromLastCount);
	}

	public static int pageCount3(int n, int p) {
		//思路：極致濃縮code。p在前半部，從前面翻比較快；p在後半部，從後面翻比較快，從後翻要考慮單雙問題
		//return  p>n/2 ? (int)(Math.ceil((n+1.0)/2)*2-1 -p)/2 : p/2;
		return  p>n/2 ? (n-p + (n%2==0 ? 1 : 0))/2 : p/2;
		//n%2==0單，n%2==1雙
		//n=>n+1，n=>n   4->5 5->5
		//ceil((4+1.0)/2)=3
		//3*2-1=5
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		int p = Integer.parseInt(bufferedReader.readLine().trim());

		int result = Result.pageCount(n, p);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
