package com.ven.leetcode.easy;

public class MergeSortedArray {
	/*public void merge(int[] nums1, int m, int[] nums2, int n) {
		for (int i = 0, j = 0; i < nums1.length && j < n; i++) {
			if (nums1[i] > nums2[j]) {
				int temp = nums2[j];
				nums2[j] = nums1[i];
				nums1[i] = temp;
			} else if (nums1[i] == 0) {
				nums1[i] = nums2[j];
				j++;
			}

		}
	}*/
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int index = m + n - 1;
		m--;
		n--;
		while (m >= 0 || n >= 0) {
			if (n == -1) {
				return;
			} else if (m < 0) {
				nums1[index--] = nums2[n--];
			} else if (nums1[m] >= nums2[n]) {
				nums1[index--] = nums1[m--];
			} else {
				nums1[index--] = nums2[n--];
			}

		}
		
	}
}
