package lc000151_ReverseWordsInAString;

public class Solution {

	public Solution() {}

	public String reverseWords(String s) {
		StringBuilder result = new StringBuilder(), word = new StringBuilder();
		for(int i=s.length()-1; i>=0; i--) {
			if(s.charAt(i)!=' ') {
				word.append(s.charAt(i));
			}
			if((s.charAt(i)==' ' || i==0) && !word.isEmpty()) {
				result.append(word.reverse());
				result.append(' ');
				word.setLength(0);
			}
		}
		return result.deleteCharAt(result.length()-1).toString();
	}

}
