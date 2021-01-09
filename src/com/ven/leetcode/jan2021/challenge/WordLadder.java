package com.ven.leetcode.jan2021.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given two words beginWord and endWord, and a dictionary wordList, return the
 * length of the shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * Only one letter can be changed at a time. Each transformed word must exist in
 * the word list. Return 0 if there is no such transformation sequence.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"] Output: 5 Explanation: As one shortest
 * transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its
 * length 5. Example 2:
 * 
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log"] Output: 0 Explanation: The endWord "cog" is
 * not in wordList, therefore no possible transformation.
 * 
 * 
 * Constraints:
 * 
 * 1 <= beginWord.length <= 100 endWord.length == beginWord.length 1 <=
 * wordList.length <= 5000 wordList[i].length == beginWord.length beginWord,
 * endWord, and wordList[i] consist of lowercase English letters. beginWord !=
 * endWord All the strings in wordList are unique.
 * 
 * @author Venkatesh Manohar
 *
 */
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> s = new HashSet<>();
		for (String st : wordList) {
			s.add(st);
		}

		if (!s.contains(endWord)) {
			return 0;
		}

		Queue<String> q = new LinkedList<>();
		q.offer(beginWord);
		int level = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String curr = q.poll();
				char[] chrs = curr.toCharArray();
				for (int j = 0; j < chrs.length; j++) {
					char originalchar = chrs[j];
					for (char c = 'a'; c <= 'z'; c++) {
						if (c == originalchar || chrs[j] == c) {
							continue;
						}
						chrs[j] = c;

						String newWord = new String(chrs);
						if (endWord.equals(newWord)) {
							return level + 1;
						}
						if (s.contains(newWord)) {
							q.offer(newWord);
							s.remove(newWord);
						}

					}
					chrs[j] = originalchar;
				}
			}
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

	}
}
