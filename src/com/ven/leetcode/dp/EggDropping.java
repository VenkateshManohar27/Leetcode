package com.ven.leetcode.dp;

public class EggDropping {

	// Driver code
	public static void main(String args[]) {
		int n = 2, k = 10;
		System.out.print("Minimum number of " + "trials in worst case with " + n + " eggs and " + k + " floors is "
				+ eggDrop(n, k));
	}

	private static int eggDrop(int numOfEggs, int numOfFloors) {

		if (numOfFloors == 1 || numOfFloors == 0) {
			return numOfFloors;
		}

		if (numOfEggs == 1) {
			return numOfFloors;
		}
		int ways = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= numOfFloors; i++) {
			System.out.println("eggDrop(" + (numOfEggs - 1) + ", " + (i - 1) + ")");
			System.out.println("eggDrop(" + (numOfEggs) + ", " + (numOfFloors - i) + ")");
			ways = Math.max(eggDrop(numOfEggs - 1, i - 1), eggDrop(numOfEggs, numOfFloors - i));

			if (ways < min) {
				min = ways;
			}
		}

		return min + 1;
	}

	public static int eggDropIterative(int numOfEggs, int numOfFloors) {
		int[][] memo = new int[numOfFloors + 1][numOfEggs + 1];

		for (int floor = 0; floor <= numOfFloors; floor++) {
			for (int egg = 0; egg <= numOfEggs; egg++) {
				// Case where no drops are necessary
				if (floor == 0 || egg == 0) {
					memo[floor][egg] = 0;
				}

				// Case where only one drop is necessary since there is only one floor
				else if (floor == 1) {
					memo[floor][egg] = 1;
				}

				// Case where the numbers of drops equals the number of floors, since
				// there is only one egg available
				else if (egg == 1) {
					memo[floor][egg] = floor;
				} else {
					for (int i = 1; i <= numOfFloors; i++) {

					}
				}
			}
		}

		return memo[numOfFloors][numOfEggs];
	}

}
