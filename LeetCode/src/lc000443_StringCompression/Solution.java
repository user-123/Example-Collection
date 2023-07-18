package lc000443_StringCompression;

public class Solution {

	public Solution() {}

	public int compress(char[] chars) {
		//思路；修改_compress的方法，加上將計數(count)的char填入input的chars裡
		char lastChar=' ';
		int result=0, count=0, index=0;
		for(char character : chars) {
			if(character!=lastChar) {	// && lastChar!=' '
				if(count>1) {
					String countToString = String.valueOf(count);
					for(char countDigit : countToString.toCharArray()) {
						chars[index++]=countDigit;
					}
					while(count!=0) {
						count/=10;
						result++;
					}
				}
				chars[index++]=character;
				result++;
				count++;
				lastChar=character;
			}else {
				count++;
			}
		}
		if(count>1) {
			String countToString = String.valueOf(count);	//Integer.toString(count);
			for(char countDigit : countToString.toCharArray()) {
				chars[index++]=countDigit;
			}
			while(count!=0) {
				count/=10;
				result++;
			}
		}
		return result;
	}

	public int compress2(char[] chars) {
		//思路；將compress邏輯重寫，思路是差不多的，不過直接整體考量，包含chars的寫入；
		//後來選定的方向為，直接使用readIndex pointer讀取當前位置的char，使用另一個resultIndex pointer去寫入壓縮後的結果(readIndex永遠跑得比resultIndex快，頂多持平但不會超過，所以不需擔心結果蓋到輸入)
		//將第一個遇到char存起來做比對，如果一樣就count++，readIndex向後移，直到char不一樣；判斷count是否大於1，如果是就利用resultIndex將count digit寫入chars
		int resultIndex=0, readIndex=0;
		while(readIndex<chars.length) {
			char lastChar=chars[readIndex];
			int count=0;
			while(readIndex<chars.length && chars[readIndex]==lastChar) {
				count++;
				readIndex++;
			}
			chars[resultIndex++]=lastChar;
			if(count>1) {
				for(char countDigit : String.valueOf(count).toCharArray()) {	//Integer.toString(count).toCharArray()
					chars[resultIndex++]=countDigit;
				}
			}
		}
		return resultIndex;
	}

	public int _compress(char[] chars) {
		//思路；當遇到不一樣的char時壓縮長度(result)會增加；將count>1的數字利用/10去計算count位數，加到結果(result)；
		//然後接下來的char要計入，所以壓縮長度result+1(第一個char是利用一點點tricky的方法，將lastChar初始值設為空白char，然後count為0，遇到了chars第一個char(chars[0])，因為判定不一樣的char，所以也會計算到chars[0])
		//算法正確但不符合題意 ="= ，如果只是純粹return壓縮後的長度的話，這個算法簡單高效，完全沒毛病
		char lastChar=' ';
		int result=0, count=0;
		for(char character : chars) {
			if(character!=lastChar) {	// && lastChar!=' '
				if(count!=1) {
					while(count!=0) {
						count/=10;
						result++;
					}
				}
				lastChar=character;
				result++;
				count=1;
			}else {
				count++;
			}
		}
		if(count!=1) {
			while(count!=0) {
				count/=10;
				result++;
			}
		}
		return result;
	}

}
