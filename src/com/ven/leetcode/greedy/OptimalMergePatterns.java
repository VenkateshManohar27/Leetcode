package com.ven.leetcode.greedy;

import java.util.PriorityQueue;

public class OptimalMergePatterns {

	public static void main(String[] args) {
		// 6 files with their sizes
		int files[] = new int[] { 2, 3, 4, 5, 6, 7 };

		// total no of computations
		// do be done final answer
		System.out.println("Minimum Computations = " + minComputation(files));

		files = new int[] { 6, 5, 2, 3 };

		// total no of computations
		// do be done final answer
		System.out.println("Minimum Computations = " + minComputation(files));

		files = new int[] { 20, 30, 10, 5, 30 };

		// total no of computations
		// do be done final answer
		System.out.println("Minimum Computations = " + minComputation(files));
	}

	public static int minComputation(int[] files) {
		int cost = 0;
		if (files == null || files.length == 0) {
			return cost;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i : files) {
			pq.add(i);
		}

		while (pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();
			int c = a + b;
			cost += c;
			pq.add(c);
		}
		return cost;
	}
}
