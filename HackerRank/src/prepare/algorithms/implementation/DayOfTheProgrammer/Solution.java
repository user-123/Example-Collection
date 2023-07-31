package prepare.algorithms.implementation.DayOfTheProgrammer;

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
	 * Complete the 'dayOfProgrammer' function below.
	 *
	 * The function is expected to return a STRING.
	 * The function accepts INTEGER year as parameter.
	 */

	public static String dayOfProgrammer(int year) {
	// Write your code here
		//思路：非閏年的第256天為09/13，有閏年就提早1天，1918年沒閏年就多13天，這是個tricky的寫法，完整的寫法(參考：https://www.hackerrank.com/rest/contests/master/challenges/day-of-the-programmer/hackers/uwi/download_solution?primary=true)
		//儒略歷(Julian calendar)：每4一閏；公曆(Gregorian calendar)：每4一閏，100不閏，400又閏
		//俄羅斯的官方曆法：1700年到1917年為儒略歷，1918年過渡到公曆，1918/01/31(儒略歷)隔天為1918/02/14(公曆)，少了13天，意味著1918/02/14為該年的第32天
		int date=13, month=9;
		if(year==1918) {date+=13;}
		if(year<1918 && year%4==0) {date-=1;}
		if(year>1918 && (year%4==0 && year%100!=0 || year%400==0)) {date-=1;}
		return date + ".0" + month + "." + year;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int year = Integer.parseInt(bufferedReader.readLine().trim());

		String result = Result.dayOfProgrammer(year);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
