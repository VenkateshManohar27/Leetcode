package com.ven.amazon;

import java.util.Arrays;

import com.ven.utility.ArrayUtility;

/**
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Example 1:
 * 
 * Input: coins = [1, 2, 5], amount = 11 Output: 3 Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * 
 * Input: coins = [2], amount = 3 Output: -1 Note: You may assume that you have
 * an infinite number of each kind of coin.
 * 
 * @author Venkatesh Manohar
 *
 */
public class CoinChange {

	public int coinChange(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}
		if (amount < 0) {
			return -1;
		}
		int res = -1;
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] <= amount) {
				int sub_res = coinChange(coins, amount - coins[i]);

				if (sub_res != -1 && (res == -1 || sub_res + 1 < res)) {
					res = sub_res + 1;
				}

			}
		}
		return res;
	}

	public int coinChangeDp(int[] coins, int amount) {
		Arrays.sort(coins);
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount+1);
		dp[0] = 0;
		
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], 1+ dp[i-coins[j]]);
				}
				
			}
			ArrayUtility.print(dp);
		}
		return dp[amount] > amount ? -1: dp[amount];
	}

	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		System.out.println(cc.coinChange(new int[] { 1, 2, 5 }, 11));
		System.out.println(cc.coinChange(new int[] { 2 }, 3));
		System.out.println(cc.coinChange(new int[] { 9, 6, 5, 1 }, 11));
		System.out.println(cc.coinChangeDp(new int[] { 1, 2, 5 }, 11));
		System.out.println(cc.coinChangeDp(new int[] { 2 }, 3));
		System.out.println(cc.coinChangeDp(new int[] { 9, 6, 5, 1 }, 11));
		System.out.println(cc.coinChangeDp(new int[] { 2, 4, 6, 8 }, 16));
	}
}
