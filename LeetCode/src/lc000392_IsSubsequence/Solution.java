package lc000392_IsSubsequence;

public class Solution {

	public Solution() {}

	public boolean isSubsequence(String s, String t) {
		int index=0, sLength=s.length();
		if(sLength==0) {return true;}
		for(char character : t.toCharArray()) {
			if(character==s.charAt(index)) {index++;}
			if(index==sLength) {return true;}
		}
		return false;
	}

	public boolean isSubsequence2(String s, String t) {
		int index = 0;
		StringBuilder sequence = new StringBuilder(t);
		for(int i=0;i<s.length();i++){
			index = sequence.indexOf(s.substring(i,i+1),index);
			if(index==-1) {return false;}
			sequence.setCharAt(index,'-');
		}
		return true;
	}

}
