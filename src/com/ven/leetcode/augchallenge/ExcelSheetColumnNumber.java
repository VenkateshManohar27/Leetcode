package com.ven.leetcode.augchallenge;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * 
 * For example:
 * 
 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28 ... Example 1:
 * 
 * Input: "A" Output: 1 Example 2:
 * 
 * Input: "AB" Output: 28 Example 3:
 * 
 * Input: "ZY" Output: 701
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 7 s consists only of uppercase English letters. s is between
 * "A" and "FXSHRXW".
 * 
 * @author Venkatesh Manohar
 *
 */
public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int col = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i == s.length() - 1) {
				col += (s.charAt(i) - 'A');
				break;
			}

			col += Math.pow(26, s.length() - 1 - i) * (s.charAt(i) - 'A' + 1);

		}

		return col + 1;
	}

	public static void main(String[] args) {
		ExcelSheetColumnNumber escn = new ExcelSheetColumnNumber();
		System.out.println(escn.titleToNumber("A"));
		System.out.println(escn.titleToNumber("Z"));
		System.out.println(escn.titleToNumber("AZ"));
		System.out.println(escn.titleToNumber("AB"));
		System.out.println(escn.titleToNumber("ZY"));
		System.out.println(escn.titleToNumber("ABC"));
		System.out.println(escn.titleToNumber("FXSHRXW"));
	}
}
