package com.ven.leetcode.mar2021.challenge;

import java.util.HashSet;
import java.util.Set;

public class NumberofDifferentIntegersString {
	public int numDifferentIntegers(String word) {
		Set<Integer> s = new HashSet<>();
		int i = 0;
		while (i < word.length()) {
			int num = 0;
			boolean found = false;
			while (i < word.length() && Character.isDigit(word.charAt(i))) {
				num = num * 10 + Character.getNumericValue(word.charAt(i));
				i++;
				found = true;
			}
			if (found) {
				// System.out.println(num);
				s.add(num);
				num = 0;

			}
			i++;
		}

		return s.size();
	}
}
