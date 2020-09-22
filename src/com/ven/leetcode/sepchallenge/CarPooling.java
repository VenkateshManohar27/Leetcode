package com.ven.leetcode.sepchallenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * You are driving a vehicle that has capacity empty seats initially available
 * for passengers. The vehicle only drives east (ie. it cannot turn around and
 * drive west.)
 * 
 * Given a list of trips, trip[i] = [num_passengers, start_location,
 * end_location] contains information about the i-th trip: the number of
 * passengers that must be picked up, and the locations to pick them up and drop
 * them off. The locations are given as the number of kilometers due east from
 * your vehicle's initial location.
 * 
 * Return true if and only if it is possible to pick up and drop off all
 * passengers for all the given trips.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4 Output: false Example 2:
 * 
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 5 Output: true Example 3:
 * 
 * Input: trips = [[2,1,5],[3,5,7]], capacity = 3 Output: true Example 4:
 * 
 * Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11 Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * trips.length <= 1000 trips[i].length == 3 1 <= trips[i][0] <= 100 0 <=
 * trips[i][1] < trips[i][2] <= 1000 1 <= capacity <= 100000
 * 
 * @author Venkatesh Manohar
 *
 */
public class CarPooling {

	public boolean carPooling(int[][] trips, int capacity) {
		Arrays.sort(trips, new Comparator<int[]>() {

			@Override
			// Compare values according to columns
			public int compare(final int[] entry1, final int[] entry2) {
				if (entry1[1] == entry2[1]) {
					return (entry1[2] - entry2[2]);
				} else {
					return (entry1[1] - entry2[1]);
				}
			}
		});
		/*
		 * for (int i = 0; i < trips.length; i++) { System.out.print("[" + trips[i][0] +
		 * "," + trips[i][1] + "," + trips[i][2] + "]"); } System.out.println();
		 */
		int endLocation = trips[trips.length - 1][2];
		HashMap<Integer, Integer> endLocationToCapacity = new HashMap<>();
		for (int i = 0, j = 0; i <= endLocation && j < trips.length; i++) {
			if (endLocationToCapacity.containsKey(i)) {
				capacity += endLocationToCapacity.get(i);
				endLocationToCapacity.remove(i);
			}
			while (j < trips.length && i == trips[j][1]) {
				if (!(capacity >= trips[j][0])) {
					return false;
				}
				capacity -= trips[j][0];
				if (endLocationToCapacity.containsKey(trips[j][2])) {
					int c = endLocationToCapacity.get(trips[j][2]);
					endLocationToCapacity.put(trips[j][2], c + trips[j][0]);
				} else {
					endLocationToCapacity.put(trips[j][2], trips[j][0]);
				}
				j++;
			}

		}

		return true;
	}

	public boolean carPoolingOptimized(int[][] trips, int capacity) {
		Map<Integer, Integer> timestamp = new TreeMap<>();
		for (int[] trip : trips) {
			int start_passenger = timestamp.getOrDefault(trip[1], 0) + trip[0];
			timestamp.put(trip[1], start_passenger);

			int end_passenger = timestamp.getOrDefault(trip[2], 0) - trip[0];
			timestamp.put(trip[2], end_passenger);
		}
		int ued_capacity = 0;
		for (int passenger_change : timestamp.values()) {
			ued_capacity += passenger_change;
			if (ued_capacity > capacity) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		CarPooling c = new CarPooling();
		System.out.println(c.carPooling(new int[][] { { 2, 1, 5 }, { 3, 3, 7 } }, 4));
		System.out.println(c.carPooling(new int[][] { { 2, 1, 5 }, { 3, 3, 7 } }, 5));
		System.out.println(c.carPooling(new int[][] { { 2, 1, 5 }, { 3, 5, 7 } }, 4));
		System.out.println(c.carPooling(new int[][] { { 3, 2, 7 }, { 3, 7, 9 }, { 8, 3, 9 } }, 11));
		System.out.println(
				c.carPooling(new int[][] { { 8, 2, 3 }, { 4, 1, 3 }, { 1, 3, 6 }, { 8, 4, 6 }, { 4, 4, 8 } }, 12));

		System.out.println(c.carPoolingOptimized(new int[][] { { 2, 1, 5 }, { 3, 3, 7 } }, 4));
		System.out.println(c.carPoolingOptimized(new int[][] { { 2, 1, 5 }, { 3, 3, 7 } }, 5));
		System.out.println(c.carPoolingOptimized(new int[][] { { 2, 1, 5 }, { 3, 5, 7 } }, 4));
		System.out.println(c.carPoolingOptimized(new int[][] { { 3, 2, 7 }, { 3, 7, 9 }, { 8, 3, 9 } }, 11));
		System.out.println(c.carPoolingOptimized(
				new int[][] { { 8, 2, 3 }, { 4, 1, 3 }, { 1, 3, 6 }, { 8, 4, 6 }, { 4, 4, 8 } }, 12));
	}

}
