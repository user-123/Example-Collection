package lc000242_ValidAnagram;

public class Solution {

	public Solution() {}

	//跟 383. Ransom Note 一樣邏輯
	public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length()) {return false;}
		boolean result=true;
		int[] charUsedCounts = new int[26];
		for(char character : s.toCharArray()) {
			charUsedCounts[character-'a']++;
		}
		for(char character : t.toCharArray()) {
			charUsedCounts[character-'a']--;
		}
		for(int usedCount : charUsedCounts) {
			if(usedCount!=0) {
				result=false;
				break;
			}
		}
		return result;
	}

	public boolean isAnagram2(String s, String t) {
		if(s.length()!=t.length()) {return false;}
		boolean result=true;
		int[] charUsedCounts = new int[26];
		for(int i=0; i<s.length(); i++) {
			charUsedCounts[s.charAt(i)-'a']++;
			charUsedCounts[t.charAt(i)-'a']--;
		}
		for(int usedCount : charUsedCounts) {
			if(usedCount!=0) {
				result=false;
				break;
			}
		}
		return result;
	}

	public boolean isAnagram3(String s, String t) {
		if(s.length()!=t.length()) {return false;}
		boolean result=true;
		int[] charUsedCounts = new int[26];
        char[] sArray = s.toCharArray(), tArray = t.toCharArray();
		for(int i=0; i<s.length(); i++) {
			charUsedCounts[sArray[i]-'a']++;
			charUsedCounts[tArray[i]-'a']--;
		}
		for(int usedCount : charUsedCounts) {
			if(usedCount!=0) {
				result=false;
				break;
			}
		}
		return result;
	}

	public boolean isAnagram4(String s, String t) {
		if(s.length()!=t.length()) {return false;}
		boolean result=true;
		int[] charUsedCounts = new int[26];
		for(char character : s.toCharArray()) {
			charUsedCounts[character-'a']++;
		}
		for(char character : t.toCharArray()) {
			charUsedCounts[character-'a']--;
			if(charUsedCounts[character-'a']<0) {
				result=false;
				break;
			}
		}
		return result;
	}

}
