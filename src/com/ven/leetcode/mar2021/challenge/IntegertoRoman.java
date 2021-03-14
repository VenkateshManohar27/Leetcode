package com.ven.leetcode.mar2021.challenge;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000 For example, 2 is written
 * as II in Roman numeral, just two one's added together. 12 is written as XII,
 * which is simply X + II. The number 27 is written as XXVII, which is XX + V +
 * II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There
 * are six instances where subtraction is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed
 * before L (50) and C (100) to make 40 and 90. C can be placed before D (500)
 * and M (1000) to make 400 and 900. Given an integer, convert it to a roman
 * numeral.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num = 3 Output: "III" Example 2:
 * 
 * Input: num = 4 Output: "IV" Example 3:
 * 
 * Input: num = 9 Output: "IX" Example 4:
 * 
 * Input: num = 58 Output: "LVIII" Explanation: L = 50, V = 5, III = 3. Example
 * 5:
 * 
 * Input: num = 1994 Output: "MCMXCIV" Explanation: M = 1000, CM = 900, XC = 90
 * and IV = 4.
 * 
 * 
 * Constraints:
 * 
 * 1 <= num <= 3999
 * 
 * @author Venkatesh Manohar
 *
 */
public class IntegertoRoman {
	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		if (num <= 0 && num > 3999)
			return sb.toString();
		int base = 1;
		while (num > 0) {
			int remainder = num % 10;
			sb.insert(0, getRomanNumeral(remainder, base));
			base = base * 10;
			num = num / 10;
		}
		return sb.toString();
	}

	private String getRomanNumeral(int num, int base) {

		if (base == 1) {
			switch (num) {
			case 1:
				return "I";

			case 2:
				return "II";

			case 3:
				return "III";

			case 4:
				return "IV";

			case 5:
				return "V";

			case 6:
				return "VI";

			case 7:
				return "VII";

			case 8:
				return "VIII";

			case 9:
				return "IX";
			}
		} else if (base == 10) {
			switch (num) {
			case 1:
				return "X";

			case 2:
				return "XX";

			case 3:
				return "XXX";

			case 4:
				return "XL";

			case 5:
				return "L";

			case 6:
				return "LX";

			case 7:
				return "LXX";

			case 8:
				return "LXXX";

			case 9:
				return "XC";
			}
		} else if (base == 100) {
			switch (num) {
			case 1:
				return "C";

			case 2:
				return "CC";

			case 3:
				return "CCC";

			case 4:
				return "CD";

			case 5:
				return "D";

			case 6:
				return "DC";

			case 7:
				return "DCC";

			case 8:
				return "DCCC";

			case 9:
				return "CM";
			}
		} else if (base == 1000) {
			switch (num) {
			case 1:
				return "M";

			case 2:
				return "MM";

			case 3:
				return "MMM";
			}
		}
		return "";
	}
}
