package lc000524_LongestWordInDictionaryThroughDeleting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution4 {

	public Solution4() {}

	public String findLongestWord(String s, List<String> dictionary) {
		//簡化老實人檢查法的邏輯
		List<String> resultList = new ArrayList<>();
		String result;
		for(String dictionaryWord : dictionary) {
			System.out.println(dictionaryWord);
			if(dictionaryWord.length() > s.length()) {
				continue;
			}
			int sPointer = 0;
			int dictionaryWordPointer = 0;
			while(sPointer < s.length() && dictionaryWordPointer < dictionaryWord.length()) {
				if(dictionaryWord.charAt(dictionaryWordPointer) == s.charAt(sPointer)) {
					sPointer++;
					dictionaryWordPointer++;
				}else {
					sPointer++;
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
