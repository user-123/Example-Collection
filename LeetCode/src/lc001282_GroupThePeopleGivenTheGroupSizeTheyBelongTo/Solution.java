package lc001282_GroupThePeopleGivenTheGroupSizeTheyBelongTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public Solution() {}

	public List<List<Integer>> groupThePeople(int[] groupSizes) {
		//思路：利用維持一個map，來將groupSizes[i]作為key，維護value裡的list(list存放i)；只要list.size()>=groupSizes[i]，就將list存入reusltList裡；又因為題目有設計過，所以不需要考慮最後map裡面會有殘留的數據，所以不需要在最後檢查map裡殘留的list存入resultList(當然如果題目稍微改一下下條件，就必須補上了，且判斷式裡的result = new ArrayList<>(groupSizes[i])也必須改成map.remove(groupSizes[i])，另外map.put(groupSizes[i], result)也需要加入判斷)
		List<List<Integer>> resultList = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		for(int i=0; i<groupSizes.length; i++) {
			List<Integer> result = map.getOrDefault(groupSizes[i], new ArrayList<>(groupSizes[i]));
			result.add(i);
			if(result.size()>=groupSizes[i]) {
				resultList.add(result);
				result = new ArrayList<>(groupSizes[i]);
				//map.remove(groupSizes[i]);
			}
			map.put(groupSizes[i], result);
		}
		return resultList;
	}

	public List<List<Integer>> groupThePeople2(int[] groupSizes) {
		//思路：直接做個map將所有i存入map key groupSizes[i]裡頭，再將所有i按key大小分組取出放入resultList裡
		List<List<Integer>> resultList = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		for(int i=0; i<groupSizes.length; i++) {
			List<Integer> result = map.getOrDefault(groupSizes[i], new ArrayList<>());
			result.add(i);
			map.put(groupSizes[i], result);
		}
		map.forEach((k, v) -> {
			List<Integer> result = new ArrayList<>(k);
			for(int element : v) {
				result.add(element);
				if(result.size()>=k) {resultList.add(result);result = new ArrayList<>(k);}
			}
		});
		return resultList;
	}

}
