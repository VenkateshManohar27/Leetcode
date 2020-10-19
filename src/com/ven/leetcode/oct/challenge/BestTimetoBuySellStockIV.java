package com.ven.leetcode.oct.challenge;

import java.util.Arrays;

/**
 * You are given an integer array prices where prices[i] is the price of a given
 * stock on the ith day.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most k
 * transactions.
 * 
 * Notice that you may not engage in multiple transactions simultaneously (i.e.,
 * you must sell the stock before you buy again).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: k = 2, prices = [2,4,1] Output: 2 Explanation: Buy on day 1 (price =
 * 2) and sell on day 2 (price = 4), profit = 4-2 = 2. Example 2:
 * 
 * Input: k = 2, prices = [3,2,6,5,0,3] Output: 7 Explanation: Buy on day 2
 * (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day
 * 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * 
 * 
 * Constraints:
 * 
 * 0 <= k <= 109 0 <= prices.length <= 104 0 <= prices[i] <= 1000
 * 
 * @author Venkatesh Manohar
 *
 */
public class BestTimetoBuySellStockIV {
	int[][][] mem;

	private int recursion(int[] prices, int n, int k, int pos, int bought) {
		if (k == 0 || pos >= n) // All transactions done OR outOfBounds
			return 0;
		if (mem[bought][k][pos] != -1) // Return already calculated value
			return mem[bought][k][pos];

		int sum = recursion(prices, n, k, pos + 1, bought);
		if (bought == 1)
			sum = Math.max(sum, recursion(prices, n, k - 1, pos + 1, 0) + prices[pos]); // SELL
		else
			sum = Math.max(sum, recursion(prices, n, k, pos + 1, 1) - prices[pos]); // BUY

		mem[bought][k][pos] = sum;
		return sum;
	}

	public int maxProfit(int k, int[] prices) {
		mem = new int[2][k + 1][prices.length]; // mem[bought][k][pos]
		for (int i = 0; i < mem.length; i++) {
			
				for (int[] row : mem[i]) {
					Arrays.fill(row, -1);
				}
			
		}
		
		return recursion(prices, prices.length, k, 0, 0);
	}

	public static void main(String[] args) {
		BestTimetoBuySellStockIV b = new BestTimetoBuySellStockIV();
		System.out.println(b.maxProfit(2, new int[] {2,4,1}));
		System.out.println(b.maxProfit(2, new int[] {3,2,6,5,0,3}));
	}
}
