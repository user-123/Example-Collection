package lc000125_ValidPalindrome;

public class Solution {

	public Solution() {}

	public boolean isPalindrome(String s) {
		//關鍵API~
		//Character.isLetterOrDigit(character);
		//Character.toLowerCase(character);
		boolean result=true;
		int startPointer = 0, endPointer = s.length()-1;
		while(!(startPointer>endPointer)) {
			if(!Character.isLetterOrDigit(s.charAt(startPointer))) {
				startPointer++;
			}else if(!Character.isLetterOrDigit(s.charAt(endPointer))) {
				endPointer--;
			}else if(Character.toLowerCase(s.charAt(startPointer))==Character.toLowerCase(s.charAt(endPointer))) {
				startPointer++;
				endPointer--;
			}else {
				result=false;
				break;
			}
		}

		return result;
	}

}
