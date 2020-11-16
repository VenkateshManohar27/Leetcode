package com.ven.leetcode.nov.challenge;

import java.util.ArrayList;
import java.util.List;

import com.ven.utility.ArrayUtility;

/**
 * Given two lists of closed intervals, each list of intervals is pairwise
 * disjoint and in sorted order.
 * 
 * Return the intersection of these two interval lists.
 * 
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real
 * numbers x with a <= x <= b. The intersection of two closed intervals is a set
 * of real numbers that is either empty, or can be represented as a closed
 * interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * 
 * 
 * Note:
 * 
 * 0 <= A.length < 1000 0 <= B.length < 1000 0 <= A[i].start, A[i].end,
 * B[i].start, B[i].end < 10^9
 * 
 * @author Venkatesh Manohar
 *
 */
public class IntervalListIntersections {
	public int[][] intervalIntersection(int[][] A, int[][] B) {
		List<int[]> l = new ArrayList<>();
		int aInd = 0;
		int bInd = 0;

		while (aInd < A.length && bInd < B.length) {
			if (A[aInd][0] <= B[bInd][0] && (B[bInd][0] <= A[aInd][1])) {
				int[] t = new int[2];
				t[0] = Math.max(A[aInd][0], B[bInd][0]);
				t[1] = Math.min(A[aInd][1], B[bInd][1]);
				l.add(t);

				if (A[aInd][1] < B[bInd][1]) {
					aInd++;
				} else if (A[aInd][1] > B[bInd][1]) {
					bInd++;
				} else {
					aInd++;
					bInd++;

				}
			} else if (B[bInd][0] <= A[aInd][0] && (A[aInd][0] <= B[bInd][1])) {
				int[] t = new int[2];
				t[0] = Math.max(A[aInd][0], B[bInd][0]);
				t[1] = Math.min(A[aInd][1], B[bInd][1]);
				l.add(t);
				if (A[aInd][1] > B[bInd][1]) {
					bInd++;
				} else if (A[aInd][1] < B[bInd][1]) {
					aInd++;
				} else {
					aInd++;
					bInd++;

				}
			} else {
				if (A[aInd][1] < B[bInd][1]) {
					aInd++;
				} else if (A[aInd][1] > B[bInd][1]) {
					bInd++;
				} else {
					aInd++;
					bInd++;

				}
			}
		}
		int ind = 0;
		int[][] arr = new int[l.size()][2];
		for (int[] i : l) {
			arr[ind++] = i;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		IntervalListIntersections i = new IntervalListIntersections();
		int[][] A = new int[][] {{0,2},{5,10},{13,23},{24,25}};
		int[][] B = new int[][] {{1,5},{8,12},{15,24},{25,26}};
		ArrayUtility.print(i.intervalIntersection(A, B));
	}
}
