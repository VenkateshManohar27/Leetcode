package com.ven.leetcode.mar2021.challenge;

import java.util.HashMap;
import java.util.List;

public class EvaluateBracketPairsofString {
	public String evaluate(String s, List<List<String>> knowledge) {
		HashMap<String, String> map = new HashMap<>();

		for (List<String> l : knowledge) {
			map.put(l.get(0), l.get(1));
		}

		StringBuilder sb = new StringBuilder();
		StringBuilder tmp = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				String temp = tmp.toString();
				if (map.containsKey(temp)) {
					sb.append(map.get(temp));
				} else {
					sb.append("?");
				}
				tmp = new StringBuilder();
			} else if (s.charAt(i) == '(') {
				sb.append(tmp.toString());
				tmp = new StringBuilder();
				continue;
			} else {
				tmp.append(s.charAt(i));
			}
		}
		sb.append(tmp.toString());
		return sb.toString();
	}
}
