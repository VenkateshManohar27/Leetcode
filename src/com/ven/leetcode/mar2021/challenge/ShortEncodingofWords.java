package com.ven.leetcode.mar2021.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * A valid encoding of an array of words is any reference string s and array of
 * indices indices such that:
 * 
 * words.length == indices.length The reference string s ends with the '#'
 * character. For each index indices[i], the substring of s starting from
 * indices[i] and up to (but not including) the next '#' character is equal to
 * words[i]. Given an array of words, return the length of the shortest
 * reference string s possible of any valid encoding of words.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["time", "me", "bell"] Output: 10 Explanation: A valid
 * encoding would be s = "time#bell#" and indices = [0, 2, 5]. words[0] =
 * "time", the substring of s starting from indices[0] = 0 to the next '#' is
 * underlined in "time#bell#" words[1] = "me", the substring of s starting from
 * indices[1] = 2 to the next '#' is underlined in "time#bell#" words[2] =
 * "bell", the substring of s starting from indices[2] = 5 to the next '#' is
 * underlined in "time#bell#" Example 2:
 * 
 * Input: words = ["t"] Output: 2 Explanation: A valid encoding would be s =
 * "t#" and indices = [0].
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= words.length <= 2000 1 <= words[i].length <= 7 words[i] consists of only
 * lowercase letters.
 * 
 * @author Venkatesh Manohar
 *
 */
class TrieNode{
	TrieNode[] children;
	int count;
	public TrieNode() {
		super();
		this.children = new TrieNode[26];
		count = 0;
	}
	
	public TrieNode get(char ch) {
		if(children[ch-'a'] == null) {
			children[ch-'a'] = new TrieNode();
			count++;
		}
		return children[ch-'a'];
	}
}
public class ShortEncodingofWords {
	TrieNode root = new TrieNode();
	public int minimumLengthEncoding(String[] words) {
		Set<String> good = new HashSet<>(Arrays.asList(words));
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			for (int j = 1; j < word.length(); j++) {
				good.remove(word.substring(j));
			}
		}

		int ans = 0;
		for (String word : good)
			ans += word.length() + 1;
		return ans;

	}
	
	
	public int minimumLengthEncodingTrie(String[] words) {
		TrieNode curr =root;
		HashMap<TrieNode, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			for (int j = words.length-1; j >= 0; j--) {
				curr = curr.get(word.charAt(j));
			}
			map.put(curr, i);
		}

		int ans = 0;
		for (TrieNode node : map.keySet())
			if(node.count == 0)
				ans += words[map.get(node)].length() + 1;
		return ans;

	}

	public static void main(String[] args) {
		ShortEncodingofWords s = new ShortEncodingofWords();
		s.minimumLengthEncoding(new String[] { "time", "me", "bell" });
		s.minimumLengthEncoding(new String[] { "t" });
	}
}
