package com.ven.leetcode.week223;

public class MInLength {
	public int minimumLength(String s) {

		int start = 0;
		char[] arr = s.toCharArray();
		int end = arr.length - 1;
		int len = arr.length;
		while (start < end) {
			if (arr[start] == arr[end]) {
				char st = arr[start];
				char e = arr[end];
				while (start <= end && st == arr[start]) {
					start++;
					len--;
				}

				while (end >= start && e == arr[end]) {
					end--;
					len--;
				}
			} else {
				break;
			}
		}
		//if(start == end && arr[start] ==arr[end]) len--;
		return len;
	}
	
	public static void main(String[] args) {
		MInLength m = new MInLength();
		System.out.println(m.minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
		System.out.println(m.minimumLength("aaaaaaa"));
		System.out.println(m.minimumLength("c"));
		
		System.out.println(m.minimumLength("ca"));
		System.out.println(m.minimumLength("cabaabac"));
		System.out.println(m.minimumLength("aabccabba"));
		
		
		
	}
}
