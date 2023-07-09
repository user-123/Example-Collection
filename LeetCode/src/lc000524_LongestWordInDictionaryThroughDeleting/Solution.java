package lc000524_LongestWordInDictionaryThroughDeleting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	public Solution() {}

	public String findLongestWord(String s, List<String> dictionary) {
		//老實人檢查法XDDDD
		List<String> resultList = new ArrayList<>();
		//String result;
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
					//continue;
				}
				if(sPointer<s.length() && dictionaryWord.charAt(dictionaryWordPointer) == s.charAt(sPointer)) {
					dictionaryWordPointer++;
				}
				//sPointer++;
			}
			if (dictionaryWordPointer == dictionaryWord.length()) {
				resultList.add(dictionaryWord);
			}
		}
		//比較結果集裡的元素
		System.out.println(resultList);
		//resultList.sort(Comparator.reverseOrder());
		Collections.sort(resultList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o1.length() != o2.length()) ? (o2.length() - o1.length()) : o1.compareTo(o2);
			}
		});
		System.out.println(resultList);
		/*
		if(resultList.isEmpty()) {
			result="";
		}else {
			result=resultList.get(0);
		}
		*/


		return resultList.isEmpty() ? "" : resultList.get(0);
	}

}
