package com.ven.leetcode.week245;

public class B {

	public int maximumRemovals(String s, String p, int[] removable) {
		//char[] arr = s.toCharArray();
		int removables = 0;
		int m = p.length();
		int n = s.length();
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < removable.length; i++) {
			//arr[removable[i]] = '-';
			//String temp = new String(arr);
			sb.setCharAt(removable[i], '-');
			if (!isSubSequence(p, sb.toString(), m, n)) {
				return removables;
			}
			removables++;
		}
		return removables;
	}

	private boolean isSubSequence(String str1, String str2, int m, int n) {
		int j = 0;

		// Traverse str2 and str1, and compare
		// current character of str2 with first
		// unmatched char of str1, if matched
		// then move ahead in str1
		for (int i = 0; i < n && j < m; i++)
			if (str1.charAt(j) == str2.charAt(i))
				j++;

		// If all characters of str1 were found
		// in str2
		return (j == m);
	}

	public static void main(String[] args) {
		B b = new B();
		System.out.println(b.maximumRemovals("abcacb","ab", new int[] {3,1,0}));
		
	}

}
