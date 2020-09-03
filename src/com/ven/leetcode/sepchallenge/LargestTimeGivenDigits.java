package com.ven.leetcode.sepchallenge;

/**
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 * 
 * The smallest 24 hour time is 00:00, and the largest is 23:59. Starting from
 * 00:00, a time is larger if more time has elapsed since midnight.
 * 
 * Return the answer as a string of length 5. If no valid time can be made,
 * return an empty string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4] Output: "23:41" Example 2:
 * 
 * Input: [5,5,5,5] Output: ""
 * 
 * 
 * Note:
 * 
 * A.length == 4 0 <= A[i] <= 9
 * 
 * @author Venkatesh Manohar
 *
 */
public class LargestTimeGivenDigits {
	static int max = -1;
	static String sMax = null;

	public String largestTimeFromDigits(int[] A) {
		max = -1;
		sMax = null;
		helper(A, "", 0);
		if (max != -1) {
			StringBuilder sb = new StringBuilder();
			sb.append(sMax);
			sb.insert(2, ":");
			return sb.toString();
		} else {
			return "";
		}
	}

	private void helper(int[] a, String s, int index) {
		if (s.length() == 4) {
			int hour = Integer.parseInt(s.substring(0, 2));
			int min = Integer.parseInt(s.substring(2));
			if (hour >= 0 && hour <= 23 && min >= 0 && min <= 59) {
				int numb = Integer.parseInt(s);
				if (numb > max) {
					max = numb;
					sMax = s;
				}
			}
			return;
		}
		for (int i = 0; i < a.length; i++) {
			int num = a[i];
			if (a[i] == -1) {
				continue;
			}
			a[i] = -1;

			helper(a, s + num, index + 1);
			a[i] = num;
		}
	}

	public static void main(String[] args) {
		LargestTimeGivenDigits l = new LargestTimeGivenDigits();
		System.out.println(l.largestTimeFromDigits(new int[] { 1, 2, 3, 4 }));
		System.out.println(l.largestTimeFromDigits(new int[] { 5, 5, 5, 5 }));
		System.out.println(l.largestTimeFromDigits(new int[] { 0, 5, 5, 5 }));
		System.out.println(l.largestTimeFromDigits(new int[] { 5, 9, 3, 2 }));
		System.out.println(l.largestTimeFromDigits(new int[] { 0, 0, 5, 1 }));
		System.out.println(l.largestTimeFromDigits(new int[] { 0, 0, 0, 0 }));
		System.out.println(l.largestTimeFromDigits(new int[] { 0, 0, 0, 1 }));
		
	}
}
