package com.practice.datastructures.queue.LRUCache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class CacheEntry {
	int key;
	String value;

	CacheEntry(int key, String value) {
		this.key = key;
		this.value = value;
	}
}

public class LRUCacheImpl {

	Deque<CacheEntry> queue = new LinkedList();
	Map<Integer, CacheEntry> cacheMap = new HashMap();
	int CACHE_SIZE = 5;

	public String getFromCache(int key) {
		if (cacheMap.containsKey(key)) {
			CacheEntry entry = cacheMap.get(key);
			queue.remove(entry);
			queue.addFirst(entry);
			return entry.value;
		}
		return null;
	}

	public void putEntryIntoCache(int key, String value) {
		if (cacheMap.containsKey(key)) {
			CacheEntry entry = cacheMap.get(key);
			queue.remove(entry);
		} else {
			if (queue.size() == CACHE_SIZE) {
				CacheEntry entrytoBeRemoved = queue.removeLast();
				cacheMap.remove(entrytoBeRemoved.key);
			}
		}

		CacheEntry entry = new CacheEntry(key, value);
		queue.addFirst(entry);
		cacheMap.put(key, entry);
	}

	public static void main(String[] args) {
		LRUCacheImpl cache = new LRUCacheImpl();
		cache.putEntryIntoCache(1, "Product-1-Info");
		cache.putEntryIntoCache(2, "Product-2-Info");
		cache.putEntryIntoCache(3, "Product-3-Info");
		cache.putEntryIntoCache(4, "Product-4-Info");
		cache.putEntryIntoCache(5, "Product-5-Info");

		System.out.println(cache.getFromCache(1));
		System.out.println(cache.getFromCache(2));
		System.out.println(cache.getFromCache(3));
		System.out.println(cache.getFromCache(4));
		System.out.println(cache.getFromCache(5));

		cache.putEntryIntoCache(6, "Product-6-Info");
		System.out.println(cache.getFromCache(1));
		System.out.println(cache.getFromCache(6));

	}
}

// Reference : https://www.youtube.com/watch?v=N-GGrDK_Ev8&list=PLt4nG7RVVk1hF5w6QavZKJnZSY_50XIee&index=5
// 