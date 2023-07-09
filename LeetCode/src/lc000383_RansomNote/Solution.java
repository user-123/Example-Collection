package lc000383_RansomNote;

public class Solution {

	public Solution() {}

	//跟 242. Valid Anagram 一樣邏輯
	public boolean canConstruct(String ransomNote, String magazine) {
		if(ransomNote.length()>magazine.length()) {return false;}
		boolean result=true;
		int[] charUsedCounts = new int[26];
		for(char character : magazine.toCharArray()) {
			charUsedCounts[character-'a']++;
		}
		for(char character : ransomNote.toCharArray()) {
			charUsedCounts[character-'a']--;
		}
		for(int usedCount : charUsedCounts) {
			if(usedCount<0) {
				result=false;
				break;
			}
		}
		return result;
	}

}
