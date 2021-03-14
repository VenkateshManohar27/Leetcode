package com.ven.leetcode.mar2021.challenge;

import java.util.HashSet;
import java.util.Set;

public class CheckNumberSumPowersThree {
	public boolean checkPowersOfThree(int n) {
		Set<Integer> s = new HashSet<>();
		while (n > 0) {
			int num = n;
			int pow = 0;
			while (num % 3 == 0) {
				num /= 3;
				pow++;
			}
			if (s.contains(pow)) {
				return false;
			}
			s.add(pow);
			n = n - (int) Math.pow(3, pow);
		}
		return true;
	}
	
	public static void main(String[] args) {
		CheckNumberSumPowersThree c = new CheckNumberSumPowersThree();
		System.out.println(c.checkPowersOfThree(3));
		System.out.println(c.checkPowersOfThree(12));
		System.out.println(c.checkPowersOfThree(91));
		System.out.println(c.checkPowersOfThree(27));
		System.out.println(c.checkPowersOfThree(28));
		System.out.println(c.checkPowersOfThree(21));
		System.out.println(c.checkPowersOfThree(18));
	}
}
