package com.ven.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"], Output: [
 * ["ate","eat","tea"], ["nat","tan"], ["bat"] ] Note:
 * 
 * All inputs will be in lowercase. The order of your output does not matter.
 * 
 * @author Venkatesh Manohar
 *
 */
public class GroupedAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> groups = new ArrayList<>();
		if (strs == null || strs.length == 0) {
			return groups;
		}

		HashMap<String, Integer> map = new HashMap<>();
		int index = 0;
		for (int i = 0; i < strs.length; i++) {
			char[] chrs = strs[i].toCharArray();
			Arrays.sort(chrs);
			String s = new String(chrs);
			if (map.containsKey(s)) {
				groups.get(map.get(s)).add(strs[i]);
			} else {
				groups.add(new ArrayList<>());
				groups.get(index).add(strs[i]);
				map.put(s, index);
				index++;
			}
		}
		return groups;
	}

	public static void main(String[] args) {
		GroupedAnagrams ga = new GroupedAnagrams();
		List<List<String>> groups = ga.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
		System.out.println(groups);
	}
}
