package com.ven.leetcode.sepchallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * A string S of lowercase English letters is given. We want to partition this
 * string into as many parts as possible so that each letter appears in at most
 * one part, and return a list of integers representing the size of these parts.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: S = "ababcbacadefegdehijhklij" Output: [9,7,8] Explanation: The
 * partition is "ababcbaca", "defegde", "hijhklij". This is a partition so that
 * each letter appears in at most one part. A partition like "ababcbacadefegde",
 * "hijhklij" is incorrect, because it splits S into less parts.
 * 
 * 
 * Note:
 * 
 * S will have length in range [1, 500]. S will consist of lowercase English
 * letters ('a' to 'z') only.
 * 
 * @author Venkatesh Manohar
 *
 */
public class PartitionLabels {
	public List<Integer> partitionLabels(String S) {
		List<Integer> li = new ArrayList<>();
		if (S == null || S.length() == 0) {
			return li;
		}
		int[] lastCharIdx = new int[26];
		for (int i = 0; i < S.length(); i++) {
			lastCharIdx[S.charAt(i) - 'a'] = i;
		}
		int start = 0;
		int i = 0;
		while (i < S.length()) {
			char c = S.charAt(i);
			int end = lastCharIdx[c - 'a'];
			i++;
			while (i < end) {
				char ch = S.charAt(i);
				int endIndex = lastCharIdx[ch - 'a'];
				if (endIndex > end) {
					end = endIndex;
				}
				i++;
			}
			i = end + 1;
			li.add(i - start);
			start = i;
		}

		return li;
	}

	public static void main(String[] args) {
		PartitionLabels p = new PartitionLabels();
		System.out.println(p.partitionLabels("ababcbacadefegdehijhklij"));
		System.out.println(p.partitionLabels("ababcbacadefegdehijhklij"));
		System.out.println(p.partitionLabels("ababcbacadefegdehijhklij"));
	}
}
