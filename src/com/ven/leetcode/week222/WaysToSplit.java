package com.ven.leetcode.week222;

public class WaysToSplit {
	public int waysToSplit(int[] nums) {
		int n = nums.length;
		// Stores the prefix sums
		int[] prefix_sum = new int[n];

		prefix_sum[0] = nums[0];

		for (int i = 1; i < n; i++)
			prefix_sum[i] = prefix_sum[i - 1] + nums[i];

		// Stores the suffix sums
		int[] suffix_sum = new int[n];

		suffix_sum[n - 1] = nums[n - 1];

		for (int i = n - 2; i >= 0; i--)
			suffix_sum[i] = suffix_sum[i + 1] + nums[i];

		int s = 1, e = 1;
		int curr_subarray_sum = 0, count = 0;

		// Traverse the given array
		while (s < n - 1 && e < n - 1) {

			// Updating curr_subarray_sum until
			// it is less than prefix_sum[s-1]
			while (e < n - 1 && curr_subarray_sum < prefix_sum[s - 1]) {
				curr_subarray_sum += nums[e++];
			}

			if (curr_subarray_sum <= suffix_sum[e]) {
				// Increase count
				count++;
			}

			// Decrease curr_subarray_sum by arr[s[]
			curr_subarray_sum -= nums[s++];
		}

		// Return count
		return count;
	}
}
