package lc000735_AsteroidCollision;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Solution {

	public Solution() {}

	public int[] asteroidCollision(int[] asteroids) {
		//思路：利用stack結構，進行放入前的比較；只有三種情況下可以將asteroid放入stack(stack裡永遠只保留不會碰撞的小行星)：1.asteroid>0(因為asteroid永遠不會與stack裡的小行星碰撞)，2.stack.isEmpty()(stack為空時也沒有碰撞的可能)，3.stack.peek()<0(不管asteroid為多少均不會碰撞)；
		//當發生碰撞時，進行絕對值大小的比較，並記錄asteroid是否湮滅，當asteroid湮滅時不push進stack
		Deque<Integer> stack = new ArrayDeque<>(asteroids.length);
		for(int asteroid : asteroids) {
			if(asteroid>0 || stack.isEmpty() || stack.peek()<0) {stack.push(asteroid);continue;}
			boolean beCollision=false;
			while(asteroid<0 && !stack.isEmpty() && stack.peek()>0) {
				if(Math.abs(asteroid)>Math.abs(stack.peek())) {
					//beCollision=false;
					stack.pop();
				}else if(Math.abs(asteroid)<Math.abs(stack.peek())) {
					beCollision=true;
					break;
				}else {
					beCollision=true;
					stack.pop();
					break;
				}
			}
			if(!beCollision) {stack.push(asteroid);}
		}
		List<Integer> result = new ArrayList<>(stack);
		Collections.reverse(result);
		return result.stream().mapToInt(i->i).toArray();
	}

	public int[] asteroidCollision2(int[] asteroids) {
		//思路：使用pointer模擬stack
		//TODO
		return new int[0];
	}

}
