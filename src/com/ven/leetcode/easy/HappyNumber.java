package com.ven.leetcode.easy;

import java.util.HashSet;

public class HappyNumber {
	public static boolean isHappy(int n) {
		if (n == 1)
			return true;
		HashSet<Integer> s = new HashSet<Integer>();
		s.add(n);
		while (n > 1) {

			int temp = 0;
			while (n > 0) {
				int digit = n % 10;
				digit *= digit;
				temp += digit;
				n /= 10;
			}
			if (temp == 1) {
				return true;
			}
			if (s.contains(temp)) {
				return false;
			} else {
				s.add(temp);
			}
			n = temp;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isHappy(1));
		System.out.println(isHappy(19));
	}
}
