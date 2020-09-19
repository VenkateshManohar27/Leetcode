package com.ven.leetcode.sepchallenge;

import java.util.ArrayList;
import java.util.List;

import com.ven.utility.ArrayUtility;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5] Output: [[1,5],[6,9]]
 * Example 2:
 * 
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]] Explanation: Because the new interval [4,8]
 * overlaps with [3,5],[6,7],[8,10]. NOTE: input types have been changed on
 * April 15, 2019. Please reset to default code definition to get new method
 * signature.
 * 
 * @author Venkatesh Manohar
 *
 */

class Interval {
	int start = 0;
	int end = 0;

	public Interval(int i, int j) {
		start = i;
		end = j;
	}

}

public class InsertInterval {
	public int[][] insert2(int[][] intervals, int[] newInterval) {
		List<Interval> li = new ArrayList<>();
		Interval prev = null;
		for (int i = 0; i < intervals.length; i++) {
			li.add(new Interval(intervals[i][0], intervals[i][1]));
		}
		boolean inserted = false;
		int i = 0;
		while (i < li.size()) {
			Interval curr = li.get(i);
			if (prev != null && prev.end >= curr.start) {
				prev.end = (prev.end < curr.end) ? curr.end : prev.end;
				// prev.start =(prev.start > curr.end)
				li.remove(i);
				continue;
			} else if (curr.start <= newInterval[0] && curr.end >= newInterval[0]) {
				if (curr.end < newInterval[1]) {
					curr.end = newInterval[1];
				}
				if (!inserted)
					inserted = true;
			} else if (!inserted && curr.start > newInterval[1]) {
				prev = new Interval(newInterval[0], newInterval[1]);
				li.add(i, prev);
				i++;
				inserted = true;
				continue;
			}
			i++;
			prev = curr;
		}
		if (!inserted) {
			li.add(new Interval(newInterval[0], newInterval[1]));
		}
		int[][] res = new int[li.size()][2];
		for (int j = 0; j < li.size(); j++) {
			res[j][0] = li.get(j).start;
			res[j][1] = li.get(j).end;
		}
		return res;
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> li = new ArrayList<>();
		int[] prev = null;
		for (int i = 0; i < intervals.length; i++) {
			li.add(new int[] {intervals[i][0], intervals[i][1]});
		}
		li.add(new int[] {newInterval[0], newInterval[1]});
		li.sort((a, b) -> {
			return a[0] - b[0];
		});
		int i = 1;
		prev = li.get(0);
		while (i < li.size()) {
			int[] curr = li.get(i);
			if (prev[1] >= curr[0]) {
				prev[1]= (prev[1] < curr[1]) ? curr[1] : prev[1];
				// prev.start =(prev.start > curr.end)
				li.remove(i);
				continue;
			} 
			prev = curr;
			i++;
		}
		int[][] res = new int[li.size()][2];
		for (int j = 0; j < li.size(); j++) {
			res[j] = li.get(j);
		}
		return res;
	}

	public static void main(String[] args) {
		InsertInterval i = new InsertInterval();
		ArrayUtility.print(i.insert(new int[][] { { 1, 5 } }, new int[] { 0, 3 }));
		ArrayUtility.print(i.insert(new int[][] { { 1, 3 }, { 6, 9 } }, new int[] { 4, 5 }));
		ArrayUtility.print(
				i.insert(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } }, new int[] { 4, 8 }));
		ArrayUtility.print(i.insert(new int[][] { { 1, 3 }, { 6, 9 } }, new int[] { 2, 5 }));
		ArrayUtility.print(i.insert(new int[][] { { 3, 5 }, { 6, 9 } }, new int[] { 1, 2 }));
		ArrayUtility.print(i.insert(new int[][] { { 1, 3 }, { 6, 9 } }, new int[] { 10, 11 }));
		ArrayUtility.print(i.insert(new int[][] { { 1, 5 } }, new int[] { 2, 3 }));
	}
}
