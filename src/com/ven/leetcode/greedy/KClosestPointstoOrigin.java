package com.ven.leetcode.greedy;

import java.util.PriorityQueue;

/**
 * We have a list of points on the plane. Find the K closest points to the
 * origin (0, 0).
 * 
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * 
 * You may return the answer in any order. The answer is guaranteed to be unique
 * (except for the order that it is in.)
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: points = [[1,3],[-2,2]], K = 1 Output: [[-2,2]] Explanation: The
 * distance between (1, 3) and the origin is sqrt(10). The distance between (-2,
 * 2) and the origin is sqrt(8). Since sqrt(8) < sqrt(10), (-2, 2) is closer to
 * the origin. We only want the closest K = 1 points from the origin, so the
 * answer is just [[-2,2]]. Example 2:
 * 
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2 Output: [[3,3],[-2,4]] (The
 * answer [[-2,4],[3,3]] would also be accepted.)
 * 
 * @author Venkatesh Manohar
 *
 */


public class KClosestPointstoOrigin {
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
	public int[][] kClosest(int[][] points, int K) {
		if (K == 0 || points == null || points.length == 0) {
			return null;
		}
		PriorityQueue<Point> pq = new PriorityQueue<Point>(K, (p1, p2) -> {
			return ((p2.x * p2.x + p2.y * p2.y) - (p1.x * p1.x + p1.y * p1.y));
		});

		for (int i = 0; i < points.length; i++) {
			pq.add(new Point(points[i][0], points[i][1]));
			if (pq.size() > K) {
				pq.remove();
			}
		}
		int[][] result = new int[K][2];
		int index = 0;
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			result[index][0] = p.x;
			result[index][1] = p.y;
			index++;

		}

		return result;
	}

	public static void main(String[] args) {
		KClosestPointstoOrigin k = new KClosestPointstoOrigin();
		int[][] res = k.kClosest(new int[][] { { 1, 3 }, { -2, 2 } }, 1);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i][0] + "," + res[i][1]);
		}
		
		res = k.kClosest(new int[][] { { 3,3},{5,-1},{-2,4 } }, 2);
		
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i][0] + "," + res[i][1]);
		}
	}
}
