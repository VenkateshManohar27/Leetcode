package com.ven.leetcode.biweek58;

public class MinSpaceWastedKResizing {

	/*
	 * public int minSpaceWastedKResizing(int[] nums, int k) { int min =
	 * Integer.MAX_VALUE;
	 * 
	 * for (int i = 0; i < nums.length; i++) { int size = nums[i]; int count = k;
	 * int minwasted = 0; boolean notfit = true; for (int j = 0; j < nums.length;
	 * j++) { if(size < nums[j] ) { if(count > 0) { size = nums[j]; count--; }else {
	 * notfit = false; break; } }
	 * 
	 * minwasted += size - nums[j]; } if(notfit) min = Math.min(minwasted, min); }
	 * 
	 * return min; }
	 */
	private int min = Integer.MAX_VALUE;

	public int minSpaceWastedKResizing(int[] nums, int k) {
		for (int i = 0; i < nums.length; i++) {
			helper(nums[i], k, 0, nums, 0);
		}
		return min;
	}

	private void helper(int size, int resize, int index, int[] nums, int minWasted) {
		if (index >= nums.length) {
			min = Math.min(minWasted, min);
			return;
		}
		for (int i = index; i < nums.length; i++) {
			if (size < nums[i] && resize <= 0) {
				return;
			}
			if (size > nums[i]) {
				int wasted = minWasted;
				wasted += size - nums[index];
				//helper(size, resize, index + 1, nums, wasted);
			}
			if (resize > 0) {
				int wasted = minWasted;
				size = nums[i];
				wasted += size - nums[index];
				helper(nums[i], resize - 1, index + 1, nums, wasted);
			}
		}
	}

	public static void main(String[] args) {
		MinSpaceWastedKResizing m = new MinSpaceWastedKResizing();
		System.out.println(m.minSpaceWastedKResizing(new int[] { 10, 20 }, 0));
		System.out.println(m.minSpaceWastedKResizing(new int[] { 10, 20, 30 }, 1));
		System.out.println(m.minSpaceWastedKResizing(new int[] { 10, 20, 15, 30, 20 }, 2));
		System.out.println(m.minSpaceWastedKResizing(new int[] { 13, 46, 42, 45, 35 }, 4));
	}

}
