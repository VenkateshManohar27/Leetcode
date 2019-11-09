package com.vm.practice;

import com.ven.utility.ArrayUtility;

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length ==0 ) {
			return 0;
		}
		int length = 1;
		
		for (int i = 1; i < nums.length; i++) {
			if(nums[i-1] == nums[i]) {
				continue;
			}
			
			nums[length]=nums[i];
			length++;
		}
		return length;
	}

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArray rdsa = new RemoveDuplicatesfromSortedArray();
		int[] nums = new int[] {1,1,2};
		System.out.println(rdsa.removeDuplicates(nums));
		ArrayUtility.print(nums);
		
		nums = new int[] {0,0,1,1,1,2,2,3,3,4};
		System.out.println(rdsa.removeDuplicates(nums));
		ArrayUtility.print(nums);
		
		nums = new int[] {1,1,2};
		System.out.println(rdsa.removeDuplicates(nums));
		ArrayUtility.print(nums);
	}
}
