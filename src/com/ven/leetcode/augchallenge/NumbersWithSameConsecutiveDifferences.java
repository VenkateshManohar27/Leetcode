package com.ven.leetcode.augchallenge;

import java.util.ArrayList;
import java.util.List;

import com.ven.utility.ArrayUtility;

/**
 * Return all non-negative integers of length N such that the absolute
 * difference between every two consecutive digits is K.
 * 
 * Note that every number in the answer must not have leading zeros except for
 * the number 0 itself. For example, 01 has one leading zero and is invalid, but
 * 0 is valid.
 * 
 * You may return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: N = 3, K = 7 Output: [181,292,707,818,929] Explanation: Note that 070
 * is not a valid number, because it has leading zeroes. Example 2:
 * 
 * Input: N = 2, K = 1 Output:
 * [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 * 
 * 
 * Note:
 * 
 * 1 <= N <= 9 0 <= K <= 9
 * 
 * @author Venkatesh Manohar
 *
 */
public class NumbersWithSameConsecutiveDifferences {
	public int[] numsSameConsecDiff(int N, int K) {
		List<Integer> li = new ArrayList<>();
		helper("", N, K, li);
		return li.stream().mapToInt(i -> i).toArray();
	}

	private void helper(String s, int length, int diff, List<Integer> li) {
		if (s.length() == length) {
			li.add(Integer.parseInt(s));
			return;
		}
		for (int i = 0; i <= 9; i++) {
			if (s.length() == 0) {
				if (i == 0 && length != 1) {
					continue;
				}
				helper(s + i, length, diff, li);
			} else {
				int prev = s.charAt(s.length() - 1) - '0';
				if (Math.abs(i - prev) == diff) {
					helper(s + i, length, diff, li);
				}
			}

		}
	}

	public static void main(String[] args) {
		NumbersWithSameConsecutiveDifferences n = new NumbersWithSameConsecutiveDifferences();
		ArrayUtility.print(n.numsSameConsecDiff(3, 7));
		ArrayUtility.print(n.numsSameConsecDiff(2, 1));
		ArrayUtility.print(n.numsSameConsecDiff(2, 0));
		ArrayUtility.print(n.numsSameConsecDiff(1, 0));
	}
}
