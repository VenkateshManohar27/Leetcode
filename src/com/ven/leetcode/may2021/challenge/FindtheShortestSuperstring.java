package com.ven.leetcode.may2021.challenge;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array of strings words, return the smallest string that contains
 * each string in words as a substring. If there are multiple valid strings of
 * the smallest length, return any of them.
 * 
 * You may assume that no string in words is a substring of another string in
 * words.
 * 
 * Example 1:
 * 
 * Input: words = ["alex","loves","leetcode"] Output: "alexlovesleetcode"
 * Explanation: All permutations of "alex","loves","leetcode" would also be
 * accepted. Example 2:
 * 
 * Input: words = ["catg","ctaagt","gcta","ttca","atgcatc"] Output:
 * "gctaagttcatgcatc"
 * 
 * Constraints:
 * 
 * 1 <= words.length <= 12 1 <= words[i].length <= 20 words[i] consists of
 * lowercase English letters. All the strings of words are unique.
 * 
 * @author Venkatesh Manohar
 *
 */
public class FindtheShortestSuperstring {
	public String shortestSuperstring(String[] A) {
		int n = A.length;
		int[][] graph = new int[n][n];

		// Build the graph
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graph[i][j] = calc(A[i], A[j]);
				graph[j][i] = calc(A[j], A[i]);
			}
		}

		// Creating dp array
		int[][] dp = new int[1 << n][n];

		// Creating path array
		int[][] path = new int[1 << n][n];
		int last = -1, min = Integer.MAX_VALUE;

		// start TSP DP
		for (int i = 1; i < (1 << n); i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);

			// Iterate j from 0 to n - 1
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) > 0) {
					int prev = i - (1 << j);

					// Check if prev is zero
					if (prev == 0) {
						dp[i][j] = A[j].length();
					} else {

						// Iterate k from 0 to n - 1
						for (int k = 0; k < n; k++) {
							if (dp[prev][k] < Integer.MAX_VALUE && dp[prev][k] + graph[k][j] < dp[i][j]) {
								dp[i][j] = dp[prev][k] + graph[k][j];
								path[i][j] = k;
							}
						}
					}
				}
				if (i == (1 << n) - 1 && dp[i][j] < min) {
					min = dp[i][j];
					last = j;
				}
			}
		}

		// Build the path
		StringBuilder sb = new StringBuilder();
		int cur = (1 << n) - 1;

		// Creating a stack
		Stack<Integer> stack = new Stack<>();

		// Untill cur is zero
		// push last
		while (cur > 0) {
			stack.push(last);
			int temp = cur;
			cur -= (1 << last);
			last = path[temp][last];
		}

		// Build the result
		int i = stack.pop();
		sb.append(A[i]);

		// Untill stack is empty
		while (!stack.isEmpty()) {
			int j = stack.pop();
			sb.append(A[j].substring(A[j].length() - graph[i][j]));
			i = j;
		}
		return sb.toString();
	}

	// Funtion to check
	public static int calc(String a, String b) {
		for (int i = 1; i < a.length(); i++) {
			if (b.startsWith(a.substring(i))) {
				return b.length() - a.length() + i;
			}
		}

		// Return size of b
		return b.length();
	}
}