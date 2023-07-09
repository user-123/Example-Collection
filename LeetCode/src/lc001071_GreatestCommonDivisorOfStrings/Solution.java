package lc001071_GreatestCommonDivisorOfStrings;

public class Solution {

	public Solution() {}

	public String gcdOfStrings(String str1, String str2) {
		//題目給訂條件為1 <= str1.length, str2.length <= 1000，所以沒有空字串問題要處理
		if(!(str1+str2).equals(str2+str1)) {return "";}
		int str1Length = str1.length();
		int str2Length = str2.length();
		//StringBuilder gcd = new StringBuilder(Math.min(str1Length, str2Length));
		int gcdLength = Math.min(str1Length, str2Length);
		for(int i=gcdLength; i>=1; i--) {
			if(str1Length%i==0 && str2Length%i==0) {
				gcdLength=i;
				break;
			}
		}
		return str1.substring(0, gcdLength);
	}

}
