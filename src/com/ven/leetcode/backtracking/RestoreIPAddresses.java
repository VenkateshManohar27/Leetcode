package com.ven.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * A valid IP address consists of exactly four integers (each integer is between
 * 0 and 255) separated by single points.
 * 
 * Example:
 * 
 * Input: "25525511135" Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * @author Venkatesh Manohar
 *
 */
public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> li = new ArrayList<String>();
		if (s == null || s.length() < 4 || s.length() > 12 || !s.matches("[0-9]+") ) {
			return li;
		}
		helper(li, s, 0, new ArrayList<>());
		return li;
	}

	private void helper(List<String> li, String s, int start, ArrayList<String> temp) {
		if (temp.size() == 4) {
			if (start == s.length()) {
				li.add(String.join(".", temp));
			}
			return;
		}

		for (int i = start; i < s.length(); i++) {
			String substr = s.substring(start, i + 1);
			if (!isValidInteger(substr)) {
				break;
			}
			temp.add(substr);
			helper(li, s, i + 1, temp);
			temp.remove(temp.size() - 1);
		}
	}

	private boolean isValidInteger(String num) {
		try {
			if(num.length() > 1 && !num.matches("[1-9][0-9]+")) {
				return false;
			}
			
			int val = Integer.parseInt(num);
			if (val < 0 || val > 255) {
				return false;
			}

		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	
	public static void main(String[] args) {
		String s = "0";
		System.out.println(s.matches("[0-9]+"));
		s="01";
		System.out.println(s.matches("[1-9][0-9]+"));
		
		s="12";
		System.out.println(s.matches("[1-9][0-9]+"));
	}
}
