package com.ven.leetcode.lru;

import java.util.HashMap;
import java.util.PriorityQueue;

/*class KeyElement implements Comparable<KeyElement>{
	private int key;
	private long time;
	public KeyElement(int key) {
		super();
		this.key = key;
		this.time = System.currentTimeMillis();
	}
	@Override
	public int compareTo(KeyElement o) {
		if( this.time > o.time) {
			return 1;
		}else if(this.time < o.time) {
			return -1;
		}else {
			return 0;
		}
	}
	
	
	
}
*/

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. put(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up: Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * LRUCache cache = new LRUCache( 2 );
 * 
 * cache.put(1,1);cache.put(2,2);cache.get(1); // returns 1 cache.put(3,3); //
 * evicts key 2 cache.get(2); // returns -1 (not found) cache.put(4,4); //
 * evicts key 1 cache.get(1); // returns -1 (not found) cache.get(3); // returns
 * 3 cache.get(4); // returns 4
 *
 * 
 * @author Venkatesh Manohar
 *
 */

class Node {
	Node prev, next;
	int key;
	int val;

	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Node(int key, int val) {
		super();
		this.key = key;
		this.val = val;
	}
}

public class LRUCache {
	private final int SIZE;
	private HashMap<Integer, Node> cache = new HashMap<>();
	private Node head = new Node();
	private Node tail = new Node();

	public LRUCache(int capacity) {
		this.SIZE = capacity;
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		int res = -1;
		if (cache.containsKey(key)) {
			Node node = cache.get(key);
			res = node.val;
			removeNode(node);
			addNode(node);
		}
		return res;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			Node node = cache.get(key);
			node.val = value;
			removeNode(node);
			addNode(node);
		} else {

			Node node = new Node(key, value);
			cache.put(key, node);
			addNode(node);
			if (cache.size() > SIZE) {
				cache.remove(tail.prev.key);
				removeNode(tail.prev);
			}
		}

		

	}

	private void removeNode(Node node) {
		Node prev = node.prev;
		Node next = node.next;
		prev.next = next;
		next.prev = prev;
	}

	private void addNode(Node node) {
		Node next = head.next;
		head.next = node;
		node.next = next;
		node.prev = head;
		next.prev = node;
	}
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache( 2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4
	}
}
