package com.ven.leetcode.julchallenge;

import java.util.Arrays;

public class ReverseWordsString {
	public String reverseWords(String s) {
		String[] strs = s.split(" ");
		int i = 0;
		int j = strs.length - 1;

		while (i < j) {
			while(strs[i].equals(" ")) {
				i++;
			}
			while(strs[j].equals(" ")) {
				j--;
			}
			String temp = strs[i];
			strs[i] = strs[j];
			strs[j] = temp;
			i++;
			j--;
		}
		return String.join(" ", strs);
	}

	public static void main(String[] args) {
		ReverseWordsString r = new ReverseWordsString();
		System.out.println(r.reverseWords(""));
		
		System.out.println(r.reverseWords("the sky is blue"));
		System.out.println(r.reverseWords("  hello world!  "));
		System.out.println(r.reverseWords("a good   example"));
		
	}
}
