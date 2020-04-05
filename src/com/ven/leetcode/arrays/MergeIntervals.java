package com.ven.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import com.ven.utility.ArrayUtility;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * Input: [[1,3},{2,6},{8,10},{15,18]] Output: [[1,6},{8,10},{15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * 
 * Input: [[1,4},{4,5]] Output: [[1,5]] Explanation: Intervals [1,4] and [4,5]
 * are considered overlapping. NOTE: input types have been changed on April 15,
 * 2019. Please reset to default code definition to get new method signature.
 * 
 * @author Venkatesh Manohar
 *
 */
public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		if(intervals == null || intervals.length ==1) {
			return intervals;
		}
		// sort the array on interval first element
		Arrays.sort(intervals, new Comparator<int[]>() {
		   	@Override
	                //arguments to this method represent the arrays to be sorted   
			public int compare(int[] o1, int[] o2) {
	                    //get the item ids which are at index 0 of the array
		            int itemIdOne = o1[0];
		            int itemIdTwo = o2[0];
			    // sort on item id
			    return Integer.compare(itemIdOne, itemIdTwo);
			}
		});
		int count = 1;
		int current = 0;
		int next = 1;
		while ( next < intervals.length ) {
			int[] item1 = intervals[current];
			int [] item2 = intervals[next];
			if(item1[0] == -1) {
				current++;
				continue;
			}
			if(item1[1] >= item2[0]) {
				intervals[current][1] = Math.max(item1[1],item2[1]);
				item2[0] = -1;
				item2[1] = -1;
				next++;
			} else {
				current++;
				next++;
				count++;
			}
			
		}
		
		int[][] result = new int[count][2];
		int index = 0;
		for (int i = 0; i < intervals.length; i++) {
			if(intervals[i][0] !=-1) {
				result[index]= intervals[i];
				index++;
			}
		}
		return result;
	}
	
	class Interval{
		int start;
		int end;
		public Interval(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
	}
	public int[][] merge2(int[][] intervals) {
		if(intervals == null || intervals.length ==1) {
			return intervals;
		}
		ArrayList<Interval> intervalList = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
		}
		
		// sort the array on interval first element
		Collections.sort(intervalList, new Comparator<Interval>() {
		   	@Override
	        public int compare(Interval o1, Interval o2) {
	            return Integer.compare(o1.start, o2.start);
			}
		});
		
		for (int i = 0; i < intervalList.size()-1; ) {
			Interval i1 = intervalList.get(i);
			Interval i2 = intervalList.get(i+1);
			if(i1.end >= i2.start) {
				i1.end = Math.max(i1.end, i2.end);
				intervalList.remove(i+1);
				
			}else {
				i++;
			}
		}
		
		int[][] result = new int[intervalList.size()][2];
		for (int i = 0; i < result.length; i++) {
				result[i][0]= intervalList.get(i).start;
				result[i][1]= intervalList.get(i).end;
			
		}
		return result;
	}
	public static void main(String[] args) {
		MergeIntervals mi = new MergeIntervals();
		int [][] res = mi.merge(new int[][] {{1,3},{2,6},{8,10},{15,18}});
		ArrayUtility.print(res);
		
		res = mi.merge(new int[][] {{1,4},{4,18}});
		ArrayUtility.print(res);
		
		res = mi.merge(new int[][] {{15,18},{2,6},{1,3},{8,10}});
		ArrayUtility.print(res);
		
		res = mi.merge(new int[][] {{15,18}});
		ArrayUtility.print(res);
		
		res = mi.merge(new int[][] {{1,4},{5,18}});
		ArrayUtility.print(res);
		
		System.out.println("-------------------------- Merge 2 -----------------------------------");
		res = mi.merge2(new int[][] {{1,3},{2,6},{8,10},{15,18}});
		ArrayUtility.print(res);
		
		res = mi.merge2(new int[][] {{1,4},{4,18}});
		ArrayUtility.print(res);
		
		res = mi.merge2(new int[][] {{15,18},{2,6},{1,3},{8,10}});
		ArrayUtility.print(res);
		
		res = mi.merge2(new int[][] {{15,18}});
		ArrayUtility.print(res);
		
		res = mi.merge2(new int[][] {{1,4},{5,18}});
		ArrayUtility.print(res);
	}
}
