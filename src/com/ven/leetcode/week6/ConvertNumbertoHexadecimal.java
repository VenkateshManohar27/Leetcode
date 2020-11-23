package com.ven.leetcode.week6;

/**
 * Given an integer, write an algorithm to convert it to hexadecimal. For
 * negative integer, two’s complement method is used.
 * 
 * Note:
 * 
 * All letters in hexadecimal (a-f) must be in lowercase. The hexadecimal string
 * must not contain extra leading 0s. If the number is zero, it is represented
 * by a single zero character '0'; otherwise, the first character in the
 * hexadecimal string will not be the zero character. The given number is
 * guaranteed to fit within the range of a 32-bit signed integer. You must not
 * use any method provided by the library which converts/formats the number to
 * hex directly. Example 1:
 * 
 * Input: 26
 * 
 * Output: "1a" Example 2:
 * 
 * Input: -1
 * 
 * Output: "ffffffff"
 * 
 * @author Venkatesh Manohar
 *
 */
public class ConvertNumbertoHexadecimal {
	public String toHex(int num) {
		if (num == 0) {
			return "0";
		}

		long longNum = (long) num;
		if (longNum < 0) {
			longNum += 4294967296L; // 4294967296L == 2^^32; this is a quick and dirty way of obtaining two's
									// complement for negative numbers
		}

		char[] map = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

		StringBuilder hexadecimalRepresentation = new StringBuilder();

		while (longNum > 0) {
			hexadecimalRepresentation.append(map[(int) (longNum & 0b1111)]); // mask rightmost 4 bits and append their
																				// hex representation to our SB
			longNum = longNum >>> 4; // then shift our number 4 bits rightward (i.e., divide by 16)
		}

		return hexadecimalRepresentation.reverse().toString();
	}
	
	public static void main(String[] args) {
		ConvertNumbertoHexadecimal c = new ConvertNumbertoHexadecimal();
		System.out.println(c.toHex(26));
		System.out.println(c.toHex(-1));
	}
}
