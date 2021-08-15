package com.ven.leetcode.aug2021.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * Example 1:
 * 
 * Input: strs = ["eat","tea","tan","ate","nat","bat"] Output:
 * [["bat"],["nat","tan"],["ate","eat","tea"]] Example 2:
 * 
 * Input: strs = [""] Output: [[""]] Example 3:
 * 
 * Input: strs = ["a"] Output: [["a"]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= strs.length <= 104 0 <= strs[i].length <= 100 strs[i] consists of
 * lower-case English letters.
 * 
 * @author Venkatesh Manohar
 *
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> l = new ArrayList<>();
		HashMap<String, Integer> m = new HashMap<>();
		for (String s : strs) {
			char tempArray[] = s.toCharArray();
			// sort tempArray
			Arrays.sort(tempArray);
			String str = new String(tempArray);
			if (m.containsKey(str)) {
				l.get(m.get(str)).add(s);
			} else {
				int index = l.size();
				List<String> al = new ArrayList<>();
				al.add(s);
				l.add(al);
				m.put(str, index);
			}

		}
		return l;
	}
}
