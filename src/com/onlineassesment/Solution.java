package com.onlineassesment;

import java.util.HashMap;

public class Solution {
	public int[] twoSum(int[] nums, int target) {
		if(nums == null || nums.length == 0)
			return new int[] {};

		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i< nums.length;i++) {
			int complement = target - nums[i];
			if(map.containsKey(complement)) {
				return new int[] {map.get(complement), i};
			}else {
				map.put(nums[i], i);
			}
		}
		
		return new int[] {};
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int [] res = s.twoSum(new int[] {2,7,11,15}, 9);
		System.out.println("target 9 "+res[0]+" "+res[1]);
		
		int[] input2 = new int[] {-9,-7,-5,-3,-2, -1, 0, 10,12};
		res = s.twoSum(input2, -4);
		System.out.println("target -4 "+res[0]+" "+res[1]);
		
		int[] input3 = new int[] {1,2,3,4,4,9,56,90};
		res = s.twoSum(input3, 8);
		System.out.println("target 8 "+res[0]+" "+res[1]);
		
	}
}
