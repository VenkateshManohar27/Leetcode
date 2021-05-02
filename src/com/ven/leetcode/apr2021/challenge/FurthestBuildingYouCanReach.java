package com.ven.leetcode.apr2021.challenge;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
	public int furthestBuilding(int[] heights, int bricks, int ladders) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < heights.length - 1; i++) {
			if (heights[i + 1] <= heights[i])
				continue;
			int diff = heights[i + 1] - heights[i];
			if (diff < 0) {
				pq.add(diff);
			}
			while (pq.size() > ladders) {
				bricks -= pq.poll();
				if (bricks < 0)
					return i;

			}
		}

		return heights.length - 1;
	}

	public static void main(String[] args) {
		FurthestBuildingYouCanReach f = new FurthestBuildingYouCanReach();
		f.furthestBuilding(new int[] { 4, 2, 7, 6, 9, 14, 12 }, 5, 1);
	}
}
