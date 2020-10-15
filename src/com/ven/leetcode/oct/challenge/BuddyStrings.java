package com.ven.leetcode.oct.challenge;

/**
 * Given two strings A and B of lowercase letters, return true if you can swap
 * two letters in A so the result is equal to B, otherwise, return false.
 * 
 * Swapping letters is defined as taking two indices i and j (0-indexed) such
 * that i != j and swapping the characters at A[i] and A[j]. For example,
 * swapping at indices 0 and 2 in "abcd" results in "cbad".
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = "ab", B = "ba" Output: true Explanation: You can swap A[0] = 'a'
 * and A[1] = 'b' to get "ba", which is equal to B. Example 2:
 * 
 * Input: A = "ab", B = "ab" Output: false Explanation: The only letters you can
 * swap are A[0] = 'a' and A[1] = 'b', which results in "ba" != B. Example 3:
 * 
 * Input: A = "aa", B = "aa" Output: true Explanation: You can swap A[0] = 'a'
 * and A[1] = 'a' to get "aa", which is equal to B. Example 4:
 * 
 * Input: A = "aaaaaaabc", B = "aaaaaaacb" Output: true Example 5:
 * 
 * Input: A = "", B = "aa" Output: false
 * 
 * 
 * Constraints:
 * 
 * 0 <= A.length <= 20000 0 <= B.length <= 20000 A and B consist of lowercase
 * letters.
 * 
 * @author Venkatesh Manohar
 *
 */
public class BuddyStrings {

	public boolean buddyStrings(String a, String b) {
		if (a == null || b == null || a.length() == 0 || b.length() == 0) {
			return false;
		}
		if (a.length() != b.length()) {
			return false;
		}

		int[] freqA = new int[26];
		int[] freqB = new int[26];
		for (int i = 0; i < a.length(); i++) {
			freqA[a.charAt(i) - 'a']++;
			freqB[b.charAt(i) - 'a']++;
		}

		if (a.equals(b)) {
			for (int i = 0; i < 26; i++) {
				if (freqA[i] > 1) {
					return true;
				}
			}
			return false;
		}
		for (int i = 0; i < 26; i++) {
			if (freqA[i] != freqB[i]) {
				return false;
			}
		}
		int swapCount = 0;
		for (int i = 0; i < a.length(); i++)
			if (a.charAt(i) != b.charAt(i))
				swapCount++;

		return swapCount == 2;
	}

	public static void main(String[] args) {
		BuddyStrings b = new BuddyStrings();
		System.out.println(b.buddyStrings("ab", "ba"));
		System.out.println(b.buddyStrings("ab", "ab"));
		System.out.println(b.buddyStrings("aa", "aa"));
		System.out.println(b.buddyStrings("aaaaaaabc", "aaaaaaacb"));
		System.out.println(b.buddyStrings("", "aa"));
	}

}
