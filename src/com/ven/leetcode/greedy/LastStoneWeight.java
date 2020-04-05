package com.ven.leetcode.greedy;

import java.util.Collections;
import java.util.Comparator;
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
		PriorityQueue<Integer> pqIntegers = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		for (int i = 0; i < stones.length; i++) {
			pqIntegers.add(stones[i]);
		}

		while (pqIntegers.size() > 1) {
			int x = pqIntegers.poll();
			int y = pqIntegers.poll();
			if (x != y) {
				pqIntegers.add(x - y);
			}
		}

		if (!pqIntegers.isEmpty()) {
			return pqIntegers.poll();
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		LastStoneWeight lsw = new LastStoneWeight();
		int result = lsw.lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 });
		System.out.println("Result : " + result + ", Match:" + (1 == result));
	}
}
