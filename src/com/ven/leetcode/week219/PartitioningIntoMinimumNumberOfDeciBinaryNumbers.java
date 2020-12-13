package com.ven.leetcode.week219;

/**
 * A decimal number is called deci-binary if each of its digits is either 0 or 1
 * without any leading zeros. For example, 101 and 1100 are deci-binary, while
 * 112 and 3001 are not.
 * 
 * Given a string n that represents a positive decimal integer, return the
 * minimum number of positive deci-binary numbers needed so that they sum up to
 * n.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = "32" Output: 3 Explanation: 10 + 11 + 11 = 32 Example 2:
 * 
 * Input: n = "82734" Output: 8 Example 3:
 * 
 * Input: n = "27346209830709182346" Output: 9
 * 
 * 
 * Constraints:
 * 
 * 1 <= n.length <= 105 n consists of only digits. n does not contain any
 * leading zeros and represents a positive integer.
 * 
 * @author Venkatesh Manohar
 *
 */
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
	public int minPartitions(String num) {
		char[] chrs = num.toCharArray();
		int numZeroes = 0;
		int count = 0;
		while(numZeroes != num.length()) {
			numZeroes = 0;
			for(int i = 0; i<chrs.length; i++) {
				if(chrs[i] - '0' != 0) {
					int c = chrs[i] - '0' -1;
					chrs[i] = (char)(c+'0');
				}else {
					numZeroes++;
				}
			}
			if(numZeroes == num.length()) break;
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		PartitioningIntoMinimumNumberOfDeciBinaryNumbers p = new PartitioningIntoMinimumNumberOfDeciBinaryNumbers();
		System.out.println(p.minPartitions("32"));
		
		System.out.println(p.minPartitions("82734"));
		System.out.println(p.minPartitions("27346209830709182346"));
		
	}
}
