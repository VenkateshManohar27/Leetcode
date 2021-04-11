package com.ven.leetcode.week236;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

class MyTreeMap extends TreeMap<Integer, Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int numberCont = 0;

	public void increase(Integer k) {
		numberCont += 1;
		if (super.containsKey(k)) {
			super.put(k, super.get(k) + 1);
		} else {
			super.put(k, 1);
		}
	}

	public void decrease(Integer k) {
		numberCont -= 1;
		assert super.containsKey(k);
		int v = super.get(k);
		if (v - 1 == 0) {
			super.remove(k);
		} else {
			super.put(k, super.get(k) - 1);
		}
	}

	@Override
	public int size() {
		return numberCont;
	}
}

public class MKAverage {
	int m, k, x;
	long s = 0;
	Deque<Integer> q;
	MyTreeMap lt, mi, gt;

	public MKAverage(int m, int k) {
		this.m = m;
		this.k = k;
		this.q = new ArrayDeque<Integer>(m + 1);
		this.x = m - 2 * k;
		this.lt = new MyTreeMap();
		this.mi = new MyTreeMap();
		this.gt = new MyTreeMap();
	}

	public void shuffle() {
		// move exceed little elements from lt ==> mi
		while (lt.size() > k) {
			int x = lt.lastKey();
			lt.decrease(x);
			mi.increase(x);
			s += x;
		}
		// move exceed great elements from gt ==> mi
		while (gt.size() > k) {
			int x = gt.firstKey();
			gt.decrease(x);
			mi.increase(x);
			s += x;
		}

		// padding first k little elements
		while (lt.size() < k && !mi.isEmpty()) {
			int x = mi.firstKey();
			mi.decrease(x);
			s -= x;
			lt.increase(x);
		}
		// padding last k great elements
		while (gt.size() < k && !mi.isEmpty()) {
			int x = mi.lastKey();
			mi.decrease(x);
			s -= x;
			gt.increase(x);
		}
	}

	public void remove() {
		int x = q.removeFirst();
		// System.out.println("removing:" + x);
		if (lt.containsKey(x)) {
			lt.decrease(x);
		} else if (mi.containsKey(x)) {
			mi.decrease(x);
			s -= x;
		} else {
			gt.decrease(x);
		}

	}

	public void add(int n) {
		q.addLast(n);
		if (lt.isEmpty() || n <= lt.lastKey()) {
			lt.increase(n);
		} else if (gt.isEmpty() || n >= gt.firstKey()) {
			gt.increase(n);
		} else {
			mi.increase(n);
			s += n;
		}
	}

	public void addElement(int n) {
		add(n);

		// remove
		if (q.size() > m) {
			remove();
		}

		if (q.size() >= m) {
			shuffle();
		}
		// System.out.println(q);
		// System.out.println(lt);
		// System.out.println(mi);
		// System.out.println(gt);
	}

	public int calculateMKAverage() {
		if (q.size() < m) {
			return -1;
		}
		return (int) (s / x);
	}
}
