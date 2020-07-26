package com.ven.leetcode.math;

/**
 * The Hamming distance between two integers is the number of positions at which
 * the corresponding bits are different.
 * 
 * Given two integers x and y, calculate the Hamming distance.
 * 
 * Note: 0 <= x, y < 231.
 * 
 * Example:
 * 
 * Input: x = 1, y = 4
 * 
 * Output: 2
 * 
 * Explanation: 1 (0 0 0 1) 4 (0 1 0 0)
 * 
 * The above arrows point to positions where the corresponding bits are
 * different.
 * 
 * @author Venkatesh Manohar
 *
 */
public class HammingDistance {
	public int hammingDistance(int x, int y) {
		int z = x^y;
		String bitsZ = Integer.toBinaryString(z);
		int count = 0;
		for (int i = 0; i < bitsZ.length(); i++) {
			if(bitsZ.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		HammingDistance hd = new HammingDistance();
		hd.hammingDistance(1, 4);
		
	}
}
