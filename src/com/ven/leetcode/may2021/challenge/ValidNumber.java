package com.ven.leetcode.may2021.challenge;

/**
 * A valid number can be split up into these components (in order):
 * 
 * A decimal number or an integer. (Optional) An 'e' or 'E', followed by an
 * integer. A decimal number can be split up into these components (in order):
 * 
 * (Optional) A sign character (either '+' or '-'). One of the following
 * formats: At least one digit, followed by a dot '.'. At least one digit,
 * followed by a dot '.', followed by at least one digit. A dot '.', followed by
 * at least one digit. An integer can be split up into these components (in
 * order):
 * 
 * (Optional) A sign character (either '+' or '-'). At least one digit. For
 * example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14",
 * "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"],
 * while the following are not valid numbers: ["abc", "1a", "1e", "e3",
 * "99e2.5", "--6", "-+3", "95a54e53"].
 * 
 * Given a string s, return true if s is a valid number.
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
}
