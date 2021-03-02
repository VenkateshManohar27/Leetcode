package com.ven.leetcode.feb2021.challenge;

import java.util.PriorityQueue;

/**
 * You are given two arrays of integers nums1 and nums2, possibly of different
 * lengths. The values in the arrays are between 1 and 6, inclusive.
 * 
 * In one operation, you can change any integer's value in any of the arrays to
 * any value between 1 and 6, inclusive.
 * 
 * Return the minimum number of operations required to make the sum of values in
 * nums1 equal to the sum of values in nums2. Return -1 if it is not
 * possible to make the sum of the two arrays equal.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2] Output: 3 Explanation:
 * You can make the sums of nums1 and nums2 equal with 3 operations. All indices
 * are 0-indexed. - Change nums2[0] to 6. nums1 = [1,2,3,4,5,6], nums2 =
 * [6,1,2,2,2,2]. - Change nums1[5] to 1. nums1 = [1,2,3,4,5,1], nums2 =
 * [6,1,2,2,2,2]. - Change nums1[2] to 2. nums1 = [1,2,2,4,5,1], nums2 =
 * [6,1,2,2,2,2]. Example 2:
 * 
 * Input: nums1 = [1,1,1,1,1,1,1], nums2 = [6] Output: -1 Explanation: There is
 * no way to decrease the sum of nums1 or to increase the sum of nums2 to make
 * them equal. Example 3:
 * 
 * Input: nums1 = [6,6], nums2 = [1] Output: 3 Explanation: You can make the
 * sums of nums1 and nums2 equal with 3 operations. All indices are 0-indexed. -
 * Change nums1[0] to 2. nums1 = [2,6], nums2 = [1]. - Change nums1[1] to 2.
 * nums1 = [2,2], nums2 = [1]. - Change nums2[0] to 4. nums1 = [2,2], nums2 =
 * [4].
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums1.length, nums2.length <= 105 1 <= nums1[i], nums2[i] <= 6
 * 
 * @author Venkatesh Manohar
 *
 */
public class EqualSumArraysWithMinimumNumberOperations {
	public int minOperations(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length * 6 || nums2.length > nums1.length * 6)
			return -1;
		int sum1 = 0, sum2 = 0, operations = 0;
		for (int i : nums2)
			sum2 += i;
		for (int i : nums1)
			sum1 += i;
		if (sum1 > sum2) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;

			int tempSum = sum1;
			sum1 = sum2;
			sum2 = tempSum;
		}
		PriorityQueue<Integer> pq1 = new PriorityQueue<>(), pq2 = new PriorityQueue<>((x, y) -> y - x);
		for (int i : nums1)
			pq1.offer(i);
		for (int i : nums2)
			pq2.offer(i);

		for (; sum1 < sum2; operations++)
			if (pq2.isEmpty() || pq2.peek() - 1 < 6 - pq1.peek())
				sum1 += 6 - pq1.poll();
			else
				sum2 -= pq2.poll() - 1;
		return operations;
	}

	public static void main(String[] args) {
		EqualSumArraysWithMinimumNumberOperations m = new EqualSumArraysWithMinimumNumberOperations();
		System.out.println(m.minOperations(new int[] {1,2,3,4,5,6}, new int[] {1,1,2,2,2,2}));
	}
}
