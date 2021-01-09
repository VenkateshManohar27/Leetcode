package com.ven.leetcode.week222;

import java.util.HashMap;

/**
 * A good meal is a meal that contains exactly two different food items with a
 * sum of deliciousness equal to a power of two.
 * 
 * You can pick any two different foods to make a good meal.
 * 
 * Given an array of integers deliciousness where deliciousness[i] is the
 * deliciousness of the i item of food, return the number of
 * different good meals you can make from this list modulo 100000000007
 * 
 * Note that items with different indices are considered different even if they
 * have the same deliciousness value.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: deliciousness = [1,3,5,7,9] Output: 4 Explanation: The good meals are
 * (1,3), (1,7), (3,5) and, (7,9). Their respective sums are 4, 8, 8, and 16,
 * all of which are powers of 2. Example 2:
 * 
 * Input: deliciousness = [1,1,1,3,3,3,7] Output: 15 Explanation: The good meals
 * are (1,1) with 3 ways, (1,3) with 9 ways, and (1,7) with 3 ways.
 * 
 * 
 * Constraints:
 * 
 * 1 <= deliciousness.length <= 105 0 <= deliciousness[i] <= 220
 * 
 * @author Venkatesh Manohar
 *
 */
public class CountPairs {
	public int countPairs(int[] deliciousness) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int MOD = 1000000007;
		for (int i = 0; i < deliciousness.length; i++) {
			int num = deliciousness[i];
			int power = 1;
			for (int j = 0; j <= 21; j++) {
				if (power >= num && map.containsKey(power - num)) {
					count += map.getOrDefault(power - num, 0);
					count %= MOD;
				}
				power *= 2;
			}
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		CountPairs c = new CountPairs();
		System.out.println(c.countPairs(new int[] { 1, 3, 5, 7, 9 }));
		System.out.println(c.countPairs(new int[] { 1, 1, 1, 3, 3, 3, 7 }));
	}
}
