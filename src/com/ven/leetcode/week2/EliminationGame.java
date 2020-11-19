package com.ven.leetcode.week2;

public class EliminationGame {
	public int lastRemaining(int n) {
		int head = 1, remaining = n, step = 1;
		boolean leftToRight = true;
		while (remaining > 1) {
			if (leftToRight || remaining % 2 == 1) {
				head += step;
			}
			step *= 2;
			remaining /= 2;
			leftToRight = !leftToRight;
		}
		return head;
	}
}
