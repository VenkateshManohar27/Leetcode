package com.ven.leetcode.binarysearch;

/**
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero.
 * 
 * Example 1:
 * 
 * Input: dividend = 10, divisor = 3 Output: 3 Example 2:
 * 
 * Input: dividend = 7, divisor = -3 Output: -2 Note:
 * 
 * Both dividend and divisor will be 32-bit signed integers. The divisor will
 * never be 0. Assume we are dealing with an environment which could only store
 * integers within the 32-bit signed integer range: [−231, 231 − 1]. For the
 * purpose of this problem, assume that your function returns 231 − 1 when the
 * division result overflows.
 * 
 * @author Venkatesh Manohar
 *
 */
public class DivideTwoNumbers {
	public int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;

		int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
		int result = 0;
		int power = 32;
		long x = Math.abs((long) dividend);
		long y = Math.abs((long) divisor);

		while (x >= y) {
			while ((y << power) > x) {
				power--;
			}
			x -= y << power;
			result += 1 << power;
		}
		return result * sign;
	}

	public static void main(String[] args) {
		DivideTwoNumbers tn = new DivideTwoNumbers();
		assert ((tn.divide(10, 3) == 3));
		assert ((tn.divide(7, -3) == -2));
		assert ((tn.divide(10, -2) == -5));
		assert ((tn.divide(10, 2) == 5));
		assert ((tn.divide(100, 10) == 10));
	}
}
