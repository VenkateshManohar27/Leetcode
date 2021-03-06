package com.ven.leetcode.may2021.challenge;

import java.util.HashSet;

/**
 * You are given an array of positive integers nums and want to erase a subarray
 * containing unique elements. The score you get by erasing the subarray is
 * equal to the sum of its elements.
 * 
 * Return the maximum score you can get by erasing exactly one subarray.
 * 
 * An array b is called to be a subarray of a if it forms a contiguous
 * subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some
 * (l,r).
 * 
 * Example 1:
 * 
 * Input: nums = [4,2,4,5,6] Output: 17 Explanation: The optimal subarray here
 * is [2,4,5,6]. Example 2:
 * 
 * Input: nums = [5,2,1,2,5,2,1,2,5] Output: 8 Explanation: The optimal subarray
 * here is [5,2,1] or [1,2,5].
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 1 <= nums[i] <= 104
 * 
 * @author Venkatesh Manohar
 *
 */
public class MaximumErasureValue {
	public int maximumUniqueSubarray(int[] nums) {
		HashSet<Integer> s = new HashSet<>();

		int l = 0, r = 0, max = 0, runningSum = 0;

		while (l <= r && r < nums.length) {
			int num = nums[r];
			if (s.contains(num)) {
				int n = nums[l];
				s.remove(n);
				runningSum -= n;
				l++;
			} else {
				s.add(num);
				runningSum += num;
				r++;
				max = Math.max(max, runningSum);
			}
		}
		return max;
	}
	
	public int maximumUniqueSubarrayOp(int[] nums) {
	       boolean[] visited = new boolean[10001];
	        
	        int l = 0, r= 0, max =0, runningSum = 0;
	        
	        while(l <= r  && r < nums.length){
	            int num = nums[r];
	            while(visited[num]){
	                int n = nums[l];
					visited[n] = false;
					runningSum -= n;
	                l++;
	            }
	            visited[num] = true;
	            runningSum += num;
	            r++;
	            max = Math.max(max, runningSum);

	        }
	        return max;
	    }
}
