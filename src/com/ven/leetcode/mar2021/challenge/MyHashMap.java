package com.ven.leetcode.mar2021.challenge;

import java.util.ArrayList;
import java.util.List;

class Node {
	int key;
	int value;

	public Node(int key, int value) {
		super();
		this.key = key;
		this.value = value;
	}
}

public class MyHashMap {
	List<Node>[] map = new ArrayList[10001];
	final int SIZE = 10000;

	/** Initialize your data structure here. */
	public MyHashMap() {

	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		int hash = key % SIZE;
		List<Node> l = null;
		if (map[hash] != null) {
			l = map[hash];
			for (Node n : l) {
				if (n.key == key) {
					n.value = value;
					return;
				}
			}
			l.add(new Node(key, value));
		} else {
			l = new ArrayList<>();
			l.add(new Node(key, value));
			map[hash] = l;
		}
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		int hash = key % SIZE;
		if (map[hash] == null) {
			return -1;
		}
		List<Node> l = map[hash];
		for (Node n : l) {
			if (n.key == key) {
				return n.value;
			}
		}
		return -1;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		int hash = key % SIZE;
		if (map[hash] == null) {
			return;
		}
		List<Node> l = map[hash];
		for (Node n : l) {
			if (n.key == key) {
				l.remove(n);
				break;
			}
		}
	}

	public static void main(String[] args) {
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 1);
		hashMap.put(2, 2);
		System.out.println(hashMap.get(1)); // returns 1
		System.out.println(hashMap.get(3)); // returns -1 (not found)
		hashMap.put(2, 1); // update the existing value
		System.out.println(hashMap.get(2)); // returns 1
		hashMap.remove(2); // remove the mapping for 2
		System.out.println(hashMap.get(2)); // returns -1 (not found)
	}
}
