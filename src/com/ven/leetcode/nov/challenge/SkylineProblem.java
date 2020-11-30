package com.ven.leetcode.nov.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * A city's skyline is the outer contour of the silhouette formed by all the
 * buildings in that city when viewed from a distance. Now suppose you are given
 * the locations and height of all the buildings as shown on a cityscape photo
 * (Figure A), write a program to output the skyline formed by these buildings
 * collectively (Figure B).
 * 
 * Buildings Skyline Contour The geometric information of each building is
 * represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x
 * coordinates of the left and right edge of the ith building, respectively, and
 * Hi is its height. It is guaranteed that 0 <= Li, Ri <= INT_MAX, 0 < Hi <=
 * INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles
 * grounded on an absolutely flat surface at height 0.
 * 
 * For instance, the dimensions of all buildings in Figure A are recorded as: [
 * [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 * 
 * The output is a list of "key points" (red dots in Figure B) in the format of
 * [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key
 * point is the left endpoint of a horizontal line segment. Note that the last
 * key point, where the rightmost building ends, is merely used to mark the
 * termination of the skyline, and always has zero height. Also, the ground in
 * between any two adjacent buildings should be considered part of the skyline
 * contour.
 * 
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3
 * 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 * 
 * Notes:
 * 
 * The number of buildings in any input list is guaranteed to be in the range
 * [0, 10000]. The input list is already sorted in ascending order by the left x
 * position Li. The output list must be sorted by the x position. There must be
 * no consecutive horizontal lines of equal height in the output skyline. For
 * instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the
 * three lines of height 5 should be merged into one in the final output as
 * such: [...[2 3], [4 5], [12 7], ...]
 * 
 * @author Venkatesh Manohar
 *
 */
public class SkylineProblem {
	public List<List<Integer>> getSkyline(int[][] buildings) {
		Point[] points = transformToPointsArray(buildings);
		return getSkyline(points);
	}

	private Point[] transformToPointsArray(int[][] buildings) {
		int n = buildings.length;
		Point[] points = new Point[n * 2];

		for (int i = 0; i < n; i++) {
			points[i + i] = new Point(false, buildings[i][0], buildings[i][2]);
			points[i + i + 1] = new Point(true, buildings[i][1], buildings[i][2]);
		}

		return points;
	}

	private List<List<Integer>> getSkyline(Point[] points) {
		Arrays.sort(points, new CompareByPosition());

		List<List<Integer>> skyline = new ArrayList<>();
		TreeMap<Integer, Integer> openedBuildings = new TreeMap<>();
		openedBuildings.put(0, 1);
		int previousHeight = 0;

		for (Point point : points) {
			if (point.closed) {
				handleClosePoint(openedBuildings, point);
			} else {
				handleOpenPoint(openedBuildings, point);
			}

			int currentHeight = openedBuildings.lastEntry().getKey();
			if (currentHeight != previousHeight) {
				skyline.add(Arrays.asList(point.position, currentHeight));
				previousHeight = currentHeight;
			}
		}

		return skyline;
	}

	private void handleClosePoint(TreeMap<Integer, Integer> openedBuildings, Point point) {
		Integer previous = openedBuildings.get(point.height);

		if (previous > 1) {
			openedBuildings.put(point.height, previous - 1);
		} else {
			openedBuildings.remove(point.height);
		}
	}

	private void handleOpenPoint(TreeMap<Integer, Integer> openedBuildings, Point point) {
		Integer previous = openedBuildings.get(point.height);
		Integer current = previous == null ? 1 : previous + 1;

		openedBuildings.put(point.height, current);
	}

	private static class Point {
		public boolean closed;
		public int position;
		public int height;

		public Point(boolean closed, int position, int height) {
			this.closed = closed;
			this.position = position;
			this.height = height;
		}

		@SuppressWarnings("unused")
		public boolean equals(Point o) {
			return this.position == o.position && this.height == o.height && this.closed == o.closed;
		}
	}

	private static class CompareByPosition implements Comparator<Point> {
		@Override
		public int compare(Point a, Point b) {
			if (b.position == a.position) {
				return Integer.compare((a.closed ? 1 : -1) * a.height, (b.closed ? 1 : -1) * b.height);
			}

			return Integer.compare(a.position, b.position);
		}
	}

	public static void main(String[] args) {
		SkylineProblem s = new SkylineProblem();
		System.out.println(
				s.getSkyline(new int[][] { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } }));

		System.out.println(s.getSkyline(new int[][] { { 0, 2, 3 }, { 2, 5, 3 } }));
	}
}
