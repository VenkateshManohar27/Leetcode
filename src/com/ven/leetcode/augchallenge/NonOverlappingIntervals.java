package com.ven.leetcode.augchallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, find the minimum number of intervals you
 * need to remove to make the rest of the intervals non-overlapping.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [[1,2],[2,3],[3,4],[1,3]] Output: 1 Explanation: [1,3] can be removed
 * and the rest of intervals are non-overlapping. Example 2:
 * 
 * Input: [[1,2],[1,2],[1,2]] Output: 2 Explanation: You need to remove two
 * [1,2] to make the rest of intervals non-overlapping. Example 3:
 * 
 * Input: [[1,2],[2,3]] Output: 0 Explanation: You don't need to remove any of
 * the intervals since they're already non-overlapping.
 * 
 * 
 * Note:
 * 
 * You may assume the interval's end point is always bigger than its start
 * point. Intervals like [1,2] and [2,3] have borders "touching" but they don't
 * overlap each other.
 * 
 * @author Venkatesh Manohar
 *
 */
class Interval {
	int start = 0;
	int end = 0;

	public Interval(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}

}

public class NonOverlappingIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals == null) {
			return 0;
		}
		List<Interval> intervalList = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
		}
		intervalList.sort((Interval a, Interval b) -> {
			return (a.start - b.start);
		});
		// System.out.println(intervalList);
		int size = intervalList.size();
		int i = 0;
		while (i < intervalList.size() - 1) {
			Interval a = intervalList.get(i);
			Interval b = intervalList.get(i + 1);
			if (b.start >= a.start && b.start < a.end) {
				if (b.end > a.end) {
					intervalList.remove(i + 1);
				} else {
					intervalList.remove(i);
				}
				continue;
			}
			i++;
		}
		// System.out.println(intervalList);
		return size - intervalList.size();

	}

	
	public int eraseOverlapIntervalsOptimized(int[][] intervals) {
		if (intervals == null) {
			return 0;
		}
		Interval[] intervalArr = new Interval[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			intervalArr[i]= new Interval(intervals[i][0], intervals[i][1]);
		}
		Arrays.sort(intervalArr,  (a, b) -> (a.end == b.end ? b.start - a.start : a.end - b.end));
		int count = 0;
		int end = Integer.MIN_VALUE;
		for (int i = 0; i < intervalArr.length; i++) {
	        if (intervalArr[i].start >= end) end = intervalArr[i].end;
	        else count++;
	    }
	    return count;

	}
	
	
	

	public static void main(String[] args) {
		NonOverlappingIntervals n = new NonOverlappingIntervals();
		System.out.println(n.eraseOverlapIntervals(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } }));
		System.out.println(n.eraseOverlapIntervals(new int[][] { { 1, 2 }, { 1, 4 }, { 2, 3 }, { 3, 4 }, { 1, 3 } }));
		System.out.println(n.eraseOverlapIntervals(new int[][] { { 1, 2 }, { 1, 2 }, { 1, 2 } }));
		System.out.println(n.eraseOverlapIntervals(new int[][] { { 1, 2 }, { 2, 3 } }));
		System.out.println(n.eraseOverlapIntervals(new int[][] { { 1, 100 }, { 11, 22 }, { 1, 11 }, { 2, 12 } }));
		
		System.out.println("-----------------------Optimized-------------------------------------------------------------");
		System.out.println(n.eraseOverlapIntervalsOptimized(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } }));
		System.out.println(n.eraseOverlapIntervalsOptimized(new int[][] { { 1, 2 }, { 1, 4 }, { 2, 3 }, { 3, 4 }, { 1, 3 } }));
		System.out.println(n.eraseOverlapIntervalsOptimized(new int[][] { { 1, 2 }, { 1, 2 }, { 1, 2 } }));
		System.out.println(n.eraseOverlapIntervalsOptimized(new int[][] { { 1, 2 }, { 2, 3 } }));
		System.out.println(n.eraseOverlapIntervalsOptimized(new int[][] { { 1, 100 }, { 11, 22 }, { 1, 11 }, { 2, 12 } }));
	}
}
