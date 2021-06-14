package com.ven.leetcode.week245;

public class MergeTripletstoFormTargetTriplet {

	public boolean mergeTriplets(int[][] triplets, int[] target) {
		boolean f = false, s = false, t = false;
		int tf = target[0];
		int ts = target[1];
		int tt = target[2];
		for (int i = 0; i < triplets.length; i++) {

			if (tf == triplets[i][0] && ts >= triplets[i][1] && tt >= triplets[i][2]) {
				f = true;
			}
			if (ts == triplets[i][1] && tf >= triplets[i][0] && tt >= triplets[i][2]) {
				s = true;
			}
			if (tt == triplets[i][2] && ts >= triplets[i][1] && tf >= triplets[i][0]) {
				t = true;
			}
		}

		return f && s && t;

	}

	public static void main(String[] args) {
		MergeTripletstoFormTargetTriplet c = new MergeTripletstoFormTargetTriplet();

		System.out.println(c.mergeTriplets(
				new int[][] { { 5, 7, 6 }, { 7, 5, 9 }, { 3, 4, 7 }, { 7, 3, 10 }, { 10, 5, 7 }, { 9, 1, 5 },
						{ 5, 4, 7 }, { 10, 10, 6 }, { 8, 8, 8 }, { 4, 9, 8 }, { 3, 2, 5 }, { 9, 10, 6 }, { 2, 4, 5 },
						{ 4, 4, 3 }, { 1, 1, 4 }, { 8, 10, 2 }, { 8, 7, 10 }, { 4, 7, 8 }, { 7, 4, 3 }, { 1, 2, 7 } },
				new int[] { 3, 9, 8 }));
		System.out.println(c.mergeTriplets(new int[][] { { 2, 5, 3 }, { 2, 3, 4 }, { 1, 2, 5 }, { 5, 2, 3 } },
				new int[] { 5, 5, 5 }));
		System.out
				.println(c.mergeTriplets(new int[][] { { 2, 5, 3 }, { 1, 8, 4 }, { 1, 7, 5 } }, new int[] { 2, 7, 5 }));

	}
}
