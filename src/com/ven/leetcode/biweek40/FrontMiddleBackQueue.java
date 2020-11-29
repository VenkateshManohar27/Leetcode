package com.ven.leetcode.biweek40;

import java.util.LinkedList;

public class FrontMiddleBackQueue {
	LinkedList<Integer> l = null;
	public FrontMiddleBackQueue() {
		l= new LinkedList<>();
	}

	public void pushFront(int val) {
		l.addFirst(val);
	}

	public void pushMiddle(int val) {
		l.add(l.size()/2, val);
	}

	public void pushBack(int val) {
		l.addLast(val);
	}

	public int popFront() {
		return (l.isEmpty())? -1: l.removeFirst();
	}

	public int popMiddle() {
		return (l.isEmpty())? -1: l.remove((l.size()-1)/2);
	}

	public int popBack() {
		return (l.isEmpty())? -1: l.removeLast();
	}

	public static void main(String[] args) {
		FrontMiddleBackQueue q = new FrontMiddleBackQueue();
		q.pushFront(1); // [1]
		q.pushBack(2); // [1, 2]
		q.pushMiddle(3); // [1, 3, 2]
		q.pushMiddle(4); // [1, 4, 3, 2]
		System.out.println(q.popFront()); // return 1 -> [4, 3, 2]
		System.out.println(q.popMiddle());// return 3 -> [4, 2]
		System.out.println(q.popMiddle()); // return 4 -> [2]
		System.out.println(q.popBack()); // return 2 -> []
		System.out.println(q.popFront()); // return -1 -> [] (The queue is empty)
	}
}
