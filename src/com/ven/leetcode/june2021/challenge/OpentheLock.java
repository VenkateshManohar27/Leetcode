package com.ven.leetcode.june2021.challenge;

import java.util.Arrays;
import java.util.HashSet;

/**
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10
 * slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can
 * rotate freely and wrap around: for example we can turn '9' to be '0', or '0'
 * to be '9'. Each move consists of turning one wheel one slot.
 * 
 * The lock initially starts at '0000', a string representing the state of the 4
 * wheels.
 * 
 * You are given a list of deadends dead ends, meaning if the lock displays any
 * of these codes, the wheels of the lock will stop turning and you will be
 * unable to open it.
 * 
 * Given a target representing the value of the wheels that will unlock the
 * lock, return the minimum total number of turns required to open the lock, or
 * -1 if it is impossible.
 * 
 * Example 1:
 * 
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6 Explanation: A sequence of valid moves would be "0000" -> "1000" ->
 * "1100" -> "1200" -> "1201" -> "1202" -> "0202". Note that a sequence like
 * "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid, because the
 * wheels of the lock become stuck after the display becomes the dead end
 * "0102". Example 2:
 * 
 * Input: deadends = ["8888"], target = "0009" Output: 1 Explanation: We can
 * turn the last wheel in reverse to move from "0000" -> "0009". Example 3:
 * 
 * Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"],
 * target = "8888" Output: -1 Explanation: We can't reach the target without
 * getting stuck. Example 4:
 * 
 * Input: deadends = ["0000"], target = "8888" Output: -1
 * 
 * Constraints:
 * 
 * 1 <= deadends.length <= 500 deadends[i].length == 4 target.length == 4 target
 * will not be in the list deadends. target and deadends[i] consist of digits
 * only.
 * 
 * @author Venkatesh Manohar
 *
 */
public class OpentheLock {
	private char[][] table = new char[][] { { '9', '1' }, { '0', '2' }, { '1', '3' }, { '2', '4' }, { '3', '5' },
			{ '4', '6' }, { '5', '7' }, { '6', '8' }, { '7', '9' }, { '8', '0' } };

	public int openLock(String[] deadends, String target) {
		HashSet<String> visited = new HashSet<>(Arrays.asList(deadends));
		HashSet<String> queue = new HashSet<>();

		if (!visited.contains("0000"))
			queue.add("0000");

		int res = 0;
		while (!queue.isEmpty()) {

			if (queue.contains(target))
				return res;
			HashSet<String> next = new HashSet<>();
			for (String s : queue) {
				visited.add(s);
				char[] arr = s.toCharArray();
				for (int i = 0; i < arr.length; i++) {
					char origin = arr[i];
					arr[i] = table[origin - '0'][0];
					String one = new String(arr);
					if (!visited.contains(one))
						next.add(one);
					arr[i] = table[origin - '0'][1];
					String two = new String(arr);
					if (!visited.contains(two))
						next.add(two);
					arr[i] = origin;
				}

			}
			queue = next;
			res++;
		}

		return -1;
	}

}
