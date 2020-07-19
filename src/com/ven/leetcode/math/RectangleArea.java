package com.ven.leetcode.math;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * 
 * Each rectangle is defined by its bottom left corner and top right corner as
 * shown in the figure.
 * 
 * Rectangle Area
 * 
 * Example:
 * 
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2 Output: 45
 * 
 * @author Venkatesh Manohar
 *
 */
public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int area = (C-A)*(D-B) + (G-E)*(H-F);
        long coverLen =(long)Math.min(C,G) -(long)Math.max(A,E);
        long coverHei =(long)Math.min(D,H) -(long)Math.max(B,F);
        if(coverLen <=0 || coverHei <= 0)
            return area;
        else
            return (int) (area-coverLen*coverHei);
	}

	public static void main(String[] args) {
		RectangleArea ra = new RectangleArea();

		System.out.println(ra.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
	}
}
