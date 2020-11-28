package com.ven.leetcode.nov.challenge;

/**
 * Given a positive integer K, you need to find the length of the smallest
 * positive integer N such that N is divisible by K, and N only contains the
 * digit 1.
 * 
 * Return the length of N. If there is no such N, return -1.
 * 
 * Note: N may not fit in a 64-bit signed integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: K = 1 Output: 1 Explanation: The smallest answer is N = 1, which has
 * length 1. Example 2:
 * 
 * Input: K = 2 Output: -1 Explanation: There is no such positive integer N
 * divisible by 2. Example 3:
 * 
 * Input: K = 3 Output: 3 Explanation: The smallest answer is N = 111, which has
 * length 3.
 * 
 * 
 * Constraints:
 * 
 * 1 <= K <= 105
 * 
 * @author Venkatesh Manohar
 *
 */
public class SmallestIntegerDivisiblebyK {
	public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) 
            return -1; 
  
        int number = 0; 
  
        int len = 1; 
  
        for (len = 1; len <= K; len++) { 
  
            // Instead of generating all possible numbers 
            // 1, 11, 111, 111, ..., K 1's 
            // Take remainder with K 
            number = (number * 10 + 1) % K; 
  
            // If number is divisible by k 
            // then remainder will be 0 
            if (number == 0) 
                return len; 
        } 
  
        return -1; 
    }
	
	public static void main(String[] args) {
		SmallestIntegerDivisiblebyK s = new SmallestIntegerDivisiblebyK();
		
		System.out.println(s.smallestRepunitDivByK(1));

		System.out.println(s.smallestRepunitDivByK(2));

		System.out.println(s.smallestRepunitDivByK(7));

		System.out.println(s.smallestRepunitDivByK(8));

		System.out.println(s.smallestRepunitDivByK(1999));
	}
}
