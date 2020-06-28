package com.ven.leetcode.math;

import java.util.HashMap;

/**
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * Example 1:
 * 
 * Input: numerator = 1, denominator = 2 Output: "0.5" Example 2:
 * 
 * Input: numerator = 2, denominator = 1 Output: "2" Example 3:
 * 
 * Input: numerator = 2, denominator = 3 Output: "0.(6)"
 * 
 * @author Venkatesh Manohar
 *
 */
public class FractiontoRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();

		sb.append((numerator > 0 ^ denominator > 0) ? "-" : "");
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);
		sb.append(num / den);
		num %= den;

		if (num == 0) {
			return sb.toString();
		}
		sb.append(".");
		HashMap<Long, Integer> map = new HashMap<>();
		map.put(num, sb.length());
		while (num != 0) {
			num *= 10;
			sb.append(num / den);
			num %= den;
			if (map.containsKey(num)) {
				sb.insert(map.get(num), "(");
				sb.append(")");
				break;
			} else {
				map.put(num, sb.length());
			}

		}

		return sb.toString();
	}

	public static void main(String[] args) {
		FractiontoRecurringDecimal frd = new FractiontoRecurringDecimal();
		System.out.println(frd.fractionToDecimal(1, 2));
		System.out.println(frd.fractionToDecimal(2, 1));
		System.out.println(frd.fractionToDecimal(2, 3));
		System.out.println(frd.fractionToDecimal(-2, 3));
	}
}
