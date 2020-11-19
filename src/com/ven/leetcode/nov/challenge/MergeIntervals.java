package com.ven.leetcode.nov.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]] Output:
 * [[1,6],[8,10],[15,18]] Explanation: Since intervals [1,3] and [2,6] overlaps,
 * merge them into [1,6]. Example 2:
 * 
 * Input: intervals = [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4]
 * and [4,5] are considered overlapping.
 * 
 * 
 * Constraints:
 * 
 * 1 <= intervals.length <= 104 intervals[i].length == 2 0 <= starti <= endi <=
 * 104
 * 
 * @author Venkatesh Manohar
 *
 */
public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		if (intervals.length <= 1) {
			return intervals;
		}

		Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

		List<int[]> l = new ArrayList<int[]>();

		int i = 1;
		l.add(intervals[0]);

		while (i < intervals.length) {
			int[] prev = l.get(l.size() - 1);
			if (prev[1] >= intervals[i][0]) {
				prev[1] = Math.max(intervals[i][1], prev[1]);
				i++;
			} else {
				l.add(intervals[i]);
				i++;
			}

		}
		int[][] a = new int[l.size()][2];
		for (int j = 0; j < l.size(); j++) {
			a[j][0] = l.get(j)[0];
			a[j][1] = l.get(j)[1];
		}
		return a;
	}
}
