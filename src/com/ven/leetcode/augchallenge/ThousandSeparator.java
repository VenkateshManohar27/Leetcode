package com.ven.leetcode.augchallenge;

/**
 * Given an integer n, add a dot (".") as the thousands separator and return it
 * in string format.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 987 Output: "987" Example 2:
 * 
 * Input: n = 1234 Output: "1.234" Example 3:
 * 
 * Input: n = 123456789 Output: "123.456.789" Example 4:
 * 
 * Input: n = 0 Output: "0"
 * 
 * @author Venkatesh Manohar
 *
 */
public class ThousandSeparator {
	public String thousandSeparator(int n) {

		StringBuilder sb = new StringBuilder();
		sb.append(n);
		if (n == 0) {
			return sb.toString();
		}
		boolean negative = false;
		if (n < 0) {
			negative = true;
		}
		for (int i = sb.length() - 1, j = 1; ((i > 0 && !negative) || (negative && i > 1)); i--) {
			if (j == 3) {
				sb.insert(i, '.');
				j = 0;
			}
			j++;
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		ThousandSeparator t = new ThousandSeparator();
		System.out.println(t.thousandSeparator(123));
		System.out.println(t.thousandSeparator(1234));
		System.out.println(t.thousandSeparator(12345));
		System.out.println(t.thousandSeparator(1234567));
		System.out.println(t.thousandSeparator(123456789));

		System.out.println(t.thousandSeparator(0));
		
		System.out.println(t.thousandSeparator(-123));
		System.out.println(t.thousandSeparator(-1234));
		System.out.println(t.thousandSeparator(-12345));
		System.out.println(t.thousandSeparator(-1234567));
		System.out.println(t.thousandSeparator(-123456789));
	}
}
