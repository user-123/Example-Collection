package prepare.algorithms.implementation.climbingTheLeaderboard;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'climbingLeaderboard' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY.
	 * The function accepts following parameters:
	 *  1. INTEGER_ARRAY ranked
	 *  2. INTEGER_ARRAY player
	 */

	public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
	// Write your code here
		List<Integer> denseRanked = new ArrayList<>(ranked.size()), result = new ArrayList<>(player.size());
		int prevScore=-1;
		for(int score : ranked) {
			if(score==prevScore) {continue;}
			denseRanked.add(score);
			prevScore=score;
		}
		for(int score : player) {
			if(score<denseRanked.get(denseRanked.size()-1)) {result.add(denseRanked.size()+1);continue;}
			if(score>=denseRanked.get(0)) {result.add(0+1);continue;}
			int left=0, right=denseRanked.size()-1, mid=-1, rankedScore;
			while(left<right) {
				mid=left+(right-left)/2;
				rankedScore=denseRanked.get(mid);
				if(rankedScore>score) {left=mid+1;mid=left;continue;}
				if(rankedScore<=score) {right=mid;continue;}
			}
			result.add(mid+1);
			/*
			int index;
			for(index=0; index<denseRanked.size(); index++) {
				if(denseRanked.get(index)<=score) {break;}
			}
			result.add(index+1);
			*/
		}
		return result;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(toList());

		int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(toList());

		List<Integer> result = Result.climbingLeaderboard(ranked, player);

		bufferedWriter.write(
			result.stream()
				.map(Object::toString)
				.collect(joining("\n"))
			+ "\n"
		);

		bufferedReader.close();
		bufferedWriter.close();
	}
}
