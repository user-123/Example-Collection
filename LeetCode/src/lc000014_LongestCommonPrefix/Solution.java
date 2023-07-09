package lc000014_LongestCommonPrefix;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public String longestCommonPrefix(String[] strs) {
		String prefix = "";
		char compare;
		int shortestStringLength = strs[0].length();
		//int[] stringsLength = new int[strs.length];
		for(int i=0; i<strs.length; i++) {
			//stringsLength[i]=strs[i].length();
			if(strs[i].length()<shortestStringLength) {
				shortestStringLength=strs[i].length();
			}
		}
		//Arrays.sort(stringsLength);
		for(int i=0; i<shortestStringLength; i++) {	//stringsLength[stringsLength.length-1]
			compare=strs[0].charAt(i);
			for(int j=0; j<strs.length; j++) {
				if(strs[j].charAt(i)!=compare) {
					return prefix;
				}
			}
			prefix+=compare;
		}
		return prefix;
	}

	public String longestCommonPrefix2(String[] strs) {
		//先排列，比第一個跟最後一string
		Arrays.sort(strs);
		int index = 0;
		while(index<strs[0].length()) {
			if(strs[0].charAt(index)!=strs[strs.length-1].charAt(index)) {
				break;
			}
			index++;
		}
		return strs[0].substring(0, index);
	}

	public String longestCommonPrefix3(String[] strs) {
		//爽爽用API比對，居然比我手動的還要快一點點@@
		if(strs.length==0) {return "";}
		String prefix = strs[0];
		for(int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
			}
		}
		return prefix;
	}

	public String longestCommonPrefix4(String[] strs) {
		//待完成，看到有人使用StringBuilder或StringBuffer，應該要試試看
		return "";
	}

}
