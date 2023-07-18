package lc000228_SummaryRanges;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public Solution() {}

	//思路；與lc000443_StringCompression相似邏輯

	public List<String> summaryRanges(int[] nums) {
		//思路；使用index pointer去讀取，再用difference去處理差值，依照題意，如果結果是1->5，則nums[]={1, 2, 3, 4, 5}，而會不會有其它可能如nums[]={1, 3, 5}，這意味著公差為1的數才會算連續的數，只要公差不為1就不是
		List<String> resultList = new ArrayList<>();
		int index=0;
		while(index<nums.length) {
			int startNum=nums[index++];
			int difference=1;
			while(index<nums.length && nums[index]==startNum+difference) {
				index++;
				difference++;
			}
			StringBuilder result = new StringBuilder();
			result.append(startNum);
			if(difference>1) {
				result.append("->");
				result.append(nums[index-1]);
			}
			resultList.add(result.toString());
		}
		return resultList;
	}

	public List<String> summaryRanges2(int[] nums) {
		//思路；能否有logn算法(Optimal Partitioning Algorithm(最優劃分算法)?????)，待思考
		//參考：https://leetcode.com/problems/summary-ranges/solutions/63236/my-java-0ms-not-always-luckily-you-are-here-your-runtime-beats-97-90-of-java-submissions/
		//待完成
		List<String> resultList = new ArrayList<>();

		return resultList;
	}

}
