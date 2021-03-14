package com.ven.leetcode.mar2021.challenge;

public class MinimumElementstoAddtoFormGivenSum {
	public int minElements(int[] nums, int limit, int goal) {
		long sum = 0, result = 0;
		for(int i: nums) sum+=i;
		result = Math.abs(goal-sum)/limit + (Math.abs(goal-sum)%limit==0 ? 0 : 1);
		return (int)result;   
	}

	public static void main(String[] args) {
		MinimumElementstoAddtoFormGivenSum m = new MinimumElementstoAddtoFormGivenSum();
		System.out.println(m.minElements(new int[] { -4, 0, -3, -3, 0, 0, -2, 2, 0, -2 }, 4, 940097744));
		System.out.println(m.minElements(new int[] { 1, -1, 1 }, 3, -4));
		System.out.println(m.minElements(new int[] { 1, -10, 9, 1 }, 100, 0));
	}
}
