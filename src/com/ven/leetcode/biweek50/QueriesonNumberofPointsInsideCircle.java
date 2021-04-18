package com.ven.leetcode.biweek50;

import java.util.Arrays;

public class QueriesonNumberofPointsInsideCircle {
	public int[] countPoints(int[][] points, int[][] queries) {
		// Arrays.sort(points, (a, b) -> {
		// if (a[0] != b[0]) {
		// return a[0] - b[0];
		// } else {
		// return a[1] - b[1];
		// }
		// });
		int[] res = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {
			int count = 0;
			for (int j = 0; j < points.length; j++) {

				if ((((points[j][0] - queries[i][0]) * (points[j][0] - queries[i][0]))
						+ ((points[j][1] - queries[i][1]) * (points[j][1] - queries[i][1]))) <= (queries[i][2]
								* queries[i][2])) {

					count++;
					res[i] = count;
					// System.out.println("count:"+count);
					continue;
				}
				// System.out.println("final:"+count);

			}
		}

		return res;
	}
}
