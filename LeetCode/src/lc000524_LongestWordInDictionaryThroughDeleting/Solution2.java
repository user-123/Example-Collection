package lc000524_LongestWordInDictionaryThroughDeleting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {

	public Solution2() {}

	public String findLongestWord(String s, List<String> dictionary) {
		//先排序再檢查

		//突發奇想，何不乾脆把dictionary先反向排序(雖然有些討巧，而且要正確評估排序的時間複雜度)
		//再從頭到尾檢查一遍，如果有找到，就把剩下同樣長度的尋一遍，這樣就不必做短的檢查了，先按長度降冪排列，同長度順序可不分
		//或是更極端一點，直接長度降冪排序，字母升冪排序，那找到的第一個即為結果

		System.out.println(dictionary);
		Collections.sort(dictionary, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return(o1.length() != o2.length()) ? (o2.length() - o1.length()) : o1.compareTo(o2);
			}});
		System.out.println(dictionary);
		String result = "";
		finish:for(String dictionaryWord : dictionary) {
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
				if (dictionaryWordPointer == dictionaryWord.length()) {
					result=dictionaryWord;
					break finish;
				}
			}

		}
		return result;
	}

}
