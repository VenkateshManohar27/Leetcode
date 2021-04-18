package com.ven.leetcode.biweek50;

public class MaximumXORQuery {
	public int[] getMaximumXor(int[] nums, int maximumBit) {
		int[] xor = new int[nums.length];
		int[] res = new int[nums.length];
		int max = (int) Math.pow(2, maximumBit) - 1;
		xor[0] = nums[0];

		for (int i = 0; i < xor.length; i++) {
			if (i > 0)
				xor[i] = xor[i - 1] ^ nums[i];
			// System.out.println("xor"+xor[i]);
			int maximum = xor[i] ^ max;

			res[nums.length - 1 - i] = maximum;
		}

		return res;
	}

	public static void main(String[] args) {
		MaximumXORQuery m = new MaximumXORQuery();
		m.getMaximumXor(new int[] { 0, 1, 1, 3 }, 2);
	}

}
