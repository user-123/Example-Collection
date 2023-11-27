package lc000389_FindTheDifference;

public class Solution {

	public Solution() {}

	public char findTheDifference(String s, String t) {
		//思路：這邊用了一個tricky的方法，試想不管每個char被使用幾次(奇數或偶數)，只要統計完，多的char其位置的boolean必定為true
		if(s.length()>t.length()) {return findTheDifference(t, s);}
		if(s.isEmpty()) {return t.charAt(0);}
		char[] sCharArray = s.toCharArray(), tCharArray = t.toCharArray();
		boolean[] used = new boolean[128];
		for(char sChar : sCharArray) {
			used[sChar]=!used[sChar];
		}
		for(char tChar : tCharArray) {
			used[tChar]=!used[tChar];
		}
		for(int i=97; i<=122; i++) {
			if(used[i]) {return (char)i;}
		}
		return ' ';
	}

	public char findTheDifference2(String s, String t) {
		//思路：前一個方法的更進階，根本不需要維護一個boolean array，只要把兩個charSum相減，得到的絕對值數字就是char的ascii碼
		if(s.length()>t.length()) {return findTheDifference(t, s);}
		//if(s.isEmpty()) {return t.charAt(0);}
		char[] sCharArray = s.toCharArray(), tCharArray = t.toCharArray();
		int charSum=0;
		for(char sChar : sCharArray) {
			charSum-=sChar;
		}
		for(char tChar : tCharArray) {
			charSum+=tChar;
		}
		return (char)charSum;
	}

	@Deprecated
	public char findTheDifference49(String s, String t) {
		//思路：沒看清楚題目的情況下，直覺使用binary search最快，但是報錯後才發現，要先排序...所以棄用
		if(s.length()>t.length()) {return findTheDifference(t, s);}
		//if(s.isEmpty()) {return t.charAt(0);}
		char[] sCharArray = s.toCharArray(), tCharArray = t.toCharArray();
		int left=0, right=tCharArray.length-1;
		while(left<right) {
			int mid=left+(right-left)/2;
			if(sCharArray[mid]==tCharArray[mid]) {left=mid+1;continue;}
			right=mid-1;
		}
		return tCharArray[left];
	}

}
