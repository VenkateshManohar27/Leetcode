package com.ven.leetcode.easy;

public class StrStr {
	public static int strStr(String haystack, String needle) {
		if (haystack == null || needle == null || needle.length() == 0) {
			return 0;
		}

		char[] source = haystack.toCharArray();
		char[] target = needle.toCharArray();
		int firstOccurence = -1;
		int j = -1;
		for (int i = 0; i < source.length; i++) {
			if (firstOccurence < 0 && source[i] == target[0]) {
				firstOccurence = i;
				j = 0;
			} else if (firstOccurence >= 0) {
				j++;
				if (j == target.length) {
					return firstOccurence;
				}
				if (source[i] != target[j]) {
					firstOccurence = -1;
					j = -1;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		String haystack = "hello", needle = "ll";
		System.out.println(strStr(haystack, needle));

		haystack = "aaaaa";
		needle = "bba";
		System.out.println(strStr(haystack, needle));

		haystack = "aaaaa";
		needle = "";
		System.out.println(strStr(haystack, needle));

		haystack = "helllll";
		needle = "ll";
		System.out.println(strStr(haystack, needle));

		haystack = "hewwl";
		needle = "ll";
		System.out.println(strStr(haystack, needle));

		haystack = "a";
		needle = "a";
		System.out.println(strStr(haystack, needle));

		haystack = "mississippi";
		needle = "mississippi";
		System.out.println(strStr(haystack, needle));
	}
}
