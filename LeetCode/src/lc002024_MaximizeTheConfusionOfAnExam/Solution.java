package lc002024_MaximizeTheConfusionOfAnExam;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public Solution() {}

	public int maxConsecutiveAnswers(String answerKey, int k) {
		//n == answerKey.length
		//1 <= n <= 5 * 10^4
		//answerKey[i] is either 'T' or 'F'
		//1 <= k <= n
		if(answerKey.length()<=1) {return answerKey.length();}
		char[] akArray = answerKey.toCharArray();

		char previousAk = akArray[0];
		int startIndex = 0, count = 0;

		for(int i=0; i<akArray.length; i++) {
			//if(??????>k)
			if(akArray[i]!=previousAk) {startIndex=i;}
			count++;
		}

		return count;
	}

	public int maxConsecutiveAnswers2(String answerKey, int k) {
		//題意不清，此方法不符合題目期望
		//思路：將每一段T/F的數量紀錄，再去比對k，不過好像"過度處理"了
		char[] akArray = answerKey.toCharArray();
		char startChar = akArray[0], previousAk = startChar;
		int count = 0;
		List<Integer> countList = new ArrayList<>();
		for(char ak : akArray) {
			if(ak==previousAk) {
				count++;
			}else {
				countList.add(count);
				previousAk=ak;
				count=0+1;
			}
		}
		countList.add(count);

		if(countList.size()==1) {return countList.get(0);}
		if(countList.size()==2) {return Math.max(countList.get(0)+Math.min(countList.get(1), k), countList.get(1)+Math.min(countList.get(0), k));}
		int maxLenght=0;
		for(int i=0; i<countList.size(); i++) {
			if(i+1==countList.size()) {
				maxLenght=Math.max(countList.get(i)+Math.min(countList.get(i-1), k), maxLenght);
				break;
			}
			if(i+2==countList.size()) {
				maxLenght=Math.max(countList.get(i)+Math.min(countList.get(i+1), k), maxLenght);
				continue;
			}
			if(countList.get(i+1)>k) {
				maxLenght=Math.max(countList.get(i)+k, maxLenght);
				continue;
				}
			maxLenght=Math.max(countList.get(i)+countList.get(i+1)+countList.get(i+2), maxLenght);

			/*
			if(i-1<0) {
				maxLenght=Math.max(countList.get(i)+countList.get(i+1), maxLenght);
				continue;
			}
			if(i+1>countList.size()-1) {
				maxLenght=Math.max(countList.get(i-1)+countList.get(i), maxLenght);
				continue;
			}
			maxLenght=Math.max(countList.get(i-1)+countList.get(i)+countList.get(i+1), maxLenght);
			*/
		}
		return maxLenght;
	}

}
