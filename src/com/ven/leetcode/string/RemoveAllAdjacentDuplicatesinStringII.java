package com.ven.leetcode.string;

import java.util.Stack;

/**
 * Given a string s, a k duplicate removal consists of choosing k adjacent and
 * equal letters from s and removing them causing the left and the right side of
 * the deleted substring to concatenate together.
 * 
 * We repeatedly make k duplicate removals on s until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made.
 * 
 * It is guaranteed that the answer is unique.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcd", k = 2 Output: "abcd" Explanation: There's nothing to
 * delete. Example 2:
 * 
 * Input: s = "deeedbbcccbdaa", k = 3 Output: "aa" Explanation: First delete
 * "eee" and "ccc", get "ddbbbdaa" Then delete "bbb", get "dddaa" Finally delete
 * "ddd", get "aa" Example 3:
 * 
 * Input: s = "pbbcggttciiippooaais", k = 2 Output: "ps"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 10^5 2 <= k <= 10^4 s only contains lower case English
 * letters.
 * 
 * @author Venkatesh Manohar
 *
 */
public class RemoveAllAdjacentDuplicatesinStringII {
	/**
	 * Runtime: 16 ms, faster than 30.87% of Java online submissions for Remove All
	 * Adjacent Duplicates in String II. Memory Usage: 40.9 MB, less than 100.00% of
	 * Java online submissions for Remove All Adjacent Duplicates in String II.
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public String removeDuplicates(String s, int k) {
		if (s == null || s.length() == 0) {
			return s;
		}
		StringBuilder sb = new StringBuilder(s);
		int index = 1;
		int count = 1;
		while (index < sb.length()) {
			if (sb.charAt(index - 1) == sb.charAt(index)) {
				count++;
			} else {
				count = 1;
			}
			if (count == k) {
				sb.replace(index - (k - 1), index + 1, "");
				index = 1;
				count = 1;
				continue;
			}
			index++;
		}
		return sb.toString();
	}

	class Item {
		char c;
		int count;

		public Item(char c, int count) {
			super();
			this.c = c;
			this.count = count;
		}
	}

	/**
	 * Runtime: 29 ms, faster than 13.11% of Java online submissions for Remove All
	 * Adjacent Duplicates in String II. Memory Usage: 47.3 MB, less than 100.00% of
	 * Java online submissions for Remove All Adjacent Duplicates in String II.
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public String removeDuplicatesUisngStack(String s, int k) {
		if (s == null || s.length() == 0) {
			return s;
		}
		int index = 0;
		Stack<Item> st = new Stack<>();
		while (index < s.length()) {
			char c = s.charAt(index);
			if (!st.isEmpty()) {
				if (st.peek().c == c) {
					st.push(new Item(c, st.peek().count + 1));
				} else {
					st.push(new Item(c, 1));
				}

				if (st.peek().count == k) {
					int n = k;
					while (n > 0) {
						st.pop();
						n--;
					}
				}

			} else {
				st.push(new Item(c, 1));
			}
			index++;
		}
		StringBuilder sb = new StringBuilder();
		while (!st.isEmpty()) {
			sb.insert(0, st.pop().c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		RemoveAllAdjacentDuplicatesinStringII r = new RemoveAllAdjacentDuplicatesinStringII();
		System.out.println(r.removeDuplicates("abcd", 2));
		System.out.println(r.removeDuplicates("deeedbbcccbdaa", 3));
		System.out.println(r.removeDuplicates("pbbcggttciiippooaais", 2));
		System.out.println("=====================================================================");
		System.out.println(r.removeDuplicatesUisngStack("abcd", 2));
		System.out.println(r.removeDuplicatesUisngStack("deeedbbcccbdaa", 3));
		System.out.println(r.removeDuplicatesUisngStack("pbbcggttciiippooaais", 2));
	}
}
