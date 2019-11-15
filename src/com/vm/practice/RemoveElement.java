package com.vm.practice;

import com.ven.utility.ArrayUtility;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		if (nums == null) {
			return 0;
		}
		int i = 0;
		int n = nums.length;
		while (i < n) {
			if(nums[i] == val) {
				nums[i] = nums[n-1];
				n--;
			}else {
				i++;
			}
		}
		return n;
	}

	public static void main(String[] args) {
		RemoveElement re = new RemoveElement();
		int[] nums = new int[] { 3, 2, 2, 3 };
		System.out.println(re.removeElement(nums, 3));
		ArrayUtility.print(nums);

		nums = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };
		System.out.println(re.removeElement(nums, 2));
		ArrayUtility.print(nums);
		
		nums = new int[] {1 };
		System.out.println(re.removeElement(nums, 1));
		ArrayUtility.print(nums);
	}
}
