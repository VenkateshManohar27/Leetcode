package com.ven.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<>();
		res.add(0);

		for (int i = 1; i <= n; i++) {
			int size = res.size(), base = 1 << (i - 1);
			for (int j = size - 1; j >= 0; j--) {
				res.add(base + res.get(j));
			}
		}
		return res;

	}

	public static void main(String[] args) {
		GrayCode gc = new GrayCode();
		System.out.println(gc.grayCode(0));
		System.out.println(gc.grayCode(2));
		System.out.println(gc.grayCode(3));
		System.out.println(gc.grayCode(4));
	}
}
