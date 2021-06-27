package com.ven.leetcode.biweek55;

public class B {
	
	public String removeOccurrences(String s, String part) {
		StringBuilder sb = new StringBuilder(s);
		while(sb.indexOf(part) != -1) {
			sb.delete(sb.indexOf(part), sb.indexOf(part)+part.length());
		}
		return sb.toString();
	}
}
