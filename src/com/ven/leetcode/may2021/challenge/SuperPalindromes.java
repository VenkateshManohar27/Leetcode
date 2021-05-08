package com.ven.leetcode.may2021.challenge;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * Let's say a positive integer is a super-palindrome if it is a palindrome, and
 * it is also the square of a palindrome.
 * 
 * Given two positive integers left and right represented as strings, return the
 * number of super-palindromes integers in the inclusive range [left, right].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: left = "4", right = "1000" Output: 4 Explanation: 4, 9, 121, and 484
 * are superpalindromes. Note that 676 is not a superpalindrome: 26 * 26 = 676,
 * but 26 is not a palindrome. Example 2:
 * 
 * Input: left = "1", right = "2" Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= left.length, right.length <= 18 left and right consist of only digits.
 * left and right cannot have leading zeros. left and right represent integers
 * in the range [1, 1018]. left is less than or equal to right.
 * 
 * @author Venkatesh Manohar
 *
 */
public class SuperPalindromes {
	public int superpalindromesInRange(String left, String right) {
        long L = Long.valueOf(left);
        long R = Long.valueOf(right);
        int MAGIC = 100000;
        int ans = 0;

        // count odd length;
        for (int k = 1; k < MAGIC; ++k) {
            StringBuilder sb = new StringBuilder(Integer.toString(k));
            for (int i = sb.length() - 2; i >= 0; --i)
                sb.append(sb.charAt(i));
            long v = Long.valueOf(sb.toString());
            v *= v;
            if (v > R) break;
            if (v >= L && isPalindrome(v)) ans++;
        }

        // count even length;
        for (int k = 1; k < MAGIC; ++k) {
            StringBuilder sb = new StringBuilder(Integer.toString(k));
            for (int i = sb.length() - 1; i >= 0; --i)
                sb.append(sb.charAt(i));
            long v = Long.valueOf(sb.toString());
            v *= v;
            if (v > R) break;
            if (v >= L && isPalindrome(v)) ans++;
        }

        return ans;
    }

    public boolean isPalindrome(long x) {
        return x == reverse(x);
    }

    public long reverse(long x) {
        long ans = 0;
        while (x > 0) {
            ans = 10 * ans + x % 10;
            x /= 10;
        }

        return ans;
    }
    
    public static void main(String[] args) {
		SuperPalindromes s = new SuperPalindromes();
		s.superpalindromesInRange("4", "1000");
	}
}
