package com.ven.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * 
 * Input: "aab" Output: [ ["aa","b"], ["a","a","b"] ]
 * 
 * @author Venkatesh Manohar
 *
 */
public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> partitions = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return partitions;
		}
		helper(s.toCharArray(), 0, partitions, new ArrayList<String>());

		return partitions;
	}

	private void helper(char[] chars, int pos, List<List<String>> partitions, ArrayList<String> li) {
		if(pos == chars.length) {
			partitions.add(new ArrayList<>(li));
			return;
		}
		
		for (int i = pos; i < chars.length; i++) {
			if(isPalindrome(chars, pos, i)) {
				li.add(new String(chars, pos, i-pos+1));
				helper(chars, i+1, partitions, li);
				li.remove(li.size()-1);
			}
		}
		
	}

	public boolean isPalindrome(char[] chr, int start, int end) {
		while (start < end) {
			if (chr[start++] != chr[end--]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();

		System.out.println(pp.partition("aab"));
	}
}
