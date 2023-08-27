package prepare.java.introduction.javaDateAndTime;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'findDay' function below.
	 *
	 * The function is expected to return a STRING.
	 * The function accepts following parameters:
	 *  1. INTEGER month
	 *  2. INTEGER day
	 *  3. INTEGER year
	 */

	public static String findDay(int month, int day, int year) {
		//使用LocalDate
		LocalDate theDay = LocalDate.of(year, month, day);
		//DayOfWeek dayOfWeek = theDay.getDayOfWeek();
		//int intOfDayOfWeek = dayOfWeek.getValue();
		//return dayOfWeek.toString();
		return theDay.getDayOfWeek().toString();
	}

	public static String findDay2(int month, int day, int year) {
		//使用LocalDateTime
		LocalDateTime theDay = LocalDateTime.of(year, month, day, 0, 0, 0);	//LocalDateTime theDay = LocalDateTime.of(LocalDate.of(year, month, day), null);
		//LocalDate localDate = LocalDate.of(year, month, day);
		//LocalDateTime theDay = LocalDateTime.of(localDate, null);
		return theDay.getDayOfWeek().toString();
	}

	public static String findDay3(int month, int day, int year) {
		//使用Calendar
		Calendar theDay = Calendar.getInstance();
		theDay.set(year, month-1, day);	//注意：Calendar的1月值為0
		/*
		String result="";
		switch(theDay.get(Calendar.DAY_OF_WEEK)) {
			case 1 -> result="SUNDAY";
			case 2 -> result="MONDAY";
			case 3 -> result="TUESDAY";
			case 4 -> result="WEDNESDAY";
			case 5 -> result="THURSDAY";
			case 6 -> result="FRIDAY";
			case 7 -> result="SATURDAY";
		}
		return result;
		*/
		return theDay.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, new Locale("en")).toUpperCase();	//語言或地區會影響時間顯示的內容，Locale設為"en"會顯示"Wednesday"(""或其它會顯示Wed)；在利用String.toUpperCase()，將字母變成全大寫
		/*
		final String[] daysOfWeek = new String[] {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
		return daysOfWeek[theDay.get(Calendar.DAY_OF_WEEK)-1];
		*/
	}

	public static String findDay4(int month, int day, int year) {
		//使用SimpleDateFormat
		SimpleDateFormat theDay = new SimpleDateFormat("EEEE");	//注意：格式化字符串存在區分大小寫，對於創建SimpleDateFormat傳入的參數：EEEE代表星期，如"星期四"：E、EE、EEE代表週，如"週四"：u代表數字星期，如"4"；MMMM代表文字月份，如"十一月"；MM代表數字月份，如"11"；yyyy代表年份，如"2010"；dd代表天，如"25"：""代表不顯示，吃飽太閒啦XDD
		return theDay.format(new Date(year-1900, month-1, day)).toUpperCase();	//注意：Date的年為該年距離1900年多少年(也就是2015年，set的時候year要填2015-1900=115)；1月值為0(所以5月在set時候要填5-1=4)	//如果在英語區，答案會對，不過需要多加個.toUpperCase()；中文區會顯示星期幾
	}

	public static String findDay5(int month, int day, int year) {
		//使用Date
		Date theDay = new Date(year-1900, month-1, day);	//注意：Date的年為該年距離1900年多少年(也就是2015年，set的時候year要填2015-1900=115)；1月值為0(所以5月在set時候要填5-1=4)
		/*
		String result="";
		switch(theDay.getDay()) {
			case 0 -> result="SUNDAY";
			case 1 -> result="MONDAY";
			case 2 -> result="TUESDAY";
			case 3 -> result="WEDNESDAY";
			case 4 -> result="THURSDAY";
			case 5 -> result="FRIDAY";
			case 6 -> result="SATURDAY";
		}
		return result;
		 */
		final String[] daysOfWeek = new String[] {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
		return daysOfWeek[theDay.getDay()];
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int month = Integer.parseInt(firstMultipleInput[0]);

		int day = Integer.parseInt(firstMultipleInput[1]);

		int year = Integer.parseInt(firstMultipleInput[2]);

		String res = Result.findDay(month, day, year);

		bufferedWriter.write(res);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
