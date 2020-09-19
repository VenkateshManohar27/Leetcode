package com.ven.leetcode.sepchallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An integer has sequential digits if and only if each digit in the number is
 * one more than the previous digit.
 * 
 * Return a sorted list of all the integers in the range [low, high] inclusive
 * that have sequential digits.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: low = 100, high = 300 Output: [123,234] Example 2:
 * 
 * Input: low = 1000, high = 13000 Output: [1234,2345,3456,4567,5678,6789,12345]
 * 
 * 
 * Constraints:
 * 
 * 10 <= low <= high <= 10^9
 * 
 * @author Venkatesh Manohar
 *
 */
public class SequentialDigits {

	public List<Integer> sequentialDigits(int low, int high) {
		List<Integer> li = new ArrayList<Integer>();
		if (low > high) {
			return li;
		}
		helper(0, low, high, li);
		Collections.sort(li);
		return li;
	}

	private void helper(int i, int low, int high, List<Integer> li) {
		if (i >= low && i <= high) {
			li.add(i);
		}
		if (i > high) {
			return;
		}
		for (int j = 1; j <= 9; j++) {
			int prevDigit = i % 10;
			i = i * 10 + j;
			if (j - 1 == prevDigit || i <= 9) {
				helper(i, low, high, li);
			}
			i = i / 10;
		}
	}

	public static void main(String[] args) {
		SequentialDigits s = new SequentialDigits();
		System.out.println(s.sequentialDigits(100, 300));
		System.out.println(s.sequentialDigits(1000, 13000));
		System.out.println(s.sequentialDigits(0, 13000));
	}
}
