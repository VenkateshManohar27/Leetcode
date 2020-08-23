package com.ven.leetcode.augchallenge;

public class MinimumNumbersFunctionCallsMakeTargetArray {
	public int minOperations(int[] nums) {
		int result = 0;
		int n = nums.length;
		while (true) {
			int zero_count = 0;

			int i;
			for (i = 0; i < n; i++) {
				if (nums[i] % 2 == 1) {
					break;
				} else if (nums[i] == 0) {
					zero_count++;
				}
			}

			if (zero_count == n)
				return result;

			if (i == n) {
				for (int j = 0; j < n; j++)
					nums[j] = nums[j] / 2;
				result++;
			}

			for (int j = i; j < n; j++) {
				if (nums[j] % 2 == 1) {
					nums[j]--;
					result++;
				}
			}
		}
	}

	public static void main(String[] args) {
		MinimumNumbersFunctionCallsMakeTargetArray m = new MinimumNumbersFunctionCallsMakeTargetArray();
		System.out.println(m.minOperations(new int[] { 1, 5 }));
		System.out.println(m.minOperations(new int[] { 2, 2 }));
		System.out.println(m.minOperations(new int[] { 4, 2, 5 }));
		System.out.println(m.minOperations(new int[] { 3, 2, 2, 4 }));
		System.out.println(m.minOperations(new int[] { 2, 4, 8, 16 }));
	}
}
