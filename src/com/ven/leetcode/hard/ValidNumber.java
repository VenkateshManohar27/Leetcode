package com.ven.leetcode.hard;

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
		char prev = '\t';
		boolean eFound = false;
		boolean dFound = false;
		int numAfterE = 0;
		int numAfterD = 0;
		int numBeforeD = 0;
		for (char ch : s.toCharArray()) {
			System.out.println(ch);
			if (ch == '+' || ch == '-') {
				if (prev != '\t' && prev != 'e' && prev != 'E')
					return false;
			} else if (ch == 'e' || ch == 'E') {
				if (eFound)
					return false;
				eFound = true;
			} else if (ch == '.') {
				if (eFound || dFound)
					return false;
				dFound = true;
			} else if (ch >= '0' && ch <= '9') {
				if (eFound)
					numAfterE++;
				else if (dFound)
					numAfterD++;
				else
					numBeforeD++;
			} else
				return false;
			prev = ch;
		}
		if (numBeforeD == 0 && numAfterD == 0)
			return false;
		if (eFound && numAfterE == 0)
			return false;
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
