package com.ven.leetcode.week253;

import java.util.PriorityQueue;

/**
 * You are given a 0-indexed integer array piles, where piles[i] represents the
 * number of stones in the ith pile, and an integer k. You should apply the
 * following operation exactly k times:
 * 
 * Choose any piles[i] and remove floor(piles[i] / 2) stones from it. Notice
 * that you can apply the operation on the same pile more than once.
 * 
 * Return the minimum possible total number of stones remaining after applying
 * the k operations.
 * 
 * floor(x) is the greatest integer that is smaller than or equal to x (i.e.,
 * rounds x down).
 * 
 * Example 1:
 * 
 * Input: piles = [5,4,9], k = 2 Output: 12 Explanation: Steps of a possible
 * scenario are: - Apply the operation on pile 2. The resulting piles are
 * [5,4,5]. - Apply the operation on pile 0. The resulting piles are [3,4,5].
 * The total number of stones in [3,4,5] is 12. Example 2:
 * 
 * Input: piles = [4,3,6,7], k = 3 Output: 12 Explanation: Steps of a possible
 * scenario are: - Apply the operation on pile 3. The resulting piles are
 * [4,3,3,7]. - Apply the operation on pile 4. The resulting piles are
 * [4,3,3,4]. - Apply the operation on pile 0. The resulting piles are
 * [2,3,3,4]. The total number of stones in [2,3,3,4] is 12.
 * 
 * Constraints:
 * 
 * 1 <= piles.length <= 105 1 <= piles[i] <= 104 1 <= k <= 105
 * 
 * @author Venkatesh Manohar
 *
 */
public class RemoveStonestoMinimizetheTotal {
	public int minStoneSum(int[] piles, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (int i = 0; i < piles.length; i++) {
			pq.add(piles[i]);
		}

		while (k > 0) {
			int x = pq.poll();
			x = (int) Math.ceil((double) x / 2);
			pq.add(x);
			k--;
		}
		int sum = 0;
		while (!pq.isEmpty()) {

			sum += pq.poll();
		}

		return sum;
	}

	public int minStoneSumOpt(int[] piles, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        int sum = 0;
		for (int i = 0; i < piles.length; i++) {
			pq.add(piles[i]);
            sum += piles[i];
        }
		
		while(k > 0) {
			int x = pq.poll();
            sum -= x;
			x = (int) Math.ceil((double)x / 2);
			pq.add(x);
            sum +=x;
			k--;
		}
		return sum;
	}
	public static void main(String[] args) {
		RemoveStonestoMinimizetheTotal r = new RemoveStonestoMinimizetheTotal();
		// [5,4,9], k = 2
		System.out.println(r.minStoneSum(new int[] { 5, 4, 9 }, 2));
		// [4,3,6,7], k = 3
		System.out.println(r.minStoneSum(new int[] { 4, 3, 6, 7 }, 3));

	}
}
