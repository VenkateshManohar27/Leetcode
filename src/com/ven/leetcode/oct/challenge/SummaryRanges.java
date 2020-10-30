package com.ven.leetcode.oct.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * You are given a sorted unique integer array nums.
 * 
 * Return the smallest sorted list of ranges that cover all the numbers in the
 * array exactly. That is, each element of nums is covered by exactly one of the
 * ranges, and there is no integer x such that x is in one of the ranges but not
 * in nums.
 * 
 * Each range [a,b] in the list should be output as:
 * 
 * "a->b" if a != b "a" if a == b
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [0,1,2,4,5,7] Output: ["0->2","4->5","7"] Explanation: The
 * ranges are: [0,2] --> "0->2" [4,5] --> "4->5" [7,7] --> "7" Example 2:
 * 
 * Input: nums = [0,2,3,4,6,8,9] Output: ["0","2->4","6","8->9"] Explanation:
 * The ranges are: [0,0] --> "0" [2,4] --> "2->4" [6,6] --> "6" [8,9] --> "8->9"
 * Example 3:
 * 
 * Input: nums = [] Output: [] Example 4:
 * 
 * Input: nums = [-1] Output: ["-1"] Example 5:
 * 
 * Input: nums = [0] Output: ["0"]
 * 
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 20 -231 <= nums[i] <= 231 - 1 All the values of nums are
 * unique.
 * 
 * @author Venkatesh Manohar
 *
 */
public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> li = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return li;
		int min = nums[0];
		Stack<Integer> st = new Stack<>();
		st.push(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] + 1 == nums[i]) {
				continue;
			} else {
				if (min == nums[i - 1]) {
					li.add("" + min);
				} else {
					li.add(min + "->" + nums[i - 1]);
				}

				min = nums[i];
				st.push(nums[i]);

			}

		}
		if (!st.isEmpty()) {
			if (nums[nums.length - 1] == st.peek()) {
				li.add("" + min);
			} else {
				li.add(min + "->" + nums[nums.length - 1]);
			}
		}

		return li;
	}
}
