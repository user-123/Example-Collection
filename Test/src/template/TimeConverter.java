package template;

public class TimeConverter {

	public TimeConverter() {}

	public static void main(String[] args) {}

	private static String convert12To24(String s) {
		StringBuilder result = new StringBuilder(s);
		int sLength=result.length();
		char period=result.charAt(sLength-2), hourFirstDigit=result.charAt(0), hourSeconfDigit=result.charAt(1);
		if(period=='P') {
			if(hourFirstDigit=='1' && hourSeconfDigit=='2') {
				//do nothing
			}else if(hourSeconfDigit=='8') {
				result.setCharAt(0, '2');
				result.setCharAt(1, '0');
			}else if(hourSeconfDigit=='9') {
				result.setCharAt(0, '2');
				result.setCharAt(1, '1');
			}else {
				result.setCharAt(0, (char) (hourFirstDigit+1));
				result.setCharAt(1, (char) (hourSeconfDigit+2));
			}
		}
		if(period=='A') {
			if(hourFirstDigit=='1' && hourSeconfDigit=='2') {
				result.setCharAt(0, '0');
				result.setCharAt(1, '0');
			}
		}
		result.delete(sLength-2, sLength).toString();
		System.out.println(result.toString());
		return result.toString();
	}

	private static String convert24To12(String s) {
		return "";
	}

}
