package com.ven.leetcode.easy;

public class BestTimeToBuyStock {
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			}
			maxProfit = Math.max(maxProfit, prices[i] - min);

		}
		return maxProfit;
	}

	public int maxProfit2(int[] prices) {
		int profit = 0;

		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i] < prices[i + 1]) {
				profit += prices[i + 1] - prices[i];
			}
		}
		return profit;
	}
}
