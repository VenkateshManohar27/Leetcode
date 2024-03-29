package com.ven.leetcode.jul2021.challenge;

/**
 * Given an array nums, partition it into two (contiguous) subarrays left and
 * right so that:
 * 
 * Every element in left is less than or equal to every element in right. left
 * and right are non-empty. left has the smallest possible size. Return the
 * length of left after such a partitioning. It is guaranteed that such a
 * partitioning exists.
 * 
 * Example 1:
 * 
 * Input: nums = [5,0,3,8,6] Output: 3 Explanation: left = [5,0,3], right =
 * [8,6] Example 2:
 * 
 * Input: nums = [1,1,1,0,6,12] Output: 4 Explanation: left = [1,1,1,0], right =
 * [6,12]
 * 
 * Note:
 * 
 * 2 <= nums.length <= 30000 0 <= nums[i] <= 106 It is guaranteed there is at
 * least one way to partition nums as described.
 * 
 * @author Venkatesh Manohar
 *
 */
public class PartitionArrayintoDisjointIntervals {
	public int partitionDisjoint(int[] A) {
		int N = A.length;
		int[] maxleft = new int[N];
		int[] minright = new int[N];

		int m = A[0];
		for (int i = 0; i < N; ++i) {
			m = Math.max(m, A[i]);
			maxleft[i] = m;
		}

		m = A[N - 1];
		for (int i = N - 1; i >= 0; --i) {
			m = Math.min(m, A[i]);
			minright[i] = m;
		}

		for (int i = 1; i < N; ++i)
			if (maxleft[i - 1] <= minright[i])
				return i;

		throw null;
	}
}
