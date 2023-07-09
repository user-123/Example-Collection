package lc000380_InsertDeleteGetRandomO_1_;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RandomizedSet {

	private Set<Integer> hashSet;

	public RandomizedSet() {
		this.hashSet = new HashSet<>();
	}

	public boolean insert(int val) {
		return hashSet.add(val);
	}

	public boolean remove(int val) {
		return hashSet.remove(val);
	}

	public int getRandom() {
		int size = hashSet.size();
		int randomIndex = (int) (Math.random()*size);

		//Integer[] randomizedArray = (Integer[]) hashSet.toArray(new Integer[hashSet.size()]);
		//return randomizedArray[randomIndex];

		//List<Integer> randomizedList = new ArrayList<>(hashSet);
		//return randomizedList.indexOf(randomIndex);

		Iterator<Integer> iterator = hashSet.iterator();
		for(int i=0; i<randomIndex; i++) {
			iterator.next();
		}
		return iterator.next();
	}

}
