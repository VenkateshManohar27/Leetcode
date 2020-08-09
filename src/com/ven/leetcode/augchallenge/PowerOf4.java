package com.ven.leetcode.augchallenge;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a
 * power of 4.
 * 
 * Example 1:
 * 
 * Input: 16 Output: true Example 2:
 * 
 * Input: 5 Output: false Follow up: Could you solve it without loops/recursion?
 * 
 * @author Venkatesh Manohar
 *
 */
public class PowerOf4 {
	public boolean isPowerOfFour(int num) {
		return num != 0 && ((num & (num - 1)) == 0) && (num & 0xAAAAAAAA) == 0;
	}

	public static void main(String[] args) {
		PowerOf4 p = new PowerOf4();

		for (int i = 0; i < 1048577; i++) {
			if (p.isPowerOfFour(i)) {
				System.out.println(i + " is a Power Of 4");
			}
		}
	}
}
