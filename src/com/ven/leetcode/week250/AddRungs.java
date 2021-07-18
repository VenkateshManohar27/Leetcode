package com.ven.leetcode.week250;

public class AddRungs {
	public int addRungs(int[] rungs, int dist) {
		int index = 0;
		int count = 0;
		for (int i = 0; i < rungs.length; i++) {
			if ((rungs[i] - index) % dist == 0) {
				count += (rungs[i] - index) / dist - 1;
			} else {
				count += (rungs[i] - index) / dist;
			}
			index = rungs[i];
		}
		return count;
	}

	public static void main(String[] args) {
		AddRungs a = new AddRungs();
		System.out.println(a.addRungs(new int[] { 1, 3, 5, 10 }, 2));

	}
}
