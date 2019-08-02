package com.ven.leetcode.easy;

public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote == null || ransomNote.length() == 0)
			return true;
		if (magazine == null || magazine.length() == 0)
			return false;
		int[] counts = new int[256];
		for (char c : magazine.toCharArray()) {
			counts[c]++;
		}
		for (char c : ransomNote.toCharArray()) {
			if (counts[c] == 0)
				return false;
			counts[c]--;
		}
		return true;
	}

}
