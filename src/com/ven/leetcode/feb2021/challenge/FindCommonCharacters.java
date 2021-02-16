package com.ven.leetcode.feb2021.challenge;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
	public List<String> commonChars(String[] A) {
		int[][] chars = new int[A.length][26];
		for (int i = 0; i < A.length; i++) {
			String s = A[i];
			for (int j = 0; j < s.length(); j++) {
				chars[i][s.charAt(j) - 'a']++;
			}
		}

		List<String> l = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			int count = Integer.MAX_VALUE;
			for (int j = 0; j < A.length; j++) {
				count = Math.min(count, chars[j][i]);
			}
			while (count > 0) {
				l.add("" + (char) (i + 'a'));
				count--;
			}
		}

		return l;
	}
	
	public static void main(String[] args) {
		FindCommonCharacters c = new FindCommonCharacters();
		c.commonChars(new String[] {"bella","label","roller"});
	}
}
