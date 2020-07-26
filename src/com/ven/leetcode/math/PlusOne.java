package com.ven.leetcode.math;

import java.util.Arrays;

import com.ven.utility.ArrayUtility;

/**
 * Given a non-empty array of digits representing a non-negative integer,
 * increment one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contains a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 1:
 * 
 * Input: [1,2,3] Output: [1,2,4] Explanation: The array represents the integer
 * 123. Example 2:
 * 
 * Input: [4,3,2,1] Output: [4,3,2,2] Explanation: The array represents the
 * integer 4321.
 * 
 * @author Venkatesh Manohar
 *
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		int carry = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (i < digits.length - 1 && carry == 0) {
				break;
			}
			if (i == digits.length - 1) {
				digits[i] = digits[i] + 1;
			}
			digits[i] += carry;
			carry = 0;
			if (digits[i] > 9) {
				carry = digits[i] / 10;
			}
			digits[i] %= 10;
		}
		if (carry > 0) {
			int[] temp = new int[digits.length + 1];
			for (int i = temp.length - 1; i > 0; i--) {
				temp[i] = digits[i - 1];
			}
			temp[0] = carry;
			digits = temp;
		}
		return digits;
	}

	public static void main(String[] args) {
		PlusOne p = new PlusOne();

		int[] dig = new int[] { 1 };
		ArrayUtility.print(p.plusOne(dig));
		dig = new int[] { 1, 2, 3 };
		ArrayUtility.print(p.plusOne(dig));
		dig = new int[] { 4, 3, 2, 1 };
		ArrayUtility.print(p.plusOne(dig));

		dig = new int[] { 4, 3, 2, 9 };
		ArrayUtility.print(p.plusOne(dig));

		dig = new int[] { 9, 9 };
		ArrayUtility.print(p.plusOne(dig));
		dig = new int[] { 9, 9, 9 };
		ArrayUtility.print(p.plusOne(dig));
		dig = new int[] { 9, 9, 9, 9 };
		ArrayUtility.print(p.plusOne(dig));
	}
}
