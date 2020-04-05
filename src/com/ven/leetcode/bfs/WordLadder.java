package com.ven.leetcode.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * Only one letter can be changed at a time. Each transformed word must exist in
 * the word list. Note that beginWord is not a transformed word. Note:
 * 
 * Return 0 if there is no such transformation sequence. All words have the same
 * length. All words contain only lowercase alphabetic characters. You may
 * assume no duplicates in the word list. You may assume beginWord and endWord
 * are non-empty and are not the same. Example 1:
 * 
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog", return its length 5. Example 2:
 * 
 * Input: beginWord = "hit" endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 * @author Venkatesh Manohar
 *
 */
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> set = new HashSet<>();
		for (String word : wordList) {
			set.add(word);
		}
		if (!set.contains(endWord)) {
			return 0;
		}

		Queue<String> q = new LinkedList<String>();
		q.offer(beginWord);
		int level = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String currWord = q.poll();
				char[] chars = currWord.toCharArray();
				for (int j = 0; j < chars.length; j++) {
					char originalChar = chars[j];
					for (char c = 'a'; c <= 'z'; c++) {
						if (chars[j] == c || c == originalChar) {
							continue;
						}
						chars[j] = c;
						String newWord = new String(chars);
						if (endWord.equals(newWord)) {
							return level + 1;
						}
						if (set.contains(newWord)) {
							q.offer(newWord);
							set.remove(newWord);
						}

					}
					chars[j] = originalChar;
				}
			}
			level++;
		}

		return 0;
	}

	public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> wordSet = new HashSet<>();
		for (String word : wordList) {
			wordSet.add(word);
		}

		if (!wordSet.contains(endWord)) {
			return 0;
		}
		Set<String> begin = new HashSet<>();
		Set<String> end = new HashSet<>();
		Set<String> visited = new HashSet<>();
		begin.add(beginWord);
		visited.add(beginWord);
		end.add(endWord);
		int level = 1;
		while (!begin.isEmpty() && !end.isEmpty()) {
			if (begin.size() > end.size()) {
				Set<String> s = begin;
				begin = end;
				end = s;
			}
			Set<String> temp = new HashSet<>();
			for (String word : begin) {
				char[] chars = word.toCharArray();
				for (int j = 0; j < chars.length; j++) {
					char originalChar = chars[j];
					for (char c = 'a'; c <= 'z'; c++) {
						if (chars[j] == c || c == originalChar) {
							continue;
						}
						chars[j] = c;
						String newWord = new String(chars);
						if (end.contains(newWord)) {
							return level + 1;
						}
						if(!visited.contains(newWord) && wordSet.contains(newWord)) {
							temp.add(newWord);
							visited.add(newWord);
						}
					}
					chars[j] = originalChar;
				}
			}
			begin = temp;
			level++;
		}

		return 0;
	}

	public static void main(String[] args) {
		WordLadder wl = new WordLadder();
		List<String> li = new ArrayList<>();
		Collections.addAll(li, new String[] { "hot", "dot", "dog", "lot", "log", "cog" });
		System.out.println(wl.ladderLength("hit", "cog", li));
		li.clear();
		Collections.addAll(li, new String[] { "hot", "dot", "dog", "lot", "log" });
		System.out.println(wl.ladderLength("hit", "cog", li));
		li.clear();
		Collections.addAll(li, new String[] { "hot", "dot", "dog", "lot", "log", "cog" });
		System.out.println(wl.ladderLength2("hit", "cog", li));
		li.clear();
		Collections.addAll(li, new String[] { "hot", "dot", "dog", "lot", "log" });
		System.out.println(wl.ladderLength2("hit", "cog", li));
	}
}
