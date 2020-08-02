package com.ven.leetcode.augchallenge;

public class MyHashSet {
	class Node {
		int value;
		Node next;

		public Node(int val) {
			this.value = val;
		}
	}

	private final int SIZE;
	private Node[] arr = null;

	/** Initialize your data structure here. */
	public MyHashSet() {
		SIZE = 100;
		arr = new Node[SIZE];
	}

	public void add(int key) {
		int index = key % this.SIZE;
		if (arr[index] == null) {
			arr[index] = new Node(key);
			return;
		} else {
			Node p = arr[index];
			while (p != null && p.value != key) {
				p = p.next;
			}

			if (p != null) {
				return;
			}

			Node newHead = new Node(key);
			newHead.next = arr[index];
			arr[index] = newHead;
		}
	}

	public void remove(int key) {
		int index = key % this.SIZE;
		if (arr[index] != null) {
			Node p = arr[index];

			if (p.value == key) {
				arr[index] = p.next;
				return;
			}

			while (p.next != null && p.next.value != key)
				p = p.next;
			if (p.next == null)
				return;

			p.next = p.next.next;

		}
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		int index = key % this.SIZE;
		if (arr[index] == null) {
			return false;
		} else {
			Node p = arr[index];
			while (p != null && p.value != key) {
				p = p.next;
			}

			return p != null;
		}
	}

	public static void main(String[] args) {
		MyHashSet hashSet = new MyHashSet();
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
