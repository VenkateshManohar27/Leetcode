package com.ven.leetcode.june2021.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given two integers n and k and two integer arrays speed and
 * efficiency both of length n. There are n engineers numbered from 1 to n.
 * speed[i] and efficiency[i] represent the speed and efficiency of the ith
 * engineer respectively.
 * 
 * Choose at most k different engineers out of the n engineers to form a team
 * with the maximum performance.
 * 
 * The performance of a team is the sum of their engineers' speeds multiplied by
 * the minimum efficiency among their engineers.
 * 
 * Return the maximum performance of this team. Since the answer can be a huge
 * number, return it modulo 109 + 7.
 * 
 * Example 1:
 * 
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
 * Output: 60 Explanation: We have the maximum performance of the team by
 * selecting engineer 2 (with speed=10 and efficiency=4) and engineer 5 (with
 * speed=5 and efficiency=7). That is, performance = (10 + 5) * min(4, 7) = 60.
 * Example 2:
 * 
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3
 * Output: 68 Explanation: This is the same example as the first but k = 3. We
 * can select engineer 1, engineer 2 and engineer 5 to get the maximum
 * performance of the team. That is, performance = (2 + 10 + 5) * min(5, 4, 7) =
 * 68. Example 3:
 * 
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 4
 * Output: 72
 * 
 * Constraints:
 * 
 * 1 <= <= k <= n <= 105 speed.length == n efficiency.length == n 1 <= speed[i]
 * <= 105 1 <= efficiency[i] <= 108
 * 
 * @author Venkatesh Manohar
 *
 */
public class MaximumPerformanceTeam {
	public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
		int[][] candidates = new int[n][2];

		for (int i = 0; i < candidates.length; i++) {
			candidates[i][0] = speed[i];
			candidates[i][1] = efficiency[i];
		}

		Arrays.sort(candidates, (a, b) -> {
			return b[1] - a[1];
		});
		/*
		 * for (int i = 0; i < candidates.length; i++) {
		 * System.out.println(Arrays.toString(candidates[i])); }
		 */

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
		long max = 0, currSum = 0;
		int currEff = 0;

		for (int i = 0; i < candidates.length; i++) {
			currSum += candidates[i][0];
			pq.offer(candidates[i][0]);
			currEff = candidates[i][1];
			if (pq.size() > k) {
				currSum -= pq.remove();
			}

			max = Math.max(max, (currSum * currEff));
		}
		return (int) (max % 1000_000_007);
	}
}

class Pair {
	Integer key;
	Integer value;

	public Pair(Integer key, Integer value) {
		super();
		this.key = key;
		this.value = value;
	}

	public Integer getKey() {
		return key;
	}

	public Integer getValue() {
		return value;
	}
}

class MaximumPerformanceTeamPair {
	public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
		List<Pair> candidates = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			candidates.add(new Pair(speed[i], efficiency[i]));
		}

		Collections.sort(candidates, (a, b) -> {
			return b.getValue() - a.getValue();
		});
		/*
		 * for (int i = 0; i < candidates.length; i++) {
		 * System.out.println(Arrays.toString(candidates[i])); }
		 */

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
		long max = 0, currSum = 0;
		int currEff = 0;

		for (Pair p : candidates) {
			currSum += p.getKey();
			pq.offer(p.getKey());
			currEff = p.getValue();
			if (pq.size() > k) {
				currSum -= pq.remove();
			}

			max = Math.max(max, (currSum * currEff));
		}
		return (int) (max % 1000_000_007);
	}
}
