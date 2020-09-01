package com.ven.leetcode.week204;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of positive integers arr, find a pattern of length m that is
 * repeated k or more times.
 * 
 * A pattern is a subarray (consecutive sub-sequence) that consists of one or
 * more values, repeated multiple times consecutively without overlapping. A
 * pattern is defined by its length and the number of repetitions.
 * 
 * Return true if there exists a pattern of length m that is repeated k or more
 * times, otherwise return false.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [1,2,4,4,4,4], m = 1, k = 3 Output: true Explanation: The
 * pattern (4) of length 1 is repeated 4 consecutive times. Notice that pattern
 * can be repeated k or more times but not less. Example 2:
 * 
 * Input: arr = [1,2,1,2,1,1,1,3], m = 2, k = 2 Output: true Explanation: The
 * pattern (1,2) of length 2 is repeated 2 consecutive times. Another valid
 * pattern (2,1) is also repeated 2 times. Example 3:
 * 
 * Input: arr = [1,2,1,2,1,3], m = 2, k = 3 Output: false Explanation: The
 * pattern (1,2) is of length 2 but is repeated only 2 times. There is no
 * pattern of length 2 that is repeated 3 or more times. Example 4:
 * 
 * Input: arr = [1,2,3,1,2], m = 2, k = 2 Output: false Explanation: Notice that
 * the pattern (1,2) exists twice but not consecutively, so it doesn't count.
 * Example 5:
 * 
 * Input: arr = [2,2,2,2], m = 2, k = 3 Output: false Explanation: The only
 * pattern of length 2 is (2,2) however it's repeated only twice. Notice that we
 * do not count overlapping repetitions.
 * 
 * 
 * Constraints:
 * 
 * 2 <= arr.length <= 100 1 <= arr[i] <= 100 1 <= m <= 100 2 <= k <= 100
 * 
 * @author Venkatesh Manohar
 *
 */
public class DetectPatternofLengthMRepeatedKorMoreTimes {
	public boolean containsPattern(int[] arr, int m, int k) {
		HashMap<String, Set<Integer>> pattern = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		int[] dp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			if (sb.length() > m) {
				sb.deleteCharAt(0);
			}
			if (sb.length() == m) {
				if (pattern.containsKey(sb.toString())) {
					Set<Integer> indexes = pattern.get(sb.toString());
					if (indexes.contains(i - m)) {
						dp[i] = dp[i - m] + 1;
					} else {
						dp[i] = 1;

					}
					indexes.add(i);
					pattern.put(sb.toString(), indexes);
					if (dp[i] >= k) {
						return true;
					}
				} else {
					Set<Integer> indexes = new HashSet<>();
					indexes.add(i);
					pattern.put(sb.toString(), indexes);
					dp[i] = 1;
				}
			}
		}
		return false;
	}

	public boolean containsPatternOptimized(int[] arr, int m, int k) {
		for(int i = 0, n = arr.length, j = i + m, count = 0; j < n; ++i, ++j) {
            if (arr[i] != arr[j]) {
                count = 0;
            } else if (++count >= (k - 1) * m) {
                return true;
            }
        }
        return false;
	}
	public static void main(String[] args) {
		DetectPatternofLengthMRepeatedKorMoreTimes d = new DetectPatternofLengthMRepeatedKorMoreTimes();
		System.out.println(d.containsPattern(new int[] { 1, 2, 4, 4, 4, 4 }, 1, 3));
		System.out.println(d.containsPattern(new int[] { 1, 2, 1, 2, 1, 1, 1, 3 }, 2, 2));
		System.out.println(d.containsPattern(new int[] { 1, 2, 1, 2, 1, 3 }, 2, 3));
		System.out.println(d.containsPattern(new int[] { 1, 2, 3, 1, 2 }, 2, 2));
		System.out.println(d.containsPattern(new int[] { 2, 2, 2, 2 }, 2, 3));
		System.out.println(d.containsPattern(new int[] { 2, 2 }, 1, 2));
		System.out.println(d.containsPattern(new int[] { 2, 1, 2, 2, 2, 2, 2, 2 }, 2, 2));
		System.out.println(d.containsPattern(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1 }, 50, 2));
	}

}
