package com.ven.amazon;

public class SingleNumber {
	public int singleNumber(int[] nums) {
		int result = 0;
		for (int value : nums) {
			result ^= value;
		}
		return result;
	}

	public static void main(String[] args) {
		SingleNumber sn = new SingleNumber();
		int res = sn.singleNumber(new int[] { 2, 2, 1 });
		System.out.println("Result:" + res);
	}
}
