package com.ven.leetcode.week250;

import java.util.PriorityQueue;

public class SmallestChair {
	public int smallestChair(int[][] times, int targetFriend) {
		PriorityQueue<Integer> chairs = new PriorityQueue<>();
		PriorityQueue<int[]> orderedTimes = new PriorityQueue<>((a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			} else {
				return a[0] - b[0];
			}
		});
		for (int i = 0; i < times.length; i++) {
			chairs.offer(i);
			orderedTimes.offer(new int[] { times[i][0], times[i][1], i });
		}

		PriorityQueue<int[]> occupied = new PriorityQueue<>((a, b) -> {
			return a[0] - b[0];
		});

		while (!orderedTimes.isEmpty()) {
			int[] time = orderedTimes.poll();

			while (!occupied.isEmpty() && occupied.peek()[0] <= time[0]) {
				chairs.offer(occupied.poll()[1]);
			}
			if (time[2] == targetFriend) {
				return chairs.peek();
			}

			

			occupied.offer(new int[] { time[1], chairs.poll() });

		}

		return 0;
	}

	public static void main(String[] args) {
		SmallestChair a = new SmallestChair();
		System.out.println(a.smallestChair(new int[][] { { 33889, 98676 }, { 80071, 89737 }, { 44118, 52565 },
			{ 52992, 84310 }, { 78492, 88209 }, { 21695, 67063 }, { 84622, 95452 }, { 98048, 98856 },
			{ 98411, 99433 }, { 55333, 56548 }, { 65375, 88566 }, { 55011, 62821 }, { 48548, 48656 },
			{ 87396, 94825 }, { 55273, 81868 }, { 75629, 91467 } }, 6));
		System.out.println(a.smallestChair(new int[][] { { 1, 4 }, { 2, 3 }, { 4, 6 } }, 1));
		System.out.println(a.smallestChair(new int[][] { { 3, 10 }, { 1, 5 }, { 2, 6 } }, 0));

		
	}
}
