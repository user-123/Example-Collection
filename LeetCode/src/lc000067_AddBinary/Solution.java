package lc000067_AddBinary;

public class Solution {

	public Solution() {}

	public String addBinary(String a, String b) {
		StringBuilder reverseResult = new StringBuilder();
		int aDigit=a.length()-1, bDigit=b.length()-1, carry=0;
		while(aDigit>=0 || bDigit>=0) {
			int sum=0+carry;
			if(aDigit>=0) {sum+=a.charAt(aDigit--)-'0';}
			if(bDigit>=0) {sum+=b.charAt(bDigit--)-'0';}
			reverseResult.append(sum%2);
			carry=sum/2;
		}
		if(carry!=0) {reverseResult.append(carry);}
		return reverseResult.reverse().toString();
	}

}
