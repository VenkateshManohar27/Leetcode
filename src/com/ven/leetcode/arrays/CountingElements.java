package com.ven.leetcode.arrays;

import java.util.HashMap;

/**
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 * 
 * If there're duplicates in arr, count them seperately.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [1,2,3] Output: 2 Explanation: 1 and 2 are counted cause 2 and 3
 * are in arr. Example 2:
 * 
 * Input: arr = [1,1,3,3,5,5,7,7] Output: 0 Explanation: No numbers are counted,
 * cause there's no 2, 4, 6, or 8 in arr. Example 3:
 * 
 * Input: arr = [1,3,2,3,5,0] Output: 3 Explanation: 0, 1 and 2 are counted
 * cause 1, 2 and 3 are in arr. Example 4:
 * 
 * Input: arr = [1,1,2,2] Output: 2 Explanation: Two 1s are counted cause 2 is
 * in arr.
 * 
 * @author Venkatesh Manohar
 *
 */
public class CountingElements {
	public int countElements(int[] arr) {
		int count = 0;
		HashMap<Integer, Integer> countMap =  new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if(countMap.containsKey(arr[i])) {
				countMap.put(arr[i], countMap.get(arr[i])+1);
			}else {
				countMap.put(arr[i], 1);
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			if(countMap.containsKey(num+1)) {
				count++;
				countMap.put(num+1, countMap.get(num+1)-1);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		CountingElements ce = new CountingElements();
		System.out.println(ce.countElements(new int [] {1,2,3}));
		System.out.println(ce.countElements(new int [] {1,1,3,3,5,5,7,7}));
		System.out.println(ce.countElements(new int [] {1,3,2,3,5,0}));
		System.out.println(ce.countElements(new int [] {1,1,2,2}));
		
	}
}
