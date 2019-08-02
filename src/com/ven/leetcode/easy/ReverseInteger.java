package com.ven.leetcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseInteger {
	public static int reverse(int x) {
		int reverse = 0;
		int number = x;
		while (number != 0) {
			if (reverse > Integer.MAX_VALUE / 10 || reverse < Integer.MIN_VALUE / 10)
				return 0;
			reverse = reverse * 10 + (number % 10);
			number /= 10;
		}
		return reverse;
	}

	public static void main(String[] args) {
		System.out.println(reverse(321));
		System.out.println(reverse(-321));

		System.out.println(reverse(-123));
		assertEquals(123, 123);
	}
}
