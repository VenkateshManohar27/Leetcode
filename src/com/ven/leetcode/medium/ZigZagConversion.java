package com.ven.leetcode.medium;

import java.util.Arrays;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P A H N A P L S I I G Y I R And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string s, int numRows); Example 1:
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3 Output: "PAHNAPLSIIGYIR" Example 2:
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4 Output: "PINALSIGYAHRPI"
 * Explanation:
 * 
 * P I N A L S I G Y A H R P I
 * 
 * @author Venkatesh Manohar
 *
 */

public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (s == null || s.length() == 0 || s.length() < numRows || numRows == 1) {
			return s;
		}

		int length = s.length();
		/*
		 * int col = length / numRows; col = col * col;
		 */

		char[][] zigZag = new char[numRows][length];
		for (int i = 0; i < zigZag.length; i++) {
			Arrays.fill(zigZag[i], ' ');
		}

		int rowIndex = 0;
		int colIndex = 0;
		int index = 0;
		boolean direction = false;
		while (index < length) {
			char c = s.charAt(index);
			zigZag[rowIndex][colIndex] = c;
			if (!direction) {
				if (rowIndex == numRows - 1) {
					direction = true;
					colIndex++;
					rowIndex--;
				} else {
					rowIndex++;
				}
			} else {
				if (colIndex > 0 && rowIndex == 0) {
					direction = false;
					rowIndex++;
				} else {
					rowIndex--;
					colIndex++;
				}
			}

			index++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < zigZag.length; i++) {
			for (int j = 0; j < zigZag[0].length; j++) {
				if (zigZag[i][j] == ' ')
					continue;
				sb.append(zigZag[i][j]);
			}
		}
		return sb.toString();
	}

	/*
	 * Solution 1: Visit by Column
	 * 
	 * We can use array of StringBuilders to represent the rows of the Zig-Zag
	 * Pattern. Iterate through an input string s from left to right, appending each
	 * character to the appropriate row. Time complexity: O(n) - where n is the
	 * length of an input string. Space complexity: O(n) - space required for the
	 * StringBuilder array.
	 */
	public String convert2(String s, int nRows) {
		StringBuilder[] sb = new StringBuilder[nRows];
		int n = s.length();
		int i = 0;

		for (int k = 0; k < sb.length; k++)
			sb[k] = new StringBuilder();

		while (i < n) {
			for (int j = 0; j < nRows && i < n; j++) // Move Vertically Down
				sb[j].append(s.charAt(i++));
			for (int j = nRows - 2; j >= 1 && i < n; j--) // Move Obliquely Up
				sb[j].append(s.charAt(i++));
		}
		return String.join("", sb);
	}

	public static void main(String[] args) {
		ZigZagConversion zzc = new ZigZagConversion();
		System.out.println(zzc.convert("PAYPALISHIRING", 3) + " should be PAHNAPLSIIGYIR");
		System.out.println(zzc.convert("PAYPALISHIRING", 4) + " should be PINALSIGYAHRPI");

		System.out.println(zzc.convert("A", 2) + " should be A");
		System.out.println(zzc.convert("ABC", 2) + " should be A");
		System.out.println(zzc.convert("ABCD", 2) + " should be A");
	}
}
