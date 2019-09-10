package com.ven.amazon;

import java.util.HashSet;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find
 * the one that is missing from the array.
 * 
 * Example 1:
 * 
 * Input: [3,0,1] Output: 2 Example 2:
 * 
 * Input: [9,6,4,2,3,5,7,0,1] Output: 8 Note: Your algorithm should run in
 * linear runtime complexity. Could you implement it using only constant extra
 * space complexity?
 * 
 * @author Venkatesh Manohar
 *
 */
public class MissingNumber {
	/**
	 * Runtime: 9 ms, faster than 10.03% of Java online submissions for Missing
	 * Number. Memory Usage: 40 MB, less than 100.00% of Java online submissions for
	 * Missing Number.
	 * 
	 * @param nums
	 * @return
	 */
	public int missingNumber(int[] nums) {
		HashSet<Integer> s = new HashSet<>();
		for (int i : nums) {
			s.add(i);
		}

		for (int i = 0; i <= nums.length; i++) {
			if (!s.contains(i)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing
	 * Number. Memory Usage: 38.8 MB, less than 100.00% of Java online submissions
	 * for Missing Number.
	 * 
	 * @param nums
	 * @return
	 */
	public int missingNumber2(int[] nums) {
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		int n = nums.length;
		return (n * (n + 1)) / 2 - sum;
	}

	public static void main(String[] args) {
		MissingNumber mn = new MissingNumber();
		System.out.println(mn.missingNumber(new int[] { 0, 1, 3 }));
		System.out.println(mn.missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));

		System.out.println(mn.missingNumber2(new int[] { 0, 1, 3 }));
		System.out.println(mn.missingNumber2(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
	}
}
