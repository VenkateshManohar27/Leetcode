package com.ven.leetcode.feb2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * A transformation sequence from word beginWord to word endWord using a
 * dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk
 * such that:
 * 
 * Every adjacent pair of words differs by a single letter. Every si for 1 <= i
 * <= k is in wordList. Note that beginWord does not need to be in wordList. sk
 * == endWord Given two words, beginWord and endWord, and a dictionary wordList,
 * return the number of words in the shortest transformation sequence from
 * beginWord to endWord, or 0 if no such sequence exists.
 * 
 * 
 * Example 1:
 * 
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"] Output: 5 Explanation: One shortest
 * transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is
 * 5 words long. Example 2:
 * 
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log"] Output: 0 Explanation: The endWord "cog" is
 * not in wordList, therefore there is no valid transformation sequence.
 * 
 * 
 * Constraints:
 * 
 * 1 <= beginWord.length <= 10 endWord.length == beginWord.length 1 <=
 * wordList.length <= 5000 wordList[i].length == beginWord.length beginWord,
 * endWord, and wordList[i] consist of lowercase English letters. beginWord !=
 * endWord All the words in wordList are unique.
 * 
 * @author Venkatesh Manohar
 *
 */
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int count = 0;
		Queue<String> q = new LinkedList<>();
		
		Set<String> s = wordList.stream().collect(Collectors.toSet());
		if(!s.contains(endWord)) {
			return 0;
		}
		
		q.add(beginWord);
		boolean found = false;
		while (!q.isEmpty()) {
			int size = q.size();
			count++;
			while (size > 0) {
				char[] str = q.poll().toCharArray();
				
				for(int i = 0 ; i< str.length; i++) {
					char c = str[i];
					for(int j = 0; j <= 26; j++) {
						char ch = (char)('a'+j);
						if(c != ch ) {
							str[i] =ch;
							String next = new String(str);
							if(endWord.equals(next)) {
								return count+1;
							}
							if(s.contains(next)) {
								q.add(next);
								s.remove(next);
							}
						}
					}
					str[i] = c;
				}
				
				
				size--;
			}
		}

		return (found) ? count : 0;
	}

	public static void main(String[] args) {
		WordLadder wl = new WordLadder();

		System.out.println(wl.ladderLength("hit", "cog", new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));
	}
}
