package javaTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	public RegexTest() {}

	public static void main(String[] args) {
		//Regular expression(簡稱Regex，正規表示式、正則表達式)
		String regex = "[a-z]+@gmail.com";
		Pattern pattern1 = Pattern.compile("[a-z]+@gmail.com");
		Pattern pattern2 = Pattern.compile(regex);
		/*
		旗標的形式有兩種，除了正常的旗標表示法，可使用嵌入旗標表示法 (Embedded Flag Expression)。
		Pattern.CASE_INSENSITIVE的嵌入旗標表示法為 (?i)，
		若想對特定分組嵌入旗標，可以使用 (?i:uppengarden) 這樣的語法，以下是能使用的語法：
		Pattern.CASE_INSENSITIVE：(?i)
		Pattern.COMMENTS：(?x)
		Pattern.MULTILINE：(?m)
		Pattern.DOTALL：(?s)
		Pattern.UNICODE_CASE：(?u)
		Pattern.UNICODE_CHARACTER_CLASS：(?U)
		Pattern.UNIX_LINES：(?d)
		Pattern.CANON_EQ 與 Pattern.LITERAL 沒有對應的嵌入式表示法。
		Pattern.CANON_EQ 會啟用 Canonical equivalence，簡單來說，像 å 字元（U+00E5），也會使用 a 與 ̊ 組合標示（combining mark）（U+030A）來表示，對 Pattern 來說，預設兩個是不等價的，然而啟用了 Pattern.CANON_EQ，兩者會視為相同
		*/
		Pattern pattern3 = Pattern.compile("[a-z]+@gmail.com", 0);
		Pattern pattern4 = Pattern.compile("[a-z]+@gmail.com", Pattern.CASE_INSENSITIVE);
		Pattern pattern5 = Pattern.compile("(?i)[a-z]+@gmail.com");
		Pattern pattern6 = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		boolean trueOrFalse = Pattern.matches(null, null);
		//Pattern pattern = Pattern.compile();	//Pattern.compile()方法私有
		pattern1.matches("", "");
		String string = "";
		string.matches("[a-zA-Z]{3}");

		//標準流程：		(https://ithelp.ithome.com.tw/articles/10229763)
		//首先創建一個Regex
		final String REGEX = ".*www.*";
		// 創建一個String, 會被用於搜尋的text
		String actualString = "www.uppengarden.com";
		// 使用compile() method
		Pattern pattern = Pattern.compile(REGEX);
		// 創建一個 matcher物件
		Matcher matcher = pattern.matcher(actualString);
		// 驗證REGEX是否在actualString中
		boolean matches = matcher.matches();
		boolean matchResult = matcher.find();
		System.out.println("actualString " + "contains REGEX = " + matches);
	}

}
