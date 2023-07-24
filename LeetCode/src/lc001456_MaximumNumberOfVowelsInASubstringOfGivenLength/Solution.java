package lc001456_MaximumNumberOfVowelsInASubstringOfGivenLength;

public class Solution {

	public Solution() {}

	public int maxVowels(String s, int k) {
		int count=0, maxCount;
		for(int i=0; i<k; i++) {
			if(isVowel(s.charAt(i))) {count++;}
		}
		maxCount=count;
		for(int i=k; i<s.length(); i++) {
			if(isVowel(s.charAt(i))) {count++;}
			if(isVowel(s.charAt(i-k))) {count--;}
			maxCount=Math.max(count, maxCount);
		}
		return maxCount;
	}

	private boolean isVowel(char character) {
		return character=='a' || character=='e' || character=='i' || character=='o' || character=='u';
	}

	public int maxVowels_2(String s, int k) {
		char[] sArray = s.toCharArray();
		int count=0, maxCount;
		for(int i=0; i<k; i++) {
			if(isVowel(sArray[i])) {count++;}
		}
		maxCount=count;
		for(int i=k; i<s.length(); i++) {
			if(isVowel(sArray[i])) {count++;}
			if(isVowel(sArray[i-k])) {count--;}
			maxCount=Math.max(count, maxCount);
		}
		return maxCount;
	}

	public int maxVowels2(String s, int k) {
		char[] sArray = s.toCharArray();
		int[] isVowel = new int[128];
		/*
		isVowel['a']=1;
		isVowel['e']=1;
		isVowel['i']=1;
		isVowel['o']=1;
		isVowel['u']=1;
		*/
		isVowel['a']=isVowel['e']=isVowel['i']=isVowel['o']=isVowel['u']=1;
		int count=0, maxCount;
		for(int i=0; i<k; i++) {
			count+=isVowel[sArray[i]];
		}
		maxCount=count;
		for(int i=k; i<s.length(); i++) {
			//count+=isVowel[sArray[i]];
			//count-=isVowel[sArray[i-k]];
			count+=isVowel[sArray[i]] - isVowel[sArray[i-k]];
			maxCount=Math.max(count, maxCount);
		}
		return maxCount;
	}

}
