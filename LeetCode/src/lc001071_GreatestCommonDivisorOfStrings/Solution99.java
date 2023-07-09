package lc001071_GreatestCommonDivisorOfStrings;

public class Solution99 {

	public Solution99() {}

	public String gcdOfStrings(String str1, String str2) {
		//輾轉相除法的邏輯
		if(!(str1+str2).equals(str2+str1)) {return "";}
		int str1Length = str1.length();
		int str2Length = str2.length();
		int gcdLength = Math.min(str1Length, str2Length);
		while(str1Length!=str2Length) {
			if(str1Length>str2Length) {
				if(str1Length%str2Length==0) {
					gcdLength=str2Length;
					break;
				}
				str1Length%=str2Length;
			}else if(str1Length<str2Length) {
				if(str2Length%str1Length==0) {
					gcdLength=str1Length;
					break;
				}
				str2Length%=str1Length;
			}
		}
		return str1.substring(0, gcdLength);
	}

}
