package com.ven.leetcode.june2021.challenge;

import java.util.Arrays;

/**
 * Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
 * 
 * Given a rectangular cake with height h and width w, and two arrays of
 * integers horizontalCuts and verticalCuts where horizontalCuts[i] is the
 * distance from the top of the rectangular cake to the ith horizontal cut and
 * similarly, verticalCuts[j] is the distance from the left of the rectangular
 * cake to the jth vertical cut.
 * 
 * Return the maximum area of a piece of cake after you cut at each horizontal
 * and vertical position provided in the arrays horizontalCuts and verticalCuts.
 * Since the answer can be a huge number, return this modulo 10^9 + 7.
 * 
 * Example 1:
 * 
 * Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3] Output: 4
 * Explanation: The figure above represents the given rectangular cake. Red
 * lines are the horizontal and vertical cuts. After you cut the cake, the green
 * piece of cake has the maximum area. Example 2:
 * 
 * Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1] Output: 6
 * Explanation: The figure above represents the given rectangular cake. Red
 * lines are the horizontal and vertical cuts. After you cut the cake, the green
 * and yellow pieces of cake have the maximum area. Example 3:
 * 
 * Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3] Output: 9
 * 
 * 
 * Constraints:
 * 
 * 2 <= h, w <= 10^9 1 <= horizontalCuts.length < min(h, 10^5) 1 <=
 * verticalCuts.length < min(w, 10^5) 1 <= horizontalCuts[i] < h 1 <=
 * verticalCuts[i] < w It is guaranteed that all elements in horizontalCuts are
 * distinct. It is guaranteed that all elements in verticalCuts are distinct.
 * 
 * @author Venkatesh Manohar
 *
 */
public class MaximumArea {
	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);

		int h1 = horizontalCuts[0];
		int v1 = verticalCuts[0];
		for (int i = 1; i < horizontalCuts.length; i++) {
			h1 = Math.max(h1, horizontalCuts[i] - horizontalCuts[i - 1]);
		}

		for (int i = 1; i < verticalCuts.length; i++) {
			v1 = Math.max(v1, verticalCuts[i] - verticalCuts[i - 1]);
		}
		h1 = Math.max(h1, h - horizontalCuts[horizontalCuts.length - 1]);
		v1 = Math.max(v1, w - verticalCuts[verticalCuts.length - 1]);
		return ((int) ((long) h1 * v1 % 1000_000_007));

	}
}
