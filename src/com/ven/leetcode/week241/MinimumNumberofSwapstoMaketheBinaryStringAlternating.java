package com.ven.leetcode.week241;

public class MinimumNumberofSwapstoMaketheBinaryStringAlternating {
	public int minSwaps(String s) {
		int zeros = 0;
		int ones = 0;
		int needSwap = Integer.MAX_VALUE;
		int n = s.length();
		// starts with 0
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0 && s.charAt(i) != '0') {
				zeros++;
			} else if (i % 2 == 1 && s.charAt(i) != '1') {
				ones++;
			}
		}
		if (zeros == ones) {
			needSwap = zeros;
		}
		zeros = 0;
		ones = 0;
		// starts with 1
		for (int i = 0; i < n; i++) {
			if (i % 2 == 1 && s.charAt(i) != '0') {
				ones++;
			} else if (i % 2 == 0 && s.charAt(i) != '1') {
				zeros++;
			}
		}
		if (zeros == ones) {
			needSwap = Math.min(zeros, needSwap);
		}
		return needSwap == Integer.MAX_VALUE ? -1 : needSwap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumNumberofSwapstoMaketheBinaryStringAlternating b = new MinimumNumberofSwapstoMaketheBinaryStringAlternating();
		System.out.println(b.minSwaps("010"));
		System.out.println(b.minSwaps("100"));

	}

}
