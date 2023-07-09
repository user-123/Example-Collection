package lc001768_MergeStringsAlternately;

public class Solution {

	public Solution() {}

	public String mergeAlternately(String word1, String word2) {
		int word1Length = word1.length();
		int word2Length = word2.length();
		int word1Pointer = 0;
		int word2Pointer = 0;
		//StringBuilder result = new StringBuilder();
		StringBuilder result = new StringBuilder(word1Length+word2Length);	//效能高，線程不安全
		//StringBuffer result = new StringBuffer(word1Length+word2Length);	//效能中，線程安全
		//String result = "";	//效能低；是immutable class，所以本質上是"線程安全"的
		while(word1Pointer+word2Pointer<word1Length+word2Length) {
			if(word1Pointer<word1Length) {
				result.append(word1.charAt(word1Pointer++));
			}
			if(word2Pointer<word2Length) {
				result.append(word2.charAt(word2Pointer++));
			}
		}
		return result.toString();

	}

	public String mergeAlternately2(String word1, String word2) {
		int word1Length = word1.length();
		int word2Length = word2.length();
		int word1Pointer = 0;
		int word2Pointer = 0;
		StringBuilder result = new StringBuilder();
		while(word1Pointer<word1Length && word2Pointer<word2Length) {
			result.append(word1.charAt(word1Pointer++));
			result.append(word2.charAt(word2Pointer++));
		}
		while(word1Pointer<word1Length) {
			result.append(word1.charAt(word1Pointer++));
		}
		while(word2Pointer<word2Length) {
			result.append(word2.charAt(word2Pointer++));
		}
		return result.toString();
	}

	public String mergeAlternately3(String word1, String word2) {
		int word1Length = word1.length();
		int word2Length = word2.length();
		int word1Pointer = 0;
		int word2Pointer = 0;
		String result = "";
		while(word1Pointer+word2Pointer<word1Length+word2Length) {
			if(word1Pointer<word1Length) {
				result+=word1.charAt(word1Pointer++);
			}
			if(word2Pointer<word2Length) {
				result+=word2.charAt(word2Pointer++);
			}
		}
		return result;
	}

	public String mergeAlternately4(String word1, String word2) {
		int word1Length = word1.length();
		int word2Length = word2.length();
		int word1Pointer = 0;
		int word2Pointer = 0;
		String result = "";
		while(word1Pointer<word1Length && word2Pointer<word2Length) {
			result+=word1.charAt(word1Pointer++);
			result+=word2.charAt(word2Pointer++);
		}
		while(word1Pointer<word1Length) {
			result+=word1.charAt(word1Pointer++);
		}
		while(word2Pointer<word2Length) {
			result+=word2.charAt(word2Pointer++);
		}
		return result;
	}
}
