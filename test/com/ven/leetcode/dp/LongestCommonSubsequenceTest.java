package com.ven.leetcode.dp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LongestCommonSubsequenceTest {
	LongestCommonSubsequence lcs = new LongestCommonSubsequence();
	@Test
	void test() {
		assertEquals(2, lcs.longestCommonSubsequence("AXYT", "AYZX"));
		assertEquals(3, lcs.longestCommonSubsequence("ABCDGH", "AEDFHR"));
		assertEquals(4, lcs.longestCommonSubsequence("AGGTAB", "GXTXAYB"));
		assertEquals(3, lcs.longestCommonSubsequence("stone", "longest"));
		assertEquals(2, lcs.longestCommonSubsequence("AXYT", "AYZX"));
		
	}

}
