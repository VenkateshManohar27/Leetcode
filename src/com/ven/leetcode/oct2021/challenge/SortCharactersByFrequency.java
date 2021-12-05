package com.ven.leetcode.oct2021.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Given a string s, sort it in decreasing order based on the frequency of the
 * characters. The frequency of a character is the number of times it appears in
 * the string.
 * 
 * Return the sorted string. If there are multiple answers, return any of them.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "tree" Output: "eert" Explanation: 'e' appears twice while 'r' and
 * 't' both appear once. So 'e' must appear before both 'r' and 't'. Therefore
 * "eetr" is also a valid answer. Example 2:
 * 
 * Input: s = "cccaaa" Output: "aaaccc" Explanation: Both 'c' and 'a' appear
 * three times, so both "cccaaa" and "aaaccc" are valid answers. Note that
 * "cacaca" is incorrect, as the same characters must be together. Example 3:
 * 
 * Input: s = "Aabb" Output: "bbAa" Explanation: "bbaA" is also a valid answer,
 * but "Aabb" is incorrect. Note that 'A' and 'a' are treated as two different
 * characters.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 5 * 105 s consists of uppercase and lowercase English
 * letters and digits.
 * 
 * @author Venkatesh Manohar
 *
 */
public class SortCharactersByFrequency {
	public String frequencySort(String s) {
		Map<Character, Integer> m = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			m.put(c, m.getOrDefault(c, 0) + 1);
		}

		System.out.println(m);
		SortedMap<Integer, List<Character>> ml = new TreeMap<>(Collections.reverseOrder());
		for (Map.Entry<Character, Integer> entry : m.entrySet()) {
	        if(ml.containsKey(entry.getValue())) {
	        	List<Character > l = ml.get(entry.getValue());
	        	l.add(entry.getKey());
	        	ml.put(entry.getValue(), l);
	        }else {
	        	List<Character > l = new ArrayList<Character>();
	        	l.add(entry.getKey());
	        	ml.put(entry.getValue(), l);
	        }
	    }
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, List<Character>> entry : ml.entrySet()) {
			int i = entry.getKey();
			for(char c : entry.getValue()) {
				int count = i;
				while(count > 0) {
					sb.append(c);
					count--;
				}
			}
			
			
		}
		return sb.toString();

	}
}
