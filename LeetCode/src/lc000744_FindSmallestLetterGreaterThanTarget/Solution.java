package lc000744_FindSmallestLetterGreaterThanTarget;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	public Solution() {}

	public char nextGreatestLetter(char[] letters, char target) {
		//Set<Character> chars = new HashSet<>();
		//Map<Integer, Character> result = new HashMap<>();
		char result = target;
		if(target=='z') {return letters[0];}
		for(int i=0; i<letters.length; i++) {
			if(letters[i]-target>0 && result-letters[i]>0) {
				result=letters[i];
				break;
			}
		}
		return result==target ? letters[0] : result;
		//return result=(result==target) ? letters[0] : result;
	}

	public char nextGreatestLetter2(char[] letters, char target) {
		for(int i=0; i<letters.length; i++) {
			if(letters[i]-target>0) {
				return letters[i];
			}
		}
		return letters[0];
	}

	public char nextGreatestLetter3(char[] letters, char target) {
		//使用binary search加速XDD
		int start=0, end=letters.length-1;
		while(start<=end) {
			int mid = start+(end-start)/2;
			if(letters[mid]-target>0) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		return letters[start%letters.length];
	}
}
