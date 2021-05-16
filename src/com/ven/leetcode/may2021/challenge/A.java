package com.ven.leetcode.may2021.challenge;

public class A {
	public int[] memLeak(int memory1, int memory2) {

		int i = 1;
		while (true) {

			if (memory1 >= memory2) {
				if (i > memory1) {
					break;
				}
				memory1 -= i;

			} else {
				if (i > memory2) {
					break;
				}
				memory2 -= i;
			}
			i++;
		}

		return new int[] { i, memory1, memory2 };
	}

	public static void main(String[] args) {
		A a = new A();
		a.memLeak(2, 2);
	}
}
