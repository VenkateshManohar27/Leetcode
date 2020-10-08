package com.ven.leetcode.oct.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of intervals, remove all intervals that are covered by another
 * interval in the list.
 * 
 * Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
 * 
 * After doing so, return the number of remaining intervals.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,4],[3,6],[2,8]] Output: 2 Explanation: Interval [3,6]
 * is covered by [2,8], therefore it is removed. Example 2:
 * 
 * Input: intervals = [[1,4],[2,3]] Output: 1 Example 3:
 * 
 * Input: intervals = [[0,10],[5,12]] Output: 2 Example 4:
 * 
 * Input: intervals = [[3,10],[4,10],[5,11]] Output: 2 Example 5:
 * 
 * Input: intervals = [[1,2],[1,4],[3,4]] Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= intervals.length <= 1000 intervals[i].length == 2 0 <= intervals[i][0] <
 * intervals[i][1] <= 10^5 All the intervals are unique.
 * 
 * @author Venkatesh Manohar
 *
 */
public class RemoveCoveredIntervals {
	public int removeCoveredIntervals(int[][] intervals) {
		Arrays.sort(intervals, (int a[], int b[]) -> {
			if (a[0] != b[0]) {
				return a[0] - b[0];
			} else {
				return a[1] - b[1];
			}
		});
		if (intervals.length == 1) {
			return 1;
		}
		// ArrayUtility.print(intervals);
		List<int[]> li = new ArrayList<int[]>();
		li.add(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			int[] a = li.get(li.size() - 1);
			int[] b = intervals[i];
			if (a[0] <= b[0] && a[1] >= b[1]) {
				continue;
			} else if (b[0] <= a[0] && b[1] >= a[1]) {
				li.remove(li.size() - 1);
				li.add(b);
			} else {
				li.add(b);
			}
		}
		return li.size();
	}

	public static void main(String[] args) {
		RemoveCoveredIntervals r = new RemoveCoveredIntervals();
		System.out.println(r.removeCoveredIntervals(new int[][] { { 1, 4 }, { 3, 6 }, { 2, 8 } }));
		System.out.println(r.removeCoveredIntervals(new int[][] { { 1, 4 }, { 2, 3 } }));
		System.out.println(r.removeCoveredIntervals(new int[][] { { 0, 10 }, { 5, 12 } }));
		System.out.println(r.removeCoveredIntervals(new int[][] { { 5, 11 }, { 4, 10 }, { 3, 10 } }));
		System.out.println(r.removeCoveredIntervals(new int[][] { { 1, 2 }, { 1, 4 }, { 3, 4 } }));
		System.out.println(r.removeCoveredIntervals(new int[][] { { 1, 2 }, { 1, 4 }, { 3, 4 }, { 1, 10 } }));
	}
}
