package lc000205_IsomorphicStrings;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public Solution() {}

	public boolean isIsomorphic(String s, String t) {
		//思路：依照題意，同構性指的是兩個string的每個char都能雙向映射，代表每對兩個char之間有一對一的mapping關係
		if(s.length()!=t.length()) {return false;}
		Map<Character, Character> sMapToT = new HashMap<>(), tMapToS = new HashMap<>();
		char[] sCharArray = s.toCharArray(), tCharArray = t.toCharArray();
		for(int i=0; i<sCharArray.length; i++) {
			sMapToT.put(sCharArray[i], tCharArray[i]);
			tMapToS.put(tCharArray[i], sCharArray[i]);
		}
		for(int i=0; i<sCharArray.length; i++) {
			if(sMapToT.get(sCharArray[i])!=tCharArray[i] || tMapToS.get(tCharArray[i])!=sCharArray[i]) {return false;}
		}
		return true;
	}

}
