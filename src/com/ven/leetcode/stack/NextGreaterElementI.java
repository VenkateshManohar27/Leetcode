package com.ven.leetcode.stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] output = new int[nums1.length];
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
			while(!st.isEmpty() && num > st.peek()) {
				map.put(st.pop(), num);
			}
        	st.push(num);
		}
        
        for (int i = 0; i < output.length; i++) {
			output[i] = map.getOrDefault(nums1[i], -1);
		}
        
        return output;
    }
}
