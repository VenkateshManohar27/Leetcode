package com.ven.leetcode.augchallenge;

/**
 * Given an integer array arr, return true if there are three consecutive odd
 * numbers in the array. Otherwise, return false.
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [2,6,4,1] Output: false Explanation: There are no three
 * consecutive odds. Example 2:
 * 
 * Input: arr = [1,2,34,3,4,5,7,23,12] Output: true Explanation: [5,7,23] are
 * three consecutive odds.
 * 
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 1000 1 <= arr[i] <= 1000
 * 
 * @author Venkatesh Manohar
 *
 */
public class ThreeConsecutiveOdds {
	public boolean threeConsecutiveOdds(int[] arr) {
		boolean res = false;
		if (arr == null || arr.length < 2) {
			return res;
		}
		for (int i = 0; i < arr.length - 2; i++) {
			res = (arr[i] % 2 == 1) && (arr[i + 1] % 2 == 1) && (arr[i + 2] % 2 == 1);
			if (res) {
				break;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		ThreeConsecutiveOdds t = new ThreeConsecutiveOdds();
		System.out.println(t.threeConsecutiveOdds(new int[] { 2, 6, 4, 1 }));
		System.out.println(t.threeConsecutiveOdds(new int[] { 1, 2, 34, 3, 4, 5, 7, 23, 12 }));
		System.out.println(t.threeConsecutiveOdds(new int[] { 1, 2 }));
		System.out.println(t.threeConsecutiveOdds(new int[] { 1, 1, 1 }));
	}
}
