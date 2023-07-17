package javaTest;

//import java.util.*;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Dictionary;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

enum listOfEnum {a, b, c, d};	//可以不加分號耶0.0

public class CollectionsFrameworkTest {

	public CollectionsFrameworkTest() {}

	public static void main(String[] args) {
		Collection<? extends Object> collection_ = new HashSet<>();
		Collection<? super Object> collection__ = new HashSet<>();
		//Collection為Set、List、Queue interface的父interface
		Collection<?> collection = new LinkedList<>();
		Set<?> setImplByHashSet = new HashSet<>();
		Set<?> setImplByLinkedHashSet = new LinkedHashSet<>();
		Set<?> setImplByTreeSet = new TreeSet<>();
		List<?> listImplByArrayList = new ArrayList<>();
		List<?> listImplByLinkedList = new LinkedList<>();
		List<?> listImplByVector = new Vector<>();
		List<?> listImplByStack = new Stack<>();
		Map<?, ?> mapImplByHashMap = new HashMap<>();	//非線程安全的
		Map<?, ?> mapImplByHashtable = new Hashtable<>();	//線程安全的，使用synchronized修飾method，等同為線程同步方法，概念是利用資源"互斥鎖"實現(鎖在put、get方法上)
		Map<?, ?> mapImplByConcurrentHashMap = new ConcurrentHashMap<>();	//線程安全的，效能比HashTable高
		Map<?, ?> mapImplByLinkedHashMap = new LinkedHashMap<>();
		Map<?, ?> mapImplByTreeMap = new TreeMap<>();
		Map<?, ?> mapImplByEnumMap = new EnumMap<>(listOfEnum.class);
		Map<?, ?> mapImplByWeakHashMap = new WeakHashMap<>();
		//Queue.offer：如果隊列已滿，則返回false並且不會拋出異常；Queue.add：如果隊列已滿，則拋出異常
		Queue<?> queueImplByLinkedList = new LinkedList<>();
		Queue<?> queueImplByConcurrentLinkedQueue = new ConcurrentLinkedQueue<>();
		Queue<?> queueImplByPriorityQueue = new PriorityQueue<>();
		Queue<?> queueImplByArrayBlockingQueue = new ArrayBlockingQueue<>(0);
		Queue<?> queueImplByArrayDeque = new ArrayDeque<>();
		Deque<?> dequeImplByArrayDeque = new ArrayDeque<>();
		Deque<?> dequeImplByLinkedList = new LinkedList<>();
		AbstractQueue<?> abstractQueueImplByPriorityQueue = new PriorityQueue<>();
		PriorityQueue<?> priorityQueueImplByPriorityQueue = new PriorityQueue<>();
		Stack<?> stackImplByStack = new Stack<>();
		Vector<?> vectorImplByStack = new Stack<>();
		Vector<?> vectorImplByVector = new Vector<>();
		AbstractMap<?, ?> abstractMapImplByIdentityHashMap = new IdentityHashMap<>();
		AbstractMap<?, ?> abstractMapImplByWeakHashMap = new WeakHashMap<>();
		Hashtable<?, ?> hashTableImplByProperties = new Properties();
		//Queue：隊列，用於按照特定順序存儲元素並支持先進先出（FIFO）的操作。常見的實現類有LinkedList 和PriorityQueue。
		//Deque：雙端隊列，類似於隊列，但支持從隊列的兩端插入和刪除元素。常見的實現類有ArrayDeque 和LinkedList。
		//Stack：棧，用於按照特定順序存儲元素並支持後進先出（LIFO）的操作。常見的實現類是Stack。
		//TreeSet：基於紅黑樹實現的有序集合，保持元素有序並且不允許重複。
		//HashSet：基於哈希表實現的集合，元素無序並且不允許重複。
		//LinkedHashSet：基於哈希表和鍊錶實現的集合，元素按照插入順序排序並且不允許重複。
		//TreeMap：基於紅黑樹實現的有序映射，根據鍵進行排序。
		//HashMap：基於哈希表實現的映射，鍵值對無序並且鍵不允許重複。
		//LinkedHashMap：基於哈希表和鍊錶實現的映射，鍵值對按照插入順序排序。
		//此外，Java 還提供了一些特殊用途的集合類，例如BitSet（位集合）和EnumSet（枚舉集合）等。這些集合類提供了不同的功能和性能特點，可以根據具體的需求選擇適當的集合類來使用。

		//多線程環境下保證HashMap 的線程安全性，主要有如下幾種方法：
		//使用java.util.Hashtable 類，此類是線程安全的。
		//使用java.util.concurrent.ConcurrentHashMap，此類是線程安全的。
		//使用java.util.Collections.synchronizedMap() 方法包裝HashMap object，得到線程安全的Map，並在此Map上進行操作。
		//自己在程序的關鍵方法或者代碼段加鎖，保證安全性，當然這是嚴重的不推薦。
		Map<?, ?> synMap  = Collections.synchronizedMap(mapImplByHashMap);
		Collection<?> synCollection  = Collections.synchronizedCollection(collection);
		Set<?> synSet  = Collections.synchronizedSet(setImplByTreeSet);
		List<?> synList  = Collections.synchronizedList(listImplByArrayList);

		Dictionary<?, ?> dictionaryImplByHashtable = new Hashtable<>();

		//SortedSet 接口：繼承自Set 接口，表示一個有序的集合，根據元素的自然順序或者指定的比較器進行排序。
		//NavigableSet 接口：繼承自SortedSet 接口，提供了額外的導航方法，如獲取元素的前一個或後一個元素。
		//SortedMap 接口：表示一個有序的鍵值對映射，根據鍵的自然順序或者指定的比較器進行排序。
		//NavigableMap 接口：繼承自SortedMap 接口，提供了額外的導航方法，如獲取鍵的前一個或後一個鍵。
		SortedSet<?> sortedSetImplByTreeSet = new TreeSet<>();
		NavigableSet<?> navigableSetImplByTreeSet = new TreeSet<>();
		SortedMap<?, ?> sortedMapImplByTreeMap = new TreeMap<>();
		NavigableMap<?, ?> navigableMapImplByTreeMap = new TreeMap<>();
		//Comparator<?> queue = new Comparator<T>() {public int compare(T o1, T o2) {};};

		//迭代器
		Iterator<?> iterator = collection.iterator();
		//Iterable<?>
	}
}
