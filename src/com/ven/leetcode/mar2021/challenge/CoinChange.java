package com.ven.leetcode.mar2021.challenge;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: coins = [1,2,5], amount = 11 Output: 3 Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * 
 * Input: coins = [2], amount = 3 Output: -1 Example 3:
 * 
 * Input: coins = [1], amount = 0 Output: 0 Example 4:
 * 
 * Input: coins = [1], amount = 1 Output: 1 Example 5:
 * 
 * Input: coins = [1], amount = 2 Output: 2
 * 
 * 
 * Constraints:
 * 
 * 1 <= coins.length <= 12 1 <= coins[i] <= 231 - 1 0 <= amount <= 104
 * 
 * @author Venkatesh Manohar
 *
 */
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		return coinChange(coins, amount, new int[amount + 1]);
	}

	public int coinChangeDp(int[] coins, int amount) {
		int max = amount + 1;
	    int[] dp = new int[amount + 1];
	    Arrays.fill(dp, max);
	    dp[0] = 0;
	    for (int i = 1; i <= amount; i++) {
	      for (int j = 0; j < coins.length; j++) {
	        if (coins[j] <= i) {
	          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
	        }
	      }
	    }
	    return dp[amount] > amount ? -1 : dp[amount];
	}
	private int coinChange(int[] coins, int amount, int[] count) {
		if(amount < 0) {
			return -1;
		}
		if(amount == 0) {
			return 0;
		}
		if(count[amount] != 0) return count[amount];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			int res = coinChange(coins, amount - coins[i], new int[amount + 1]);
			if(res >= 0 && res < min) {
				min = res + 1;
			}
		}
		count[amount] = (min == Integer.MAX_VALUE)? -1: min;
		//ArrayUtility.print(count);
		return count[amount];
	}
	
	public static void main(String[] args) {
		CoinChange c = new CoinChange();
		System.out.println(c.coinChange(new int[] {1, 2,5}, 11));
	}
}
