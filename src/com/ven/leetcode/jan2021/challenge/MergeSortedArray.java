package com.ven.leetcode.jan2021.challenge;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively. You may assume that nums1 has enough space (size that is equal
 * to m + n) to hold additional elements from nums2.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 Output:
 * [1,2,2,3,5,6] Example 2:
 * 
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0 Output: [1]
 * 
 * 
 * Constraints:
 * 
 * 0 <= n, m <= 200 1 <= n + m <= 200 nums1.length == m + n nums2.length == n
 * -109 <= nums1[i], nums2[i] <= 109
 * 
 * @author Venkatesh Manohar
 *
 */
public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int index = (m + n - 1);
		m = m - 1;
		n = n - 1;
		for (int i = index; i >= 0; i--) {
			// System.out.println(i);
			if (m < 0) {
				nums1[i] = nums2[n--];
			} else if (n < 0) {
				nums1[i] = nums1[m--];
			} else if (nums1[m] > nums2[n]) {
				nums1[i] = nums1[m--];
			} else {
				nums1[i] = nums2[n--];
			}
		}
	}
}