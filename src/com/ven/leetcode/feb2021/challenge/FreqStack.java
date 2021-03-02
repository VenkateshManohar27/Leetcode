package com.ven.leetcode.feb2021.challenge;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Implement FreqStack, a class which simulates the operation of a stack-like
 * data structure.
 * 
 * FreqStack has two functions:
 * 
 * push(int x), which pushes an integer x onto the stack. pop(), which removes
 * and returns the most frequent element in the stack. If there is a tie for
 * most frequent element, the element closest to the top of the stack is removed
 * and returned.
 * 
 * 
 * Example 1:
 * 
 * Input:
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]] Output:
 * [null,null,null,null,null,null,null,5,7,5,4] Explanation: After making six
 * .push operations, the stack is [5,7,5,7,4,5] from bottom to top. Then:
 * 
 * pop() -> returns 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
 * 
 * pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the
 * top. The stack becomes [5,7,5,4].
 * 
 * pop() -> returns 5. The stack becomes [5,7,4].
 * 
 * pop() -> returns 4. The stack becomes [5,7].
 * 
 * 
 * Note:
 * 
 * Calls to FreqStack.push(int x) will be such that 0 <= x <= 10^9. It is
 * guaranteed that FreqStack.pop() won't be called if the stack has zero
 * elements. The total number of FreqStack.push calls will not exceed 10000 in a
 * single test case. The total number of FreqStack.pop calls will not exceed
 * 10000 in a single test case. The total number of FreqStack.push and
 * FreqStack.pop calls will not exceed 150000 across all test cases.
 * 
 * @author Venkatesh Manohar
 *
 */

public class FreqStack {
	HashMap<Integer, Integer> m = null;
	PriorityQueue<int[]> pq = null;
	int ind = 0;

	public FreqStack() {
		m = new HashMap<>();
		pq = new PriorityQueue<>((a, b) -> {
			if (a[0] != b[0]) {
				return b[0] - a[0];
			}
			return b[1] - a[1];

		});
	}

	public void push(int x) {

		int freq = m.getOrDefault(x, 0) + 1;
		m.put(x, freq);
		pq.offer(new int[] { x, ind++, freq });

	}

	public int pop() {
		int val = pq.poll()[2];
		int freq = m.get(val) - 1;
		if (freq > 0) {
			m.put(val, freq);
		} else {
			m.remove(val);
		}
		return val;
	}

	public static void main(String[] args) {

	}
}
