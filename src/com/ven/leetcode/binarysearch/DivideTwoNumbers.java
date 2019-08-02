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
		if (dividend == 0) {
			return 0;
		}

		int sign = 1;
		if (dividend < 0 || divisor < 0) {
			sign = -1;
		}

		int mid = 0;
		int count = Math.abs(divisor) - 1;
		int start = 1, end = Math.abs(dividend);
		while (count > 0) {
			mid = start + (end - start) / 2;
			end = mid;
			count--;
		}

		return sign * mid;
	}
	
	public static void main(String[] args) {
		DivideTwoNumbers tn = new DivideTwoNumbers();
		assert((tn.divide(10, 3) == 3));
		assert((tn.divide(7, -3) == -2));
		assert((tn.divide(10, -2) == -5));
		assert((tn.divide(10, 2) == 5));
		assert((tn.divide(100, 10) == 0));
	}
}
