package com.ven.leetcode.greedy;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * We have a collection of rocks, each rock has a positive integer weight.
 * 
 * Each turn, we choose the two heaviest rocks and smash them together. Suppose
 * the stones have weights x and y with x <= y. The result of this smash is:
 * 
 * If x == y, both stones are totally destroyed; If x != y, the stone of weight
 * x is totally destroyed, and the stone of weight y has new weight y-x. At the
 * end, there is at most 1 stone left. Return the weight of this stone (or 0 if
 * there are no stones left.)
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [2,7,4,1,8,1] Output: 1 Explanation: We combine 7 and 8 to get 1 so
 * the array converts to [2,4,1,1,1] then, we combine 2 and 4 to get 2 so the
 * array converts to [2,1,1,1] then, we combine 2 and 1 to get 1 so the array
 * converts to [1,1,1] then, we combine 1 and 1 to get 0 so the array converts
 * to [1] then that's the value of last stone.
 * 
 * @author Venkatesh Manohar
 *
 */
public class LastStoneWeight {
	public int lastStoneWeight(int[] stones) {
		if (stones == null || stones.length == 0) {
			return 0;
		}

		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i : stones) {
			pQueue.add(i);
		}

		while (pQueue.size() > 1) {
			Integer y = pQueue.poll();
			Integer x = pQueue.poll();
			if (x != y) {
				pQueue.add(y - x);
			}
		}
		if (!pQueue.isEmpty()) {
			return pQueue.poll();
		}

		return 0;
	}
	
	public static void main(String[] args) {
		LastStoneWeight lsw =  new LastStoneWeight();
		int result = lsw.lastStoneWeight(new int[] {2,7,4,1,8,1});
		System.out.println("Result : "+result+", Match:"+(1==result));
	}
}
