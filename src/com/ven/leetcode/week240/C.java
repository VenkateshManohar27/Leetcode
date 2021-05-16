package com.ven.leetcode.week240;

import java.util.Arrays;

public class C {
	public int maxSumMinProduct(int[] nums) {
		int mod = 1000000007;
		int[] sum = new int[nums.length + 1];
		for (int i = 1; i <= nums.length; i++) {
			sum[i] += nums[i - 1] + sum[i - 1];
		}
		// System.out.println(Arrays.toString(sum));
		long maxproduct = 0;
		int max = 0;
		SegmentTreeMinRangeQuery s = new SegmentTreeMinRangeQuery(nums);
		for (int i = 0; i < sum.length; i++) {
			for (int j = i + 1; j < sum.length; j++) {
				int sumOf = sum[j] - sum[i];
				maxproduct = sumOf * s.findMinimumInRange(i, j - 1);
				max = Math.max(max, (int) maxproduct % mod);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		C c = new C();
		System.out.println(c.maxSumMinProduct(new int[] { 1, 2, 3, 2 }));
	}
}

class SegmentTreeMinRangeQuery {
	private int[] segTree;
	private int[] input;

	public SegmentTreeMinRangeQuery(int[] input) {
		this.input = input;
		createSegmentTree();
	}

	private static int nextPowerOf2(int num) {
		if (num == 0) {
			return 1;
		}
		if (num > 0 && (num & (num - 1)) == 0) {
			return num;
		}
		while ((num & (num - 1)) > 0) {
			num = num & (num - 1);
		}
		return num << 1;
	}

	private void createSegmentTree() {
		int nextPowerOf2 = nextPowerOf2(this.input.length);
		this.segTree = new int[nextPowerOf2 * 2 - 1];
		Arrays.fill(this.segTree, Integer.MAX_VALUE);
		construct(this.input, this.segTree, 0, input.length - 1, 0);
	}

	private void construct(int[] inp, int[] segmentTree, int low, int high, int pos) {
		if (low == high) {
			this.segTree[pos] = inp[low];
			return;
		}
		int mid = (low + high) / 2;
		construct(inp, segmentTree, low, mid, 2 * pos + 1);
		construct(inp, segmentTree, mid + 1, high, 2 * pos + 2);
		this.segTree[pos] = Math.min(this.segTree[2 * pos + 1], this.segTree[2 * pos + 2]);
	}

	public int findMinimumInRange(int startIndex, int endIndex) {
		return rangeMinQuery(startIndex, endIndex, 0, this.input.length - 1, 0);
	}

	private int rangeMinQuery(int startIndex, int endIndex, int low, int high, int pos) {
		if (startIndex <= low && endIndex >= high) {
			return this.segTree[pos];
		}
		if (startIndex > high || endIndex < low) {
			return Integer.MAX_VALUE;
		}
		int mid = (low + high) / 2;

		return Math.min(rangeMinQuery(startIndex, endIndex, low, mid, 2 * pos + 1),
				rangeMinQuery(startIndex, endIndex, mid + 1, high, 2 * pos + 2));
	}
}
