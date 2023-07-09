package lc000524_LongestWordInDictionaryThroughDeleting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution3 {

	public Solution3() {}

	public String findLongestWord(String s, List<String> dictionary) {
		//老實人檢查法，再改造成遞迴，待修改改改改改改改改改
		List<String> resultList = new ArrayList<>();
		String result;
		for(String dictionaryWord : dictionary) {
			System.out.println(dictionaryWord);
			if(dictionaryWord.length() > s.length()) {
				continue;
			}
			int sPointer = 0;
			int dictionaryWordPointer;
			for(dictionaryWordPointer=0; dictionaryWordPointer<dictionaryWord.length(); sPointer++) {
				if(!(sPointer<s.length())) {
					break;
				}
				while(sPointer<s.length() && dictionaryWord.charAt(dictionaryWordPointer) != s.charAt(sPointer)) {
					sPointer++;
					continue;
				}
				if(sPointer<s.length() && dictionaryWord.charAt(dictionaryWordPointer) == s.charAt(sPointer)) {
					dictionaryWordPointer++;
				}
			}
			if (dictionaryWordPointer == dictionaryWord.length()) {
				resultList.add(dictionaryWord);
			}

		}
		//比較結果集裡的元素
		System.out.println(resultList);
		Collections.sort(resultList, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s1.length() != s2.length()) ? (s2.length() - s1.length()) : s1.compareTo(s2);
			}});
		System.out.println(resultList);
		return resultList.isEmpty() ? "" : resultList.get(0);
	}

}
