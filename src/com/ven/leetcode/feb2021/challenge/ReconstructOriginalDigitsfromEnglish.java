package com.ven.leetcode.feb2021.challenge;

/**
 * Given a non-empty string containing an out-of-order English representation of
 * digits 0-9, output the digits in ascending order.
 * 
 * Note: Input contains only lowercase English letters. Input is guaranteed to
 * be valid and can be transformed to its original digits. That means invalid
 * inputs such as "abc" or "zerone" are not permitted. Input length is less than
 * 50,000. Example 1: Input: "owoztneoer"
 * 
 * Output: "012" Example 2: Input: "fviefuro"
 * 
 * Output: "45"
 * 
 * @author Venkatesh Manohar
 *
 */
public class ReconstructOriginalDigitsfromEnglish {
	char[] dic = { 'z', 'w', 'g', 'x', 'u', 's', 'v', 'o', 't', 'i' };
	String[] digits = { "zero", "two", "eight", "six", "four", "seven", "five", "one", "three", "nine" };
	int[] index = { 0, 2, 8, 6, 4, 7, 5, 1, 3, 9 };

	public String originalDigits(String s) {
		int[] ch = new int[26];
		for (int i = 0; i < s.length(); i++) {
			ch[s.charAt(i) - 'a']++;
		}

		int[] res = new int[10];
		for (int i = 0; i < 10; i++) {
			int chIndex = dic[i] - 'a';
			int count = ch[chIndex];
			if (count < 1) {
				continue;
			}
			res[index[i]] = count;
			String number = digits[i];
			for (int j = 0; j < number.length(); j++) {
				char c = number.charAt(j);
				ch[c - 'a'] -= count;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			int len = res[i];
			while (len > 0) {
				sb.append(i);
				len--;
			}
		}
		return sb.toString();

	}

	public static void main(String[] args) {
		ReconstructOriginalDigitsfromEnglish r = new ReconstructOriginalDigitsfromEnglish();
		System.out.println(r.originalDigits("owoztneoer"));
	}
}
