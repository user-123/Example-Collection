package lc002024_MaximizeTheConfusionOfAnExam;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public Solution() {}

	public int maxConsecutiveAnswers(String answerKey, int k) {
		//思路：使用sliding windows，先檢查翻轉T的情況，再檢查翻轉F的情況，取其中最長
		char[] akArray = answerKey.toCharArray();
		int start=0, end=0, count=0, maxLength=0;
		while(end<akArray.length){
			if(akArray[end++]=='T') {count++;}
			while(count>k){
				if(akArray[start++]=='T') {count--;}
			}
			maxLength = Math.max(end-start, maxLength);
		}
		start=0; end=0; count=0;
		while(end<akArray.length){
			if(akArray[end++]=='F') {count++;}
			while(count>k){	// && start<akArray.length
				if(akArray[start++]=='F') {count--;}
			}
			maxLength = Math.max(end-start, maxLength);
		}
		return maxLength;
	}

	public int maxConsecutiveAnswers2(String answerKey, int k) {
		//思路：與前一方法邏輯相同，使用sliding windows分別記錄tCount和fCount，並交叉檢查switch T 或 F 的情況，永遠選擇需要switch最小的選項(T或F)，其長度為局部window最長；此方法的程式碼能清楚表示意圖，利於閱讀與維護，讚讚
		//if(answerKey.length()<=1) {return answerKey.length();}
		char[] akArray = answerKey.toCharArray();
		int start=0, end=0, tCount=0, fCount=0, maxLenght=0;
		while(end<akArray.length) {
			if(akArray[end++]=='T') {
				tCount++;
			}else {
				fCount++;
			}
			while(Math.min(tCount, fCount)>k) {
				if(akArray[start++]=='T') {
					tCount--;
				}else {
					fCount--;
				}
			}
			maxLenght=Math.max(tCount+fCount, maxLenght);
			//maxLenght = tCount+fCount>maxLenght ? tCount+fCount : maxLenght;
		}
		return maxLenght;
	}

	public int maxConsecutiveAnswers50(String answerKey, int k) {
		//思路：將每一段T/F的數量紀錄，再去比對k，XXXXXXXXXX
		//算法沒問題，但效率太差，因為時間複雜度為O(n^2)
		char[] akArray = answerKey.toCharArray();
		char previousAk = akArray[0];
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
			int j=i, length=0, swapCount=k;
			while(j<=countList.size()-1) {
				length+=countList.get(j++);
				if(swapCount==0 || j>countList.size()-1) {break;}
				length+=Math.min(countList.get(j), swapCount);
				swapCount-=countList.get(j++);
				if(swapCount<0) {break;}
			}
			maxLenght = length>maxLenght ? length : maxLenght;
		}
		for(int i=0; i<countList.size(); i++) {
			int j=i, length=0, swapCount=k;
			while(j<=countList.size()-1) {
				if(swapCount==0) {break;}
				length+=Math.min(countList.get(j), swapCount);
				swapCount-=countList.get(j++);
				if(swapCount<0 || j>countList.size()-1) {break;}
				length+=countList.get(j++);
			}
			maxLenght = length>maxLenght ? length : maxLenght;
		}
		for(int i=countList.size()-1; i>=0; i--) {
			int j=i, length=0, swapCount=k;
			while(j>=0) {
				length+=countList.get(j--);
				if(swapCount==0 || j<0) {break;}
				length+=Math.min(countList.get(j), swapCount);
				swapCount-=countList.get(j--);
				if(swapCount<0) {break;}
			}
			maxLenght = length>maxLenght ? length : maxLenght;
		}
		for(int i=countList.size()-1; i>=0; i--) {
			int j=i, length=0, swapCount=k;
			while(j>=0) {
				if(swapCount==0) {break;}
				length+=Math.min(countList.get(j), swapCount);
				swapCount-=countList.get(j--);
				if(swapCount<0 || j<0) {break;}
				length+=countList.get(j--);
			}
			maxLenght = length>maxLenght ? length : maxLenght;
		}
		/*
		for(int i=countList.size()-1; i>=0; i--) {
			int j=i, length=0, swapCount=k;
			while(j>=0) {
				length+=countList.get(j);
				if(swapCount==0 || j-1<0) {break;}
				length+=Math.min(countList.get(j-1), swapCount);
				swapCount-=countList.get(j-1);
				j-=2;
				if(swapCount<0) {break;}
			}
			if(j==-1 && swapCount>=0) {length+=countList.get(j+1);}
			maxLenght = length>maxLenght ? length : maxLenght;
		}
		*/
		return maxLenght;
	}

	public int maxConsecutiveAnswers51(String answerKey, int k) {
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
