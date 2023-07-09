package lc000859_BuddyStrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public Solution() {}

	public boolean buddyStrings(String s, String goal) {
		if(s.length()!=goal.length()) {return false;}
		if(s.equals(goal)) {
			Set<Character> charSet = new HashSet<>();
			for(char character : s.toCharArray()) {
				charSet.add(character);
			}
			return charSet.size()<s.length();
		}
		int count = 0;
		char sCharacter = 0, goalCharacter = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)!=goal.charAt(i) && count==0) {
				sCharacter=s.charAt(i);
				goalCharacter=goal.charAt(i);
				count++;
			}else if(s.charAt(i)!=goal.charAt(i) && count==1) {
				if(s.charAt(i)!=goalCharacter || goal.charAt(i)!=sCharacter) {return false;}
				count++;
			}else if(count==2) {
				return false;
			}
		}
		return count!=1;
	}

	public boolean buddyStrings2(String s, String goal) {
		if(s.length()!=goal.length()) {return false;}
		int count = 0;
		char sCharacter = 0, goalCharacter = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)!=goal.charAt(i) && count==0) {
				sCharacter=s.charAt(i);
				goalCharacter=goal.charAt(i);
				count++;
			}else if(s.charAt(i)!=goal.charAt(i) && count==1) {
				if(s.charAt(i)!=goalCharacter || goal.charAt(i)!=sCharacter) {return false;}
				count++;
			}else if(s.charAt(i)!=goal.charAt(i) && count==2) {
				count++;
			}else if(count>2) {
				return false;
			}
		}
		if(count==0) {
			Set<Character> charSet = new HashSet<>();
			for(char character : s.toCharArray()) {
				charSet.add(character);
			}
			return charSet.size()<s.length();
		}
		return count!=1;
	}

	public boolean buddyStrings3(String s, String goal) {
		if(s.length()!=goal.length()) {return false;}
		List<Character> sDifferent = new ArrayList<>();
		List<Character> goalDifferent = new ArrayList<>();
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)!=goal.charAt(i)) {
				sDifferent.add(s.charAt(i));
				goalDifferent.add(goal.charAt(i));
				if(sDifferent.size()>2 || goalDifferent.size()>2) {return false;}
			}
		}
		if(sDifferent.size()==0 || goalDifferent.size()==0) {
			Set<Character> charSet = new HashSet<>();
			for(char character : s.toCharArray()) {
				charSet.add(character);
			}
			return charSet.size()<s.length();
		}else if(sDifferent.size()==1 || goalDifferent.size()==1) {
			return false;
		}
		return sDifferent.get(0)==goalDifferent.get(1) && sDifferent.get(1)==goalDifferent.get(0);
	}

	public boolean buddyStrings4(String s, String goal) {
		if(s.length()!=goal.length()) {return false;}
		List<Character> sDifferent = new ArrayList<>();
		List<Character> goalDifferent = new ArrayList<>();
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)!=goal.charAt(i)) {
				sDifferent.add(s.charAt(i));
				goalDifferent.add(goal.charAt(i));
				if(sDifferent.size()>2 || goalDifferent.size()>2) {return false;}
			}
		}
		if(sDifferent.size()==0 || goalDifferent.size()==0) {
			int[] charCount = new int[26];
			for(char character : s.toCharArray()) {
				charCount[character-'a']++;
			}
			for(int count : charCount) {
				if(count>1) {return true;}
			}
			return false;
		}else if(sDifferent.size()==1 || goalDifferent.size()==1) {
			return false;
		}
		return sDifferent.get(0)==goalDifferent.get(1) && sDifferent.get(1)==goalDifferent.get(0);
	}

}
