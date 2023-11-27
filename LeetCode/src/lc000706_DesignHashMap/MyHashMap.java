package lc000706_DesignHashMap;

import java.util.Arrays;

class MyHashMap {
	int[] table;

	public MyHashMap() {
		this.table = new int[1000001];
		Arrays.fill(this.table, -1);	//效能低落元凶，可以改成空為0，所有value+1儲存
	}

	public void put(int key, int value) {
		table[key]=value;
		return;
	}

	public int get(int key) {
		return table[key];
	}

	public void remove(int key) {
		table[key]=-1;
		return;
	}

}