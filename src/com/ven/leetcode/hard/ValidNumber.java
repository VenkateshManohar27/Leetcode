package com.ven.leetcode.hard;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Validate if a given string can be interpreted as a decimal number.
 * 
 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false
 * "2e10" => true " -90e3 " => true " 1e" => false "e3" => false " 6e-1" => true
 * " 99e2.5 " => false "53.5e93" => true " --6 " => false "-+3" => false
 * "95a54e53" => false
 * 
 * Note: It is intended for the problem statement to be ambiguous. You should
 * gather all requirements up front before implementing one. However, here is a
 * list of characters that can be in a valid decimal number:
 * 
 * Numbers 0-9 Exponent - "e" Positive/negative sign - "+"/"-" Decimal point -
 * "." Of course, the context of these characters also matters in the input.
 * 
 * @author Venkatesh Manohar
 *
 */
public class ValidNumber {
	public boolean isNumber(String s) {
		boolean isValid = false;
		if (s == null) {
			return isValid;
		}
		s = s.trim();
		if(s.isEmpty()){
            return false;
        }
		int i = 0;
		boolean isExponential = false;
		boolean isDecimal = false;
		while (i < s.length()) {
			if (i == 0 && (s.charAt(i) == '+' || s.charAt(i) == '-') || Character.isDigit(s.charAt(i))) {
				i++;
				continue;
			} else if (Character.isDigit(s.charAt(i))) {
				i++;
				continue;
			} else if (s.charAt(i) == 'e') {
				if(i==0) {
					return false;
				}
				if (!isExponential) {
					isExponential = true;
					i++;
					if (i < s.length()) {
						if ((s.charAt(i) == '+' || s.charAt(i) == '-')) {
							i++;
						}
						if (i < s.length() && Character.isDigit(s.charAt(i))) {
							i++;
							continue;
						}
					}
					return false;
				} else {
					return false;
				}
			} else if (s.charAt(i) == '.') {
				if (isDecimal || isExponential) {
					return false;
				}
				isDecimal = true;
				i++;
				if(i==s.length()  ) {
					
				}
				if (i < s.length() && Character.isDigit(s.charAt(i))) {
					i++;
					continue;
				} else {
					return false;
				}
			}
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		ValidNumber vn = new ValidNumber();
		System.out.println("0 => true is :" + vn.isNumber("0"));
		System.out.println("0.1  => true :" + vn.isNumber("0.1"));
		System.out.println("abc => false is :" + vn.isNumber("abc"));
		System.out.println("1 a => false :" + vn.isNumber("1 a"));
		System.out.println("2e10 => true is :" + vn.isNumber("2e10"));
		System.out.println(" -90e3    => true is :" + vn.isNumber(" -90e3   "));
		System.out.println(" 1e => false is :" + vn.isNumber(" 1e "));
		System.out.println("e3 => false is :" + vn.isNumber("e3"));
		System.out.println(" 6e-1 => true is :" + vn.isNumber(" 6e-1"));
		System.out.println(" 99e2.5  => false is :" + vn.isNumber(" 99e2.5"));
		System.out.println(" 53.5e93 => true is :" + vn.isNumber(" 53.5e93 "));
		System.out.println(" --6  => false is :" + vn.isNumber(" --6 "));
		System.out.println("-+3 => false is :" + vn.isNumber(" -+3"));
		System.out.println("95a54e53 => false is :" + vn.isNumber("95a54e53"));
		System.out.println("  => false is :" + vn.isNumber(" "));
		System.out.println("3.  => false is :" + vn.isNumber("3."));
	}
}
