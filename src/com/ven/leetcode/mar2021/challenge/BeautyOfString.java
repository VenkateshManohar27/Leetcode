package com.ven.leetcode.mar2021.challenge;

public class BeautyOfString {
	public int beautySum(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			int[] a = new int[26]; // initialize charCount to all 0
			for (int j = i; j < s.length(); j++) {
				a[s.charAt(j)-'a']++;
				int res = beauty(a);
				//System.out.println(res);
				if(res != -1) {
					count+= res;
				}
			}
		}
		return count;
	}

	private int beauty(int[] arr) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				continue;
			}
			if (min > arr[i]) {
				min = arr[i];
			}
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		if(max == Integer.MIN_VALUE || min == Integer.MAX_VALUE) return -1;
		return ((max - min) > 0)? max- min:0;
	}
	
	public static void main(String[] args) {
		BeautyOfString b = new BeautyOfString();
		System.out.println(b.beautySum("aabcb"));
		System.out.println(b.beautySum("aabcbaa"));
	}
}
