package com.ven.leetcode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * Example:
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC" Output: "BANC" Note:
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "". If there is such window, you are guaranteed that there will
 * always be only one unique minimum window in S.
 * 
 * @author Venkatesh Manohar
 *
 */
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (s == null || s.length() == 0 || t == null || t.length() == 0) {
			return "";
		}
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		int tempStart = 0, tempEnd = -1, start = 0, end = 0;
		int minLength = Integer.MAX_VALUE;
		HashMap<Character, Integer> cloneMap = null;
		while (tempStart < s.length()) {
			char startChar = s.charAt(tempStart);
			if (!map.containsKey(startChar)) {
				tempStart++;
				continue;
			} else {
				cloneMap = new HashMap<>(map);
				tempEnd = tempStart;
				int count = cloneMap.get(startChar);
				if (count > 1) {
					cloneMap.put(startChar, count - 1);
				} else {
					cloneMap.remove(startChar);
				}
			}

			while (tempEnd < s.length() - 1 && !cloneMap.isEmpty()) {
				tempEnd++;
				char curr = s.charAt(tempEnd);
				if (cloneMap.containsKey(curr)) {
					int count = cloneMap.get(curr);
					if (count > 1) {
						cloneMap.put(curr, count - 1);
					} else {
						cloneMap.remove(curr);
					}
				}
			}
			if (cloneMap.isEmpty()) {
				
				if ((tempEnd - tempStart) < minLength) {
					minLength = Math.min(minLength, tempEnd - tempStart);
					start = tempStart;
					end = tempEnd;
				}
			}
			tempStart++;
			tempEnd = tempStart + 1;
		}
		if (minLength != Integer.MAX_VALUE) {
			return s.substring(start, end+1);
		} else {
			return "";
		}

	}
	
	public String minWindowOptimized(String s, String t) {
        Map<Character, Integer> wc = IntStream.range(0, t.length()).mapToObj(i -> t.charAt(i)).collect(Collectors.toMap(k -> k, k -> 1, Integer::sum));
        int numCharSeen = 0;
        String minWindow = ""; int minLen = Integer.MAX_VALUE;
        for (int start = 0, end = 0; end < s.length(); end++) {
            // get end char, update cache
            char eChar = s.charAt(end);
            wc.computeIfPresent(eChar, (k, v) -> v - 1);
            if (wc.getOrDefault(eChar, -1) >= 0) numCharSeen++; // works both for invalid char and valid char
            // adjust start
            while (numCharSeen == t.length()) {
                // update result
                int curLen = end - start + 1;
                if (curLen < minLen) {
                    minLen = curLen;
                    minWindow = s.substring(start, end + 1);
                }
                // update cache
                char sChar = s.charAt(start);
                wc.computeIfPresent(sChar, (k, v) -> v + 1);
                if (wc.getOrDefault(sChar, -1) > 0) numCharSeen--; // works both for invalid char and valid char
                start++; // remember to update start here
            }
        } 
        return minWindow;
    }

	public static void main(String[] args) {
		MinimumWindowSubstring m = new MinimumWindowSubstring();
		System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(m.minWindow("ADOBE1ODEBAND", "ABC"));
		System.out.println(m.minWindow("cabwefgewcwaefgcf", "cae"));
		System.out.println(m.minWindow("a", "a"));
		System.out.println(m.minWindow("abdc", "abc"));
		System.out.println(m.minWindow("", ""));
		System.out.println("-----------------------Optimized-------------------------------------------------------------");
		System.out.println(m.minWindowOptimized("AAABECODEBANC", "ABC"));
		System.out.println(m.minWindowOptimized("ADOBECODEBANC", "ABC"));
		System.out.println(m.minWindowOptimized("ADOBE1ODEBAND", "ABC"));
		System.out.println(m.minWindowOptimized("cabwefgewcwaefgcf", "cae"));
		System.out.println(m.minWindowOptimized("a", "a"));
		System.out.println(m.minWindowOptimized("abdc", "abc"));
		System.out.println(m.minWindowOptimized("", ""));
	}
}
