package com.ven.leetcode.dec.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given a non-empty string containing only
 * digits return all possible options in a list 1 <= s.length <= 100 s contains
 * only digits and may contain leading zero(s).
 * 
 * @author Venkatesh Manohar
 *
 */
public class DecodeWaysCustom {
	public List<String> numDecodings(String s) {
		List<String> l = new ArrayList<>();
		helper(s, 0, 0, "", l);
		return l;
	}

	private void helper(String s, int i, int length, String curr, List<String> l) {
		if (length == s.length()) {
			l.add(curr);
			return;
		}
		//for (int i = index; i < s.length(); i++) {
			int c = s.charAt(i) - '0';

			if (i > 0) {
				int prev = s.charAt(i - 1) - '0';
				if (prev > 0 && prev < 3) {
					prev = prev * 10 + c;

					if (prev <= 26) {
						String st = (curr.length() > 0)?curr.substring(0, curr.length() -1):curr;
						String t = getCharForNumber(prev);
						helper(s, i + 1, length + 1,  new String(st + t), l);
					}
				}

			} 
			if (c >= 1 && c <= 9) {
				String t = getCharForNumber(c);
				helper(s, i + 1, length + 1, new String(curr + t), l);
			}
			
		//}
	}

	private String getCharForNumber(int i) {
		return i > 0 && i < 27 ? String.valueOf((char) (i + 64)) : null;
	}

	public static void main(String[] args) {
		DecodeWaysCustom dw = new DecodeWaysCustom();
		System.out.println(dw.numDecodings("12"));
		System.out.println(dw.numDecodings("226"));
		System.out.println(dw.numDecodings("2626"));
		System.out.println(dw.numDecodings("012"));
		System.out.println(dw.numDecodings("110"));
		System.out.println(dw.numDecodings("101"));
	}
}
