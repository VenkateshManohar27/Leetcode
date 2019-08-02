package com.ven.leetcode.dp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class NimGameTest {
	NimGame ng = new NimGame();
	@Test
	void test() {
		assertTrue(ng.canWinNim(1));
	}

}
