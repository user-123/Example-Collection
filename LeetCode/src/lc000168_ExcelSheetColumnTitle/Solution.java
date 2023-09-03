package lc000168_ExcelSheetColumnTitle;

public class Solution {

	public Solution() {}

	public String convertToTitle(int columnNumber) {
		//思路：十進位轉二十六進位的概念，要注意的是十進位是從0到9，這個"特別的"二十六進位是從'A'(1)到'Z'(26)
		StringBuilder result = new StringBuilder();
		/*
		TODO 再思考為何不行，邏輯上有什麼缺失；想通為什麼是先-1而不是取餘後-1
		while(columnNumber/26!=0) {
			result.append((char)columnNumber%26-1+'a');
			columnNumber/=26;
		}
		result.append((char)columnNumber-1+'a');	//result.append((char)columnNumber%26-1+'a');
		*/
		while((columnNumber-1)/26!=0) {	//while(columnNumber>0) {
			result.append((char)(--columnNumber%26+'A'));
			columnNumber/=26;
		}
		result.append((char)(--columnNumber+'A'));

		return result.reverse().toString();
	}

}
