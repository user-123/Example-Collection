package lc000524_LongestWordInDictionaryThroughDeleting;

import java.util.Arrays;
import java.util.List;

public class Solution9999 {

	public Solution9999() {}

	public String findLongestWord(String s, List<String> dictionary) {
        int[][] nextChar = preprocess(s);
        String output = null;
        for(String word : dictionary)
            if(found(nextChar, word) && (output==null || output.length() < word.length() || (output.length() == word.length() && output.compareTo(word)>0)))
                output = word;
        return (output==null)?"":output;
    }
    private boolean found(int[][] nextChar, String word) {
    	System.out.println("字典string：" + word);
        int ind=nextChar[0][word.charAt(0)-'a']+1;
        System.out.println("第1字：" + ind + "位");
        for(int i=1;i<word.length();i++) {
            if(ind==0)return false;
            ind = nextChar[ind][word.charAt(i)-'a']+1;
            System.out.println(ind==0 ? "第" + (i+1) + "字：" + "沒位" : "第" + (i+1) + "字：" + ind + "位");
        }
        return ind!=0;
    }
    private int[][] preprocess(String s) {
        int n = s.length();
        int[][] nextChar = new int[n+1][26];
        Arrays.fill(nextChar[n], -1);
        for(int i=n-1;i>=0;i--) {
            for(int j=0;j<26;j++)
                nextChar[i][j] = nextChar[i+1][j];
            nextChar[i][s.charAt(i)-'a'] = i;
        }
        //印出陣列學習
        for(int[] x : nextChar) {System.out.println(Arrays.toString(x));}
        return nextChar;
    }
}
