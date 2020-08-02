package com.ven.leetcode.augchallenge;

public class MyHashSet2 {
	class Node {
		int value;
		
		public Node(int val) {
			this.value = val;
		}
	}

	private final int SIZE;
	private Node[] arr = null;

	/** Initialize your data structure here. */
	public MyHashSet2() {
		SIZE = 1000001;
		arr = new Node[SIZE];
	}

	public void add(int key) {
		
		if (arr[key] == null) {
			arr[key] = new Node(key);
			return;
		} 
	}

	public void remove(int key) {
		
		if (arr[key] != null) {
			arr[key] = null;
		}
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		return arr[key] != null;
	}

	public static void main(String[] args) {
		MyHashSet2 hashSet = new MyHashSet2();
		hashSet.add(1);
		hashSet.add(2);
		System.out.println(hashSet.contains(1)); // returns true
		System.out.println(hashSet.contains(3)); // returns false (not found)
		hashSet.add(2);
		System.out.println(hashSet.contains(2)); // returns true
		hashSet.remove(2);
		System.out.println(hashSet.contains(2)); // returns false (already removed)
	}
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */
