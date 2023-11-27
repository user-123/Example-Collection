package lc000880_DecodedStringAtIndex;

public class Solution {

	public Solution() {}

	public String decodeAtIndex(String s, int k) {
		//思路：
		char[] sCharArray = s.toCharArray();
		long n=0L;
		int index;
		for(index=0; n<k; index++) {
			n = sCharArray[index]>='0' && sCharArray[index]<='9' ? n*(sCharArray[index]-'0') : n+1;
		}
		for(--index; index>0; index--) {
			if(Character.isDigit(sCharArray[index])) {
				n/=sCharArray[index]-'0';
				k%=n;
				continue;
			}
			if(k%n==0) {break;}
			n--;
		}
		return Character.toString(sCharArray[index]);
	}

	public String decodeAtIndex2(String s, int k) {
		char[] sCharArray = s.toCharArray();
		StringBuilder result = new StringBuilder();
		for(char character : sCharArray) {
			if(Character.isAlphabetic(character)) {result.append(character);continue;}
			//TODO
			if(result.length()>=k) {return result.substring(k-1, k);}
		}


		return "";
	}

}
