package com.ven.leetcode.dec.challenge;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * A string is said to be a special string if either of two conditions is met:
 * 
 * All of the characters are the same, e.g. aaa. All characters except the
 * middle one are the same, e.g. aadaa. A special substring is any substring of
 * a string which meets one of those criteria. Given a string, determine how
 * many special substrings can be formed from it.
 * 
 * For example, given the string , we have the following special substrings: .
 * 
 * Function Description
 * 
 * Complete the substrCount function in the editor below. It should return an
 * integer representing the number of special substrings that can be formed from
 * the given string.
 * 
 * substrCount has the following parameter(s):
 * 
 * n: an integer, the length of string s s: a string Input Format
 * 
 * The first line contains an integer, , the length of . The second line
 * contains the string .
 * 
 * Constraints
 * 
 * 
 * Each character of the string is a lowercase alphabet, .
 * 
 * Output Format
 * 
 * Print a single line containing the count of total special substrings.
 * 
 * Sample Input 0
 * 
 * 5 asasd Sample Output 0
 * 
 * 7 Explanation 0
 * 
 * The special palindromic substrings of are
 * 
 * Sample Input 1
 * 
 * 7 abcbaba Sample Output 1
 * 
 * 10 Explanation 1
 * 
 * The special palindromic substrings of are
 * 
 * Sample Input 2
 * 
 * 4 aaaa Sample Output 2
 * 
 * 10 Explanation 2
 * 
 * The special palindromic substrings of are
 * 
 * @author Venkatesh Manohar
 *
 */
public class SpecialStringAgain {
	// Complete the substrCount function below.
	long substrCount(int n, String s) {
		int count = 0;
		char[] chrs = s.toCharArray();

		for (int i = 0; i < s.length(); i++) {
			count++;
			if (i > 0) {
				count += expand(i, i, chrs);
				if (chrs[i] == chrs[i - 1]) {
					count += expand(i - 1, i, chrs) + 1;
				}
			}
		}
		return count;
	}

	private static int expand(int left, int right, char[] chrs) {
		HashSet<Character> set = new HashSet<>();
		int count = 0;
		while (left > 0 && right < chrs.length) {
			if ((left - 1 >= 0) && (right + 1 < chrs.length)){
				left--;
				set.add(chrs[left]);
			
				right++;
				set.add(chrs[right]);
				if (set.size() > 1)
					break;
			}else {
				break;
			}
			
			count++;
		}
		return count;
	}

	
	public static void main(String[] args) throws IOException {
		SpecialStringAgain s = new SpecialStringAgain();

		System.out.println(s.substrCount(5, "asasd"));
		System.out.println(s.substrCount(7, "abcbaba"));
		System.out.println(s.substrCount(4, "aaaa"));
		System.out.println(s.substrCount(8, "mnonopoo"));
	}
}
