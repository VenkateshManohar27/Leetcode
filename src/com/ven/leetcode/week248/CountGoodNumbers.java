package com.ven.leetcode.week248;

/**
 * A digit string is good if the digits (0-indexed) at even indices are even and
 * the digits at odd indices are prime (2, 3, 5, or 7).
 * 
 * For example, "2582" is good because the digits (2 and 8) at even positions
 * are even and the digits (5 and 2) at odd positions are prime. However, "3245"
 * is not good because 3 is at an even index but is not even. Given an integer
 * n, return the total number of good digit strings of length n. Since the
 * answer may be large, return it modulo 109 + 7.
 * 
 * A digit string is a string consisting of digits 0 through 9 that may contain
 * leading zeros.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 1 Output: 5 Explanation: The good numbers of length 1 are "0",
 * "2", "4", "6", "8". Example 2:
 * 
 * Input: n = 4 Output: 400 Example 3:
 * 
 * Input: n = 50 Output: 564908303
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 1015
 * 
 * @author Venkatesh Manohar
 *
 */
public class CountGoodNumbers {
	long mod = (int) 1e9 + 7;

	public int countGoodNumbers(long n) {
		return (int) (helper(5, (n + 1) / 2) * helper(4, n / 2) % mod);
	}

	public long helper(int x, long n) {
		System.out.println(x+" "+n);
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		if (n % 2 == 1) {
			return (x * helper(x, n - 1)) % mod;
		}
		long half = helper(x, n / 2);
		return half * half % mod;
	}

	public static void main(String[] args) {
		CountGoodNumbers c = new CountGoodNumbers();
		System.out.println(c.countGoodNumbers(4));
		System.out.println(c.countGoodNumbers(50));
		System.out.println(c.countGoodNumbers(1));
		System.out.println(c.countGoodNumbers(2));
		System.out.println(c.countGoodNumbers(3));
		
		System.out.println(c.countGoodNumbers(806166225460393L));
	}
}
