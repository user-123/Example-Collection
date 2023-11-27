package lc002785_SortVowelsInAString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
	private final List<Character> vowels = Arrays.asList(new Character[] {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'});

	public Solution() {}

	public String sortVowels(String s) {
		char[] charArray = s.toCharArray();
		List<Integer> vowelIndex = new ArrayList<>();
		List<Character> vowelElement = new ArrayList<>();
		for(int i=0; i<s.length(); i++) {
			if(vowels.contains(charArray[i])) {
				vowelIndex.add(i);
				vowelElement.add(charArray[i]);
			}
		}
		Collections.sort(vowelElement);
		for(int i=0; i<vowelIndex.size(); i++) {
			charArray[vowelIndex.get(i)]=vowelElement.get(i);
		}
		return new String(charArray);
	}

	public String sortVowels2(String s) {
		char[] charArray = s.toCharArray();
		List<Integer> vowelIndex = new ArrayList<>();
		List<Character> vowelElement = new ArrayList<>();
		for(int i=0; i<s.length(); i++) {
			if(isVowel(charArray[i])) {
				vowelIndex.add(i);
				vowelElement.add(charArray[i]);
			}
		}
		Collections.sort(vowelElement);
		for(int i=0; i<vowelIndex.size(); i++) {
			charArray[vowelIndex.get(i)]=vowelElement.get(i);
		}
		return new String(charArray);
	}

	private boolean isVowel(char character) {
		character=Character.toLowerCase(character);
		return character=='a' || character=='e' || character=='i' || character=='o' || character=='u';
	}

}
